package com.example.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Elemente
        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner = findViewById(R.id.nenner);
        int ggt = 1;

        // Zahlenwerte
        int zaehler = Integer.valueOf(etZaehler.getText().toString());
        int nenner = Integer.valueOf(etNenner.getText().toString());

        for (int i = 2; i <= zaehler && i <=nenner; i++) {
            if ((zaehler % i == 0) && (nenner % i == 0)) {
                ggt = i;
            }
        }

        etZaehler.setText(String.valueOf(zaehler / ggt));
        etNenner.setText(String.valueOf(nenner / ggt));
    }
}
