package com.example.tccv2.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tccv2.contract.Contract;

public class DbHelper extends SQLiteOpenHelper {
    //Realiza a manipulação das tabelas no banco de dados
    //Responsável por fazer as operações de acesso do banco

    public static final int DATABASE_VERSION = 6;
    public static final String DATABASE_NOME = "BdCEC";

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
            + Contract.Paciente.TABELA + "("
            + Contract.Paciente._ID + " integer primary key autoincrement,"
            + Contract.Paciente.COLUNA_USUARIO + " INTEGER, "
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
            + Contract.ExamesAdicionais.TABELA + "("
            + Contract.ExamesAdicionais._ID + " integer primary key autoincrement,"
            + Contract.ExamesAdicionais.COLUNA_USUARIO + " INTEGER, "
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
            + Contract.PCir.TABELA + "("
            + Contract.PCir._ID + " integer primary key autoincrement,"
            + Contract.PCir.COLUNA_USUARIO + " INTEGER, "
            +Contract.PCir.COLUNA_PIACIR + " TEXT, "
            +Contract.PCir.COLUNA_PVCCIR + " TEXT, "
            +Contract.PCir.COLUNA_TEMPCIR + " TEXT, "
            +Contract.PCir.COLUNA_DIURESECIR + " TEXT, "
            +Contract.PCir.COLUNA_FCCIR + " TEXT, "
            + " FOREIGN KEY (" + Contract.PCir.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";

    private static final String CREATE_PCEC = " create table "
            + Contract.PCec.TABELA + "("
            + Contract.PCec._ID + " integer primary key autoincrement,"
            + Contract.PCec.COLUNA_USUARIO + " INTEGER, "
            +Contract.PCec.COLUNA_PIACEC + " TEXT, "
            +Contract.PCec.COLUNA_PVCCEC + " TEXT, "
            +Contract.PCec.COLUNA_TEMPCEC + " TEXT, "
            +Contract.PCec.COLUNA_DIURESECEC + " TEXT, "
            +Contract.PCec.COLUNA_FCCEC + " TEXT, "
            +Contract.PCec.COLUNA_HORAINICIOCEC + " TEXT, "
            + " FOREIGN KEY (" + Contract.PCir.COLUNA_USUARIO + ") REFERENCES " + Contract.Usuario.TABELA
            + "( " + Contract.Usuario._ID + "))";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USUARIO);
        sqLiteDatabase.execSQL(CREATE_EQUIPE);
        sqLiteDatabase.execSQL(CREATE_PACIENTE);
        sqLiteDatabase.execSQL(CREATE_EXAMESADICIONAIS);
        sqLiteDatabase.execSQL(CREATE_PCIR);
        sqLiteDatabase.execSQL(CREATE_PCEC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Usuario.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Equipe.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Paciente.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.ExamesAdicionais.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.PCir.TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.PCec.TABELA);
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

    // Adicionar Parametros da Cirurgia
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


}