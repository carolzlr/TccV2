package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idPCir;
    private long idPCec;
    private long idCalculoInicial;
    private long idExamesRep;
    private long idCalculo_Rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimento_resumo);

        // Inicializar os componentes de interface
        iniciarComponentes();

        // Recuperar os ids
        recuperarExtras();

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

    private void recuperarExtras(){
        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);

        // Recuperar idExamesAdicionais
        idExamesAdicionais = getIntent().getLongExtra("EXAMESADICIONAIS_ID", -1);

        // Recuperar idPCir
        idPCir = getIntent().getLongExtra("PCIR_ID", -1);

        //Recuperar idPCec
        idPCec = getIntent().getLongExtra("PCEC_ID", -1);

        // Recuperar idExamesAdicionais
        idCalculoInicial = getIntent().getLongExtra("CALCULOINICIAL_ID", -1);

        // Recuperar idExamesRep
        idExamesRep = getIntent().getLongExtra("EXAMESREP_ID", -1);

        // Recuperar idCalculo_Rep
        idCalculo_Rep = getIntent().getLongExtra("CALCULOREP_ID", -1);

        Log.d("Procedimento", "userId: " + userId);
        Log.d("Procedimento", "EQUIPE_ID: " + idEquipe);
        Log.d("Procedimento", "PACIENTE_ID: " + idPaciente);
        Log.d("Procedimento", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("Procedimento", "PCIR_ID: " + idPCir);
        Log.d("Procedimento", "PCEC_ID: " + idPCec);
        Log.d("Procedimento", "CALCULOINICIAL_ID: " + idCalculoInicial);
        Log.d("Procedimento", "EXAMESREP_ID:" + idExamesRep);
        Log.d("Procedimento", "CALCULOREP_ID:" + idCalculo_Rep);
    }
}