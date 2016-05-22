package com.laialechma.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaResultadosContacto extends AppCompatActivity {
    TextView nameView;
    TextView mailView;
    TextView descripcionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultados_contacto);
        Bundle parametros = getIntent().getExtras();
        String name = parametros.getString(getResources().getString(R.string.pname));
        String mail = parametros.getString(getResources().getString(R.string.pmail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
;


        nameView = (TextView) findViewById(R.id.nameView);
        mailView = (TextView) findViewById(R.id.mailView);
        descripcionView = (TextView) findViewById(R.id.descripionView);

        nameView.setText(name);
        mailView.setText(mail);
        descripcionView.setText(descripcion);



        Button botonModificar = (Button) findViewById(R.id.botonModificar);
        botonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaResultadosContacto.this, ActivityContacto.class);
                intent.putExtra(getResources().getString(R.string.pname), nameView.getText().toString());
                intent.putExtra(getResources().getString(R.string.pmail), mailView.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcionView.getText().toString());

                startActivity(intent);


            }

        });
    }
}