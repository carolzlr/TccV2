package com.example.tccv2;

import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;


public class Login extends AppCompatActivity {

    private EditText edit_user, edit_senha;
    private Button bt_entrar;
    private TextView text_tela_cadastro, text_tela_senha;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);


        // Configurando o clique no texto para abrir a tela de cadastro
        // Direciona o usuário que não tem cadastro para a Tela de Cadastro

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Login", "Clicado no TextView para abrir a tela de cadastro");
                Intent intent = new Intent(Login.this, Cad_Usuario.class);
                startActivity(intent);
            }
        });

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edit_user.getText().toString();
                String senha = edit_senha.getText().toString();
                if (!userName.isEmpty() && !senha.isEmpty()){
                    if (dbHelper.verificarUsuario(userName, senha)){
                        int userId  = dbHelper.obterIdUsuario(userName);
                        if (userId !=-1){
                            Intent intent = new Intent(Login.this, TelaPrincipal.class);
                            intent.putExtra("USER_ID", userId);
                            intent.putExtra("userName", userName);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Usuário não cadastrado",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Falha no Login - Dados Inválidos",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Exibir mensagem de erro se algum campo estiver vazio
                    Toast.makeText(Login.this, "Por favor, preencha todos os campos.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        text_tela_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Senha.class);
                startActivity(intent);
                finish();
            }
        });



    }

    // Método para inicializar os componentes de interface
    private void iniciarComponentes(){
        edit_user = findViewById(R.id.edit_user);
        edit_senha = findViewById(R.id.edit_senha);
        bt_entrar = findViewById(R.id.bt_entrar);
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        text_tela_senha = findViewById(R.id.text_tela_senha);
    }
}