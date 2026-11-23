package com.example.contadorclicks;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textoContador;
    int contador = 0;
    @SuppressLint("MissingInflatedId")
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
        textoContador = findViewById(R.id.texto_contador);
    }

    public void sumar (View v){
        contador++;
        actualizarPantalla();
    }

    public void restar(View v) {
        if (contador > 0) {
            contador--;
        }
        actualizarPantalla();
    }

    public void reset(View v) {
        contador = 0;
        actualizarPantalla();
    }

    private void actualizarPantalla() {
        textoContador.setText(String.valueOf(contador));

        if (contador >= 10) {
            textoContador.setTextColor(Color.RED);
        } else {
            textoContador.setTextColor(Color.BLACK);
        }
    }
}