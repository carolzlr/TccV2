package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class CalculoInicial {
    private int idCalculos;
    private int usuario;
    private double peso;
    private double estatura;
    private double hb;
    private double pao2;
    private double sao2;
    private double pvo2;
    private double svo2;
    private double pam;
    private double pvc;
    private double papm;
    private double pcp;
    private double fc;
    private double areaSupC;
    private double vo2_36;
    private double vo2_35;
    private double vo2_34;
    private double vo2_33;
    private double vo2_32;
    private double vo2_escolhido;
    private double cao2;
    private double cvo2;
    private double reo2;
    private double dc;
    private double ic;
    private double vs;
    private double irvs;
    private double irvp;
    private String obs;
    private long horaValor;

    public CalculoInicial(int idCalculos, int usuario, double peso, double estatura, double hb, double pao2, double sao2,
                          double pvo2, double svo2, double pam, double pvc, double papm, double pcp, double fc,
                          double areaSupC, double vo2_36, double vo2_35, double vo2_34, double vo2_33, double vo2_32,
                          double vo2_escolhido, double cao2, double cvo2, double reo2, double dc, double ic, double vs,
                          double irvs, double irvp, String obs, long horaValor) {
        this.idCalculos = idCalculos;
        this.usuario = usuario;
        this.peso = peso;
        this.estatura = estatura;
        this.hb = hb;
        this.pao2 = pao2;
        this.sao2 = sao2;
        this.pvo2 = pvo2;
        this.svo2 = svo2;
        this.pam = pam;
        this.pvc = pvc;
        this.papm = papm;
        this.pcp = pcp;
        this.fc = fc;
        this.areaSupC = areaSupC;
        this.vo2_36 = vo2_36;
        this.vo2_35 = vo2_35;
        this.vo2_34 = vo2_34;
        this.vo2_33 = vo2_33;
        this.vo2_32 = vo2_32;
        this.vo2_escolhido = vo2_escolhido;
        this.cao2 = cao2;
        this.cvo2 = cvo2;
        this.reo2 = reo2;
        this.dc = dc;
        this.ic = ic;
        this.vs = vs;
        this.irvs = irvs;
        this.irvp = irvp;
        this.obs = obs;
        this.horaValor = horaValor;
    }

    public CalculoInicial(int usuario, double peso, double estatura, double hb, double pao2, double sao2, double pvo2,
                          double svo2, double pam, double pvc, double papm, double pcp, double fc, double areaSupC,
                          double vo2_36, double vo2_35, double vo2_34, double vo2_33, double vo2_32, double vo2_escolhido,
                          double cao2, double cvo2, double reo2, double dc, double ic, double vs, double irvs, double irvp,
                          String obs, long horaValor) {
        this.usuario = usuario;
        this.peso = peso;
        this.estatura = estatura;
        this.hb = hb;
        this.pao2 = pao2;
        this.sao2 = sao2;
        this.pvo2 = pvo2;
        this.svo2 = svo2;
        this.pam = pam;
        this.pvc = pvc;
        this.papm = papm;
        this.pcp = pcp;
        this.fc = fc;
        this.areaSupC = areaSupC;
        this.vo2_36 = vo2_36;
        this.vo2_35 = vo2_35;
        this.vo2_34 = vo2_34;
        this.vo2_33 = vo2_33;
        this.vo2_32 = vo2_32;
        this.vo2_escolhido = vo2_escolhido;
        this.cao2 = cao2;
        this.cvo2 = cvo2;
        this.reo2 = reo2;
        this.dc = dc;
        this.ic = ic;
        this.vs = vs;
        this.irvs = irvs;
        this.irvp = irvp;
        this.obs = obs;
        this.horaValor = horaValor;
    }

    public int getIdCalculos() {
        return idCalculos;
    }

    public void setIdCalculos(int idCalculos) {
        this.idCalculos = idCalculos;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getHb() {
        return hb;
    }

    public void setHb(double hb) {
        this.hb = hb;
    }

    public double getPao2() {
        return pao2;
    }

    public void setPao2(double pao2) {
        this.pao2 = pao2;
    }

    public double getSao2() {
        return sao2;
    }

    public void setSao2(double sao2) {
        this.sao2 = sao2;
    }

    public double getPvo2() {
        return pvo2;
    }

    public void setPvo2(double pvo2) {
        this.pvo2 = pvo2;
    }

    public double getSvo2() {
        return svo2;
    }

    public void setSvo2(double svo2) {
        this.svo2 = svo2;
    }

    public double getPam() {
        return pam;
    }

    public void setPam(double pam) {
        this.pam = pam;
    }

    public double getPvc() {
        return pvc;
    }

    public void setPvc(double pvc) {
        this.pvc = pvc;
    }

    public double getPapm() {
        return papm;
    }

    public void setPapm(double papm) {
        this.papm = papm;
    }

    public double getPcp() {
        return pcp;
    }

    public void setPcp(double pcp) {
        this.pcp = pcp;
    }

    public double getFc() {
        return fc;
    }

    public void setFc(double fc) {
        this.fc = fc;
    }

    public double getAreaSupC() {
        return areaSupC;
    }

    public void setAreaSupC(double areaSupC) {
        this.areaSupC = areaSupC;
    }

    public double getVo2_36() {
        return vo2_36;
    }

    public void setVo2_36(double vo2_36) {
        this.vo2_36 = vo2_36;
    }

    public double getVo2_35() {
        return vo2_35;
    }

    public void setVo2_35(double vo2_35) {
        this.vo2_35 = vo2_35;
    }

    public double getVo2_34() {
        return vo2_34;
    }

    public void setVo2_34(double vo2_34) {
        this.vo2_34 = vo2_34;
    }

    public double getVo2_33() {
        return vo2_33;
    }

    public void setVo2_33(double vo2_33) {
        this.vo2_33 = vo2_33;
    }

    public double getVo2_32() {
        return vo2_32;
    }

    public void setVo2_32(double vo2_32) {
        this.vo2_32 = vo2_32;
    }

    public double getVo2_escolhido() {
        return vo2_escolhido;
    }

    public void setVo2_escolhido(double vo2_escolhido) {
        this.vo2_escolhido = vo2_escolhido;
    }

    public double getCao2() {
        return cao2;
    }

    public void setCao2(double cao2) {
        this.cao2 = cao2;
    }

    public double getCvo2() {
        return cvo2;
    }

    public void setCvo2(double cvo2) {
        this.cvo2 = cvo2;
    }

    public double getReo2() {
        return reo2;
    }

    public void setReo2(double reo2) {
        this.reo2 = reo2;
    }

    public double getDc() {
        return dc;
    }

    public void setDc(double dc) {
        this.dc = dc;
    }

    public double getIc() {
        return ic;
    }

    public void setIc(double ic) {
        this.ic = ic;
    }

    public double getVs() {
        return vs;
    }

    public void setVs(double vs) {
        this.vs = vs;
    }

    public double getIrvs() {
        return irvs;
    }

    public void setIrvs(double irvs) {
        this.irvs = irvs;
    }

    public double getIrvp() {
        return irvp;
    }

    public void setIrvp(double irvp) {
        this.irvp = irvp;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public long gethoraValor() {
        return horaValor;
    }

    public void sethoraValor(long horaValor) {
        this.horaValor = horaValor;
    }

    @NonNull
    @Override
    public String toString() {
        return "CalculoInicial{" +
                "idCalculos=" + idCalculos +
                ", usuario=" + usuario +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", hb=" + hb +
                ", pao2=" + pao2 +
                ", sao2=" + sao2 +
                ", pvo2=" + pvo2 +
                ", svo2=" + svo2 +
                ", pam=" + pam +
                ", pvc=" + pvc +
                ", papm=" + papm +
                ", pcp=" + pcp +
                ", fc=" + fc +
                ", areaSupC=" + areaSupC +
                ", vo2_36=" + vo2_36 +
                ", vo2_35=" + vo2_35 +
                ", vo2_34=" + vo2_34 +
                ", vo2_33=" + vo2_33 +
                ", vo2_32=" + vo2_32 +
                ", vo2_escolhido=" + vo2_escolhido +
                ", cao2=" + cao2 +
                ", cvo2=" + cvo2 +
                ", reo2=" + reo2 +
                ", dc=" + dc +
                ", ic=" + ic +
                ", vs=" + vs +
                ", irvs=" + irvs +
                ", irvp=" + irvp +
                ", obs='" + obs + '\'' +
                ", horaValor=" + horaValor +
                '}';
    }
}
