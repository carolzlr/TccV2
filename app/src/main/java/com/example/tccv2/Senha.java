package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

public class Senha extends AppCompatActivity {
    private EditText id_userName;
    private EditText id_email;
    private EditText id_tipo;
    private EditText id_senha;
    private Button bt_nova_senha;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        //Configurar o botão para alterar senha

        bt_nova_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = id_email.getText().toString();
                String userName = id_userName.getText().toString();
                String tipo = id_tipo.getText().toString();
                String novaSenha = id_senha.getText().toString();

                if (email.isEmpty() || userName.isEmpty() || tipo.isEmpty() || novaSenha.isEmpty()) {
                    Toast.makeText(Senha.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean sucesso = dbHelper.atualizarSenha(email, userName, tipo, novaSenha);

                if (sucesso) {
                    Toast.makeText(Senha.this, "Senha atualizada com sucesso.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Senha.this, Login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Senha.this, "Usuário não encontrado. Verifique as informações fornecidas.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarComponentes(){
        id_userName = findViewById(R.id.id_userName);
        id_email = findViewById(R.id.id_email);
        id_tipo = findViewById(R.id.id_tipo);
        id_senha = findViewById(R.id.id_senha);
        bt_nova_senha = findViewById(R.id.bt_nova_senha);
    }
}