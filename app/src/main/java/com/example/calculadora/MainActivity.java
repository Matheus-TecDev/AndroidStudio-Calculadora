package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtFirstNumber, edtSecondNumber;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstNumber = findViewById(R.id.edtFirstNumber);
        edtSecondNumber = findViewById(R.id.edtSecondNumber);
        tvResult = findViewById(R.id.tvResult);

        findViewById(R.id.btnAdd).setOnClickListener(this::onOpClick);
        findViewById(R.id.btnSub).setOnClickListener(this::onOpClick);
        findViewById(R.id.btnMul).setOnClickListener(this::onOpClick);
        findViewById(R.id.btnDiv).setOnClickListener(this::onOpClick);
    }

    private void onOpClick(View v) {
        String s1 = edtFirstNumber.getText().toString().trim();
        String s2 = edtSecondNumber.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Preencha ambos os números", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double r;

        int id = v.getId();
        if (id == R.id.btnAdd) {
            r = a + b;
        } else if (id == R.id.btnSub) {
            r = a - b;
        } else if (id == R.id.btnMul) {
            r = a * b;
        } else {
            if (b == 0) { tvResult.setText("Resultado: indefinido"); return; }
            r = a / b;
        }
        tvResult.setText("Resultado: " + r);
    }
}
