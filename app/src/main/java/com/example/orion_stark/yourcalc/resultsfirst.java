package com.example.orion_stark.yourcalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by orion_stark on 04/11/17.
 * I have no idea wut I'm doing
 */

public class resultsfirst extends Fragment{
    TextView a, b ,c, d, x, y, decimal;
    Button dec;
    ArrayList<Integer> results = new ArrayList<>();
    ArrayList<Integer> enteredValue = new ArrayList<>();
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.resultsfirst, container, false);
        setPropsFrag1();
        if (getArguments() != null) {
            results = getArguments().getIntegerArrayList("ResultsTambah");
            enteredValue = getArguments().getIntegerArrayList("EnteredValue");
            setFrag1Text();
        }
        if (!(savedInstanceState == null)) {
            decimal.setText(savedInstanceState.getString("DecimalResque"));
        }
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimal.setText(String.valueOf(Double.valueOf(x.getText().toString()) / Double.valueOf(y.getText().toString())));
            }
        });

        return view;
    }

    private void setPropsFrag1() {
        a = view.findViewById(R.id.Afield);
        b = view.findViewById(R.id.Bfield);
        c = view.findViewById(R.id.Cfield);
        d = view.findViewById(R.id.Dfield);
        x = view.findViewById(R.id.Xfield);
        y = view.findViewById(R.id.Yfield);
        dec = view.findViewById(R.id.btn_sbmt);
        decimal = view.findViewById(R.id.decimal);
    }

    private void setFrag1Text() {
        a.setText(String.valueOf(enteredValue.get(0)));
        b.setText(String.valueOf(enteredValue.get(1)));
        c.setText(String.valueOf(enteredValue.get(2)));
        d.setText(String.valueOf(enteredValue.get(3)));
        x.setText(String.valueOf(results.get(0)));
        y.setText(String.valueOf(results.get(1)));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!this.decimal.getText().equals("")) {
            outState.putString("DecimalResque", String.valueOf(Double.valueOf(x.getText().toString()) / Double.valueOf(y.getText().toString())));
        }
        super.onSaveInstanceState(outState);
    }

}
