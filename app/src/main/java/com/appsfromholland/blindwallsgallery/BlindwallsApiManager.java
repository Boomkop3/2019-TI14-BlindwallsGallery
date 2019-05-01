package com.appsfromholland.blindwallsgallery;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Random;

public class BlindwallsApiManager {

    Context context;
    RequestQueue queue;
    BlindwallsApiListener listener;

    final String url = "https://api.blindwalls.gallery/apiv2/murals";

    // Constructor
    public BlindwallsApiManager(Context context, BlindwallsApiListener listener) {
        this.context = context;
        this.queue = Volley.newRequestQueue(this.context);
        this.listener = listener;
    }

    public void getMurals() {
        JsonArrayRequest request = new JsonArrayRequest(

                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("VOLLEY_TAG", response.toString());

                        try {
                            // JSONArray jsonArray = new JSONArray(response);
                            for( int idx = 0; idx < response.length(); idx++) {
                                String author = response.getJSONObject(idx).getString("author");
                                String desc = response.getJSONObject(idx).getJSONObject("description").getString("nl");
                                JSONArray images = response.getJSONObject(idx).getJSONArray("images");

                                int index = new Random().nextInt(images.length());

                                String imageUrl = "https://api.blindwalls.gallery/" +
                                        images.getJSONObject(index).getString("url");

                                Mural mural = new Mural(author, desc, imageUrl);

                                listener.onMuralAvailable(mural);

                                Log.d("VOLLEY_TAG", mural.toString());
                            }
                        } catch (JSONException e) {
                            Log.e("VOLLEY_TAG", e.getLocalizedMessage());
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY_TAG", error.toString());
                        listener.onMuralError( new Error("Fout bij ophalen murals") );
                    }
                }
        );

        queue.add(request);
    }

}
