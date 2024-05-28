package com.example.tccv2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tccv2.helper.DbHelper;

import java.util.Locale;

public class CalculoInicial extends AppCompatActivity {

    private EditText ed_peso;
    private EditText ed_estatura;
    private EditText ed_hb;
    private EditText ed_pao2;
    private EditText ed_sao2;
    private EditText ed_pvo2;
    private EditText ed_svo2;
    private EditText ed_pam;
    private EditText ed_pvc;
    private EditText ed_papm;
    private EditText ed_pcp;
    private EditText ed_fc;
    private EditText ed_vo2_escolhido;
    private EditText ed_obs;
    private EditText ed_horaValor;
    private TextView ed_areaSupC;
    private TextView ed_vo2_36;
    private TextView ed_vo2_35;
    private TextView ed_vo2_34;
    private TextView ed_vo2_33;
    private TextView ed_vo2_32;
    private TextView ed_cao2;
    private TextView ed_cvo2;
    private TextView ed_reo2;
    private TextView ed_dc;
    private TextView ed_ic;
    private TextView ed_vs;
    private TextView ed_irvs;
    private TextView ed_irvp;
    private Button bt_add;
    private ImageButton bt_voltar;
    private DbHelper dbHelper;
    private int userId;
    private long idEquipe;
    private long idPaciente;
    private long idExamesAdicionais;
    private double superficieCorporal;


