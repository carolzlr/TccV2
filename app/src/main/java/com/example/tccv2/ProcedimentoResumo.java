package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.adapter.AdapterEquipe;
import com.example.tccv2.adapter.AdapterProcedimento;
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.entidades.Procedimento;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class ProcedimentoResumo extends AppCompatActivity {
    private RecyclerView recyclerViewProcedimento;
    private ImageButton bt_home;
    private AdapterProcedimento adapterProcedimento;
    private DbHelper dbHelper;
    private List<Procedimento> resumoProcedimento;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimento_resumo);

        // Inicializar os componentes de interface
        iniciarComponentes();

        // Recuperar os ids
        recuperarId();

        // Verifica se o ID do usuário é válido
        if (userId != -1) {
            // Inicializa o banco de dados
            dbHelper = new DbHelper(this);

            // Recupera as equipes
            resumoProcedimento = dbHelper.resumirProcedimento(userId);

            // Configura o Adapter do RecyclerView
            adapterProcedimento = new AdapterProcedimento(resumoProcedimento);
            recyclerViewProcedimento.setAdapter(adapterProcedimento);
        }

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProcedimentoResumo.this, TelaPrincipal.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    private void iniciarComponentes() {
        bt_home = findViewById(R.id.bt_home);
        recyclerViewProcedimento = findViewById(R.id.recyclerViewProcedimento);
        recyclerViewProcedimento.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProcedimento.setHasFixedSize(true);
    }

    private void recuperarId() {
        userId = getIntent().getIntExtra("USER_ID", -1);
    }
}