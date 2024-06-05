package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

import java.util.Locale;

public class ExamesAdicionais extends AppCompatActivity {
    private EditText id_ph;
    private EditText id_pco2;
    private EditText id_po2;
    private EditText id_svo2;
    private EditText id_hco3;
    private EditText id_beecf;
    private EditText id_k;
    private EditText id_na;
    private EditText id_ca;
    private EditText id_cl;
    private EditText id_glic;
    private EditText id_lact;
    private EditText id_hemogl;
    private EditText id_htc;
    private EditText id_plaq;
    private EditText id_tca;
    private EditText id_hora;
    private ImageButton bt_voltar;
    private Button bt_salvar_e;
    private DbHelper dbHelper;
    private static final String TAG = "Exames_Adicionais";

    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais
    private int userId;
    private long idEquipe;
    private long idPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exames_adicionais);

        //Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = Locale.getDefault();

        // Recuperar ids
        recuperarIds();


        // Configurar botão salvar
        bt_salvar_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarExames();
            }
        });


    }

    private void iniciarComponentes() {
        bt_salvar_e = findViewById(R.id.bt_salvar_e);
        id_ph = findViewById(R.id.id_ph);
        id_pco2 = findViewById(R.id.id_pco2);
        id_po2 = findViewById(R.id.id_po2);
        id_svo2 = findViewById(R.id.id_svo2);
        id_hco3 = findViewById(R.id.id_hco3);
        id_beecf= findViewById(R.id.id_beecf);
        id_k = findViewById(R.id.id_k);
        id_na = findViewById(R.id.id_na);
        id_ca = findViewById(R.id.id_ca);
        id_cl = findViewById(R.id.id_cl);
        id_glic = findViewById(R.id.id_glic);
        id_lact = findViewById(R.id.id_lact);
        id_hemogl= findViewById(R.id.id_hemogl);
        id_htc = findViewById(R.id.id_htc);
        id_plaq = findViewById(R.id.id_plaq);
        id_tca = findViewById(R.id.id_tca);
        id_hora = findViewById(R.id.id_hora);
        bt_voltar = findViewById(R.id.bt_voltar);
    }

    private void recuperarIds(){
        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);

        Log.d("ExamesAdicionais", "userId: " + userId);
        Log.d("ExamesAdicionais", "EQUIPE_ID: " + idEquipe);
        Log.d("ExamesAdicionais", "PACIENTE_ID: " + idPaciente);

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
    
    private void salvarExames(){
        // Obtendo os valores dos EditText
        String ph = id_ph.getText().toString();
        String pco2 = id_pco2.getText().toString();
        String po2  = id_po2.getText().toString();
        String svo2  = id_svo2.getText().toString();
        String hco3  = id_hco3.getText().toString();
        String beecf  = id_beecf.getText().toString();
        String k  = id_k.getText().toString();
        String na  = id_na.getText().toString();
        String ca  = id_ca.getText().toString();
        String cl  = id_cl.getText().toString();
        String glic  = id_glic.getText().toString();
        String lact  = id_lact.getText().toString();
        String hb  = id_hemogl.getText().toString();
        String htc  = id_htc.getText().toString();
        String plaq  = id_plaq.getText().toString();
        String tca  = id_tca.getText().toString();
        String hora  = id_hora.getText().toString();

        // Formatando os valores numéricos
        ph  = formatarValor(ph );
        pco2  = formatarValor(pco2 );
        po2  = formatarValor(po2 );
        svo2  = formatarValor(svo2 );
        hco3  = formatarValor(hco3 );
        beecf  = formatarValor(beecf );
        k  = formatarValor(k );
        na  = formatarValor(na );
        ca  = formatarValor(ca );
        cl  = formatarValor(cl );
        glic  = formatarValor(glic );
        lact  = formatarValor(lact );
        hb  = formatarValor(hb );
        htc  = formatarValor(htc );
        plaq  = formatarValor(plaq );
        tca  = formatarValor(tca );
        hora  = formatarValor(hora );

        // Salvando os valores no banco de dados utilizando o DbHelper
        if (userId != -1) {
            long idExamesAdicionais = dbHelper.adicionarExames(userId, ph, pco2, po2, svo2, hco3, beecf, k, na, ca, cl,
                    glic, lact, hb, htc, plaq, tca, hora );
            if (idExamesAdicionais != -1) {
                Intent intent = new Intent(ExamesAdicionais.this, P_Cir.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Exames adicionados com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao adicionar exames.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
        }
    }

}