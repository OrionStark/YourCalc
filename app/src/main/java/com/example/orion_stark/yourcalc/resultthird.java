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

public class resultthird extends Fragment {

    TextView fieldAfrag3, fieldBfrag3, fieldCfrag3, fieldDfrag3, fieldXfrag3, fieldYfrag3, decimal_frag3;
    Button decimal_btn_frag3;
    View view_frag3;
    ArrayList<Integer> resultsDivide = new ArrayList<>();
    ArrayList<Integer> enteredValue3 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_frag3 = inflater.inflate(R.layout.resultthird, container, false);

        setFrag3Prop();
        if (!(getArguments() == null)) {
            resultsDivide = getArguments().getIntegerArrayList("ResultsBagi");
            enteredValue3 = getArguments().getIntegerArrayList("EnteredValue");
            setTextFrag3();
        }
        if (!(savedInstanceState == null)) {
            decimal_frag3.setText(savedInstanceState.getString("Decimalku"));
        }
        this.decimal_btn_frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimal_frag3.setText(String.valueOf(Double.valueOf(resultsDivide.get(0)) / Double.valueOf(resultsDivide.get(1))));
            }
        });

        return view_frag3;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!this.decimal_frag3.getText().equals("")) {
            outState.putString("Decimalku", String.valueOf(Double.valueOf(resultsDivide.get(0)) / Double.valueOf(resultsDivide.get(1))));
        }
        super.onSaveInstanceState(outState);
    }

    public void setFrag3Prop() {
        this.fieldAfrag3 = view_frag3.findViewById(R.id.fieldAFrag3);
        this.fieldBfrag3 = view_frag3.findViewById(R.id.fieldBFrag3);
        this.fieldCfrag3 = view_frag3.findViewById(R.id.fieldCFrag3);
        this.fieldDfrag3 = view_frag3.findViewById(R.id.fieldDFrag3);
        this.fieldXfrag3 = view_frag3.findViewById(R.id.fieldXFrag3);
        this.fieldYfrag3 = view_frag3.findViewById(R.id.fieldYFrag3);
        this.decimal_frag3 = view_frag3.findViewById(R.id.decimalTextFrag3);
        this.decimal_btn_frag3 = view_frag3.findViewById(R.id.btn_sbmt_frag3);
    }

    public void setTextFrag3() {
        this.fieldAfrag3.setText(String.valueOf(this.enteredValue3.get(0)));
        this.fieldBfrag3.setText(String.valueOf(this.enteredValue3.get(1)));
        this.fieldCfrag3.setText(String.valueOf(this.enteredValue3.get(2)));
        this.fieldDfrag3.setText(String.valueOf(this.enteredValue3.get(3)));
        this.fieldXfrag3.setText(String.valueOf(this.resultsDivide.get(0)));
        this.fieldYfrag3.setText(String.valueOf(this.resultsDivide.get(1)));
    }
}
