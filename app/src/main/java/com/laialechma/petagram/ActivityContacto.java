package com.laialechma.petagram;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityContacto extends AppCompatActivity {

    TextInputEditText agregarname;
    TextInputEditText agregarmaill;
    TextInputEditText agregardescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);




        agregarname = (TextInputEditText) findViewById(R.id.txtname);
        String name = agregarname.getText().toString();


        agregardescripcion = (TextInputEditText) findViewById(R.id.txtdescripcion);
        String descripcion = agregardescripcion.getText().toString();

        agregarmaill= (TextInputEditText) findViewById(R.id.txtmail);
        String email = agregarmaill.getText().toString();



        Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            agregarname.setText(parametros.getString("Nombre"));
            agregardescripcion.setText(parametros.getString("Descripcion"));
            agregarmaill.setText(parametros.getString("Mail"));
        }


        Button botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityContacto.this,PantallaResultadosContacto.class);

                intent.putExtra(getResources().getString(R.string.pname), agregarname.getText().toString());
                intent.putExtra(getResources().getString(R.string.pmail), agregarmaill.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), agregardescripcion.getText().toString());

                startActivity(intent);
            }


        });

    }
}
