package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class ExamesRep {
    private int idExamesRep;
    private int usuario;
    private double rep_ph;
    private double rep_pco2;
    private double rep_po2;
    private double rep_svo2;
    private double rep_hco3;
    private double rep_beecf;
    private double rep_k;
    private double rep_na;
    private double rep_ca;
    private double rep_cl;
    private double rep_glic;
    private double rep_lact;
    private double rep_hb;
    private double rep_htc;
    private double rep_plaq;
    private double rep_tca;
    private long rep_hora;

    public ExamesRep() {
    }

    public ExamesRep(int idExamesRep, int usuario, double rep_ph, double rep_pco2, double rep_po2, double rep_svo2,
                     double rep_hco3, double rep_beecf, double rep_k, double rep_na, double rep_ca, double rep_cl,
                     double rep_glic, double rep_lact, double rep_hb, double rep_htc, double rep_plaq, double rep_tca,
                     long rep_hora) {
        this.idExamesRep = idExamesRep;
        this.usuario = usuario;
        this.rep_ph = rep_ph;
        this.rep_pco2 = rep_pco2;
        this.rep_po2 = rep_po2;
        this.rep_svo2 = rep_svo2;
        this.rep_hco3 = rep_hco3;
        this.rep_beecf = rep_beecf;
        this.rep_k = rep_k;
        this.rep_na = rep_na;
        this.rep_ca = rep_ca;
        this.rep_cl = rep_cl;
        this.rep_glic = rep_glic;
        this.rep_lact = rep_lact;
        this.rep_hb = rep_hb;
        this.rep_htc = rep_htc;
        this.rep_plaq = rep_plaq;
        this.rep_tca = rep_tca;
        this.rep_hora = rep_hora;
    }

    public ExamesRep(int usuario, double rep_ph, double rep_pco2, double rep_po2, double rep_svo2, double rep_hco3,
                     double rep_beecf, double rep_k, double rep_na, double rep_ca, double rep_cl, double rep_glic,
                     double rep_lact, double rep_hb, double rep_htc, double rep_plaq, double rep_tca, long rep_hora) {
        this.usuario = usuario;
        this.rep_ph = rep_ph;
        this.rep_pco2 = rep_pco2;
        this.rep_po2 = rep_po2;
        this.rep_svo2 = rep_svo2;
        this.rep_hco3 = rep_hco3;
        this.rep_beecf = rep_beecf;
        this.rep_k = rep_k;
        this.rep_na = rep_na;
        this.rep_ca = rep_ca;
        this.rep_cl = rep_cl;
        this.rep_glic = rep_glic;
        this.rep_lact = rep_lact;
        this.rep_hb = rep_hb;
        this.rep_htc = rep_htc;
        this.rep_plaq = rep_plaq;
        this.rep_tca = rep_tca;
        this.rep_hora = rep_hora;
    }

    public int getIdExamesRep() {
        return idExamesRep;
    }

    public void setIdExamesRep(int idExamesRep) {
        this.idExamesRep = idExamesRep;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getRep_ph() {
        return rep_ph;
    }

    public void setRep_ph(double rep_ph) {
        this.rep_ph = rep_ph;
    }

    public double getRep_pco2() {
        return rep_pco2;
    }

    public void setRep_pco2(double rep_pco2) {
        this.rep_pco2 = rep_pco2;
    }

    public double getRep_po2() {
        return rep_po2;
    }

    public void setRep_po2(double rep_po2) {
        this.rep_po2 = rep_po2;
    }

    public double getRep_svo2() {
        return rep_svo2;
    }

    public void setRep_svo2(double rep_svo2) {
        this.rep_svo2 = rep_svo2;
    }

    public double getRep_hco3() {
        return rep_hco3;
    }

    public void setRep_hco3(double rep_hco3) {
        this.rep_hco3 = rep_hco3;
    }

    public double getRep_beecf() {
        return rep_beecf;
    }

    public void setRep_beecf(double rep_beecf) {
        this.rep_beecf = rep_beecf;
    }

    public double getRep_k() {
        return rep_k;
    }

    public void setRep_k(double rep_k) {
        this.rep_k = rep_k;
    }

    public double getRep_na() {
        return rep_na;
    }

    public void setRep_na(double rep_na) {
        this.rep_na = rep_na;
    }

    public double getRep_ca() {
        return rep_ca;
    }

    public void setRep_ca(double rep_ca) {
        this.rep_ca = rep_ca;
    }

    public double getRep_cl() {
        return rep_cl;
    }

    public void setRep_cl(double rep_cl) {
        this.rep_cl = rep_cl;
    }

    public double getRep_glic() {
        return rep_glic;
    }

    public void setRep_glic(double rep_glic) {
        this.rep_glic = rep_glic;
    }

    public double getRep_lact() {
        return rep_lact;
    }

    public void setRep_lact(double rep_lact) {
        this.rep_lact = rep_lact;
    }

    public double getRep_hb() {
        return rep_hb;
    }

    public void setRep_hb(double rep_hb) {
        this.rep_hb = rep_hb;
    }

    public double getRep_htc() {
        return rep_htc;
    }

    public void setRep_htc(double rep_htc) {
        this.rep_htc = rep_htc;
    }

    public double getRep_plaq() {
        return rep_plaq;
    }

    public void setRep_plaq(double rep_plaq) {
        this.rep_plaq = rep_plaq;
    }

    public double getRep_tca() {
        return rep_tca;
    }

    public void setRep_tca(double rep_tca) {
        this.rep_tca = rep_tca;
    }

    public long getRep_hora() {
        return rep_hora;
    }

    public void setRep_hora(long rep_hora) {
        this.rep_hora = rep_hora;
    }

    @NonNull
    @Override
    public String toString() {
        return "ExamesRep{" +
                "idExamesRep=" + idExamesRep +
                ", usuario=" + usuario +
                ", rep_ph=" + rep_ph +
                ", rep_pco2=" + rep_pco2 +
                ", rep_po2=" + rep_po2 +
                ", rep_svo2=" + rep_svo2 +
                ", rep_hco3=" + rep_hco3 +
                ", rep_beecf=" + rep_beecf +
                ", rep_k=" + rep_k +
                ", rep_na=" + rep_na +
                ", rep_ca=" + rep_ca +
                ", rep_cl=" + rep_cl +
                ", rep_glic=" + rep_glic +
                ", rep_lact=" + rep_lact +
                ", rep_hb=" + rep_hb +
                ", rep_htc=" + rep_htc +
                ", rep_plaq=" + rep_plaq +
                ", rep_tca=" + rep_tca +
                ", rep_hora=" + rep_hora +
                '}';
    }
}
