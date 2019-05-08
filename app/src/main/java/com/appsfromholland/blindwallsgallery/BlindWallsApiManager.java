package com.appsfromholland.blindwallsgallery;

import android.content.Context;
import android.util.Log;

import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Cache;

import org.json.JSONArray;
import org.json.JSONException;

public class BlindWallsApiManager {
    private String url;
    private Context context;
    private RequestQueue queue;
    public BlindWallsApiManager(Context context){
        this.url = "https://api.blindwalls.gallery/apiv2/murals";
        this.context = context;
        this.queue = Volley.newRequestQueue(this.context);
    }
    public void getMurals(final BlindWallsListener listener){
        JsonArrayRequest request = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                String author = response.getJSONObject(i).getString("author");
                                Mural mural = new Mural(
                                        author,
                                        "description, ",
                                        "https://camo.githubusercontent.com/fe9976caf90267e2f565db30b24d2f3076bee52a/68747470733a2f2f74352e72627863646e2e636f6d2f6164613134666132356431363066333161643962656334313964656332643965"
                                );
                                listener.onMuralAvailable(mural);
                                Log.d("onResponse", "onResponse: " + author);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                listener.unMuralError(e.getMessage());
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Volley Error", "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        this.queue.add(request);
    }
}
