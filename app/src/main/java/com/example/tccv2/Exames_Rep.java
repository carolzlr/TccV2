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

public class Exames_Rep extends AppCompatActivity {

    private EditText rep_ph;
    private EditText rep_pco2;
    private EditText rep_po2;
    private EditText rep_svo2;
    private EditText rep_hco3;
    private EditText rep_beecf;
    private EditText rep_k;
    private EditText rep_na;
    private EditText rep_ca;
    private EditText rep_cl;
    private EditText rep_glic;
    private EditText rep_lact;
    private EditText rep_hemogl;
    private EditText rep_htc;
    private EditText rep_plaq;
    private EditText rep_tca;
    private EditText rep_hora;

    private ImageButton bt_voltar_rep;
    private Button bt_salvar_rep;
    private DbHelper dbHelper;
    private static final String TAG = "Exames_Rep";
    private String areaSupCValue;
    private Locale locale;
    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idCalculoInicial ;
    private long idPCir;
    private long idPCec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exames_rep);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = new Locale("pt", "BR");
        
        // Recuperar Ids
        recuperarId();

        
        bt_salvar_rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarExamesRep();
            }
        });
    }

    private void iniciarComponentes() {
        bt_salvar_rep = findViewById(R.id.bt_salvar_rep);
        rep_ph = findViewById(R.id.rep_ph);
        rep_pco2 = findViewById(R.id.rep_pco2);
        rep_po2 = findViewById(R.id.rep_po2);
        rep_svo2 = findViewById(R.id.rep_svo2);
        rep_hco3 = findViewById(R.id.rep_hco3);
        rep_beecf= findViewById(R.id.rep_beecf);
        rep_k = findViewById(R.id.rep_k);
        rep_na = findViewById(R.id.rep_na);
        rep_ca = findViewById(R.id.rep_ca);
        rep_cl = findViewById(R.id.rep_cl);
        rep_glic = findViewById(R.id.rep_glic);
        rep_lact = findViewById(R.id.rep_lact);
        rep_hemogl= findViewById(R.id.rep_hemogl);
        rep_htc = findViewById(R.id.rep_htc);
        rep_plaq = findViewById(R.id.rep_plaq);
        rep_tca = findViewById(R.id.rep_tca);
        rep_hora = findViewById(R.id.rep_hora);
        bt_voltar_rep = findViewById(R.id.bt_voltar_rep);
    }
    
    private void recuperarId(){
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

        Log.d("ExamesRep", "userId: " + userId);
        Log.d("ExamesRep", "EQUIPE_ID: " + idEquipe);
        Log.d("ExamesRep", "PACIENTE_ID: " + idPaciente);
        Log.d("ExamesRep", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("ExamesRep", "PCIR_ID: " + idPCir);
        Log.d("ExamesRep", "PCEC_ID: " + idPCec);
        Log.d("ExamesRep", "CALCULOINICIAL_ID: " + idCalculoInicial);
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

    private void salvarExamesRep(){
        // Obtendo os valores dos EditText
        String ph_rep = rep_ph.getText().toString();
        String pco2_rep = rep_pco2.getText().toString();
        String po2_rep  = rep_po2.getText().toString();
        String svo2_rep  = rep_svo2.getText().toString();
        String hco3_rep  = rep_hco3.getText().toString();
        String beecf_rep  = rep_beecf.getText().toString();
        String k_rep  = rep_k.getText().toString();
        String na_rep  = rep_na.getText().toString();
        String ca_rep  = rep_ca.getText().toString();
        String cl_rep  = rep_cl.getText().toString();
        String glic_rep  = rep_glic.getText().toString();
        String lact_rep  = rep_lact.getText().toString();
        String hb_rep  = rep_hemogl.getText().toString();
        String htc_rep  = rep_htc.getText().toString();
        String plaq_rep  = rep_plaq.getText().toString();
        String tca_rep  = rep_tca.getText().toString();
        String hora_rep  = rep_hora.getText().toString();

        // Formatando os valores numéricos
        ph_rep  = formatarValor(ph_rep );
        pco2_rep  = formatarValor(pco2_rep );
        po2_rep  = formatarValor(po2_rep );
        svo2_rep  = formatarValor(svo2_rep );
        hco3_rep  = formatarValor(hco3_rep );
        beecf_rep  = formatarValor(beecf_rep );
        k_rep  = formatarValor(k_rep );
        na_rep  = formatarValor(na_rep );
        ca_rep  = formatarValor(ca_rep );
        cl_rep  = formatarValor(cl_rep );
        glic_rep  = formatarValor(glic_rep );
        lact_rep  = formatarValor(lact_rep );
        hb_rep  = formatarValor(hb_rep );
        htc_rep  = formatarValor(htc_rep );
        plaq_rep  = formatarValor(plaq_rep );
        tca_rep  = formatarValor(tca_rep );
        hora_rep  = formatarValor(hora_rep );

        // Salvando os valores no banco de dados utilizando o DbHelper
        if (userId != -1) {
            long idExamesRep = dbHelper.adicionarExamesRep(userId, ph_rep, pco2_rep, po2_rep, svo2_rep, hco3_rep,
                    beecf_rep, k_rep, na_rep, ca_rep, cl_rep, glic_rep, lact_rep, hb_rep, htc_rep, plaq_rep,
                    tca_rep, hora_rep );
            if (idExamesRep != -1) {
                Intent intent = new Intent(Exames_Rep.this, Calculo_Rep.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                intent.putExtra("PCIR_ID", idPCir);
                intent.putExtra("PCEC_ID", idPCec);
                intent.putExtra("CALCULOINICIAL_ID", idCalculoInicial);
                intent.putExtra("EXAMESREP_ID", idExamesRep);
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
