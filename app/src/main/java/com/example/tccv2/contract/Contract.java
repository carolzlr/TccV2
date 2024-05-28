package com.example.tccv2.contract;

import android.provider.BaseColumns;

public class Contract {
    //contem as definições básicas da base de dados que será criada
    //Define a estrutura do BD
    //Cada entidade é uma tabela no BD

    public static class Usuario implements BaseColumns {
        public static final String TABELA = "usuario";
        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_NOME_USUARIO = "userName";
        public static final String COLUNA_EMAIL = "email";
        public static final String COLUNA_TIPO = "tipo";
        public static final String COLUNA_SENHA = "senha";
    }

    public static class Equipe implements BaseColumns {
        public static final String TABELA = "equipe";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_CIRURGIAO = "cirurgiao";
        public static final String COLUNA_AUXILIAR1 = "auxiliar1";
        public static final String COLUNA_AUXILIAR2 = "auxiliar2";
        public static final String COLUNA_PERFUSIONISTA = "perfusionista";
        public static final String COLUNA_INSTRUMENTADOR = "instrumentador";
        public static final String COLUNA_ANESTESISTA = "anestesista";
        public static final String COLUNA_CIRCULANTE = "circulante";
        public static final String COLUNA_HOSPITAL = "hospital";
        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class Paciente implements BaseColumns {
        public static final String TABELA = "paciente";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_IDADE = "idade";
        public static final String COLUNA_GENERO = "genero";
        public static final String COLUNA_PESO = "peso";
        public static final String COLUNA_ESTATURA = "estaura";
        public static final String COLUNA_SUPERFICIECORPOREA = "superficieCorporea";
        public static final String COLUNA_FLUXO1 = "fluxo1";
        public static final String COLUNA_FLUXO2 = "fluxo2";
        public static final String COLUNA_FLUXO3 = "fluxo3";
        public static final String COLUNA_DIAGNOSTICO = "diagnostico";
        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class ExamesAdicionais implements BaseColumns {
        public static final String TABELA = "exames";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_PH = "ph";
        public static final String COLUNA_PCO2 = "pco2";
        public static final String COLUNA_PO2 = "po2";
        public static final String COLUNA_SVO2 = "svo2";
        public static final String COLUNA_HCO3 = "hco3";
        public static final String COLUNA_BEECF = "beecf";
        public static final String COLUNA_K = "k";
        public static final String COLUNA_NA = "na";
        public static final String COLUNA_CA = "ca";
        public static final String COLUNA_CL = "cl";
        public static final String COLUNA_GLIC = "glic";
        public static final String COLUNA_LACT = "lact";
        public static final String COLUNA_HB = "hb";
        public static final String COLUNA_HTC = "htc";
        public static final String COLUNA_PLAQ = "plaq";
        public static final String COLUNA_TCA = "tca";
        public static final String COLUNA_HORA = "hora";
        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class PCir implements BaseColumns {
        public static final String TABELA = "pCir";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_PIACIR = "piaCir";
        public static final String COLUNA_PVCCIR = "pvcCir";
        public static final String COLUNA_TEMPCIR = "tempCir";
        public static final String COLUNA_DIURESECIR = "diureseCir";
        public static final String COLUNA_FCCIR = "fcCir";

        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class PCec implements BaseColumns {
        public static final String TABELA = "pCec";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_PIACEC = "piaCec";
        public static final String COLUNA_PVCCEC = "pvcCec";
        public static final String COLUNA_TEMPCEC = "tempCec";
        public static final String COLUNA_DIURESECEC = "diureseCec";
        public static final String COLUNA_FCCEC = "fcCec";
        public static final String COLUNA_HORAINICIOCEC = "horaInicioCec";

        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class CalculoInicial implements BaseColumns{
        public static final String TABELA = "calculoInicial";
        public static final String COLUNA_ID = "idCalculos";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_PESO = "peso";
        public static final String COLUNA_ESTATURA = "estatura";
        public static final String COLUNA_HB = "hb";
        public static final String COLUNA_PAO2 = "pao2";
        public static final String COLUNA_SAO2 = "sao2";
        public static final String COLUNA_PVO2 = "pvo2";
        public static final String COLUNA_SVO2 = "svo2";
        public static final String COLUNA_PAM = "pam";
        public static final String COLUNA_PVC = "pvc";
        public static final String COLUNA_PAPM = "papm";
        public static final String COLUNA_PCP = "pcp";
        public static final String COLUNA_FC = "fc";
        public static final String COLUNA_AREASUPC = "areaSupc";
        public static final String COLUNA_VO2_36 = "vo2_36";
        public static final String COLUNA_VO2_35 = "vo2_35";
        public static final String COLUNA_VO2_34 = "vo2_34";
        public static final String COLUNA_VO2_33 = "vo2_33";
        public static final String COLUNA_VO2_32 = "vo2_32";
        public static final String COLUNA_VO2_ESCOLHIDO = "vo2_escolhido";
        public static final String COLUNA_CAO2 = "cao2";
        public static final String COLUNA_CVO2 = "cvo2";
        public static final String COLUNA_REO2 = "reo2";
        public static final String COLUNA_DC = "dc";
        public static final String COLUNA_IC = "ic";
        public static final String COLUNA_VS = "vs";
        public static final String COLUNA_IRVS = "irvs";
        public static final String COLUNA_IRVP = "irvp";
        public static final String COLUNA_OBS = "obs";
        public static final String COLUNA_HORAVALOR = "horaValor";

        public static final String FK_USUARIO =
                "FOREIGN KEY(" + COLUNA_USUARIO + ") REFERENCES "
                        + Usuario.TABELA + "(" + Usuario._ID + ")";
    }

    public static class ExamesRep implements BaseColumns {
        public static final String TABELA = "examesRep";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_PHR_REP = "phRep";
        public static final String COLUNA_PCO2_REP = "pco2Rep";
        public static final String COLUNA_PO2_REP = "po2Rep";
        public static final String COLUNA_SVO2_REP = "svo2Rep";
        public static final String COLUNA_HCO3_REP = "hco3Rep";
        public static final String COLUNA_BEECF_REP = "beecfRep";
        public static final String COLUNA_K_REP = "kRep";
        public static final String COLUNA_NA_REP= "naRep";
        public static final String COLUNA_CA_REP = "caRep";
        public static final String COLUNA_CL_REP = "clRep";
        public static final String COLUNA_GLIC_REP = "glicRep";
        public static final String COLUNA_LACT_REP = "lactRep";
        public static final String COLUNA_HB_REP = "hbRep";
        public static final String COLUNA_HTC_REP = "htcRep";
        public static final String COLUNA_PLAQ_REP = "plaqRep";
        public static final String COLUNA_TCA_REP = "tcaRep";
        public static final String COLUNA_HORA_REP = "horaRep";
        public static final String FK_USUARIO = " FOREIGN KEY (" + COLUNA_USUARIO + " ) REFERENCES "
                + Usuario.TABELA + " ( " + Usuario._ID + " ) ";
    }

    public static class Calculo_Rep implements BaseColumns{
        public static final String TABELA = "calculoRep";
        public static final String COLUNA_ID = "idCalculosRep";
        public static final String COLUNA_USUARIO = "usuario";
        public static final String COLUNA_REP_HB = "Rep_hb";
        public static final String COLUNA_REP_PAO2 = "Rep_pao2";
        public static final String COLUNA_REP_SAO2 = "Rep_sao2";
        public static final String COLUNA_REP_PVO2 = "Rep_pvo2";
        public static final String COLUNA_REP_SVO2 = "Rep_svo2";
        public static final String COLUNA_REP_PAM = "Rep_pam";
        public static final String COLUNA_REP_PVC = "Rep_pvc";
        public static final String COLUNA_REP_PAPM = "Rep_papm";
        public static final String COLUNA_REP_PCP = "Rep_pcp";
        public static final String COLUNA_REP_FC = "Rep_fc";
        public static final String COLUNA_REP_CAO2 = "Rep_cao2";
        public static final String COLUNA_REP_CVO2 = "Rep_cvo2";
        public static final String COLUNA_REP_REO2 = "Rep_reo2";
        public static final String COLUNA_REP_DC = "Rep_dc";
        public static final String COLUNA_REP_IC = "Rep_ic";
        public static final String COLUNA_REP_VS = "Rep_vs";
        public static final String COLUNA_REP_IRVS = "Rep_irvs";
        public static final String COLUNA_REP_IRVP = "Rep_irvp";
        public static final String COLUNA_REP_OBS = "Rep_obs";
        public static final String COLUNA_REP_HORAVALOR = "Rep_horaValor";

        public static final String FK_USUARIO =
                "FOREIGN KEY(" + COLUNA_USUARIO + ") REFERENCES "
                        + Usuario.TABELA + "(" + Usuario._ID + ")";
    }
}
