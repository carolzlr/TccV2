package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tccv2.helper.DbHelper;

import java.util.Locale;

public class Cad_Paciente extends AppCompatActivity {
    private TextView id_superficie;
    TextView id_fluxo1;
    TextView id_fluxo2;
    TextView id_fluxo3;
    private EditText id_idade;
    private EditText id_genero;
    private EditText id_peso;
    private EditText id_estatura;
    private EditText id_diagnostico;
    private Button bt_salvar;

    private DbHelper dbHelper;

    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais
    private int userId;
    private long idEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_paciente);

        //Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = Locale.getDefault();

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paciente();
            }
        });

        // Adicionando ouvintes de texto para peso e estatura
        id_peso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                calcularValores();
            }
        });

        id_estatura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                calcularValores();
            }
        });
    }

    private void iniciarComponentes() {
        bt_salvar = findViewById(R.id.bt_salvar);
        id_idade = findViewById(R.id.id_idade);
        id_genero = findViewById(R.id.id_genero);
        id_peso = findViewById(R.id.id_peso);
        id_estatura = findViewById(R.id.id_estatura);
        id_superficie = findViewById(R.id.id_superficie);
        id_fluxo1 = findViewById(R.id.id_fluxo1);
        id_fluxo2 = findViewById(R.id.id_fluxo2);
        id_fluxo3 = findViewById(R.id.id_fluxo3);
        id_diagnostico = findViewById(R.id.id_diagnostico);
    }

    private void calcularValores() {
        String peso = id_peso.getText().toString();
        String estatura = id_estatura.getText().toString();

        if (!peso.isEmpty() && !estatura.isEmpty()) {
            double pesoDouble = Double.parseDouble(peso);
            double estaturaDouble = Double.parseDouble(estatura);

            // Calculando a superfície corpórea
            double superficie = Math.sqrt((pesoDouble * estaturaDouble) / 3600);

            // Atualizando o campo de texto da superfície corpórea com o resultado
            id_superficie.setText(String.format(locale, "%.2f", superficie));

            // Calculando os valores de fluxo1, fluxo2 e fluxo3
            double fluxo1Value = superficie * 1.8;
            double fluxo2Value = superficie * 2;
            double fluxo3Value = superficie * 2.2;

            // Atualizando os campos de texto dos fluxos com os resultados
            id_fluxo1.setText(String.format(locale, "%.2f", fluxo1Value));
            id_fluxo2.setText(String.format(locale, "%.2f", fluxo2Value));
            id_fluxo3.setText(String.format(locale, "%.2f", fluxo3Value));
        }
    }

    private void Paciente() {
        // Coletar todos os dados dos campos
        String idade = id_idade.getText().toString();
        String genero = id_genero.getText().toString();
        String peso = id_peso.getText().toString();
        String estatura = id_estatura.getText().toString();
        String superficieCorporea = id_superficie.getText().toString();
        String fluxo1 = id_fluxo1.getText().toString();
        String fluxo2 = id_fluxo2.getText().toString();
        String fluxo3 = id_fluxo3.getText().toString();
        String diagnostico = id_diagnostico.getText().toString();

        if (userId != -1) {
            long idPaciente = dbHelper.adicionarPaciente(userId, idade, genero, peso, estatura, superficieCorporea,
                    fluxo1, fluxo2, fluxo3, diagnostico);
            if (idPaciente != -1) {
                Intent intent = new Intent(Cad_Paciente.this, ExamesAdicionais.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Paciente adicionada com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao adicionar paciente.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
        }
    }
}