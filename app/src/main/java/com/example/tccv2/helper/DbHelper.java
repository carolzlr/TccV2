package com.example.tccv2.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.tccv2.contract.Contract;
import com.example.tccv2.entidades.CalculoInicial;
import com.example.tccv2.entidades.Calculo_Rep;
import com.example.tccv2.entidades.Equipe;
import com.example.tccv2.entidades.ExamesAdicionais;
import com.example.tccv2.entidades.ExamesRep;
import com.example.tccv2.entidades.PCec;
import com.example.tccv2.entidades.PCir;
import com.example.tccv2.entidades.Paciente;
import com.example.tccv2.entidades.Procedimento;
import com.example.tccv2.entidades.Relatorio;
import com.example.tccv2.entidades.Usuario;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {
    //Realiza a manipulação das tabelas no banco de dados
    //Responsável por fazer as operações de acesso do banco
    public static final String DATABASE_NOME = "BDCEC";

    public static final int DATABASE_VERSION = 23;
    public DbHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSION);
    }

    private static final String CREATE_USUARIO = "create table " +
            Contract.Usuario.TABELA + "(" +
            Contract.Usuario._ID + " integer primary key autoincrement," +
            Contract.Usuario.COLUNA_NOME + " text," +
            Contract.Usuario.COLUNA_NOME_USUARIO + " text, " +
            Contract.Usuario.COLUNA_EMAIL + " text," +
            Contract.Usuario.COLUNA_TIPO + " text, " +
            Contract.Usuario.COLUNA_SENHA + " text)";

    private static final String CREATE_EQUIPE = " create table "
            + Contract.Equipe.TABELA + "("
            + Contract.Equipe._ID + " integer primary key autoincrement,"
            + Contract.Equipe.COLUNA_USUARIO + " INTEGER, "
            + Contract.Equipe.COLUNA_CIRURGIAO + " TEXT,"
            + Contract.Equipe.COLUNA_AUXILIAR1 + " TEXT,"
            + Contract.Equipe.COLUNA_AUXILIAR2 + " TEXT,"
            + Contract.Equipe.COLUNA_PERFUSIONISTA + " TEXT,"
            + Contract.Equipe.COLUNA_INSTRUMENTADOR + " TEXT,"
            + Contract.Equipe.COLUNA_ANESTESISTA + " TEXT,"
            + Contract.Equipe.COLUNA_CIRCULANTE + " TEXT,"
            + Contract.Equipe.COLUNA_HOSPITAL + " TEXT,"
            + " FOREIGN KEY (" + Contract.Equipe.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_PACIENTE = " create table "
            +Contract.Paciente.TABELA + "("
            +Contract.Paciente._ID + " integer primary key autoincrement,"
            +Contract.Paciente.COLUNA_USUARIO + " INTEGER, "
            +Contract.Paciente.COLUNA_IDADE + " TEXT, "
            +Contract.Paciente.COLUNA_GENERO + " TEXT, "
            +Contract.Paciente.COLUNA_PESO + " TEXT, "
            +Contract.Paciente.COLUNA_ESTATURA + " TEXT, "
            +Contract.Paciente.COLUNA_SUPERFICIECORPOREA + " TEXT, "
            +Contract.Paciente.COLUNA_FLUXO1 + " TEXT, "
            +Contract.Paciente.COLUNA_FLUXO2 + " TEXT, "
            +Contract.Paciente.COLUNA_FLUXO3 + " TEXT, "
            +Contract.Paciente.COLUNA_DIAGNOSTICO + " TEXT, "
            + " FOREIGN KEY (" + Contract.Paciente.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_EXAMESADICIONAIS = " create table "
            +Contract.ExamesAdicionais.TABELA + "("
            +Contract.ExamesAdicionais._ID + " integer primary key autoincrement,"
            +Contract.ExamesAdicionais.COLUNA_USUARIO + " INTEGER, "
            +Contract.ExamesAdicionais.COLUNA_PH + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_PCO2 + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_PO2 + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_SVO2 + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_HCO3 + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_BEECF + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_K + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_NA + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_CA + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_CL + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_GLIC + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_LACT + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_HB + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_HTC + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_PLAQ + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_TCA + " TEXT, "
            +Contract.ExamesAdicionais.COLUNA_HORA + " TEXT, "
            + " FOREIGN KEY (" + Contract.ExamesAdicionais.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_PCIR = " create table "
            +Contract.PCir.TABELA + "("
            +Contract.PCir._ID + " integer primary key autoincrement,"
            +Contract.PCir.COLUNA_USUARIO + " INTEGER, "
            +Contract.PCir.COLUNA_PIACIR + " TEXT, "
            +Contract.PCir.COLUNA_PVCCIR + " TEXT, "
            +Contract.PCir.COLUNA_TEMPCIR + " TEXT, "
            +Contract.PCir.COLUNA_DIURESECIR + " TEXT, "
            +Contract.PCir.COLUNA_FCCIR + " TEXT, "
            + " FOREIGN KEY (" + Contract.PCir.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_PCEC = " create table "
            +Contract.PCec.TABELA + "("
            +Contract.PCec._ID + " integer primary key autoincrement,"
            +Contract.PCec.COLUNA_USUARIO + " INTEGER, "
            +Contract.PCec.COLUNA_PIACEC + " TEXT, "
            +Contract.PCec.COLUNA_PVCCEC + " TEXT, "
            +Contract.PCec.COLUNA_TEMPCEC + " TEXT, "
            +Contract.PCec.COLUNA_DIURESECEC + " TEXT, "
            +Contract.PCec.COLUNA_FCCEC + " TEXT, "
            +Contract.PCec.COLUNA_HORAINICIOCEC + " TEXT, "
            + " FOREIGN KEY (" + Contract.PCir.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_CALCULOINICIAL = " create table "
            +Contract.CalculoInicial.TABELA + "("
            +Contract.CalculoInicial._ID + " integer primary key autoincrement,"
            +Contract.CalculoInicial.COLUNA_USUARIO + " INTEGER, "
            +Contract.CalculoInicial.COLUNA_PESO + " TEXT, "
            +Contract.CalculoInicial.COLUNA_ESTATURA + " TEXT, "
            +Contract.CalculoInicial.COLUNA_HB + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PAO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_SAO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PVO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_SVO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PAM + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PVC + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PAPM + " TEXT, "
            +Contract.CalculoInicial.COLUNA_PCP + " TEXT, "
            +Contract.CalculoInicial.COLUNA_FC + " TEXT, "
            +Contract.CalculoInicial.COLUNA_AREASUPC + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_32 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_33 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_34 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_35 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_36 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VO2_ESCOLHIDO + " TEXT, "
            +Contract.CalculoInicial.COLUNA_CAO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_CVO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_REO2 + " TEXT, "
            +Contract.CalculoInicial.COLUNA_DC + " TEXT, "
            +Contract.CalculoInicial.COLUNA_IC + " TEXT, "
            +Contract.CalculoInicial.COLUNA_VS + " TEXT, "
            +Contract.CalculoInicial.COLUNA_IRVS + " TEXT, "
            +Contract.CalculoInicial.COLUNA_IRVP + " TEXT, "
            +Contract.CalculoInicial.COLUNA_OBS + " TEXT, "
            +Contract.CalculoInicial.COLUNA_HORAVALOR + " TEXT, "
            + " FOREIGN KEY (" + Contract. CalculoInicial.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_EXAMESREP = " create table "
            +Contract.ExamesRep.TABELA + "("
            +Contract.ExamesRep._ID + " integer primary key autoincrement,"
            +Contract.ExamesRep.COLUNA_USUARIO + " INTEGER, "
            +Contract.ExamesRep.COLUNA_PHR_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_PCO2_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_PO2_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_SVO2_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_HCO3_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_BEECF_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_K_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_NA_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_CA_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_CL_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_GLIC_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_LACT_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_HB_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_HTC_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_PLAQ_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_TCA_REP + " TEXT, "
            +Contract.ExamesRep.COLUNA_HORA_REP + " TEXT, "
            + " FOREIGN KEY (" + Contract.ExamesRep.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_CALCULO_REP = " create table "
            +Contract.Calculo_Rep.TABELA + "("
            +Contract.Calculo_Rep._ID + " integer primary key autoincrement,"
            +Contract.Calculo_Rep.COLUNA_USUARIO + " INTEGER, "
            +Contract.Calculo_Rep.COLUNA_REP_HB + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_PAO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_SAO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_PVO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_SVO2 + " TEXT, "
            +Contract. Calculo_Rep.COLUNA_REP_PAM + " TEXT, "
            +Contract. Calculo_Rep.COLUNA_REP_PVC + " TEXT, "
            +Contract. Calculo_Rep.COLUNA_REP_PAPM + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_PCP + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_FC + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_CAO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_CVO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_REO2 + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_DC + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_IC + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_VS + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_IRVS + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_IRVP + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_OBS + " TEXT, "
            +Contract.Calculo_Rep.COLUNA_REP_HORAVALOR + " TEXT, "
            + " FOREIGN KEY (" + Contract.Calculo_Rep.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_PROCEDIMENTO  = " create table "
            + Contract.Procedimento.TABELA + "("
            + Contract.Procedimento._ID + " integer primary key autoincrement,"
            + Contract.Procedimento.COLUNA_USUARIO + " INTEGER, "
            + Contract.Procedimento.COLUNA_NOMEPROC + " TEXT, "
            + Contract.Procedimento.COLUNA_DATAINICIO + " TEXT, "
            + Contract.Procedimento.COLUNA_HORAINICO + " TEXT, "
            + Contract.Procedimento.COLUNA_OXI + " TEXT, "
            + Contract.Procedimento.COLUNA_CANULAAA + " TEXT, "
            + Contract.Procedimento.COLUNA_CANULAV + " TEXT, "
            + Contract.Procedimento.COLUNA_PROT + " TEXT, "
            + Contract.Procedimento.COLUNA_HEPMG + " TEXT, "
            + Contract.Procedimento.COLUNA_HEPML + " TEXT, "
            + Contract.Procedimento.COLUNA_INCIOCEC + " TEXT, "
            + Contract.Procedimento.COLUNA_FINALCEC + " TEXT, "
            + Contract.Procedimento.COLUNA_TCEC + " TEXT, "
            + Contract.Procedimento.COLUNA_INCIOCALMP + " TEXT, "
            + Contract.Procedimento.COLUNA_FIMCLAMP + " TEXT, "
            + Contract.Procedimento.COLUNA_TCLAMP + " TEXT, "
            + Contract.Procedimento.COLUNA_DATAFPROC + " TEXT, "
            + Contract.Procedimento.COLUNA_HORAFPROC + " TEXT, "
            + Contract.Procedimento.COLUNA_OBS + " TEXT, "
            + " FOREIGN KEY (" + Contract.Procedimento.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USUARIO);
        sqLiteDatabase.execSQL(CREATE_EQUIPE);
        sqLiteDatabase.execSQL(CREATE_PACIENTE);
        sqLiteDatabase.execSQL(CREATE_EXAMESADICIONAIS);
        sqLiteDatabase.execSQL(CREATE_PCIR);
        sqLiteDatabase.execSQL(CREATE_PCEC);
        sqLiteDatabase.execSQL(CREATE_CALCULOINICIAL);
        sqLiteDatabase.execSQL(CREATE_EXAMESREP);
        sqLiteDatabase.execSQL(CREATE_CALCULO_REP);
        sqLiteDatabase.execSQL(CREATE_PROCEDIMENTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Usuario.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Equipe.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Paciente.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.ExamesAdicionais.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.PCir.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.PCec.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.CalculoInicial.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.ExamesRep.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Calculo_Rep.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Procedimento.TABELA);

        onCreate(sqLiteDatabase);
    }

    // Métodos CRUD para usuários

    // Adicionar Usuário
    public boolean adicionarUsuario (String nome, String userName, String email, String tipo, String senha){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.Usuario.COLUNA_NOME, nome);
        values.put(Contract.Usuario.COLUNA_NOME_USUARIO, userName);
        values.put(Contract.Usuario.COLUNA_EMAIL, email);
        values.put(Contract.Usuario.COLUNA_TIPO, tipo);
        values.put(Contract.Usuario.COLUNA_SENHA, senha);
        long result = sqLiteDatabase.insert(Contract.Usuario.TABELA, null, values);
        return result != -1;
    }

    // Verificar se o usuário foi criado no BD
    public boolean verificarUsuario (String userName, String senha){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String [] columns = {Contract.Usuario._ID};
        String selection = Contract.Usuario.COLUNA_NOME_USUARIO + " = ? AND " + Contract.Usuario.COLUNA_SENHA + " = ? ";
        String[] selectionArgs = {userName, senha};
        Cursor cursor = sqLiteDatabase.query(Contract.Usuario.TABELA, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        return cursorCount > 0;
    }

    // Obter a ID do Usuário
    public int obterIdUsuario (String userName){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String [] columns = {Contract.Usuario._ID};
        String selection = Contract.Usuario.COLUNA_NOME_USUARIO + " = ? ";
        String [] selectionArgs = {userName};
        Cursor cursor = sqLiteDatabase.query (Contract.Usuario.TABELA, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            int userId = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Usuario._ID));
            cursor.close();
            return userId;
        } else {
            if (cursor != null){
                cursor.close();
            }
            return  -1;
        }
    }

    public boolean atualizarSenha(String email, String userName, String tipo, String novaSenha) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Verificar se o usuário existe
        String[] columns = {Contract.Usuario._ID};
        String selection = Contract.Usuario.COLUNA_EMAIL + " = ? AND " +
                Contract.Usuario.COLUNA_NOME_USUARIO + " = ? AND " +
                Contract.Usuario.COLUNA_TIPO + " = ?";
        String[] selectionArgs = {email, userName, tipo};

        Cursor cursor = sqLiteDatabase.query(Contract.Usuario.TABELA, columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            // Usuário existe, atualizar a senha
            ContentValues values = new ContentValues();
            values.put(Contract.Usuario.COLUNA_SENHA, novaSenha);

            // Atualizar a senha do usuário
            int rowsAffected = sqLiteDatabase.update(Contract.Usuario.TABELA, values, selection, selectionArgs);

            cursor.close();
            return rowsAffected > 0;
        } else {
            if (cursor != null) {
                cursor.close();
            }
            return false; // Usuário não encontrado
        }
    }

    // Método para carregar os dados do usuário
    public Cursor carregarDadosUsuario(int userId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        return sqLiteDatabase.query(Contract.Usuario.TABELA,
                new String[]{
                        Contract.Usuario.COLUNA_NOME,
                        Contract.Usuario.COLUNA_NOME_USUARIO,
                        Contract.Usuario.COLUNA_EMAIL,
                        Contract.Usuario.COLUNA_TIPO
                },
                Contract.Usuario._ID + " = ?",
                new String[]{String.valueOf(userId)},
                null, null, null);
    }

    // Método para salvar as alterações do usuário
    public boolean salvarAlteracoes(int userId, String nome, String email, String userName, String tipo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.Usuario.COLUNA_NOME, nome);
        values.put(Contract.Usuario.COLUNA_EMAIL, email);
        values.put(Contract.Usuario.COLUNA_NOME_USUARIO, userName);
        values.put(Contract.Usuario.COLUNA_TIPO, tipo);

        int rowsAffected = sqLiteDatabase.update(Contract.Usuario.TABELA,
                values, Contract.Usuario._ID + " = ?", new String[]{String.valueOf(userId)});
        sqLiteDatabase.close();

        return rowsAffected > 0;
    }

    public Cursor carregarPerfilUsuario(int userId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        return sqLiteDatabase.query(Contract.Usuario.TABELA,
                new String[]{

                        Contract.Usuario.COLUNA_NOME_USUARIO,
                        Contract.Usuario.COLUNA_EMAIL,
                        Contract.Usuario.COLUNA_SENHA
                },
                Contract.Usuario._ID + " = ?",
                new String[]{String.valueOf(userId)},
                null, null, null);
    }


    // Carregar dados do usuário na tela Perfil

    // Métodos CRUD para Equipe

    // Adicionar Usuário
    public long adicionarEquipe (int userId, String cirurgiao, String auxiliar1, String auxiliar2, String perfusionista,
                                 String instrumentador, String anestesista, String circulante, String hospital){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.Equipe.COLUNA_USUARIO, userId);
        values.put(Contract.Equipe.COLUNA_CIRURGIAO, cirurgiao);
        values.put(Contract.Equipe.COLUNA_AUXILIAR1, auxiliar1);
        values.put(Contract.Equipe.COLUNA_AUXILIAR2, auxiliar2);
        values.put(Contract.Equipe.COLUNA_PERFUSIONISTA, perfusionista);
        values.put(Contract.Equipe.COLUNA_INSTRUMENTADOR, instrumentador);
        values.put(Contract.Equipe.COLUNA_ANESTESISTA, anestesista);
        values.put(Contract.Equipe.COLUNA_CIRCULANTE, circulante);
        values.put(Contract.Equipe.COLUNA_HOSPITAL, hospital);
        long idEquipe = sqLiteDatabase.insert(Contract.Equipe.TABELA, null, values);
        return idEquipe;
    }

    // Métodos CRUD para Paciente

    // Adicionar Paciente
    public long adicionarPaciente(int userId, String idade, String genero, String peso, String estatura,
                                  String superficieCorporea, String fluxo1, String fluxo2, String fluxo3, String diagnostico) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.Paciente.COLUNA_USUARIO, userId);
        values.put(Contract.Paciente.COLUNA_IDADE, idade);
        values.put(Contract.Paciente.COLUNA_GENERO, genero);
        values.put(Contract.Paciente.COLUNA_PESO, peso);
        values.put(Contract.Paciente.COLUNA_ESTATURA, estatura);
        values.put(Contract.Paciente.COLUNA_SUPERFICIECORPOREA, superficieCorporea);
        values.put(Contract.Paciente.COLUNA_FLUXO1, fluxo1);
        values.put(Contract.Paciente.COLUNA_FLUXO2, fluxo2);
        values.put(Contract.Paciente.COLUNA_FLUXO3, fluxo3);
        values.put(Contract.Paciente.COLUNA_DIAGNOSTICO, diagnostico);

        long idPaciente = sqLiteDatabase.insert(Contract.Paciente.TABELA, null, values);
        return idPaciente;
    }

    // Métodos CRUD para ExamesAdicionais

    // Adicionar ExamesAdicionais
    public long adicionarExames(int userId, String ph, String pco2, String po2, String svo2, String hco3, String beecf,
                                String k, String na, String ca, String cl, String glic, String lact, String hb,
                                String htc, String plaq, String tca, String hora) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.ExamesAdicionais.COLUNA_USUARIO, userId);
        values.put(Contract.ExamesAdicionais.COLUNA_PH, ph);
        values.put(Contract.ExamesAdicionais.COLUNA_PCO2, pco2);
        values.put(Contract.ExamesAdicionais.COLUNA_PO2, po2);
        values.put(Contract.ExamesAdicionais.COLUNA_SVO2, svo2);
        values.put(Contract.ExamesAdicionais.COLUNA_HCO3, hco3);
        values.put(Contract.ExamesAdicionais.COLUNA_BEECF, beecf);
        values.put(Contract.ExamesAdicionais.COLUNA_K, k);
        values.put(Contract.ExamesAdicionais.COLUNA_NA, na);
        values.put(Contract.ExamesAdicionais.COLUNA_CA, ca);
        values.put(Contract.ExamesAdicionais.COLUNA_CL, cl);
        values.put(Contract.ExamesAdicionais.COLUNA_GLIC, glic);
        values.put(Contract.ExamesAdicionais.COLUNA_LACT, lact);
        values.put(Contract.ExamesAdicionais.COLUNA_HB, hb);
        values.put(Contract.ExamesAdicionais.COLUNA_HTC, htc);
        values.put(Contract.ExamesAdicionais.COLUNA_PLAQ, plaq);
        values.put(Contract.ExamesAdicionais.COLUNA_TCA, tca);
        values.put(Contract.ExamesAdicionais.COLUNA_HORA, hora);

        long idExamesAdicionais = sqLiteDatabase.insert(Contract.ExamesAdicionais.TABELA, null, values);
        return idExamesAdicionais;
    }

    // Métodos CRUD para PCir

    // Adicionar Parametros da Cirurgia
    public long adicionarParametrosCir(int userId, String piaCir, String pvcCir, String tempCir, String diureseCir,
                                       String fcCir) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.PCir.COLUNA_USUARIO, userId);
        values.put(Contract.PCir.COLUNA_PIACIR, piaCir);
        values.put(Contract.PCir.COLUNA_PVCCIR, pvcCir);
        values.put(Contract.PCir.COLUNA_TEMPCIR, tempCir);
        values.put(Contract.PCir.COLUNA_DIURESECIR, diureseCir);
        values.put(Contract.PCir.COLUNA_FCCIR, fcCir);

        long idPCir = sqLiteDatabase.insert(Contract.PCir.TABELA, null, values);
        return idPCir;
    }

    // Métodos CRUD para PCec

    // Adicionar Parametros da Cec
    public long adicionarParametrosCec(int userId, String piaCec, String pvcCec, String tempCec, String diureseCec,
                                       String fcCec, String horaInicioCec) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.PCec.COLUNA_USUARIO, userId);
        values.put(Contract.PCec.COLUNA_PIACEC, piaCec);
        values.put(Contract.PCec.COLUNA_PVCCEC, pvcCec);
        values.put(Contract.PCec.COLUNA_TEMPCEC, tempCec);
        values.put(Contract.PCec.COLUNA_DIURESECEC, diureseCec);
        values.put(Contract.PCec.COLUNA_FCCEC, fcCec);
        values.put(Contract.PCec.COLUNA_HORAINICIOCEC, horaInicioCec);

        long idPCec = sqLiteDatabase.insert(Contract.PCec.TABELA, null, values);
        return idPCec;
    }

    // Métodos CRUD para CalculoInicial

    // Adicionar Valores para o cálculo
    public long adicionarValores (int userId, String peso, String estatura, String hb, String pao2, String sao2,
                                  String pvo2, String svo2, String pam, String pvc, String papm, String pcp, String fc,
                                  String areaSupC, String vo2_32, String vo2_33, String vo2_34, String vo2_35,
                                  String vo2_36, String vo2_escolhido, String cao2, String cvo2, String reo2,
                                  String dc, String ic, String vs, String irvs, String irvp, String obs, String horaValor ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.CalculoInicial.COLUNA_USUARIO, userId);
        values.put(Contract.CalculoInicial.COLUNA_PESO, peso);
        values.put(Contract.CalculoInicial.COLUNA_ESTATURA, estatura);
        values.put(Contract.CalculoInicial.COLUNA_HB, hb);
        values.put(Contract.CalculoInicial.COLUNA_PAO2, pao2);
        values.put(Contract.CalculoInicial.COLUNA_SAO2, sao2);
        values.put(Contract.CalculoInicial.COLUNA_PVO2, pvo2);
        values.put(Contract.CalculoInicial.COLUNA_SVO2, svo2);
        values.put(Contract.CalculoInicial.COLUNA_PAM, pam);
        values.put(Contract.CalculoInicial.COLUNA_PVC, pvc);
        values.put(Contract.CalculoInicial.COLUNA_PAPM, papm);
        values.put(Contract.CalculoInicial.COLUNA_PCP, pcp);
        values.put(Contract.CalculoInicial.COLUNA_FC, fc);
        values.put(Contract.CalculoInicial.COLUNA_AREASUPC, areaSupC);
        values.put(Contract.CalculoInicial.COLUNA_VO2_32, vo2_32);
        values.put(Contract.CalculoInicial.COLUNA_VO2_33, vo2_33);
        values.put(Contract.CalculoInicial.COLUNA_VO2_34, vo2_34);
        values.put(Contract.CalculoInicial.COLUNA_VO2_35, vo2_35);
        values.put(Contract.CalculoInicial.COLUNA_VO2_36, vo2_36);
        values.put(Contract.CalculoInicial.COLUNA_VO2_ESCOLHIDO, vo2_escolhido);
        values.put(Contract.CalculoInicial.COLUNA_CAO2, cao2);
        values.put(Contract.CalculoInicial.COLUNA_CVO2, cvo2);
        values.put(Contract.CalculoInicial.COLUNA_REO2, reo2);
        values.put(Contract.CalculoInicial.COLUNA_DC, dc);
        values.put(Contract.CalculoInicial.COLUNA_IC, ic);
        values.put(Contract.CalculoInicial.COLUNA_VS, vs);
        values.put(Contract.CalculoInicial.COLUNA_IRVS, irvs);
        values.put(Contract.CalculoInicial.COLUNA_IRVP, irvp);
        values.put(Contract.CalculoInicial.COLUNA_OBS, obs);
        values.put(Contract.CalculoInicial.COLUNA_HORAVALOR, horaValor);

        Log.d("DbHelper", "Salvando valores: vo2_escolhido = " + vo2_escolhido + ", areaSupC = " + areaSupC);

        long idCalculoInicial = sqLiteDatabase.insert(Contract.CalculoInicial.TABELA, null, values);
        return idCalculoInicial;
    }

    // Recuperar do BD vo2Escolhido
    // Método para recuperar o vo2_escolhido
    public double recuperarVo2Escolhido(long idCalculoInicial) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        double vo2Escolhido = -1.0; // Valor padrão em caso de falha na recuperação
        Cursor cursor = null;

        try {
            String query = "SELECT " + Contract.CalculoInicial.COLUNA_VO2_ESCOLHIDO + " FROM " + Contract.CalculoInicial.TABELA + " WHERE " + Contract.CalculoInicial._ID + " = ?";
            cursor = sqLiteDatabase.rawQuery(query, new String[]{String.valueOf(idCalculoInicial)});

            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(Contract.CalculoInicial.COLUNA_VO2_ESCOLHIDO);
                if (columnIndex != -1) {
                    vo2Escolhido = cursor.getDouble(columnIndex);
                    Log.d("DbHelper", "recuperarVo2Escolhido: " + vo2Escolhido);
                } else {
                    Log.e("DbHelper", "recuperarVo2Escolhido: Column index not found");
                }
            } else {
                Log.e("DbHelper", "recuperarVo2Escolhido: Cursor is null or empty");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return vo2Escolhido;
    }


    // Recuperar do BD ASC
    public double recuperarASC(long idCalculoInicial) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        double areaSupC = -1.0; // Valor padrão em caso de falha na recuperação
        Cursor cursor = null;

        try {
            String query = "SELECT " + Contract.CalculoInicial.COLUNA_AREASUPC + " FROM " + Contract.CalculoInicial.TABELA + " WHERE " + Contract.CalculoInicial._ID + " = ?";
            cursor = sqLiteDatabase.rawQuery(query, new String[]{String.valueOf(idCalculoInicial)});

            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(Contract.CalculoInicial.COLUNA_AREASUPC);
                if (columnIndex != -1) {
                    String areaSupCString = cursor.getString(columnIndex);
                    // Utilize o locale padrão para conversão de strings para double
                    DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
                    NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
                    try {
                        Number number = numberFormat.parse(areaSupCString);
                        areaSupC = number.doubleValue();
                        Log.d("DbHelper", "recuperarASC: " + areaSupC);
                    } catch (ParseException e) {
                        Log.e("DbHelper", "recuperarASC: Error parsing double value", e);
                    }
                } else {
                    Log.e("DbHelper", "recuperarASC: Column index not found");
                }
            } else {
                Log.e("DbHelper", "recuperarASC: Cursor is null or empty");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return areaSupC;
    }

    // Métodos CRUD para ExamesRep

    // Adicionar Exames_Rep
    public long adicionarExamesRep(int userId, String phRep, String pco2Rep, String po2Rep, String svo2Rep,
                                   String hco3Rep, String beecfRep, String kRep, String naRep, String caRep,
                                   String clRep, String glicRep, String lactRep, String hbRep, String htcRep,
                                   String plaqRep, String tcaRep, String horaRep) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.ExamesRep.COLUNA_USUARIO, userId);
        values.put(Contract.ExamesRep.COLUNA_PHR_REP, phRep);
        values.put(Contract.ExamesRep.COLUNA_PCO2_REP, pco2Rep);
        values.put(Contract.ExamesRep.COLUNA_PO2_REP, po2Rep);
        values.put(Contract.ExamesRep.COLUNA_SVO2_REP, svo2Rep);
        values.put(Contract.ExamesRep.COLUNA_HCO3_REP, hco3Rep);
        values.put(Contract.ExamesRep.COLUNA_BEECF_REP, beecfRep);
        values.put(Contract.ExamesRep.COLUNA_K_REP, kRep);
        values.put(Contract.ExamesRep.COLUNA_NA_REP, naRep);
        values.put(Contract.ExamesRep.COLUNA_CA_REP, caRep);
        values.put(Contract.ExamesRep.COLUNA_CL_REP, clRep);
        values.put(Contract.ExamesRep.COLUNA_GLIC_REP, glicRep);
        values.put(Contract.ExamesRep.COLUNA_LACT_REP, lactRep);
        values.put(Contract.ExamesRep.COLUNA_HB_REP, hbRep);
        values.put(Contract.ExamesRep.COLUNA_HTC_REP, htcRep);
        values.put(Contract.ExamesRep.COLUNA_PLAQ_REP, plaqRep);
        values.put(Contract.ExamesRep.COLUNA_TCA_REP, tcaRep);
        values.put(Contract.ExamesRep.COLUNA_HORA_REP, horaRep);

        long idExamesRep = sqLiteDatabase.insert(Contract.ExamesRep.TABELA, null, values);
        return idExamesRep;
    }

    // Métodos CRUD para Calculo_Rep

    // Adicionar para Calculo_Rep
    public long adicionarValoresRep (int userId, String Rep_hb, String Rep_pao2, String Rep_sao2, String Rep_pvo2,
                                     String Rep_svo2, String Rep_pam, String Rep_pvc, String Rep_papm,
                                     String Rep_pcp, String Rep_fc, String Rep_cao2, String Rep_cvo2,
                                     String Rep_reo2, String Rep_dc, String Rep_ic, String Rep_vs,
                                     String Rep_irvs, String Rep_irvp, String Rep_obs, String Rep_horaValor ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.Calculo_Rep.COLUNA_USUARIO, userId);
        values.put(Contract.Calculo_Rep.COLUNA_REP_HB, Rep_hb);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PAO2, Rep_pao2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_SAO2, Rep_sao2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PVO2, Rep_pvo2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_SVO2, Rep_svo2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PAM, Rep_pam);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PVC, Rep_pvc);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PAPM, Rep_papm);
        values.put(Contract.Calculo_Rep.COLUNA_REP_PCP, Rep_pcp);
        values.put(Contract.Calculo_Rep.COLUNA_REP_FC, Rep_fc);
        values.put(Contract.Calculo_Rep.COLUNA_REP_CAO2, Rep_cao2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_CVO2, Rep_cvo2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_REO2, Rep_reo2);
        values.put(Contract.Calculo_Rep.COLUNA_REP_DC, Rep_dc);
        values.put(Contract.Calculo_Rep.COLUNA_REP_IC, Rep_ic);
        values.put(Contract.Calculo_Rep.COLUNA_REP_VS, Rep_vs);
        values.put(Contract.Calculo_Rep.COLUNA_REP_IRVS, Rep_irvs);
        values.put(Contract.Calculo_Rep.COLUNA_REP_IRVP, Rep_irvp);
        values.put(Contract.Calculo_Rep.COLUNA_REP_OBS, Rep_obs);
        values.put(Contract.Calculo_Rep.COLUNA_REP_HORAVALOR, Rep_horaValor);

        long idCalculo_Rep = sqLiteDatabase.insert(Contract.Calculo_Rep.TABELA, null, values);
        return idCalculo_Rep;
    }

    // Métodos CRUD para Procedimento

    // Adicionar Procedimento
    public long adicionarProcedimento (int userId, String nomeProc, String dataInicio, String horaInicio,
                                        String oxigenador, String canulaAA, String canulaV, String protamina,
                                        String hepMg, String hepMl, String iCec, String fCec, String totalCec,
                                        String iClamp, String fClamp, String totalClamp, String datafProc,
                                        String horafProc, String obs){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Adicionar os valores inseridos pelo usuário logado
        values.put(Contract.Procedimento.COLUNA_USUARIO, userId);
        values.put(Contract.Procedimento.COLUNA_NOMEPROC, nomeProc);
        values.put(Contract.Procedimento.COLUNA_DATAINICIO, dataInicio);
        values.put(Contract.Procedimento.COLUNA_HORAINICO, horaInicio);
        values.put(Contract.Procedimento.COLUNA_OXI, oxigenador);
        values.put(Contract.Procedimento.COLUNA_CANULAAA, canulaAA);
        values.put(Contract.Procedimento.COLUNA_CANULAV, canulaV);
        values.put(Contract.Procedimento.COLUNA_PROT, protamina);
        values.put(Contract.Procedimento.COLUNA_HEPMG, hepMg);
        values.put(Contract.Procedimento.COLUNA_HEPML, hepMl);
        values.put(Contract.Procedimento.COLUNA_INCIOCEC, iCec);
        values.put(Contract.Procedimento.COLUNA_FINALCEC, fCec);
        values.put(Contract.Procedimento.COLUNA_TCEC, totalCec);
        values.put(Contract.Procedimento.COLUNA_INCIOCALMP, iClamp);
        values.put(Contract.Procedimento.COLUNA_FIMCLAMP, fClamp);
        values.put(Contract.Procedimento.COLUNA_TCLAMP, totalClamp);
        values.put(Contract.Procedimento.COLUNA_DATAFPROC, datafProc);
        values.put(Contract.Procedimento.COLUNA_HORAFPROC, horafProc);
        values.put(Contract.Procedimento.COLUNA_OBS, obs);


        long idProcedimento = sqLiteDatabase.insert(Contract.Procedimento.TABELA, null, values);
        return idProcedimento;
    }

    // Métodos para recuperar dados das tabelas
    // Método para recuperar dados da tabela Usuario
    private Usuario recuperarUsuario(int idUsuario, SQLiteDatabase sqLiteDatabase){
        Usuario usuario = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.Usuario.TABELA,
                null,
                Contract.Usuario._ID + "=?",
                new String[]{String.valueOf(idUsuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            usuario = new Usuario();
            usuario.setIdUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Usuario._ID)));
            usuario.setNome(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_NOME)));
            usuario.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_EMAIL)));
            usuario.setTipo(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Usuario.COLUNA_TIPO)));
        }
        cursor.close();
        return usuario;
    }

    // Método para recuperar dados da tabela Equipe
    private Equipe recuperarEquipe(int usuario, SQLiteDatabase sqLiteDatabase){
        Equipe equipe = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.Equipe.TABELA,
                null,
                Contract.Equipe.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            equipe = new Equipe();
            equipe.setIdEquipe(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Equipe._ID)));
            equipe.setCirurgiao(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_CIRURGIAO)));
            equipe.setAuxiliar1(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_AUXILIAR1)));
            equipe.setAuxiliar2(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_AUXILIAR2)));
            equipe.setPerfusionista(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_PERFUSIONISTA)));
            equipe.setInstrumentador(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_INSTRUMENTADOR)));
            equipe.setAnestesista(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_ANESTESISTA)));
            equipe.setCirculante(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_CIRCULANTE)));
            equipe.setHospital(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_HOSPITAL)));
        }
        cursor.close();
        return equipe;
    }

    // Método para recuperar dados da tabela Paciente
    private Paciente recuperarPaciente(int usuario, SQLiteDatabase sqLiteDatabase){
        Paciente paciente = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.Paciente.TABELA,
                null,
                Contract.Paciente.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            paciente = new Paciente();
            paciente.setIdPaciente(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Paciente._ID)));
            paciente.setIdade(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_IDADE)));
            paciente.setGenero(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_GENERO)));
            paciente.setDiagnostico(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_DIAGNOSTICO)));
        }
        cursor.close();
        return paciente;
    }

    // Método para recuperar dados da tabela ExamesAdicionais
    private ExamesAdicionais recuperarExamesAdicionais(int usuario, SQLiteDatabase sqLiteDatabase){
        ExamesAdicionais examesAdicionais = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.ExamesAdicionais.TABELA,
                null,
                Contract.ExamesAdicionais.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            examesAdicionais = new ExamesAdicionais();
            examesAdicionais.setIdExames(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais._ID)));
            examesAdicionais.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_USUARIO)));
            examesAdicionais.setPh(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_PH)));
            examesAdicionais.setPco2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_PCO2)));
            examesAdicionais.setPo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_PO2)));
            examesAdicionais.setSvo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_SVO2)));
            examesAdicionais.setHco3(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_HCO3)));
            examesAdicionais.setBeecf(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_BEECF)));
            examesAdicionais.setK(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_K)));
            examesAdicionais.setNa(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_NA)));
            examesAdicionais.setCa(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_CA)));
            examesAdicionais.setCl(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_CL)));
            examesAdicionais.setGlic(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_GLIC)));
            examesAdicionais.setLact(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_LACT)));
            examesAdicionais.setHb(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_HB)));
            examesAdicionais.setHtc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_HTC)));
            examesAdicionais.setPlaq(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_PLAQ)));
            examesAdicionais.setTca(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_TCA)));
            examesAdicionais.setHora(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.ExamesAdicionais.COLUNA_HORA)));
        }
        cursor.close();
        return examesAdicionais;
    }

    // Método para recuperar dados da tabela PCir
    private PCir recuperarPcir(int usuario, SQLiteDatabase sqLiteDatabase){
        PCir pCir = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.PCir.TABELA,
                null,
                Contract.PCir.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            pCir = new PCir();
            pCir.setIdParametrosCir(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PCir._ID)));
            pCir.setPiaCir(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCir.COLUNA_PIACIR)));
            pCir.setPvcCir(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCir.COLUNA_PVCCIR)));
            pCir.setTempCir(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCir.COLUNA_TEMPCIR)));
            pCir.setDiureseCir(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCir.COLUNA_DIURESECIR)));
            pCir.setFcCir(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCir.COLUNA_FCCIR)));
        }
        cursor.close();
        return pCir;
    }

    // Método para recuperar dados da tabela PCec
    private PCec recuperarPcec (int usuario, SQLiteDatabase sqLiteDatabase){
        PCec pCec = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.PCec.TABELA,
                null,
                Contract.PCec.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            pCec = new PCec();
            pCec.setIdParametrosCeC(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PCec._ID)));
            pCec.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_USUARIO)));
            pCec.setPiaCec(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_PVCCEC)));
            pCec.setTempCec(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_TEMPCEC)));
            pCec.setDiureseCec(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_DIURESECEC)));
            pCec.setFcCec(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_FCCEC)));
            pCec.setHoraInicioCec(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.PCec.COLUNA_HORAINICIOCEC)));
        }
        cursor.close();
        return pCec;
    }

    // Método para recuperar dados da tabela CalculoInicial
    private CalculoInicial recuperarCalculoinicial(int usuario, SQLiteDatabase sqLiteDatabase){
        CalculoInicial calculoInicial = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.CalculoInicial.TABELA,
                null,
                Contract.CalculoInicial.COLUNA_USUARIO +"=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            calculoInicial = new CalculoInicial();
            calculoInicial.setIdCalculos(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.CalculoInicial._ID)));
            calculoInicial.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_USUARIO)));
            calculoInicial.setPeso(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PESO)));
            calculoInicial.setEstatura(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_ESTATURA)));
            calculoInicial.setHb(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_HB)));
            calculoInicial.setPao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PAO2)));
            calculoInicial.setSao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_SAO2)));
            calculoInicial.setPvo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PVO2)));
            calculoInicial.setSvo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_SVO2)));
            calculoInicial.setPam(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PAM)));
            calculoInicial.setPvc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PVC)));
            calculoInicial.setPapm(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PAPM)));
            calculoInicial.setPcp(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_PCP)));
            calculoInicial.setFc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_FC)));
            calculoInicial.setAreaSupC(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_AREASUPC)));
            calculoInicial.setVo2_36(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_36)));
            calculoInicial.setVo2_35(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_35)));
            calculoInicial.setVo2_34(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_34)));
            calculoInicial.setVo2_33(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_33)));
            calculoInicial.setVo2_32(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_32)));
            calculoInicial.setVo2_escolhido(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VO2_ESCOLHIDO)));
            calculoInicial.setCao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_CAO2)));
            calculoInicial.setReo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_REO2)));
            calculoInicial.setDc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_DC)));
            calculoInicial.setIc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_IC)));
            calculoInicial.setVs(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_VS)));
            calculoInicial.setIrvs(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_IRVP)));
            calculoInicial.setObs(cursor.getString(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_OBS)));
            calculoInicial.sethoraValor(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.CalculoInicial.COLUNA_HORAVALOR)));
        }
        cursor.close();
        return calculoInicial;
    }

    // Método para recuperar dados da tabela ExamesRep
    private ExamesRep recuperarExamesRep(int usuario, SQLiteDatabase sqLiteDatabase){
        ExamesRep examesRep = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.ExamesRep.TABELA,
                null,
                Contract.ExamesRep.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            examesRep = new ExamesRep();
            examesRep.setIdExamesRep(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.ExamesRep._ID)));
            examesRep.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_USUARIO)));
            examesRep.setRep_ph(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_PHR_REP)));
            examesRep.setRep_pco2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_PCO2_REP)));
            examesRep.setRep_po2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_PO2_REP)));
            examesRep.setRep_svo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_SVO2_REP)));
            examesRep.setRep_hco3(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_HCO3_REP)));
            examesRep.setRep_beecf(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_BEECF_REP)));
            examesRep.setRep_k(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_K_REP)));
            examesRep.setRep_na(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_NA_REP)));
            examesRep.setRep_ca(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_CA_REP)));
            examesRep.setRep_cl(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_CL_REP)));
            examesRep.setRep_glic(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_GLIC_REP)));
            examesRep.setRep_lact(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_LACT_REP)));
            examesRep.setRep_hb(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_HB_REP)));
            examesRep.setRep_htc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_HTC_REP)));
            examesRep.setRep_plaq(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_PLAQ_REP)));
            examesRep.setRep_tca(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_TCA_REP)));
            examesRep.setRep_hora(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.ExamesRep.COLUNA_HORA_REP)));
        }
        cursor.close();
        return examesRep;
    }

    // Método para recuperar dados da tabela Calculo_Rep
    private Calculo_Rep recuperarCalculoRep(int usuario, SQLiteDatabase sqLiteDatabase){
        Calculo_Rep calculoRep = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.Calculo_Rep.TABELA,
                null,
                Contract.Calculo_Rep.COLUNA_USUARIO +"=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            calculoRep = new Calculo_Rep();
            calculoRep.setIdCalculoRep(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep._ID)));
            calculoRep.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_USUARIO)));
            calculoRep.setRep_hb(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_HB)));
            calculoRep.setRep_pao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PAO2)));
            calculoRep.setRep_sao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_SAO2)));
            calculoRep.setRep_pvo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PVO2)));
            calculoRep.setRep_svo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_SVO2)));
            calculoRep.setRep_pam(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PAM)));
            calculoRep.setRep_pvc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PVC)));
            calculoRep.setRep_papm(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PAPM)));
            calculoRep.setRep_pcp(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_PCP)));
            calculoRep.setRep_fc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_FC)));
            calculoRep.setRep_cao2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_CAO2)));
            calculoRep.setRep_reo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_REO2)));
            calculoRep.setRep_dc(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_DC)));
            calculoRep.setRep_ic(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_IC)));
            calculoRep.setRep_vs(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_VS)));
            calculoRep.setRep_irvs(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_IRVP)));
            calculoRep.setRep_obs(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_OBS)));
            calculoRep.setRep_dataHora(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Calculo_Rep.COLUNA_REP_HORAVALOR)));
        }
        cursor.close();
        return calculoRep;
    }

    // Método para recuperar dados da tabela Procedimento
    private Procedimento recuperarProcedimento(int usuario, SQLiteDatabase sqLiteDatabase){
        Procedimento procedimento = null;
        Cursor cursor = sqLiteDatabase.query(
                Contract.Procedimento.TABELA,
                null,
                Contract.Procedimento.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            procedimento = new Procedimento();
            procedimento.setIdProcedimento(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Procedimento._ID)));
            procedimento.setUsuario(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_USUARIO)));
            procedimento.setNomeProc(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_NOMEPROC)));
            procedimento.setDataInicio(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_DATAINICIO)));
            procedimento.setHoraInicio(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_HORAINICO)));
            procedimento.setOxigenador(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_OXI)));
            procedimento.setCanulaAA(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_CANULAAA)));
            procedimento.setCanulaV(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_CANULAV)));
            procedimento.setProtamina(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_PROT)));
            procedimento.setHepMg(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_HEPMG)));
            procedimento.setHepMl(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_HEPML)));
            procedimento.setiCec(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_INCIOCEC)));
            procedimento.setfCec(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_FINALCEC)));
            procedimento.setTotalCec(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_TCEC)));
            procedimento.setiClamp(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_INCIOCALMP)));
            procedimento.setfClamp(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_FIMCLAMP)));
            procedimento.setTotalClamp(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_TCLAMP)));
            procedimento.setDatafProc(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_DATAFPROC)));
            procedimento.setHorafProc(cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_HORAFPROC)));
            procedimento.setObs(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Procedimento.COLUNA_OBS)));
        }
        cursor.close();
        return procedimento;
    }

    // Métodos para Relatório

    public Relatorio gerarRelatorio(int idUsuario){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Relatorio relatorio = new Relatorio();
        //Recuperar os dados do usuário
        return relatorio;
    }

    // Métodos para recuperar resumos e depois exibir na tela
    // Resumo equipe
    public List<Equipe> resumirEquipe(int usuario){
        List<Equipe> resumoEquipe = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                Contract.Equipe.TABELA,
                null,
                Contract.Equipe.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            do {
                Equipe equipe = new Equipe();
                equipe.setIdEquipe(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Equipe._ID)));
                equipe.setCirurgiao(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_CIRURGIAO)));
                equipe.setAuxiliar1(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_AUXILIAR1)));
                equipe.setAuxiliar2(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_AUXILIAR2)));
                equipe.setPerfusionista(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_PERFUSIONISTA)));
                equipe.setInstrumentador(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_INSTRUMENTADOR)));
                equipe.setAnestesista(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_ANESTESISTA)));
                equipe.setCirculante(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_CIRCULANTE)));
                equipe.setHospital(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Equipe.COLUNA_HOSPITAL)));
                resumoEquipe.add(equipe);
            } while (cursor.moveToNext());
        } else {
            Log.e("DbHelper", "Cursor is null or empty");
        }

        // Fecha o cursor para liberar os recursos
        if (cursor != null) {
            cursor.close();
        }
        return resumoEquipe;
    }

    // Resumo Paciente
    public List<Paciente> resumirPaciente(int usuario){
        List<Paciente> resumoPaciente = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                Contract.Paciente.TABELA,
                null,
                Contract.Paciente.COLUNA_USUARIO + "=?",
                new String[]{String.valueOf(usuario)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()){
            do {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Paciente._ID)));
                paciente.setIdPaciente(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_IDADE)));
                paciente.setGenero(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_GENERO)));
                paciente.setFluxo1(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_FLUXO1)));
                paciente.setFluxo2(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_FLUXO2)));
                paciente.setFluxo3(cursor.getDouble(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_FLUXO3)));
                paciente.setDiagnostico(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Paciente.COLUNA_DIAGNOSTICO)));

                resumoPaciente.add(paciente);
            } while (cursor.moveToNext());
        } else {
            Log.e("DbHelper", "Cursor is null or empty");
        }

        // Fecha o cursor para liberar os recursos
        if (cursor != null) {
            cursor.close();
        }
        return resumoPaciente;
    }






}