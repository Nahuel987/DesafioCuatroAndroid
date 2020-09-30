package com.example.desafiocuatroandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    ImageView imagenAcademia;
    Button btnAbrirWeb;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //se inicia las vistas
        imagenAcademia=findViewById(R.id.imagenAcademia);
        btnAbrirWeb=findViewById(R.id.btnAbriWeb);

        //se reciben datos desde el MainActivity
        Bundle recibirUrl=getIntent().getExtras();
        final String ulrRecibida= Objects.requireNonNull(recibirUrl).getString("Url");

        //boton que abre la web de desafio latam con la url recibida
        btnAbrirWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ulrRecibida));
                startActivity(intent);
            }
        });

    }//on create

}//class