    private Locale locale; // Declare a variável Locale
    //define o local, então pode usar ",' para separar os decimais


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_inicial);

        // Inicializando os componentes
        iniciarComponentes();

        // Adicionando TextWatchers
        adicionarTextWatchers();

        // Inicializando o helper do banco de dados
        dbHelper = new DbHelper(this);

        // Inicialize a variável Locale com a localidade padrão do celualr
        locale = new Locale("pt", "BR");

        // Recuperar o idUser
        userId = getIntent().getIntExtra("USER_ID", -1);

        // Recuperar o idEquipe
        idEquipe = getIntent().getLongExtra("EQUIPE_ID", -1);

        // Recuperar idPaciente
        idPaciente = getIntent().getLongExtra("PACIENTE_ID", -1);

        // Recuperar idExamesAdicionais
        idExamesAdicionais = getIntent().getLongExtra("EXAMESADICIONAIS_ID", -1);

        // Configurar o clique do botão "Novo" para salvar os dados no banco de dados
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Após calcular os valores, chame o método para salvar os dados
                addValores();
            }
        });

        // Configurar o clique do botão "Voltar" para voltar para tela inicial
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculoInicial.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });
    }

    // Método para inicializar os componentes de interface
    private void iniciarComponentes() {
        ed_peso = findViewById(R.id.ed_peso);
        ed_estatura = findViewById(R.id.ed_estatura);
        ed_hb = findViewById(R.id.ed_hb);
        ed_pao2 = findViewById(R.id.ed_pao2);
        ed_sao2 = findViewById(R.id.ed_sao2);
        ed_pvo2 = findViewById(R.id.ed_pvo2);
        ed_svo2 = findViewById(R.id.ed_svo2);
        ed_pam = findViewById(R.id.ed_pam);
        ed_pvc = findViewById(R.id.ed_pvc);
        ed_papm = findViewById(R.id.ed_papm);
        ed_pcp = findViewById(R.id.ed_pcp);
        ed_fc = findViewById(R.id.ed_fc);
        ed_areaSupC = findViewById(R.id.ed_areaSupC);
        ed_vo2_36 = findViewById(R.id.ed_vo2_36);
        ed_vo2_35 = findViewById(R.id.ed_vo2_35);
        ed_vo2_34 = findViewById(R.id.ed_vo2_34);
        ed_vo2_33 = findViewById(R.id.ed_vo2_33);
        ed_vo2_32 = findViewById(R.id.ed_vo2_32);
        ed_vo2_escolhido = findViewById(R.id.ed_vo2_escolhido);
        ed_cao2 = findViewById(R.id.ed_cao2);
        ed_cvo2 = findViewById(R.id.ed_cvo2);
        ed_reo2 = findViewById(R.id.ed_reo2);
        ed_dc = findViewById(R.id.ed_dc);
        ed_ic = findViewById(R.id.ed_ic);
        ed_vs = findViewById(R.id.ed_vs);
        ed_irvs = findViewById(R.id.ed_irvs);
        ed_irvp = findViewById(R.id.ed_irvp);
        ed_obs = findViewById(R.id.ed_obs);
        ed_horaValor = findViewById(R.id.ed_horaValor);
        bt_voltar = findViewById(R.id.bt_voltar);
        bt_add = findViewById(R.id.bt_add);
    }

    private void adicionarTextWatchers() {
        // Adicionar TextWatchers para os campos relevantes para recalcular os valores iniciais
        TextWatcher initialWatcher = new CalculoInicial.InitialTextWatcher();
        ed_peso.addTextChangedListener(initialWatcher);
        ed_estatura.addTextChangedListener(initialWatcher);
        ed_hb.addTextChangedListener(initialWatcher);
        ed_pao2.addTextChangedListener(initialWatcher);
        ed_sao2.addTextChangedListener(initialWatcher);
        ed_pvo2.addTextChangedListener(initialWatcher);
        ed_svo2.addTextChangedListener(initialWatcher);
        ed_pam.addTextChangedListener(initialWatcher);
        ed_pvc.addTextChangedListener(initialWatcher);
        ed_papm.addTextChangedListener(initialWatcher);
        ed_pcp.addTextChangedListener(initialWatcher);
        ed_fc.addTextChangedListener(initialWatcher);

        // Adicionar TextWatcher específico para vo2_escolhido
        ed_vo2_escolhido.addTextChangedListener(new  CalculoInicial.VO2EscolhidoTextWatcher());
    }

    private class InitialTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            calcularValoresIniciais();
        }
    }
    private class VO2EscolhidoTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        @Override
        public void afterTextChanged(Editable s) {
            calcularValoresFinais();
        }
    }

    private void calcularValoresIniciais() {
        // Obtenha os valores como strings
        String pesoStr = ed_peso.getText().toString();
        String estaturaStr = ed_estatura.getText().toString();
        String hbStr = ed_hb.getText().toString();
        String sao2Str = ed_sao2.getText().toString();
        String pao2Str = ed_pao2.getText().toString();
        String svo2Str = ed_svo2.getText().toString();
        String pvo2Str = ed_pvo2.getText().toString();

        // Verifique se todos os campos estão preenchidos antes de calcular
        if (pesoStr.isEmpty() || estaturaStr.isEmpty() || hbStr.isEmpty() || sao2Str.isEmpty()
                || pao2Str.isEmpty() || svo2Str.isEmpty() || pvo2Str.isEmpty()) {
            return;
        }

        try {
            // Converta os valores para double
            double pesoDouble = Double.parseDouble(pesoStr);
            double estaturaDouble = Double.parseDouble(estaturaStr);
            double hbDouble = Double.parseDouble(hbStr);
            double sao2Double = Double.parseDouble(sao2Str);
            double pao2Double = Double.parseDouble(pao2Str);
            double svo2Double = Double.parseDouble(svo2Str);
            double pvo2Double = Double.parseDouble(pvo2Str);

            // Calcular valores
            double superficie = calcularSuperficieCorporal(pesoDouble, estaturaDouble);
            double vo2_36Value = calcularVO2_36(superficie);
            double vo2_35Value = calcularVO2_35(vo2_36Value);
            double vo2_34Value = calcularVO2_34(vo2_36Value);
            double vo2_33Value = calcularVO2_33(vo2_36Value);
            double vo2_32Value = calcularVO2_32(vo2_36Value);
            double cao2Value = calcularCAO2(hbDouble, sao2Double, pao2Double);
            double cvo2Value = calcularCVO2(hbDouble, svo2Double, pvo2Double);
            double reo2Value = calcularREO2(cao2Value, cvo2Value);

            // Atualizar TextViews
            ed_areaSupC.setText(String.format(locale, "%.2f", superficie));
            ed_vo2_36.setText(String.format(locale, "%.1f", vo2_36Value));
            ed_vo2_35.setText(String.format(locale, "%.1f", vo2_35Value));
            ed_vo2_34.setText(String.format(locale, "%.1f", vo2_34Value));
            ed_vo2_33.setText(String.format(locale, "%.1f", vo2_33Value));
            ed_vo2_32.setText(String.format(locale, "%.1f", vo2_32Value));
            ed_cao2.setText(String.format(locale, "%.2f", cao2Value));
            ed_cvo2.setText(String.format(locale, "%.2f", cvo2Value));
            ed_reo2.setText(String.format(locale, "%.2f", reo2Value));

        } catch (NumberFormatException e) {
            Toast.makeText(CalculoInicial.this, "Erro de formatação: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularValoresFinais() {
        // Obtenha os valores necessários
        String cao2Str = ed_cao2.getText().toString();
        String cvo2Str = ed_cvo2.getText().toString();
        String vo2_escolhidoStr = ed_vo2_escolhido.getText().toString();
        String pamStr = ed_pam.getText().toString();
        String pvcStr = ed_pvc.getText().toString();
        String papmStr = ed_papm.getText().toString();
        String pcpStr = ed_pcp.getText().toString();
        String fcStr = ed_fc.getText().toString();
        String areaSupCStr = ed_areaSupC.getText().toString();

        // Verifique se todos os campos necessários estão preenchidos antes de calcular
        if (cao2Str.isEmpty() || cvo2Str.isEmpty() || vo2_escolhidoStr.isEmpty()
                || pamStr.isEmpty() || pvcStr.isEmpty() || papmStr.isEmpty()
                || pcpStr.isEmpty() || fcStr.isEmpty() || areaSupCStr.isEmpty()) {
            return;
        }

        try {
            // Converta os valores para double
            double cao2Double = parseDouble(cao2Str);
            double cvo2Double = parseDouble(cvo2Str);
            double vo2EscolhidoDouble = Double.parseDouble(vo2_escolhidoStr);
            double pamDouble = Double.parseDouble(pamStr);
            double pvcDouble = Double.parseDouble(pvcStr);
            double papmDouble = Double.parseDouble(papmStr);
            double pcpDouble = Double.parseDouble(pcpStr);
            double fcDouble = Double.parseDouble(fcStr);
            double areaSupCDouble = parseDouble(areaSupCStr);

            // Calcular valores finais
            double dcValue = calcularDC(vo2EscolhidoDouble, cao2Double, cvo2Double);
            double icValue = calcularIC(dcValue, areaSupCDouble);
            double vsValue = calcularVS(dcValue, fcDouble);
            double irvsValue = calcularIRVS(pamDouble, pvcDouble, icValue);
            double irvpValue = calcularIRVP(papmDouble, pcpDouble, icValue);

            // Atualizar TextViews
            ed_dc.setText(String.format(locale, "%.2f", dcValue));
            ed_ic.setText(String.format(locale, "%.2f", icValue));
            ed_vs.setText(String.format(locale, "%.1f", vsValue));
            ed_irvs.setText(String.format(locale, "%.1f", irvsValue));
            ed_irvp.setText(String.format(locale, "%.1f", irvpValue));

        } catch (NumberFormatException e) {
            Toast.makeText(CalculoInicial.this, "Erro de formatação: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    // Função utilitária para converter string para double
    private double parseDouble(String value) {
        // Substituir vírgulas por pontos e converter para double
        return Double.parseDouble(value.replace(",", "."));
    }

    private void addValores() {
        // Obtenha os valores dos campos como strings
        String pesoStr = ed_peso.getText().toString();
        String estaturaStr = ed_estatura.getText().toString();
        String hbStr = ed_hb.getText().toString();
        String sao2Str = ed_sao2.getText().toString();
        String pao2Str = ed_pao2.getText().toString();
        String svo2Str = ed_svo2.getText().toString();
        String pvo2Str = ed_pvo2.getText().toString();
        String pamStr = ed_pam.getText().toString();
        String pvcStr = ed_pvc.getText().toString();
        String papmStr = ed_papm.getText().toString();
        String pcpStr = ed_pcp.getText().toString();
        String fcStr = ed_fc.getText().toString();
        String areasupcStr = ed_areaSupC.getText().toString();
        String vo2_36Str = ed_vo2_36.getText().toString();
        String vo2_35Str = ed_vo2_35.getText().toString();
        String vo2_34Str = ed_vo2_34.getText().toString();
        String vo2_33Str = ed_vo2_33.getText().toString();
        String vo2_32Str = ed_vo2_32.getText().toString();
        String vo2EscolhidoStr = ed_vo2_escolhido.getText().toString();
        String cao2Str = ed_cao2.getText().toString();
        String cvo2Str = ed_cvo2.getText().toString();
        String reo2Str = ed_reo2.getText().toString();
        String dcStr = ed_dc.getText().toString();
        String icStr = ed_ic.getText().toString();
        String vsStr = ed_vs.getText().toString();
        String irvsStr = ed_irvs.getText().toString();
        String irvpStr = ed_irvp.getText().toString();
        String obsStr = ed_obs.getText().toString();
        String horaValorStr = ed_horaValor.getText().toString();


        // Chame o método para adicionar os cálculos iniciais ao banco de dados
        // Verifique o resultado e tome medidas apropriadas
        if (userId != -1) {
            long idCalculoInicial = dbHelper.adicionarValores(userId, pesoStr, estaturaStr, hbStr, pao2Str, sao2Str,
                    pvo2Str, svo2Str, pamStr,pvcStr, papmStr, pcpStr, fcStr, areasupcStr, vo2_36Str, vo2_35Str,
                    vo2_34Str, vo2_33Str, vo2_32Str, vo2EscolhidoStr, cao2Str, cvo2Str, reo2Str, dcStr, icStr,
                    vsStr, irvsStr, irvpStr, obsStr, horaValorStr );
            if (idCalculoInicial != -1) {
                double vo2Escolhido = Double.parseDouble(vo2EscolhidoStr);
                Intent intent = new Intent(CalculoInicial.this, Exames_Rep.class);
                // Passar ids para a próxima atividade
                intent.putExtra("USER_ID", userId);
                intent.putExtra("EQUIPE_ID", idEquipe);
                intent.putExtra("PACIENTE_ID", idPaciente);
                intent.putExtra("EXAMESADICIONAIS_ID", idExamesAdicionais);
                intent.putExtra("CALCULOINICIAL_ID", idCalculoInicial);
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

    private double calcularSuperficieCorporal (double peso, double estatura) {
        return Math.sqrt((peso * estatura) / 3600);
    }

    private double  calcularVO2_36 (double superficie){
        return superficie * 135;
    }

    private double calcularVO2_35 (double vo2_36){
        return vo2_36 * 0.95;
    }

    private double calcularVO2_34 (double vo2_36){
        return vo2_36 * 0.90;
    }

    private double calcularVO2_33 (double vo2_36){
        return vo2_36 * 0.85;
    }

    private double calcularVO2_32 (double vo2_36){
        return vo2_36 * 0.80;
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

    private double calcularDC (double vo2_escolhido, double cao2, double cvo2){
        return (vo2_escolhido / 10) / (cao2 - cvo2);
    }

    private double calcularIC (double dc, double superficie) {
        return dc / superficie;
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
}

