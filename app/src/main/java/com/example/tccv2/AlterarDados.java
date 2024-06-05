package com.example.tccv2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tccv2.contract.Contract;
import com.example.tccv2.helper.DbHelper;

public class AlterarDados extends AppCompatActivity {
    private EditText id_nome;
    private EditText id_tipo;
    private EditText id_userName;
    private EditText id_email;
    private Button bt_alterar;
    private Button bt_retornar;
    private DbHelper dbHelper;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados);

        // Iniciar os componentes
        iniciarComponentes();

        // Iniciar DbHelper
        dbHelper = new DbHelper(this);

        // Recuperar o id Usuério
        recuperarId();

        // Carregar os dados do usuário do banco de dados
        carregarUsuario();

        // botão voltar
        bt_retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlterarDados.this, Perfil.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        // Botão alterar
        bt_alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = id_nome.getText().toString();
                String email = id_email.getText().toString();
                String userName = id_userName.getText().toString();
                String tipo = id_tipo.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || userName.isEmpty() || tipo.isEmpty()) {
                    Toast.makeText(AlterarDados.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Salvar as alterações no banco de dados
                    boolean success = dbHelper.salvarAlteracoes(userId, nome, email, userName, tipo);
                    if (success) {
                        Intent intent = new Intent(AlterarDados.this, Perfil.class);
                        intent.putExtra("USER_ID", userId);
                        startActivity(intent);
                        Toast.makeText(AlterarDados.this, "Alterações salvas com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AlterarDados.this, "Erro ao salvar alterações", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void iniciarComponentes() {
        id_nome = findViewById(R.id.id_nome);
        id_tipo = findViewById(R.id.id_tipo);
        id_userName = findViewById(R.id.id_userName);
        id_email = findViewById(R.id.id_email);
        bt_alterar = findViewById(R.id.bt_alterar);
        bt_retornar = findViewById(R.id.bt_retornar);
    }

    private void recuperarId() {
        userId = getIntent().getIntExtra("USER_ID", -1);
        Log.d("alterar dados id usuário", "userId: " + userId);
    }

    private void carregarUsuario() {
        Cursor cursor = dbHelper.carregarDadosUsuario(userId);

        if (cursor != null && cursor.moveToFirst()) {
            String nome = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_NOME));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_EMAIL));
            String userName = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_NOME_USUARIO));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_TIPO));

            id_nome.setText(nome);
            id_email.setText(email);
            id_userName.setText(userName);
            id_tipo.setText(tipo);

            cursor.close();
        } else {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}