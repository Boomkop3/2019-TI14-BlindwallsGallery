package com.appsfromholland.blindwallsgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BlindwallsApiListener {

    BlindwallsApiManager apiManager;
    ArrayList<Mural> murals;
    RecyclerView recyclerView;
    BlindwallsAdapter blindwallsAdapter;

    @Override
    public void onMuralAvailable(Mural mural) {
        murals.add(mural);
        blindwallsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMuralError(Error error) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        murals = new ArrayList<>();
        apiManager = new BlindwallsApiManager(getApplicationContext(), this);
        apiManager.getMurals();

        recyclerView = findViewById(R.id.blindwallsRecyclerViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(
                this, 2, GridLayoutManager.VERTICAL, false)
        );
        blindwallsAdapter = new BlindwallsAdapter(murals);
        recyclerView.setAdapter(blindwallsAdapter);
    }
}