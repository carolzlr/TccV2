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

public class P_Cec extends AppCompatActivity {
    private EditText id_piaCec, id_pvcCec, id_tempCec, id_diureseCec, id_fcCec, id_horaInicioCec;
    private Button bt_salvar_p;
    private DbHelper dbHelper;

    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idPCir;
    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais
    private static final String TAG = "P_Cir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcec);

        //Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = Locale.getDefault();

        // Recuperar ids
        recuperar();

        bt_salvar_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarPCec();
            }
        });

    }

    private void iniciarComponentes() {
        bt_salvar_p = findViewById(R.id.bt_salvar_p);
        id_piaCec = findViewById(R.id.id_piaCec);
        id_pvcCec = findViewById(R.id.id_pvcCec);
        id_tempCec = findViewById(R.id.id_tempCec);
        id_diureseCec = findViewById(R.id.id_diureseCec);
        id_fcCec = findViewById(R.id.id_fcCec);
        id_horaInicioCec = findViewById(R.id.id_horaInicioCec);
    }

    private void recuperar(){
        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);

        // Recuperar idExamesAdicionais
        idExamesAdicionais = getIntent().getLongExtra("EXAMESADICIONAIS_ID", -1);

        // Recuperar o idPCir
        idPCir = getIntent().getLongExtra("PCIR_ID", -1);

        Log.d("P_Cec", "userId: " + userId);
        Log.d("P_Cec", "EQUIPE_ID: " + idEquipe);
        Log.d("P_Cec", "PACIENTE_ID: " + idPaciente);
        Log.d("P_Cec", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("P_Cec", "PCIR_ID: " + idPCir);
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

    private void salvarPCec (){
        // Obtendo os valores dos EditText
        String piaCec = id_piaCec.getText().toString();
        String pvcCec = id_pvcCec.getText().toString();
        String tempCec = id_tempCec.getText().toString();
        String diureseCec = id_diureseCec.getText().toString();
        String fcCec = id_fcCec.getText().toString();
        String horaInicioCec = id_horaInicioCec.getText().toString();

        // Formatando os valores numéricos
        piaCec = formatarValor(piaCec);
        pvcCec = formatarValor(pvcCec);
        tempCec = formatarValor(tempCec);
        diureseCec = formatarValor(diureseCec);
        fcCec = formatarValor(fcCec);

        // Salvando os valores no banco de dados utilizando o DbHelper
        if (userId != -1) {
            long idPCec = dbHelper.adicionarParametrosCec(userId, piaCec, pvcCec, tempCec, diureseCec,
                    fcCec, horaInicioCec);
            if (idPCec != -1) {Intent intent = new Intent(P_Cec.this, CalculoInicial.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                intent.putExtra("PCIR_ID", idPCir);
                intent.putExtra("PCEC_ID", idPCec);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Parametros adicionados com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao adicionar parametros.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
        }
    }

}