package com.example.desafiocuatroandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

   final int REQUEST_IMAGE_CAPTURE = 1;

    ImageView imagen;
    TextView texto;
    Button btnCargar, btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iniciarVistas();

        imagen=findViewById(R.id.imagenPlaceHolder);
        btnCargar=findViewById(R.id.btnCargarImagen);
        btnSiguiente=findViewById(R.id.btnSiguiente);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validar si la imagen se creo
                if(imagen.getDrawable()!=null){
                    //crear intent
                    Intent intent=new Intent(MainActivity.this, ResultActivity.class);

                    //ingresar en el intent la url de desafio latam
                    intent.putExtra("Url","http://www.desafiolatam.com");

                    //pasar a ResultActivity
                    startActivity(intent);

                }
            }
        });

    }//on create

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //imagen=findViewById(R.id.imagenPlaceHolder);
        if ((requestCode == REQUEST_IMAGE_CAPTURE) && (resultCode == RESULT_OK)) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
        }
    }

}//class