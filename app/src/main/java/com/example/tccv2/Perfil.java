package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

public class Perfil extends AppCompatActivity {
    private TextView text_nome_usuario;
    private TextView text_email_usuario;
    private TextView text_senha;
    private Button bt_editar;
    private Button bt_editar_senha;
    private Button bt_sair;
    private DbHelper dbHelper;

    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Iniciar os componentes
        iniciarCompoenetes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        bt_editar_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Senha.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, TelaPrincipal.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, AlterarDados.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });
    }

    private void iniciarCompoenetes(){
        text_nome_usuario = findViewById(R.id.text_nome_usuario);
        text_email_usuario = findViewById(R.id.text_email_usuario);
        text_senha = findViewById(R.id.text_senha_usuario);
        bt_editar = findViewById(R.id.bt_editar);
        bt_editar_senha = findViewById(R.id.bt_editar_senha);
        bt_sair = findViewById(R.id.bt_sair);
    }
}