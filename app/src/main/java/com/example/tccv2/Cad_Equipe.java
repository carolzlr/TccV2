package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tccv2.helper.DbHelper;

public class Cad_Equipe extends AppCompatActivity {

    private EditText id_cirurgiao;
    private EditText id_auxiliar1;
    private EditText id_auxiliar2;
    private EditText id_perfusionista;
    private EditText id_instrumentador;
    private EditText id_anestesista;
    private EditText id_circulante;
    private EditText id_hospital;
    private Button bt_salvar_e;
    private DbHelper dbHelper;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_equipe);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Configurando o OnClickListener para o botão de salvar
        bt_salvar_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Equipe();
            }
        });
    }



    private void iniciarComponentes(){
            id_cirurgiao = findViewById(R.id.id_cirurgiao);
            id_auxiliar1 = findViewById(R.id.id_auxiliar1);
            id_auxiliar2 = findViewById(R.id.id_auxiliar2);
            id_perfusionista = findViewById(R.id.id_perfusionista);
            id_instrumentador = findViewById(R.id.id_instrumentador);
            id_anestesista = findViewById(R.id.id_anestesista);
            id_circulante = findViewById(R.id.id_circulante);
            id_hospital= findViewById(R.id.id_hospital);
            bt_salvar_e = findViewById(R.id.bt_salvar_e);
    }

    private void Equipe() {
        // Coletar todos os dados dos campos
        String cirurgiao = id_cirurgiao.getText().toString();
        String auxiliar1 = id_auxiliar1.getText().toString();
        String auxiliar2 = id_auxiliar2.getText().toString();
        String perfusionista = id_perfusionista.getText().toString();
        String instrumentador = id_instrumentador.getText().toString();
        String anestesista = id_anestesista.getText().toString();
        String circulante = id_circulante.getText().toString();
        String hospital = id_hospital.getText().toString();

        if (userId != -1) {
            long idEquipe = dbHelper.adicionarEquipe(userId, cirurgiao, auxiliar1, auxiliar2,
                    perfusionista, instrumentador, anestesista, circulante, hospital);
            if (idEquipe != -1) {
                Intent intent = new Intent(Cad_Equipe.this, Cad_Paciente.class);
                startActivity(intent);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE _ID", idEquipe);
                finish();
                Toast.makeText(this, "Equipe adicionada com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao adicionar equipe.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
        }
    }
}