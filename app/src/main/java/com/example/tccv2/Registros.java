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
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.entidades.Paciente;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class Registros extends AppCompatActivity {
    private RecyclerView rv_Equipes;
    private RecyclerView rv_Paciente;
    private AdapterEquipe adapterEquipe;
    private AdapterPaciente adapterPaciente;
    private DbHelper dbHelper;
    private ImageButton bt_voltar;
    private int userId;
    private long idEquipe;
    private long idPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

       /* // Recuperar extras
        recuperarExtras();

        // Inicializando os componentes
        iniciarComponentes();


        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        //Configurando o RV de Equipe
        List<Equipe> equipeList = dbHelper.obterEquipeResumida();
        AdapterEquipe adapterEquipe =new AdapterEquipe((equipeList));
        rv_Equipes.setLayoutManager(new LinearLayoutManager(this));
        rv_Equipes.setAdapter(adapterEquipe);

        //Configurando o RV de Paciente
        List<Paciente> pacienteList = dbHelper.obterPacienteResumido();
        AdapterPaciente adapterPaciente =new AdapterPaciente((pacienteList));
        rv_Paciente.setLayoutManager(new LinearLayoutManager(this));
        rv_Paciente.setAdapter(adapterPaciente);

        //Configurando o botão voltar
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criar um Intent para voltar para página inicial
                Intent intent = new Intent(Registros.this, TelaPrincipal.class);
                // Voltar para a página inicial
                startActivity(intent);
            }
        });


    }

    private void recuperarExtras() {
        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);
    }

    private void iniciarComponentes(){
        bt_voltar = findViewById(R.id.bt_voltar);
        rv_Equipes = findViewById(R.id.rv_Equipes);
        rv_Paciente = findViewById(R.id.rv_Paciente);
    }*/
    }

}