package com.example.orion_stark.yourcalc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class Calc extends AppCompatActivity {
    private MathFunc math = new MathFunc();
    private EditText a, b, c, d;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setProp();
    }

    private void setProp(){
        this.a = findViewById(R.id.aField);
        this.b = findViewById(R.id.bField);
        this.c = findViewById(R.id.cField);
        this.d = findViewById(R.id.dField);
        this.submitBtn = findViewById(R.id.btnSubmit);

        this.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    math.setValue((Integer.valueOf(a.getText().toString())), Integer.valueOf(b.getText().toString()),
                            Integer.valueOf(c.getText().toString()), Integer.valueOf(d.getText().toString()));
                    startActivity(new Intent(Calc.this, Results.class)
                            .putExtra("Avalue", math.a)
                            .putExtra("Bvalue", math.b)
                            .putExtra("Cvalue", math.c)
                            .putExtra("Dvalue", math.d)
                            .putIntegerArrayListExtra("ResultTambah", (ArrayList<Integer>) math.tambah())
                            .putIntegerArrayListExtra("ResultKurang", (ArrayList<Integer>) math.kurang())
                            .putIntegerArrayListExtra("ResultBagi", (ArrayList<Integer>) math.bagi())
                            .putIntegerArrayListExtra("ResultKali", (ArrayList<Integer>) math.kali()));

                } catch (Exception a){
                    AlertDialog.Builder alertD = new AlertDialog.Builder(Calc.this);
                    alertD.setTitle("Warning")
                            .setMessage(a.getMessage())
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
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
