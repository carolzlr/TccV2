package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.tccv2.helper.DbHelper;
import com.google.android.material.button.MaterialButton;

public class TelaPrincipal extends AppCompatActivity {
    private ImageButton bt_perfil;
    private ImageButton bt_menu_lateral;
    private ImageButton bt_sair;

    private TextView nome_app;
    private TextView nome_usuario;
    private TextView paciente;
    private TextView parametros;
    private TextView procedimento;
    private TextView relatorio;
    private TextView exames;
    private TextView registros;

    private ImageView bt_paciente;
    private ImageView bt_parametros;
    private ImageView bt_procedimento;
    private ImageView bt_relatorio;
    private ImageView bt_exames;
    private ImageView bt_registros;

    private CardView card_paciente;
    private CardView card_parametros;
    private CardView card_procedimento;
    private CardView card_relatorio;
    private CardView card_exames;
    private CardView card_registros;
    private MaterialButton bt_pesquisar;
    private MaterialButton bt_iniciar;
    private int userId;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Inicializando os componentes
        iniciarComponentes();

        // Exibir o nome do usuário na tela
        exibirNomeUsuario();

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);
        Log.d("Cad_Paciente", "USER_ID recuperado: " + userId);
        // Adicione um log para verificar o valor do userId

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
                finish();
            }
        });

        bt_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Pesquisar.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Perfil.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();

            }
        });

        bt_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Cad_Paciente.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();

            }
        });

        bt_parametros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, P_Cir.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Relatorio.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_exames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, ExamesAdicionais.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });

        bt_registros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this, Registros.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
                finish();
            }
        });
    }

    // Método para inicializar os componentes de interface
    private void iniciarComponentes() {
        bt_menu_lateral = findViewById(R.id.bt_menu_lateral);
        bt_sair = findViewById(R.id.bt_sair);
        bt_pesquisar = findViewById(R.id.bt_pesquisar);
        bt_iniciar = findViewById(R.id.bt_iniciar);
        bt_perfil = findViewById(R.id.bt_perfil);

        nome_app = findViewById(R.id.nome_app);
        nome_usuario = findViewById(R.id.nome_usuario);
        paciente = findViewById(R.id.paciente);
        parametros = findViewById(R.id.parametros);
        procedimento = findViewById(R.id.procedimento);
        relatorio = findViewById(R.id.relatorio);
        exames = findViewById(R.id.exames);
        registros = findViewById(R.id.registros);

        bt_paciente = findViewById(R.id.bt_paciente);
        bt_parametros = findViewById(R.id.bt_parametros);
        bt_procedimento = findViewById(R.id.bt_procedimento);
        bt_relatorio = findViewById(R.id.bt_relatorio);
        bt_exames = findViewById(R.id.bt_exames);
        bt_registros = findViewById(R.id.bt_registros);

        card_paciente = findViewById(R.id.card_paciente);
        card_parametros = findViewById(R.id.card_parametros);
        card_procedimento = findViewById(R.id.card_procedimento);
        card_relatorio = findViewById(R.id.card_relatorio);
        card_exames = findViewById(R.id.card_exames);
        card_registros = findViewById(R.id.card_registros);
    }

    // Método para exibir o nome do usuário na tela
    private void exibirNomeUsuario() {
        // Recuperar o nome do usuário do extra da intent
        String userName = getIntent().getStringExtra("userName");

        // Exibir o nome do usuário na TextView
        nome_usuario.setText(userName);
    }
}