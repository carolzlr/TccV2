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
import com.example.tccv2.adapter.AdapterPaciente;
import com.example.tccv2.adapter.AdapterProcedimento;
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.entidades.Paciente;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class PacienteResumo extends AppCompatActivity {
    private RecyclerView recyclerViewPaciente;
    private ImageButton bt_home;
    private AdapterPaciente adapterPaciente;
    private DbHelper dbHelper;
    private List<Paciente> resumoPaciente;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_resumo);

        // Inicializar os componentes de interface
        iniciarComponentes();

        // Recuperar os ids
        recuperarId();

        // Verifica se o ID do usuário é válido
        if (userId != -1) {
            // Inicializa o banco de dados
            dbHelper = new DbHelper(this);
            // Recupera as equipes
            resumoPaciente = dbHelper.resumirPaciente(userId);

            // Configura o Adapter do RecyclerView
            adapterPaciente = new AdapterPaciente(resumoPaciente);
            recyclerViewPaciente.setAdapter(adapterPaciente);
        }

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PacienteResumo.this, TelaPrincipal.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    private void iniciarComponentes() {
        bt_home = findViewById(R.id.bt_home);
        recyclerViewPaciente = findViewById(R.id.recyclerViewPaciente);
        recyclerViewPaciente.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPaciente.setHasFixedSize(true);
    }

    private void recuperarId() {
        userId = getIntent().getIntExtra("USER_ID", -1);
    }
}