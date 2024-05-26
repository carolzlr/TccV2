package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

public class Cad_Usuario extends AppCompatActivity {

    private EditText edit_nome, edit_userName, edit_email, edit_tipo, edit_senha;
    private Button bt_cadastrar;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        //Configurar o botão cadastrar para pegar os dados e salvar no BD

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarUsuario();
            }
        });

    }

    private void iniciarComponentes(){
        edit_nome = findViewById(R.id.edit_nome);
        edit_userName = findViewById(R.id.edit_userName);
        edit_email = findViewById(R.id.edit_email);
        edit_tipo = findViewById(R.id.edit_tipo);
        edit_senha = findViewById(R.id.edit_senha);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);

    }

    private void adicionarUsuario(){
        String nome = edit_nome.getText().toString();
        String userName = edit_userName.getText().toString();
        String email = edit_email.getText().toString();
        String tipo = edit_tipo.getText().toString();
        String senha = edit_senha.getText().toString();
        if (!nome.isEmpty() && !userName.isEmpty() && !email.isEmpty() && !tipo.isEmpty() && !senha.isEmpty()) {
            if (dbHelper.adicionarUsuario(nome, userName, email, tipo, senha)) {
                Toast.makeText(Cad_Usuario.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cad_Usuario.this, Login.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(Cad_Usuario.this, "Falha ao cadastrar usuário. Tente novamente", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Cad_Usuario.this, "Por favor, preencha todos os campos.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}





