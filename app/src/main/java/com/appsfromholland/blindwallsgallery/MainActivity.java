package com.appsfromholland.blindwallsgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mural> murals;
    RecyclerView recyclerView;
    BlindwallsAdapter blindwallsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        murals = new ArrayList<>();
        Mural mural = new Mural("Dummy Author",
                "Dummy Description",
                "https://camo.githubusercontent.com/fe9976caf90267e2f565db30b24d2f3076bee52a/68747470733a2f2f74352e72627863646e2e636f6d2f6164613134666132356431363066333161643962656334313964656332643965");
        murals.add(mural);
        murals.add(mural);
        murals.add(mural);
        murals.add(mural);
        murals.add(mural);
        murals.add(mural);


        recyclerView = findViewById(R.id.blindwallsRecyclerViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(
                this, 2, GridLayoutManager.VERTICAL, false)
        );
        blindwallsAdapter = new BlindwallsAdapter(murals);
        recyclerView.setAdapter(blindwallsAdapter);
    }
}