package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.adapter.AdapterEquipe;
import com.example.tccv2.adapter.AdapterRelatorios;
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.entidades.Relatorio;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class RelatorioResumo extends AppCompatActivity {
    private RecyclerView recyclerViewRelatorio;
    private ImageButton bt_home;
    private AdapterRelatorios adapterRelatorios;
    private DbHelper dbHelper;
    private List<Relatorio> resumoRelatorios;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_resumo);

        // Inicializar os componentes de interface
        iniciarComponentes();

        // Recuperar os ids
        recuperarId();

        // Verifica se o ID do usuário é válido
        if (userId != -1) {
            // Inicializa o banco de dados
            dbHelper = new DbHelper(this);
            // Recupera as equipes
            resumoRelatorios = dbHelper.resumoRelatorios(userId);
            // Configura o Adapter do RecyclerView
            adapterRelatorios = new AdapterRelatorios(resumoRelatorios);
            recyclerViewRelatorio.setAdapter(adapterRelatorios);
        }

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RelatorioResumo.this, TelaPrincipal.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    private void iniciarComponentes() {
        bt_home = findViewById(R.id.bt_home);
        recyclerViewRelatorio = findViewById(R.id.recyclerViewRelatorio);
        recyclerViewRelatorio.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorio.setHasFixedSize(true);
    }

    private void recuperarId() {
        userId = getIntent().getIntExtra("USER_ID", -1);
    }
}
