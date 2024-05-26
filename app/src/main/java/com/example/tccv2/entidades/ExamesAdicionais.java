package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class ExamesAdicionais {
    private int idExames;
    private int usuario;
    private double ph;
    private double pco2;
    private double po2;
    private double svo2;
    private double hco3;
    private double beecf;
    private double k;
    private double na;
    private double ca;
    private double cl;
    private double glic;
    private double lact;
    private double hb;
    private double htc;
    private double plaq;
    private double tca;
    private long hora;

    public ExamesAdicionais(int idExames, int usuario, double ph, double pco2, double po2, double svo2, double hco3,
                            double beecf, double k, double na, double ca, double cl, double glic, double lact, double hb,
                            double htc, double plaq, double tca, long hora) {
        this.idExames = idExames;
        this.usuario = usuario;
        this.ph = ph;
        this.pco2 = pco2;
        this.po2 = po2;
        this.svo2 = svo2;
        this.hco3 = hco3;
        this.beecf = beecf;
        this.k = k;
        this.na = na;
        this.ca = ca;
        this.cl = cl;
        this.glic = glic;
        this.lact = lact;
        this.hb = hb;
        this.htc = htc;
        this.plaq = plaq;
        this.tca = tca;
        this.hora = hora;
    }

    public ExamesAdicionais(int usuario, double ph, double pco2, double po2, double svo2, double hco3, double beecf, double k,
                            double na, double ca, double cl, double glic, double lact, double hb, double htc, double plaq,
                            double tca, long hora) {
        this.usuario = usuario;
        this.ph = ph;
        this.pco2 = pco2;
        this.po2 = po2;
        this.svo2 = svo2;
        this.hco3 = hco3;
        this.beecf = beecf;
        this.k = k;
        this.na = na;
        this.ca = ca;
        this.cl = cl;
        this.glic = glic;
        this.lact = lact;
        this.hb = hb;
        this.htc = htc;
        this.plaq = plaq;
        this.tca = tca;
        this.hora = hora;
    }

    public int getIdExames() {
        return idExames;
    }

    public void setIdExames(int idExames) {
        this.idExames = idExames;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getPco2() {
        return pco2;
    }

    public void setPco2(double pco2) {
        this.pco2 = pco2;
    }

    public double getPo2() {
        return po2;
    }

    public void setPo2(double po2) {
        this.po2 = po2;
    }

    public double getSvo2() {
        return svo2;
    }

    public void setSvo2(double svo2) {
        this.svo2 = svo2;
    }

    public double getHco3() {
        return hco3;
    }

    public void setHco3(double hco3) {
        this.hco3 = hco3;
    }

    public double getBeecf() {
        return beecf;
    }

    public void setBeecf(double beecf) {
        this.beecf = beecf;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getNa() {
        return na;
    }

    public void setNa(double na) {
        this.na = na;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getCl() {
        return cl;
    }

    public void setCl(double cl) {
        this.cl = cl;
    }

    public double getGlic() {
        return glic;
    }

    public void setGlic(double glic) {
        this.glic = glic;
    }

    public double getLact() {
        return lact;
    }

    public void setLact(double lact) {
        this.lact = lact;
    }

    public double getHb() {
        return hb;
    }

    public void setHb(double hb) {
        this.hb = hb;
    }

    public double getHtc() {
        return htc;
    }

    public void setHtc(double htc) {
        this.htc = htc;
    }

    public double getPlaq() {
        return plaq;
    }

    public void setPlaq(double plaq) {
        this.plaq = plaq;
    }

    public double getTca() {
        return tca;
    }

    public void setTca(double tca) {
        this.tca = tca;
    }

    public long getHora() {
        return hora;
    }

    public void setHora(long hora) {
        this.hora = hora;
    }

    @NonNull
    @Override
    public String toString() {
        return "ExamesAdicionais{" +
                "idExames=" + idExames +
                ", usuario=" + usuario +
                ", ph=" + ph +
                ", pco2=" + pco2 +
                ", po2=" + po2 +
                ", svo2=" + svo2 +
                ", hco3=" + hco3 +
                ", beecf=" + beecf +
                ", k=" + k +
                ", na=" + na +
                ", ca=" + ca +
                ", cl=" + cl +
                ", glic=" + glic +
                ", lact=" + lact +
                ", hb=" + hb +
                ", htc=" + htc +
                ", plaq=" + plaq +
                ", tca=" + tca +
                ", hora=" + hora +
                '}';
    }
}
