package com.example.tccv2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tccv2.entidades.Relatorio;
import com.example.tccv2.helper.DbHelper;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

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
    private Button bt_salvar;
    private Button bt_pdf;
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

    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 1;

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

        // Adicionando TextWatchers para cec
        adicionarTextWatchersCEC();

        // Adicionando TextWatchers para clamp
        adicionarTextWatchersCLAMP();

        // Salvar dados
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProcedimento();
            }
        });

        bt_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gerarRelatorioPDF();

            }
        });

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
       bt_salvar = findViewById(R.id.bt_salvar);
       bt_pdf = findViewById(R.id.bt_pdf);
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

    private void adicionarTextWatchersCEC() {
        // Adicionar TextWatchers para os campos relevantes para recalcular os valores iniciais
        TextWatcher initialWatcher = new Procedimento.TextWatcherCEC();
        id_iCEC.addTextChangedListener(initialWatcher);
        id_fCEC.addTextChangedListener(initialWatcher);
    }

    private void adicionarTextWatchersCLAMP() {
        // Adicionar TextWatchers para os campos relevantes para recalcular os valores iniciais
        TextWatcher initialWatcher = new Procedimento.TextWatcherCLAMP();
        id_iClamp.addTextChangedListener(initialWatcher);
        id_fClamp.addTextChangedListener(initialWatcher);
    }

    private class TextWatcherCEC implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            calcularEExibirTotalCec();
        }
    }

    private class TextWatcherCLAMP implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            calcularEExibirTotalClamp();
        }
    }

    // Método para calcular a diferença entre iClamp e fClamp e exibir o resultado
    private void calcularEExibirTotalCec() {
        String iClampStr = id_iCEC.getText().toString();
        String fClampStr = id_fCEC.getText().toString();

        // Verifica se os EditText não estão vazios
        if (!iClampStr.isEmpty() && !fClampStr.isEmpty()) {
            int iCecMinutos = converterParaMinutos(iClampStr);
            int fCecMinutos = converterParaMinutos(fClampStr);
            int diferencaMinutosCec = fCecMinutos - iCecMinutos;

            // Exibe o resultado no textViewTotalClamp
            id_totalCEC.setText(String.valueOf(diferencaMinutosCec) + " minutos");
        } else {
            // Se algum dos EditText estiver vazio, exibe um texto padrão no textViewTotalClamp
            id_totalCEC.setText("Calcule a diferença");
        }
    }

    // Método para calcular a diferença entre iClamp e fClamp e exibir o resultado
    private void calcularEExibirTotalClamp() {
        String iClampStr = id_iClamp.getText().toString();
        String fClampStr = id_fClamp.getText().toString();

        // Verifica se os EditText não estão vazios
        if (!iClampStr.isEmpty() && !fClampStr.isEmpty()) {
            int iClampMinutos = converterParaMinutos(iClampStr);
            int fClampMinutos = converterParaMinutos(fClampStr);
            int diferencaMinutosClamp = fClampMinutos - iClampMinutos;

            // Exibe o resultado no textViewTotalClamp
            id_totalClamp.setText(String.valueOf(diferencaMinutosClamp) + " minutos");
        } else {
            // Se algum dos EditText estiver vazio, exibe um texto padrão no textViewTotalClamp
            id_totalClamp.setText("Calcule a diferença");
        }
    }

    private int converterParaMinutos(String hora) {
        String[] partes = hora.split(":");
        if (partes.length >= 2) {
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            if (horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59) {
                // Se as horas e os minutos estiverem dentro dos limites válidos
                return horas * 60 + minutos;
            } else {
                // Trate o caso em que as horas ou os minutos estão fora dos limites válidos
                return 0; // Ou algum valor padrão apropriado para o seu caso
            }
        } else {
            // Trate o caso em que a string de hora não tem o formato esperado
            return 0; // Ou algum valor padrão apropriado para o seu caso
        }
    }

    private void salvarProcedimento() {
        String nomeProc = id_nomeP.getText().toString();
        String dataInicio = id_dataI.getText().toString();
        String horaInicio = id_horaI.getText().toString();
        String oxigenador = id_oxi.getText().toString();
        String canulaAA = id_canulaAA.getText().toString();
        String canulaV= id_canulaV.getText().toString();
        String protamina = id_prot.getText().toString();
        String hepMg = id_hepMg.getText().toString();
        String hepMl = id_hepMl.getText().toString();
        String iCec = id_iCEC.getText().toString();
        String fCec = id_fCEC.getText().toString();
        String totalCecString = id_totalCEC.getText().toString();
        String iClamp = id_iClamp.getText().toString();
        String fClamp = id_fClamp.getText().toString();
        String totalClampString = id_totalClamp.getText().toString();
        String datafProc = id_datafProc.getText().toString();
        String horafProc = id_horafProc.getText().toString();
        String obs = id_obsP.getText().toString();

        if (userId != -1) {
            long idProcedimento = dbHelper.adicionarProcedimento(userId, nomeProc, dataInicio, horaInicio,
                    oxigenador, canulaAA, canulaV, protamina, hepMg, hepMl, iCec, fCec, totalCecString, iClamp,
                    fClamp, totalClampString, datafProc, horafProc, obs);
            if (idProcedimento != -1) {
                Toast.makeText(this, "Procedimento adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Falha ao adicionar procedimento.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ID de usuário inválido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void gerarRelatorioPDF() {
        Relatorio relatorio = dbHelper.gerarRelatorio(userId);

        if (relatorio != null) {
            String filePath = getExternalFilesDir(null) + "/Relatorio_" + userId + ".pdf";

            try {
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                document.add(new Paragraph("Relatório do Procedimento"));
                document.add(new Paragraph("Nome do Procedimento: " + relatorio.getProcedimento()));
                document.add(new Paragraph("Data de Início: " + relatorio.getDataInicio()));
                document.add(new Paragraph("Hora de Início: " + relatorio.getHoraInicio()));
                document.add(new Paragraph("Oxigenador: " + relatorio.getOxigenador()));
                document.add(new Paragraph("Cânula AA: " + relatorio.getCanulaAA()));
                document.add(new Paragraph("Cânula V: " + relatorio.getCanulaV()));
                document.add(new Paragraph("Total de CEC: " + relatorio.getTotalCEC()));
                document.add(new Paragraph("Total de Clamp: " + relatorio.getTotalClamp()));
                document.add(new Paragraph("Data de Fim: " + relatorio.getDataFim()));
                document.add(new Paragraph("Hora de Fim: " + relatorio.getHoraFim()));
                document.add(new Paragraph("Cirurgião: " + relatorio.getCirurgiao()));
                document.add(new Paragraph("Auxiliar 1: " + relatorio.getAuxiliar1()));
                document.add(new Paragraph("Auxiliar 2: " + relatorio.getAuxiliar2()));
                document.add(new Paragraph("Perfusionista: " + relatorio.getPerfusionista()));
                document.add(new Paragraph("Hospital: " + relatorio.getHospital()));
                document.add(new Paragraph("VO2 Escolhido: " + relatorio.getVo2Escolhido()));

                document.close();
                Toast.makeText(this, "Relatório gerado com sucesso!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Erro ao gerar relatório.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Erro ao recuperar dados para o relatório.", Toast.LENGTH_SHORT).show();
        }
    }
}