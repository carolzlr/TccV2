package com.example.tccv2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.adapter.AdapterEquipe;
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class EquipeResumo extends AppCompatActivity {
    private RecyclerView recyclerViewEquipe;
    private ImageButton bt_home;
    private AdapterEquipe adapterEquipe;
    private DbHelper dbHelper;
    private List<Equipe> resumoEquipe;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_resumo);

        // Inicializar os componentes de interface
        iniciarComponentes();

        // Recuperar os ids
        recuperarId();

        // Verifica se o ID do usuário é válido
        if (userId != -1) {
            // Inicializa o banco de dados
            dbHelper = new DbHelper(this);
            // Recupera as equipes
            resumoEquipe = dbHelper.resumirEquipe(userId);
            // Configura o Adapter do RecyclerView
            adapterEquipe = new AdapterEquipe(resumoEquipe);
            recyclerViewEquipe.setAdapter(adapterEquipe);
        }

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquipeResumo.this, TelaPrincipal.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    private void iniciarComponentes() {
        bt_home = findViewById(R.id.bt_home);
        recyclerViewEquipe = findViewById(R.id.recyclerViewEquipe);
        recyclerViewEquipe.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEquipe.setHasFixedSize(true);
    }

    private void recuperarId() {
        userId = getIntent().getIntExtra("USER_ID", -1);
    }
}