package com.example.tccv2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.adapter.AdapterRegistros;
import com.example.tccv2.entidades.Registro;
import com.example.tccv2.helper.DbHelper;

import java.util.List;

public class Registros extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Recuperar extras
        recuperarExtras();

        List<Registro> registros = dbHelper.encontrarRegistroPorUsuario(userId);

        RecyclerView rv_Registros = findViewById(R.id.rv_Registros);
        rv_Registros.setLayoutManager(new LinearLayoutManager(this));
        // Handle item click
        //AdapterRegistros adapter = new AdapterRegistros(registros, this::gerarPDFParaRegistro);
        //rv_Registros.setAdapter(adapter);
    }

    /*private void gerarPDFParaRegistro(Registro registro) {
        String dest = getExternalFilesDir(null) + "/relatorio_" + registro.getIdRegistro() + ".pdf";
        PDFGenerator pdfGenerator = new PDFGenerator();

        try {
            pdfGenerator.createPDF(dest, List.of(registro));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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

        Log.d("Registro", "userId: " + userId);
        Log.d("Registro", "EQUIPE_ID: " + idEquipe);
        Log.d("Registro", "PACIENTE_ID: " + idPaciente);
        Log.d("Registro", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("Registro", "PCIR_ID: " + idPCir);
        Log.d("Registro", "PCEC_ID: " + idPCec);
        Log.d("Registro", "CALCULOINICIAL_ID: " + idCalculoInicial);
        Log.d("Registro", "EXAMESREP_ID:" + idExamesRep);
        Log.d("Registro", "CALCULOREP_ID:" + idCalculo_Rep);
        Log.d("Registro", "PROCEDIMENTO_ID:" +idProcedimento);
    }
}
