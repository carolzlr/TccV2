package com.example.tccv2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tccv2.helper.DbHelper;

public class Procedimento extends AppCompatActivity {
    private EditText id_nomeP;
    private EditText id_dataI;
    private EditText id_horaI;
    private EditText id_oxi;
    private EditText id_canulaAA;
    private EditText id_canulaV;
    private EditText id_prot;
    private EditText id_hepMg;
    private EditText id_hepMl;
    private EditText id_iCEC;
    private EditText id_fCEC;
    private EditText id_iClamp;
    private EditText id_fClamp;
    private EditText id_obsP;
    private TextView id_totalCEC;
    private TextView id_totalClamp;
    private EditText id_datafProc;
    private EditText id_horafProc;
    private Button bt_salvar_proc;
    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idPCir;
    private long idPCec;
    private long idCalculoInicial;
    private long idExamesRep;
    private long idCalculo_Rep;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimento);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Recuperar extras
        recuperarExtras();
    }



    private void iniciarComponentes(){
       id_nomeP = findViewById(R.id.id_nomeP);
       id_dataI = findViewById(R.id.id_dataI);
       id_horaI = findViewById(R.id.id_horaI);
       id_oxi = findViewById(R.id.id_oxi);
       id_canulaAA = findViewById(R.id.id_canulaAA);
       id_canulaV = findViewById(R.id.id_canulaV);
       id_prot = findViewById(R.id.id_prot);
       id_hepMg = findViewById(R.id.id_hepMg);
       id_hepMl = findViewById(R.id.id_hepMl);
       id_iCEC = findViewById(R.id.id_iCEC);
       id_fCEC = findViewById(R.id.id_fCEC);
       id_totalCEC = findViewById(R.id.id_totalCEC);
       id_iClamp = findViewById(R.id.id_iClamp);
       id_fClamp = findViewById(R.id.id_fClamp);
       id_totalClamp = findViewById(R.id.id_totalClamp);
       id_datafProc = findViewById(R.id.id_datafProc);
       id_horafProc = findViewById(R.id.id_horafProc);
       id_obsP = findViewById(R.id.id_obsP);
       bt_salvar_proc = findViewById(R.id.bt_salvar_proc);
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