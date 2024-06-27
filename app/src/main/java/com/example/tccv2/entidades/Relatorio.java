package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Relatorio {
    private int idRelatorio;
    private int usuario; // FK
    private String procedimento;
    private String cirurgiao;
    private String auxiliar1;
    private String auxiliar2;
    private String perfusionista;
    private String hospital;
    private String vo2Escolhido;
    private String dataInicio;
    private String horaInicio;
    private String dataFim;
    private String horaFim;
    private String oxigenador;
    private String canulaAA;
    private String canulaV;
    private String totalCEC;
    private String totalClamp;

    public Relatorio(int idRelatorio, int usuario, String procedimento, String cirurgiao, String auxiliar1, String auxiliar2,
                     String perfusionista, String hospital, String vo2Escolhido, String dataInicio, String horaInicio,
                     String dataFim, String horaFim, String oxigenador, String canulaAA, String canulaV, String totalCEC,
                     String totalClamp) {
        this.idRelatorio = idRelatorio;
        this.usuario = usuario;
        this.procedimento = procedimento;
        this.cirurgiao = cirurgiao;
        this.auxiliar1 = auxiliar1;
        this.auxiliar2 = auxiliar2;
        this.perfusionista = perfusionista;
        this.hospital = hospital;
        this.vo2Escolhido = vo2Escolhido;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.oxigenador = oxigenador;
        this.canulaAA = canulaAA;
        this.canulaV = canulaV;
        this.totalCEC = totalCEC;
        this.totalClamp = totalClamp;
    }

    public Relatorio(int usuario, String procedimento, String cirurgiao, String auxiliar1, String auxiliar2,
                     String perfusionista, String hospital, String vo2Escolhido, String dataInicio, String horaInicio,
                     String dataFim, String horaFim, String oxigenador, String canulaAA, String canulaV, String totalCEC,
                     String totalClamp) {
        this.usuario = usuario;
        this.procedimento = procedimento;
        this.cirurgiao = cirurgiao;
        this.auxiliar1 = auxiliar1;
        this.auxiliar2 = auxiliar2;
        this.perfusionista = perfusionista;
        this.hospital = hospital;
        this.vo2Escolhido = vo2Escolhido;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.oxigenador = oxigenador;
        this.canulaAA = canulaAA;
        this.canulaV = canulaV;
        this.totalCEC = totalCEC;
        this.totalClamp = totalClamp;
    }

    public Relatorio() {
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(String cirurgiao) {
        this.cirurgiao = cirurgiao;
    }

    public String getAuxiliar1() {
        return auxiliar1;
    }

    public void setAuxiliar1(String auxiliar1) {
        this.auxiliar1 = auxiliar1;
    }

    public String getAuxiliar2() {
        return auxiliar2;
    }

    public void setAuxiliar2(String auxiliar2) {
        this.auxiliar2 = auxiliar2;
    }

    public String getPerfusionista() {
        return perfusionista;
    }

    public void setPerfusionista(String perfusionista) {
        this.perfusionista = perfusionista;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getVo2Escolhido() {
        return vo2Escolhido;
    }

    public void setVo2Escolhido(String vo2Escolhido) {
        this.vo2Escolhido = vo2Escolhido;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
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

    public String getTotalCEC() {
        return totalCEC;
    }

    public void setTotalCEC(String totalCEC) {
        this.totalCEC = totalCEC;
    }

    public String getTotalClamp() {
        return totalClamp;
    }

    public void setTotalClamp(String totalClamp) {
        this.totalClamp = totalClamp;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "idRelatorio=" + idRelatorio +
                ", usuario=" + usuario +
                ", procedimento='" + procedimento + '\'' +
                ", cirurgiao='" + cirurgiao + '\'' +
                ", auxiliar1='" + auxiliar1 + '\'' +
                ", auxiliar2='" + auxiliar2 + '\'' +
                ", perfusionista='" + perfusionista + '\'' +
                ", hospital='" + hospital + '\'' +
                ", vo2Escolhido='" + vo2Escolhido + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", horaFim='" + horaFim + '\'' +
                ", oxigenador='" + oxigenador + '\'' +
                ", canulaAA='" + canulaAA + '\'' +
                ", canulaV='" + canulaV + '\'' +
                ", totalCEC='" + totalCEC + '\'' +
                ", totalClamp='" + totalClamp + '\'' +
                '}';
    }
}
