package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Formulas extends AppCompatActivity {

    private ImageButton bt_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);

        //iniciar os componentes do layout
        iniciarComponentes();


        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulas.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });

    }

    private void iniciarComponentes() {

        bt_voltar = findViewById(R.id.bt_voltar);
    }
}