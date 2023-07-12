package com.example.gestion_citas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPacientes;
    private Button btnMedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar_componentes();
        btnPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPacientes = new Intent(MainActivity.this, Paciente_view.class);
                startActivity(intentPacientes);
            }
        });

        btnMedicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMedicos = new Intent(MainActivity.this, Medico_view.class);
                startActivity(intentMedicos);
            }
        });
    }

    private void inicializar_componentes() {
        btnPacientes = (Button) findViewById(R.id.btnPacientes);
        btnMedicos = (Button) findViewById(R.id.btnMedicos);
    }
}