package com.example.gestion_citas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Medico_view extends AppCompatActivity {
    private EditText id;
    private EditText nombre;
    private EditText correo;
    private EditText password;
    private Spinner especialidad;
    private Spinner consultorio;
    private Button registrarMedicos;
    private ModeloMedico objMedico;
    private ArrayList<String> arrayAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico_view2);

        inicializar();
        opciones_spinner();

        registrarMedicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objMedico.setIdentificacion(Integer.parseInt(id.getText().toString()));
                objMedico.setNombre(nombre.getText().toString());
                objMedico.setCorreo(correo.getText().toString());
                objMedico.setContrasena(password.getText().toString());
                objMedico.setEspecialidad(especialidad.getSelectedItem().toString());
                objMedico.setConsultorio(consultorio.getSelectedItem().toString());
                objMedico.setAgenda(arrayAgenda);
                Toast.makeText(Medico_view.this, "Usuario registrado", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void inicializar(){
        id = findViewById(R.id.txtIdMed);
        nombre = findViewById(R.id.txtNombreMed);
        correo = findViewById(R.id.txtCorreoMed);
        password = findViewById(R.id.txtPasswordMed);
        especialidad = findViewById(R.id.selectEspecialidad);
        consultorio = findViewById(R.id.selectConsultorio);
        registrarMedicos = findViewById(R.id.btnRegistrarMed);
        objMedico = new ModeloMedico();
        arrayAgenda = new ArrayList<>();
        arrayAgenda.add("");
    }

    private void opciones_spinner(){
        String array_especialidad [] = {"general", "cirujano", "pediatra"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, array_especialidad);
        especialidad.setAdapter(arrayAdapter);

        String array_consultorio [] = {"chapinero","usaquen", "centro"};
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, array_consultorio);
        consultorio.setAdapter(arrayAdapter);
    }
}