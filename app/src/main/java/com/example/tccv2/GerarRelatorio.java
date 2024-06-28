package com.example.tccv2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

public class GerarRelatorio extends AppCompatActivity {
    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idPCir;
    private long idPCec;
    private long idCalculoInicial;
    private long idExamesRep;
    private long idCalculo_Rep;
    private long idProcedimento;
    private DbHelper dbHelper;
    private TextView id_proc;
    private TextView id_dataIni;
    private TextView id_horaIni;
    private TextView id_oxig;
    private TextView id_canulaAoA;
    private TextView id_canulaVe;
    private TextView id_CEC;
    private TextView id_Clamp;
    private TextView id_dataFim;
    private TextView id_horaFim;
    private TextView id_cir;
    private TextView id_aux1;
    private TextView id_aux2;
    private TextView id_perf;
    private TextView id_hosp;
    private TextView id_escolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        // Inicializando os componentes
        iniciarComponentes();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Recuperar extras
        recuperarExtras();

        // Recuperar os dados do relatorio
        //criarRelatorio();
    }

    private void iniciarComponentes(){
        id_proc = findViewById(R.id.id_proc);
        id_dataIni = findViewById(R.id.id_dataIni);
        id_horaIni = findViewById(R.id.id_horaIni);
        id_oxig = findViewById(R.id.id_oxig);
        id_canulaAoA = findViewById(R.id.id_canulaAoA);
        id_canulaVe = findViewById(R.id.id_canulaVe);
        id_CEC = findViewById(R.id.id_CEC);
        id_Clamp = findViewById(R.id.id_Clamp);
        id_dataFim = findViewById(R.id.id_dataFim);
        id_horaFim = findViewById(R.id.id_horaFim);
        id_cir = findViewById(R.id.id_cir);
        id_aux1 = findViewById(R.id.id_aux1);
        id_aux2 = findViewById(R.id.id_aux2);
        id_perf = findViewById(R.id.id_perf);
        id_hosp = findViewById(R.id.id_hosp);
        id_escolhido = findViewById(R.id.id_escolhido);
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

        // Recuperar idProcedimento
        idProcedimento = getIntent().getLongExtra("PROCEDIMENTO_ID", -1);

        Log.d("Relatorio", "userId: " + userId);
        Log.d("Relatorio", "EQUIPE_ID: " + idEquipe);
        Log.d("Relatorio", "PACIENTE_ID: " + idPaciente);
        Log.d("Relatorio", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("Relatorio", "PCIR_ID: " + idPCir);
        Log.d("Relatorio", "PCEC_ID: " + idPCec);
        Log.d("Relatorio", "CALCULOINICIAL_ID: " + idCalculoInicial);
        Log.d("Relatorio", "EXAMESREP_ID:" + idExamesRep);
        Log.d("Relatorio", "CALCULOREP_ID:" + idCalculo_Rep);
        Log.d("Relatorio", "PROCEDIMENTO_ID: " +idProcedimento);
    }

   /*private void criarRelatorio() {
        Relatorio relatorio = dbHelper.gerarRelatorio(userId);
        if (relatorio != null) {
            id_proc.setText(relatorio.getProcedimento());
            id_cir.setText(relatorio.getCirurgiao());
            id_aux1.setText(relatorio.getAuxiliar1());
            id_aux2.setText(relatorio.getAuxiliar2());
            id_perf.setText(relatorio.getPerfusionista());
            id_hosp.setText(relatorio.getHospital());
            id_escolhido.setText(relatorio.getVo2Escolhido());
            id_dataIni.setText(relatorio.getDataInicio());
            id_horaIni.setText(relatorio.getHoraInicio());
            id_dataFim.setText(relatorio.getDataFim());
            id_horaFim.setText(relatorio.getHoraFim());
            id_oxig.setText(relatorio.getOxigenador());
            id_canulaAoA.setText(relatorio.getCanulaAA());
            id_canulaVe.setText(relatorio.getCanulaV());
            id_CEC.setText(relatorio.getTotlaCEC);
            id_Clamp.setText(relatorio.getTotalClamp);
        }*/
    }
}