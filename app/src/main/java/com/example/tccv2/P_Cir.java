package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

import java.util.Locale;

public class P_Cir extends AppCompatActivity {
    private EditText id_piaCir;
    private EditText id_pvcCir;
    private EditText id_tempCir;
    private EditText id_diureseCir;
    private EditText id_fcCir;

    private Button bt_iniciar;
    private DbHelper dbHelper;
    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais
    private static final String TAG = "P_Cir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcir);

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

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);

        // Recuperar idExamesAdicionais
        idExamesAdicionais = getIntent().getLongExtra("EXAMESADICIONAIS_ID", -1);

        bt_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P_Cirurgia();
            }
        });
    }

    private void iniciarComponentes() {
        id_piaCir = findViewById(R.id.id_piaCir);
        id_pvcCir = findViewById(R.id.id_pvcCir);
        id_tempCir = findViewById(R.id.id_tempCir);
        id_diureseCir = findViewById(R.id.id_diureseCir);
        id_fcCir = findViewById(R.id.id_fcCir);
        bt_iniciar = findViewById(R.id.bt_iniciar);
    }

    private String formatarValor(String valor) {
        try {
            double doubleValue = Double.parseDouble(valor);
            return String.format(Locale.getDefault(), "%.2f", doubleValue);
        } catch (NumberFormatException e) {
            Log.e(TAG, "Erro ao formatar valor: " + valor, e);
        }
        return valor;
    }

    private void P_Cirurgia() {

        if (idPaciente != -1) {
            // Obtendo os valores dos EditText
            String piaCir = id_piaCir.getText().toString();
            String pvcCir = id_pvcCir.getText().toString();
            String tempCir = id_tempCir.getText().toString();
            String diureseCir = id_diureseCir.getText().toString();
            String fcCir = id_fcCir.getText().toString();

            // Formatando os valores numéricos
            piaCir = formatarValor(piaCir);
            pvcCir = formatarValor(pvcCir);
            tempCir = formatarValor(tempCir);
            diureseCir = formatarValor(diureseCir);
            fcCir = formatarValor(fcCir);


            // Salvando os valores no banco de dados utilizando o DbHelper
            if (userId != -1) {
                long idPCir = dbHelper.adicionarParametrosCir(userId, piaCir, pvcCir, tempCir, diureseCir, fcCir);
                if (idPCir != -1) {
                    Intent intent = new Intent(P_Cir.this, P_Cec.class);
                    // Passar ids para a próxima atividade
                    intent.putExtra("USER_ID", userId);
                    intent.putExtra("EQUIPE_ID", idEquipe);
                    intent.putExtra("PACIENTE_ID", idPaciente);
                    intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                    intent.putExtra("PCIR_ID", idPCir);
                    startActivity(intent);
                    finish();
                    Toast.makeText(this, "Parametros adicionados com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Falha ao adicionar parametros.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de paciente inválido.", Toast.LENGTH_SHORT).show();
        }
    }
}
