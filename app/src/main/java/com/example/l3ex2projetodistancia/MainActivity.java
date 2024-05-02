package com.example.l3ex2projetodistancia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumo;
    private EditText etLitro;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etConsumo = findViewById(R.id.etConsumo);
        etConsumo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etLitro = findViewById(R.id.etLitro);
        etLitro.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        double consumo = Double.parseDouble(etConsumo.getText().toString());
        double litro = Double.parseDouble(etLitro.getText().toString());
        double resultado = consumo * litro;
        String res = resultado + getString(R.string.resultado);
        tvResultado.setText(res);
    }
}