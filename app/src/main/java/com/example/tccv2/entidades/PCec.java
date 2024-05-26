package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class PCec {
    private int idParametrosCeC;
    private int usuario;
    private double piaCec;
    private double pvcCec;
    private double tempCec;
    private double diureseCec;
    private double fcCec;
    private long horaInicioCec;

    public PCec(int idParametrosCeC, int usuario, double piaCec, double pvcCec, double tempCec, double diureseCec,
                double fcCec, long horaInicioCec) {
        this.idParametrosCeC = idParametrosCeC;
        this.usuario = usuario;
        this.piaCec = piaCec;
        this.pvcCec = pvcCec;
        this.tempCec = tempCec;
        this.diureseCec = diureseCec;
        this.fcCec = fcCec;
        this.horaInicioCec = horaInicioCec;
    }

    public PCec(int usuario, double piaCec, double pvcCec, double tempCec, double diureseCec, double fcCec, long horaInicioCec) {
        this.usuario = usuario;
        this.piaCec = piaCec;
        this.pvcCec = pvcCec;
        this.tempCec = tempCec;
        this.diureseCec = diureseCec;
        this.fcCec = fcCec;
        this.horaInicioCec = horaInicioCec;
    }

    public int getIdParametrosCeC() {
        return idParametrosCeC;
    }

    public void setIdParametrosCeC(int idParametrosCeC) {
        this.idParametrosCeC = idParametrosCeC;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public double getPiaCec() {
        return piaCec;
    }

    public void setPiaCec(double piaCec) {
        this.piaCec = piaCec;
    }

    public double getPvcCec() {
        return pvcCec;
    }

    public void setPvcCec(double pvcCec) {
        this.pvcCec = pvcCec;
    }

    public double getTempCec() {
        return tempCec;
    }

    public void setTempCec(double tempCec) {
        this.tempCec = tempCec;
    }

    public double getDiureseCec() {
        return diureseCec;
    }

    public void setDiureseCec(double diureseCec) {
        this.diureseCec = diureseCec;
    }

    public double getFcCec() {
        return fcCec;
    }

    public void setFcCec(double fcCec) {
        this.fcCec = fcCec;
    }

    public long getHoraInicioCec() {
        return horaInicioCec;
    }

    public void setHoraInicioCec(long horaInicioCec) {
        this.horaInicioCec = horaInicioCec;
    }

    @NonNull
    @Override
    public String toString() {
        return "PCec{" +
                "idParametrosCeC=" + idParametrosCeC +
                ", usuario=" + usuario +
                ", piaCec=" + piaCec +
                ", pvcCec=" + pvcCec +
                ", tempCec=" + tempCec +
                ", diureseCec=" + diureseCec +
                ", fcCec=" + fcCec +
                ", horaInicioCec=" + horaInicioCec +
                '}';
    }
}
