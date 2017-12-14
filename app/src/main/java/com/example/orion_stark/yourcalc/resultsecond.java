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


public class resultsecond extends Fragment {
    TextView Afield, Bfield, Cfield, Dfield, Xfield, Yfield, decimalfrag2;
    Button submit;
    private View viewfrag2;
    ArrayList<Integer> resultsMinus = new ArrayList<>();
    ArrayList<Integer> enteredValue2 = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewfrag2 = inflater.inflate(R.layout.resultsecond, container, false);

        setProps();
        if (!(getArguments() == null)) {
            resultsMinus = getArguments().getIntegerArrayList("ResultsKurang");
            enteredValue2 = getArguments().getIntegerArrayList("EnteredValue");
            settext();
        }
        if (savedInstanceState != null) {
            decimalfrag2.setText(savedInstanceState.getString("Decimals"));
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimalfrag2.setText(String.valueOf(Double.valueOf(resultsMinus.get(0)) / Double.valueOf(resultsMinus.get(1))));
            }
        });

        return viewfrag2;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!this.decimalfrag2.getText().equals("")) {
            outState.putString("Decimals", String.valueOf(Double.valueOf(resultsMinus.get(0)) / Double.valueOf(resultsMinus.get(1))));
        }
        super.onSaveInstanceState(outState);
    }

    private void setProps() {
        this.Afield = viewfrag2.findViewById(R.id.fieldA);
        this.Bfield = viewfrag2.findViewById(R.id.fieldB);
        this.Cfield = viewfrag2.findViewById(R.id.fieldC);
        this.Dfield = viewfrag2.findViewById(R.id.fieldD);
        this.Xfield = viewfrag2.findViewById(R.id.fieldX);
        this.Yfield = viewfrag2.findViewById(R.id.fieldY);
        this.decimalfrag2 = viewfrag2.findViewById(R.id.decimalTextfrag2);
        this.submit = viewfrag2.findViewById(R.id.submit_frag2);
    }

    private void settext() {
        Afield.setText(String.valueOf(enteredValue2.get(0)));
        Bfield.setText(String.valueOf(enteredValue2.get(1)));
        Cfield.setText(String.valueOf(enteredValue2.get(2)));
        Dfield.setText(String.valueOf(enteredValue2.get(3)));

        Xfield.setText(String.valueOf(resultsMinus.get(0)));
        Yfield.setText(String.valueOf(resultsMinus.get(1)));
    }

}
