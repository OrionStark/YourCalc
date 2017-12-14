package com.example.orion_stark.yourcalc;

import android.app.Fragment;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Results extends AppCompatActivity {
    MyPagerAdapter myAdapter;
    ViewPager myViewPager;
    TabLayout mytabLayout;
    Toolbar toolbar;
    Bundle bundle = new Bundle();
    public ArrayList<Integer> results = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsact);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        try {
            getAnyExtras();
            setProp();
        } catch (Exception e) {
            AlertDialog.Builder alertD = new AlertDialog.Builder(Results.this);
            alertD.setTitle("Warning")
                    .setMessage(e.getMessage())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    });
            alertD.create()
                    .show();
        }
    }

    private void setProp() {
        bundle.putIntegerArrayList("EnteredValue", this.results);
        bundle.putIntegerArrayList("ResultsTambah", getIntent().getIntegerArrayListExtra("ResultTambah"));
        bundle.putIntegerArrayList("ResultsKurang", getIntent().getIntegerArrayListExtra("ResultKurang"));
        bundle.putIntegerArrayList("ResultsBagi", getIntent().getIntegerArrayListExtra("ResultBagi"));
        bundle.putIntegerArrayList("ResultsKali", getIntent().getIntegerArrayListExtra("ResultKali"));

        mytabLayout = findViewById(R.id.tabs);
        myAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myViewPager = findViewById(R.id.viewPager);
        myAdapter.setFragment(new resultsfirst(), "+");
        myAdapter.setFragment(new resultsecond(), "-");
        myAdapter.setFragment(new resultthird(), ":");
        myAdapter.setFragment(new resultfourth(), "*");

        // Set Arguments to fragments
        for(int i = 0; i < myAdapter.getCount(); i ++)
        {
            myAdapter.getItem(i).setArguments(bundle);
        }

        myViewPager.setAdapter(myAdapter);
        mytabLayout.setupWithViewPager(myViewPager);
    }

    private void getAnyExtras() throws Exception {

        // get entered value
        /*
            Index 0 = A;
            Index 1 = B;
            Index 2 = C;
            Index 3 = D;
         */
        results.add(getIntent().getIntExtra("Avalue", 0));
        results.add(getIntent().getIntExtra("Bvalue", 0));
        results.add(getIntent().getIntExtra("Cvalue", 0));
        results.add(getIntent().getIntExtra("Dvalue", 0));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}