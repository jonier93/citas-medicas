package com.example.gestion_citas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Paciente_view extends AppCompatActivity {
    private EditText id;
    private EditText nombre;
    private EditText correo;
    private EditText password;
    private Spinner eps;
    private Spinner aficiliacion;
    private Spinner regimen;
    private Button btnRegistrar;
    private ModeloPaciente paciente;
    private File file;
    private String file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_view);

        inicializar_elementos();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paciente.setIdentificacion(Integer.parseInt(id.getText().toString()));
                paciente.setNombre(nombre.getText().toString());
                paciente.setCorreo(correo.getText().toString());
                paciente.setContrasena(password.getText().toString());
                paciente.setEps(eps.getSelectedItem().toString());
                paciente.setTipoAfiliacion(aficiliacion.getSelectedItem().toString());
                paciente.setRegimen(regimen.getSelectedItem().toString());
                Toast.makeText(Paciente_view.this, "Usuario registrado", Toast.LENGTH_LONG).show();
                saveData();
                readData();
            }
        });

    }
    private void inicializar_elementos(){
        id = (EditText) findViewById(R.id.txtIdPac);
        nombre = (EditText) findViewById(R.id.txtNombrePac);
        correo = (EditText) findViewById(R.id.txtCorreoPac);
        password = (EditText) findViewById(R.id.txtPasswordPac);
        eps = (Spinner) findViewById(R.id.selectEps);
        aficiliacion = (Spinner) findViewById(R.id.selectAfiliacion);
        regimen = (Spinner) findViewById(R.id.selectRemigen);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrarPac);
        paciente = new ModeloPaciente();
        opciones_spinner();
        file_name = "datosArchivo.json";
        file = new File(this.getFilesDir(), file_name);
    }

    private void opciones_spinner() {
        String array_eps [] = {"Sura", "Colsanitas", "Compensar"};
        ArrayAdapter<String> array_adapter = new ArrayAdapter<>(Paciente_view.this,
                android.R.layout.simple_spinner_item, array_eps);
        eps.setAdapter(array_adapter);

        String array_aficialiacion [] = {"Particular", "Eps", "Prepagada"};
        array_adapter = new ArrayAdapter<>(Paciente_view.this,
                android.R.layout.simple_spinner_item, array_aficialiacion);
        aficiliacion.setAdapter(array_adapter);

        String array_regimen [] = {"Contributivo", "Beneficiario"};
        array_adapter = new ArrayAdapter<>(Paciente_view.this,
                android.R.layout.simple_spinner_item, array_aficialiacion);
        regimen.setAdapter(array_adapter);
    }

    private void saveData() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("{'nombre':'" + paciente.getNombre() + "', 'apellido':'Porras', 'edad':29}");
            bufferedWriter.close();
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();
        }
        catch (IOException err) {
            Log.e("MyTag", err.toString());
        }
    }
    private  void readData() {
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        try {
            fileReader = new FileReader(file.getAbsoluteFile());
            bufferReader = new BufferedReader(fileReader);
            String line;
            String datos = "";
            while((line = bufferReader.readLine()) != null) {
                datos += line + " ";
            }
            bufferReader.close();
            JSONObject objJson = new JSONObject(datos);
            Log.i("MyTag", datos);
            Log.i("MyTag", objJson.getString("nombre") + " " +
                    objJson.getString("apellido") + " " + objJson.getInt("edad"));

        }
        catch (Exception err) {
            Log.e("MyTag", err.toString());
        }
    }

}