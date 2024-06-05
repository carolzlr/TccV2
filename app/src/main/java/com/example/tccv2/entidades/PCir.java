package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class PCir {

    private int idParametrosCir; 
    private int usuario;
    private double  piaCir;
    private double  pvcCir;
    private double tempCir;
    private double diureseCir;
    private double fcCir;

    public PCir() {
    }

    public PCir(int idParametrosCir, int usuario, double  piaCir, double  pvcCir, double tempCir, double diureseCir, double fcCir) {
        this.idParametrosCir = idParametrosCir;
        this.usuario = usuario;
        this. piaCir =  piaCir;
        this. pvcCir =  pvcCir;
        this.tempCir = tempCir;
        this.diureseCir = diureseCir;
        this.fcCir = fcCir;
    }

    public PCir(int usuario, double  piaCir, double  pvcCir, double tempCir, double diureseCir, double fcCir) {
        this.usuario = usuario;
        this. piaCir =  piaCir;
        this. pvcCir =  pvcCir;
        this.tempCir = tempCir;
        this.diureseCir = diureseCir;
        this.fcCir = fcCir;
    }

    public int getIdParametrosCir() {
        return idParametrosCir;
    }

    public void setIdParametrosCir(int idParametrosCir) {
        this.idParametrosCir = idParametrosCir;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getPiaCir() {
        return piaCir;
    }

    public void setPiaCir(double piaCir) {
        this.piaCir = piaCir;
    }

    public double getPvcCir() {
        return pvcCir;
    }

    public void setPvcCir(double pvcCir) {
        this.pvcCir = pvcCir;
    }

    public double getTempCir() {
        return tempCir;
    }

    public void setTempCir(double tempCir) {
        this.tempCir = tempCir;
    }

    public double getDiureseCir() {
        return diureseCir;
    }

    public void setDiureseCir(double diureseCir) {
        this.diureseCir = diureseCir;
    }

    public double getFcCir() {
        return fcCir;
    }

    public void setFcCir(double fcCir) {
        this.fcCir = fcCir;
    }

    @NonNull
    @Override
    public String toString() {
        return "PCir{" +
                "idParametrosCir=" + idParametrosCir +
                ", usuario=" + usuario +
                ", piaCir=" + piaCir +
                ", pvcCir=" + pvcCir +
                ", tempCir=" + tempCir +
                ", diureseCir=" + diureseCir +
                ", fcCir=" + fcCir +
                '}';
    }
}
