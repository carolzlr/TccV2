package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.tccv2.helper.DbHelper;
import com.google.android.material.button.MaterialButton;

public class TelaPrincipal extends AppCompatActivity {
    private ImageButton bt_perfil;
    private ImageButton bt_sair;
    private TextView nome_app;
    private TextView nome_usuario;
    private CardView card_paciente;
    private CardView card_procedimento;
    private CardView card_formulas;
    private CardView card_relatorio;
    private CardView card_info;
    private CardView card_equipe;
    private MaterialButton bt_iniciar;
    private int userId;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Inicializando os componentes
        iniciarComponentes();

        // Exibir o nome do usuário na tela
        exibirNomeUsuario();

        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        bt_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Cad_Equipe.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Perfil.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, PacienteResumo.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_formulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Formulas.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, RelatorioResumo.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_procedimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, ProcedimentoResumo.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Infos.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        card_equipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, EquipeResumo.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    // Método para inicializar os componentes de interface
    private void iniciarComponentes() {
        bt_sair = findViewById(R.id.bt_sair);
        bt_iniciar = findViewById(R.id.bt_iniciar);
        bt_perfil = findViewById(R.id.bt_perfil);
        nome_app = findViewById(R.id.nome_app);
        nome_usuario = findViewById(R.id.nome_usuario);
        card_paciente = findViewById(R.id.card_paciente);
        card_formulas = findViewById(R.id.card_formulas);
        card_info = findViewById(R.id.card_info);
        card_relatorio = findViewById(R.id.card_relatorio);
        card_procedimento = findViewById(R.id.card_procedimento);
        card_equipe = findViewById(R.id.card_equipe);
    }

    // Método para exibir o nome do usuário na tela
    private void exibirNomeUsuario() {
        dbHelper = new DbHelper(this);
        String userName = dbHelper.recuperarNome(userId);
        if (userName != null) {
            nome_usuario.setText(userName);
        }
    }
}