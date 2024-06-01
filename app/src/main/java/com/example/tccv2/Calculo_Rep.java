package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tccv2.helper.DbHelper;

import java.util.Locale;

public class Calculo_Rep extends AppCompatActivity {

    private EditText hb_rep;
    private EditText pao2_rep;
    private EditText sao2_rep;
    private EditText  pvo2_rep;
    private EditText svo2_rep;
    private EditText pam_rep;
    private EditText pvc_rep;
    private EditText papm_rep;
    private EditText pcp_rep;
    private EditText fc_rep;
    private EditText obs_rep;
    private EditText dataHora_rep;
    private TextView vo2_escolhido_rep;
    private TextView cao2_rep;
    private TextView cvo2_rep;
    private TextView reo2_rep;
    private TextView dc_rep;
    private TextView ic_rep;
    private TextView  vs_rep;
    private TextView irvs_rep;
    private TextView irvp_rep;
    private ImageButton bt_retorna, bt_rep;
    private Button bt_finaliza, bt_repetir;
    private DbHelper dbHelper;
    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais

    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private long idPCir;
    private long idPCec;
    private long idCalculoInicial;
    private long idExamesRep;
    private double areaSupC;
    private double vo2Escolhido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_rep);

        // Inicializando os componentes
        iniciarComponentes();

        // Adicionando TextWatchers
        adicionarTextWatchers();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = Locale.getDefault();

        // Recuperar extras
        recuperarExtras();

        // Recuperar vo2_escolhido e ASC
        recuperardoBD();

        // Botão Repetir
        bt_rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Botão Finalizar

    }

    // Método para inicializar os componentes de interface
    private void iniciarComponentes() {
        hb_rep = findViewById(R.id.hb_rep);
        pao2_rep = findViewById(R.id.pao2_rep);
        sao2_rep = findViewById(R.id.sao2_rep);
        pvo2_rep = findViewById(R.id.pvo2_rep);
        svo2_rep = findViewById(R.id.svo2_rep);
        pam_rep = findViewById(R.id.pam_rep);
        pvc_rep = findViewById(R.id.pvc_rep);
        papm_rep = findViewById(R.id.papm_rep);
        pcp_rep = findViewById(R.id.pcp_rep);
        fc_rep = findViewById(R.id.fc_rep);
        cao2_rep = findViewById(R.id.cao2_rep);
        cvo2_rep = findViewById(R.id.cvo2_rep);
        reo2_rep = findViewById(R.id.reo2_rep);
        dc_rep = findViewById(R.id.dc_rep);
        ic_rep = findViewById(R.id.ic_rep);
        vs_rep = findViewById(R.id.vs_rep);
        irvs_rep = findViewById(R.id.irvs_rep);
        irvp_rep = findViewById(R.id.irvp_rep);
        obs_rep = findViewById(R.id.obs_rep);
        dataHora_rep = findViewById(R.id.dataHora_rep);
        bt_retorna = findViewById(R.id.bt_retorna);
        bt_rep = findViewById(R.id.bt_rep);
        bt_finaliza = findViewById(R.id.bt_finaliza);
        bt_repetir = findViewById(R.id.bt_repetir);
    }

    private void adicionarTextWatchers() {
        // Adicionar TextWatchers para os campos relevantes para recalcular os valores iniciais
        TextWatcher initialWatcher = new Calculo_Rep.InitialTextWatcher();
        hb_rep.addTextChangedListener(initialWatcher);
        pao2_rep.addTextChangedListener(initialWatcher);
        sao2_rep.addTextChangedListener(initialWatcher);
        pvo2_rep.addTextChangedListener(initialWatcher);
        svo2_rep.addTextChangedListener(initialWatcher);
        pam_rep.addTextChangedListener(initialWatcher);
        pvc_rep.addTextChangedListener(initialWatcher);
        papm_rep.addTextChangedListener(initialWatcher);
        pcp_rep.addTextChangedListener(initialWatcher);
        fc_rep.addTextChangedListener(new FCTextWatcher()); // Específico para fc_rep
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

        Log.d("CalculoRep", "userId: " + userId);
        Log.d("CalculoRep", "EQUIPE_ID: " + idEquipe);
        Log.d("CalculoRep", "PACIENTE_ID: " + idPaciente);
        Log.d("CalculoRep", "EXAMESADICIONAIS_ID: " + idExamesAdicionais);
        Log.d("CalculoRep", "PCIR_ID: " + idPCir);
        Log.d("CalculoRep", "PCEC_ID: " + idPCec);
        Log.d("CalculoRep", "CALCULOINICIAL_ID: " + idCalculoInicial);
        Log.d("CalculoRep", "EXAMESREP_ID:" + idExamesRep);
    }

    private void recuperardoBD() {
        vo2Escolhido = dbHelper.recuperarVo2Escolhido(idCalculoInicial);
        areaSupC = dbHelper.recuperarASC(idCalculoInicial);

        Log.d("Calculo_Rep", "vo2Escolhido: " + vo2Escolhido);
        Log.d("Calculo_Rep", "areaSupC: " + areaSupC);
    }

    private class InitialTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            calcularValoresRep();
        }
    }

    private class FCTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            calcularValoresFinaisRep();
        }
    }

    private double calcularCAO2 (double hb, double sao2, double pao2){
        return ((1.34 * hb *sao2)/100) + (pao2 * 0.003);
    }

    private double calcularCVO2 (double hb, double svo2, double pvo2){
        return ((1.34 * hb *svo2)/100) + (pvo2 * 0.003);
    }

    private double calcularREO2 (double cao2, double cvo2){
        return (cao2-cvo2) / cao2;
    }

    private double calcularDC (double vo2Escolhido, double cao2, double cvo2){
        return (vo2Escolhido / 10) / (cao2 - cvo2);
    }

    private double calcularIC (double dc, double areaSupC) {
        return dc / areaSupC;
    }

    private double calcularVS (double dc, double fc) {
        return (dc * 1000) / fc;
    }

    private  double calcularIRVS (double pam, double pvc, double ic){
        return ((pam - pvc)*80) / ic;
    }

    private double  calcularIRVP (double papm, double pcp, double ic){
        return ((papm - pcp)*80) / ic;
    }

    private void calcularValoresRep() {
        // Obtenha os valores como strings
        String hbStr = hb_rep.getText().toString();
        String sao2Str = sao2_rep.getText().toString();
        String pao2Str = pao2_rep.getText().toString();
        String svo2Str = svo2_rep.getText().toString();
        String pvo2Str = pvo2_rep.getText().toString();

        // Verifique se todos os campos estão preenchidos antes de calcular
        if (hbStr.isEmpty() || sao2Str.isEmpty() || pao2Str.isEmpty() || svo2Str.isEmpty() || pvo2Str.isEmpty()) {
            return;
        }

        try {
            // Converta os valores para double
            double hbDouble = Double.parseDouble(hbStr);
            double sao2Double = Double.parseDouble(sao2Str);
            double pao2Double = Double.parseDouble(pao2Str);
            double svo2Double = Double.parseDouble(svo2Str);
            double pvo2Double = Double.parseDouble(pvo2Str);

            // Calcular valores
            double cao2Value = calcularCAO2(hbDouble, sao2Double, pao2Double);
            double cvo2Value = calcularCVO2(hbDouble, svo2Double, pvo2Double);
            double reo2Value = calcularREO2(cao2Value, cvo2Value);

            // Adicione logs para verificar os valores calculados
            Log.d("Calculo_Rep", "cao2Value: " + cao2Value);
            Log.d("Calculo_Rep", "cvo2Value: " + cvo2Value);
            Log.d("Calculo_Rep", "reo2Value: " + reo2Value);

            // Atualizar TextViews
            cao2_rep.setText(String.format(locale, "%.2f", cao2Value));
            cvo2_rep.setText(String.format(locale, "%.2f", cvo2Value));
            reo2_rep.setText(String.format(locale, "%.2f", reo2Value));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro de formatação: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularValoresFinaisRep() {
        // Obtenha os valores necessários
        String cao2Str = cao2_rep.getText().toString();
        String cvo2Str = cvo2_rep.getText().toString();
        String pamStr = pam_rep.getText().toString();
        String pvcStr = pvc_rep.getText().toString();
        String papmStr = papm_rep.getText().toString();
        String pcpStr = pcp_rep.getText().toString();
        String fcStr = fc_rep.getText().toString();



        // Verifique se todos os campos necessários estão preenchidos antes de calcular
        if (cao2Str.isEmpty() || cvo2Str.isEmpty() ||pamStr.isEmpty() || pvcStr.isEmpty()
                || papmStr.isEmpty() || pcpStr.isEmpty() || fcStr.isEmpty() ) {
            return;
        }

        try {
            // Converta os valores para double
            double cao2Double = parseDouble(cao2Str);
            double cvo2Double = parseDouble(cvo2Str);
            double pamDouble = Double.parseDouble(pamStr);
            double pvcDouble = Double.parseDouble(pvcStr);
            double papmDouble = Double.parseDouble(papmStr);
            double pcpDouble = Double.parseDouble(pcpStr);
            double fcDouble = Double.parseDouble(fcStr);

            // Calcular valores finais
            double dcValue = calcularDC(vo2Escolhido, cao2Double, cvo2Double);
            double icValue = calcularIC(dcValue, areaSupC );
            double vsValue = calcularVS(dcValue, fcDouble);
            double irvsValue = calcularIRVS(pamDouble, pvcDouble, icValue);
            double irvpValue = calcularIRVP(papmDouble, pcpDouble, icValue);

            // Adicione logs para verificar os valores calculados
            Log.d("Calculo_Rep", "dcValue: " + dcValue);
            Log.d("Calculo_Rep", "icValue: " + icValue);
            Log.d("Calculo_Rep", "vsValue: " + vsValue);
            Log.d("Calculo_Rep", "irvsValue: " + irvsValue);
            Log.d("Calculo_Rep", "irvpValue: " + irvpValue);

            // Atualizar TextViews
            dc_rep.setText(String.format(locale, "%.2f", dcValue));
            ic_rep.setText(String.format(locale, "%.2f", icValue));
            vs_rep.setText(String.format(locale, "%.1f", vsValue));
            irvs_rep.setText(String.format(locale, "%.1f", irvsValue));
            irvp_rep.setText(String.format(locale, "%.1f", irvpValue));

            // Atualizar TextViews
            dc_rep.setText(String.format(locale, "%.2f", dcValue));
            ic_rep.setText(String.format(locale, "%.2f", icValue));
            vs_rep.setText(String.format(locale, "%.1f", vsValue));
            irvs_rep.setText(String.format(locale, "%.1f", irvsValue));
            irvp_rep.setText(String.format(locale, "%.1f", irvpValue));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro de formatação: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    // Função utilitária para converter string para double
    private double parseDouble(String value) {
        // Substituir vírgulas por pontos e converter para double
        return Double.parseDouble(value.replace(",", "."));
    }
    private void salvarDadosNoBanco() {
        // Obtenha os valores dos campos como strings
        String rep_hbStr = hb_rep.getText().toString();
        String rep_sao2Str = sao2_rep.getText().toString();
        String rep_pao2Str = pao2_rep.getText().toString();
        String rep_svo2Str = svo2_rep.getText().toString();
        String rep_pvo2Str = pvo2_rep.getText().toString();
        String rep_pamStr = pam_rep.getText().toString();
        String rep_pvcStr = pvc_rep.getText().toString();
        String rep_papmStr = papm_rep.getText().toString();
        String rep_pcpStr = pcp_rep.getText().toString();
        String rep_fcStr = fc_rep.getText().toString();
        String rep_cao2Str = cao2_rep.getText().toString();
        String rep_cvo2Str = cvo2_rep.getText().toString();
        String rep_reo2Str = reo2_rep.getText().toString();
        String rep_dcStr = dc_rep.getText().toString();
        String rep_icStr = ic_rep.getText().toString();
        String rep_vsStr = vs_rep.getText().toString();
        String rep_irvsStr = irvs_rep.getText().toString();
        String rep_irvpStr = irvp_rep.getText().toString();
        String rep_obsStr = obs_rep.getText().toString();
        String rep_dataHoraInicioStr = dataHora_rep.getText().toString();


        // Chame o método para adicionar os cálculos iniciais ao banco de dados
        if (userId != -1) {
            long idCalculoRep = dbHelper.adicionarValoresRep(userId, rep_hbStr, rep_pao2Str, rep_sao2Str, rep_pvo2Str,
                    rep_svo2Str, rep_pamStr, rep_pvcStr, rep_papmStr, rep_pcpStr, rep_fcStr, rep_cao2Str, rep_cvo2Str,
                    rep_reo2Str, rep_dcStr, rep_icStr, rep_vsStr, rep_irvsStr, rep_irvpStr, rep_obsStr, rep_dataHoraInicioStr );
            if (idCalculoRep!= -1) {
                Intent intent = new Intent(Calculo_Rep.this, Exames_Rep.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                intent.putExtra("PCIR_ID", idPCir);
                intent.putExtra("PCEC_ID", idPCec);
                intent.putExtra("CALCULOINICIAL_ID", idCalculoInicial);
                intent.putExtra("EXAMESREP_ID", idExamesRep);
                intent.putExtra("CALCULOREP_ID", idCalculoRep);
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