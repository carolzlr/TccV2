package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Procedimento {
    private int idProcedimento;
    private int usuario; // FK
    private String nomeProc;
    private long dataInicio;
    private long horaInicio;
    private String oxigenador;
    private String canulaAA;
    private String canulaV;
    private String protamina;
    private String hepMg;
    private String hepMl;
    private long iCec;
    private long fCec;
    private long totalCec;
    private long iClamp;
    private long fClamp;
    private long totalClamp;
    private long datafProc;
    private long horafProc;
    private String obs;

    public Procedimento() {
    }

    public Procedimento(int idProcedimento, int usuario, String nomeProc, long dataInicio, long horaInicio, String oxigenador, String canulaAA,
                        String canulaV, String protamina, String hepMg, String hepMl, long iCec, long fCec, long totalCec, long iClamp,
                        long fClamp, long totalClamp, long datafProc, long horafProc, String obs) {
        this.idProcedimento = idProcedimento;
        this.usuario = usuario;
        this.nomeProc = nomeProc;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.oxigenador = oxigenador;
        this.canulaAA = canulaAA;
        this.canulaV = canulaV;
        this.protamina = protamina;
        this.hepMg = hepMg;
        this.hepMl = hepMl;
        this.iCec = iCec;
        this.fCec = fCec;
        this.totalCec = totalCec;
        this.iClamp = iClamp;
        this.fClamp = fClamp;
        this.totalClamp = totalClamp;
        this.datafProc = datafProc;
        this.horafProc = horafProc;
        this.obs = obs;
    }

    public Procedimento(int usuario, String nomeProc, long dataInicio, long horaInicio, String oxigenador, String canulaAA, String canulaV,
                        String protamina, String hepMg, String hepMl, long iCec, long fCec, long totalCec, long iClamp, long fClamp,
                        long totalClamp, long datafProc, long horafProc, String obs) {
        this.usuario = usuario;
        this.nomeProc = nomeProc;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.oxigenador = oxigenador;
        this.canulaAA = canulaAA;
        this.canulaV = canulaV;
        this.protamina = protamina;
        this.hepMg = hepMg;
        this.hepMl = hepMl;
        this.iCec = iCec;
        this.fCec = fCec;
        this.totalCec = totalCec;
        this.iClamp = iClamp;
        this.fClamp = fClamp;
        this.totalClamp = totalClamp;
        this.datafProc = datafProc;
        this.horafProc = horafProc;
        this.obs = obs;
    }

    public Procedimento(int idProcedimento, String nomeProc, long dataInicio, long horaInicio, String oxigenador, String canulaAA,
                        String canulaV, long totalCec, long totalClamp, long datafProc) {
        this.idProcedimento = idProcedimento;
        this.nomeProc = nomeProc;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.oxigenador = oxigenador;
        this.canulaAA = canulaAA;
        this.canulaV = canulaV;
        this.totalCec = totalCec;
        this.totalClamp = totalClamp;
        this.datafProc = datafProc;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNomeProc() {
        return nomeProc;
    }

    public void setNomeProc(String nomeProc) {
        this.nomeProc = nomeProc;
    }

    public long getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(long dataInicio) {
        this.dataInicio = dataInicio;
    }

    public long getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getOxigenador() {
        return oxigenador;
    }

    public void setOxigenador(String oxigenador) {
        this.oxigenador = oxigenador;
    }

    public String getCanulaAA() {
        return canulaAA;
    }

    public void setCanulaAA(String canulaAA) {
        this.canulaAA = canulaAA;
    }

    public String getCanulaV() {
        return canulaV;
    }

    public void setCanulaV(String canulaV) {
        this.canulaV = canulaV;
    }

    public String getProtamina() {
        return protamina;
    }

    public void setProtamina(String protamina) {
        this.protamina = protamina;
    }

    public String getHepMg() {
        return hepMg;
    }

    public void setHepMg(String hepMg) {
        this.hepMg = hepMg;
    }

    public String getHepMl() {
        return hepMl;
    }

    public void setHepMl(String hepMl) {
        this.hepMl = hepMl;
    }

    public long getiCec() {
        return iCec;
    }

    public void setiCec(long iCec) {
        this.iCec = iCec;
    }

    public long getfCec() {
        return fCec;
    }

    public void setfCec(long fCec) {
        this.fCec = fCec;
    }

    public long getTotalCec() {
        return totalCec;
    }

    public void setTotalCec(long totalCec) {
        this.totalCec = totalCec;
    }

    public long getiClamp() {
        return iClamp;
    }

    public void setiClamp(long iClamp) {
        this.iClamp = iClamp;
    }

    public long getfClamp() {
        return fClamp;
    }

    public void setfClamp(long fClamp) {
        this.fClamp = fClamp;
    }

    public long getTotalClamp() {
        return totalClamp;
    }

    public void setTotalClamp(long totalClamp) {
        this.totalClamp = totalClamp;
    }

    public long getDatafProc() {
        return datafProc;
    }

    public void setDatafProc(long datafProc) {
        this.datafProc = datafProc;
    }

    public long getHorafProc() {
        return horafProc;
    }

    public void setHorafProc(long horafProc) {
        this.horafProc = horafProc;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @NonNull
    @Override
    public String toString() {
        return "Procedimento{" +
                "idProcedimento=" + idProcedimento +
                ", usuario=" + usuario +
                ", nomeProc='" + nomeProc + '\'' +
                ", dataInicio=" + dataInicio +
                ", horaInicio=" + horaInicio +
                ", oxigenador='" + oxigenador + '\'' +
                ", canulaAA='" + canulaAA + '\'' +
                ", canulaV='" + canulaV + '\'' +
                ", protamina='" + protamina + '\'' +
                ", hepMg='" + hepMg + '\'' +
                ", hepMl='" + hepMl + '\'' +
                ", iCec=" + iCec +
                ", fCec=" + fCec +
                ", totalCec=" + totalCec +
                ", iClamp=" + iClamp +
                ", fClamp=" + fClamp +
                ", totalClamp=" + totalClamp +
                ", datafProc=" + datafProc +
                ", horafProc=" + horafProc +
                ", obs='" + obs + '\'' +
                '}';
    }
}
