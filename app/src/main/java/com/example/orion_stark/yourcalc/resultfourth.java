package com.example.orion_stark.yourcalc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class resultfourth extends Fragment {

    TextView fieldAfrag4, fieldBfrag4, fieldCfrag4, fieldDfrag4, fieldXfrag4, fieldYfrag4, decimalTextfrag4;
    Button submit_btn_frag4;
    private View view_frag4;
    private ArrayList<Integer> resultsmult = new ArrayList<>();
    private ArrayList<Integer> enteredValue4 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_frag4 = inflater.inflate(R.layout.resultfourth, container, false);

        setPropsFrag4();
        if (!(getArguments() == null)) {
            this.resultsmult = getArguments().getIntegerArrayList("ResultsKali");
            this.enteredValue4 = getArguments().getIntegerArrayList("EnteredValue");
            setTextfrag4();
        }
        if (!(savedInstanceState == null)) {
            decimalTextfrag4.setText(savedInstanceState.getString("ManaDecimalku"));
        }
        this.submit_btn_frag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimalTextfrag4.setText(String.valueOf(Double.valueOf(resultsmult.get(0)) / Double.valueOf(resultsmult.get(1))));
            }
        });

        return view_frag4;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!this.decimalTextfrag4.getText().equals("")) {
            outState.putString("ManaDecimalku", String.valueOf(Double.valueOf(resultsmult.get(0)) / Double.valueOf(resultsmult.get(1))));
        }
        super.onSaveInstanceState(outState);
    }

    public void setPropsFrag4() {
        this.fieldAfrag4 = view_frag4.findViewById(R.id.fieldAFrag4);
        this.fieldBfrag4 = view_frag4.findViewById(R.id.fieldBFrag4);
        this.fieldCfrag4 = view_frag4.findViewById(R.id.fieldCFrag4);
        this.fieldDfrag4 = view_frag4.findViewById(R.id.fieldDFrag4);
        this.fieldXfrag4 = view_frag4.findViewById(R.id.fieldXFrag4);
        this.fieldYfrag4 = view_frag4.findViewById(R.id.fieldYFrag4);
        this.decimalTextfrag4 = view_frag4.findViewById(R.id.decimalTextFrag4);
        this.submit_btn_frag4 = view_frag4.findViewById(R.id.btn_sbmt_frag4);
    }

    public void setTextfrag4() {
        this.fieldAfrag4.setText(String.valueOf(this.enteredValue4.get(0)));
        this.fieldBfrag4.setText(String.valueOf(this.enteredValue4.get(1)));
        this.fieldCfrag4.setText(String.valueOf(this.enteredValue4.get(2)));
        this.fieldDfrag4.setText(String.valueOf(this.enteredValue4.get(3)));

        this.fieldXfrag4.setText(String.valueOf(this.resultsmult.get(0)));
        this.fieldYfrag4.setText(String.valueOf(this.resultsmult.get(1)));
    }
}
