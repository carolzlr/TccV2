package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Calculo_Rep {

    private int idCalculoRep;
    private int usuario;
    private double rep_hb;
    private double rep_pao2;
    private double rep_sao2;
    private double rep_pvo2;
    private double rep_svo2;
    private double rep_pam;
    private double rep_pvc;
    private double rep_papm;
    private double rep_pcp;
    private double rep_fc;
    private double rep_cao2;
    private double rep_cvo2;
    private double rep_reo2;
    private double rep_dc;
    private double rep_ic;
    private double rep_vs;
    private double rep_irvs;
    private double rep_irvp;
    private String rep_obs;
    private long rep_dataHora;

    public Calculo_Rep() {
    }

    public Calculo_Rep(int idCalculoRep, int usuario, double rep_hb, double rep_pao2, double rep_sao2,
                       double rep_pvo2, double rep_svo2, double rep_pam, double rep_pvc, double rep_papm,
                       double rep_pcp, double rep_fc, double rep_cao2, double rep_cvo2, double rep_reo2,
                       double rep_dc, double rep_ic, double rep_vs, double rep_irvs, double rep_irvp, String rep_obs,
                       long rep_dataHora) {
        this.idCalculoRep = idCalculoRep;
        this.usuario = usuario;
        this.rep_hb = rep_hb;
        this.rep_pao2 = rep_pao2;
        this.rep_sao2 = rep_sao2;
        this.rep_pvo2 = rep_pvo2;
        this.rep_svo2 = rep_svo2;
        this.rep_pam = rep_pam;
        this.rep_pvc = rep_pvc;
        this.rep_papm = rep_papm;
        this.rep_pcp = rep_pcp;
        this.rep_fc = rep_fc;
        this.rep_cao2 = rep_cao2;
        this.rep_cvo2 = rep_cvo2;
        this.rep_reo2 = rep_reo2;
        this.rep_dc = rep_dc;
        this.rep_ic = rep_ic;
        this.rep_vs = rep_vs;
        this.rep_irvs = rep_irvs;
        this.rep_irvp = rep_irvp;
        this.rep_obs = rep_obs;
        this.rep_dataHora = rep_dataHora;
    }

    public Calculo_Rep(int usuario, double rep_hb, double rep_pao2, double rep_sao2, double rep_pvo2, double rep_svo2,
                       double rep_pam, double rep_pvc, double rep_papm, double rep_pcp, double rep_fc,
                       double rep_cao2, double rep_cvo2, double rep_reo2, double rep_dc, double rep_ic,
                       double rep_vs, double rep_irvs, double rep_irvp,
                       String rep_obs, long rep_dataHora) {
        this.usuario = usuario;
        this.rep_hb = rep_hb;
        this.rep_pao2 = rep_pao2;
        this.rep_sao2 = rep_sao2;
        this.rep_pvo2 = rep_pvo2;
        this.rep_svo2 = rep_svo2;
        this.rep_pam = rep_pam;
        this.rep_pvc = rep_pvc;
        this.rep_papm = rep_papm;
        this.rep_pcp = rep_pcp;
        this.rep_fc = rep_fc;
        this.rep_cao2 = rep_cao2;
        this.rep_cvo2 = rep_cvo2;
        this.rep_reo2 = rep_reo2;
        this.rep_dc = rep_dc;
        this.rep_ic = rep_ic;
        this.rep_vs = rep_vs;
        this.rep_irvs = rep_irvs;
        this.rep_irvp = rep_irvp;
        this.rep_obs = rep_obs;
        this.rep_dataHora = rep_dataHora;
    }

    public int getIdCalculoRep() {
        return idCalculoRep;
    }

    public void setIdCalculoRep(int idCalculoRep) {
        this.idCalculoRep = idCalculoRep;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getRep_hb() {
        return rep_hb;
    }

    public void setRep_hb(double rep_hb) {
        this.rep_hb = rep_hb;
    }

    public double getRep_pao2() {
        return rep_pao2;
    }

    public void setRep_pao2(double rep_pao2) {
        this.rep_pao2 = rep_pao2;
    }

    public double getRep_sao2() {
        return rep_sao2;
    }

    public void setRep_sao2(double rep_sao2) {
        this.rep_sao2 = rep_sao2;
    }

    public double getRep_pvo2() {
        return rep_pvo2;
    }

    public void setRep_pvo2(double rep_pvo2) {
        this.rep_pvo2 = rep_pvo2;
    }

    public double getRep_svo2() {
        return rep_svo2;
    }

    public void setRep_svo2(double rep_svo2) {
        this.rep_svo2 = rep_svo2;
    }

    public double getRep_pam() {
        return rep_pam;
    }

    public void setRep_pam(double rep_pam) {
        this.rep_pam = rep_pam;
    }

    public double getRep_pvc() {
        return rep_pvc;
    }

    public void setRep_pvc(double rep_pvc) {
        this.rep_pvc = rep_pvc;
    }

    public double getRep_papm() {
        return rep_papm;
    }

    public void setRep_papm(double rep_papm) {
        this.rep_papm = rep_papm;
    }

    public double getRep_pcp() {
        return rep_pcp;
    }

    public void setRep_pcp(double rep_pcp) {
        this.rep_pcp = rep_pcp;
    }

    public double getRep_fc() {
        return rep_fc;
    }

    public void setRep_fc(double rep_fc) {
        this.rep_fc = rep_fc;
    }

    public double getRep_cao2() {
        return rep_cao2;
    }

    public void setRep_cao2(double rep_cao2) {
        this.rep_cao2 = rep_cao2;
    }

    public double getRep_cvo2() {
        return rep_cvo2;
    }

    public void setRep_cvo2(double rep_cvo2) {
        this.rep_cvo2 = rep_cvo2;
    }

    public double getRep_reo2() {
        return rep_reo2;
    }

    public void setRep_reo2(double rep_reo2) {
        this.rep_reo2 = rep_reo2;
    }

    public double getRep_dc() {
        return rep_dc;
    }

    public void setRep_dc(double rep_dc) {
        this.rep_dc = rep_dc;
    }

    public double getRep_ic() {
        return rep_ic;
    }

    public void setRep_ic(double rep_ic) {
        this.rep_ic = rep_ic;
    }

    public double getRep_vs() {
        return rep_vs;
    }

    public void setRep_vs(double rep_vs) {
        this.rep_vs = rep_vs;
    }

    public double getRep_irvs() {
        return rep_irvs;
    }

    public void setRep_irvs(double rep_irvs) {
        this.rep_irvs = rep_irvs;
    }

    public double getRep_irvp() {
        return rep_irvp;
    }

    public void setRep_irvp(double rep_irvp) {
        this.rep_irvp = rep_irvp;
    }

    public String getRep_obs() {
        return rep_obs;
    }

    public void setRep_obs(String rep_obs) {
        this.rep_obs = rep_obs;
    }

    public long getRep_dataHora() {
        return rep_dataHora;
    }

    public void setRep_dataHora(long rep_dataHora) {
        this.rep_dataHora = rep_dataHora;
    }

    @NonNull
    @Override
    public String toString() {
        return "Calculo_Rep{" +
                "idCalculoRep=" + idCalculoRep +
                ", usuario=" + usuario +
                ", rep_hb=" + rep_hb +
                ", rep_pao2=" + rep_pao2 +
                ", rep_sao2=" + rep_sao2 +
                ", rep_pvo2=" + rep_pvo2 +
                ", rep_svo2=" + rep_svo2 +
                ", rep_pam=" + rep_pam +
                ", rep_pvc=" + rep_pvc +
                ", rep_papm=" + rep_papm +
                ", rep_pcp=" + rep_pcp +
                ", rep_fc=" + rep_fc +
                ", rep_cao2=" + rep_cao2 +
                ", rep_cvo2=" + rep_cvo2 +
                ", rep_reo2=" + rep_reo2 +
                ", rep_dc=" + rep_dc +
                ", rep_ic=" + rep_ic +
                ", rep_vs=" + rep_vs +
                ", rep_irvs=" + rep_irvs +
                ", rep_irvp=" + rep_irvp +
                ", rep_obs='" + rep_obs + '\'' +
                ", rep_dataHora=" + rep_dataHora +
                '}';
    }
}
