package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Equipe {
    private int idEquipe;
    private int usuario;
    private String cirurgiao;
    private String auxiliar1;
    private String auxiliar2;
    private String perfusionista;
    private String instrumentador;
    private String anestesista;
    private String circulante;
    private String hospital;

    public Equipe(int idEquipe, int usuario, String cirurgiao, String auxiliar1, String auxiliar2, String perfusionista,
                  String instrumentador, String anestesista, String circulante, String hospital) {
        this.idEquipe = idEquipe;
        this.usuario = usuario;
        this.cirurgiao = cirurgiao;
        this.auxiliar1 = auxiliar1;
        this.auxiliar2 = auxiliar2;
        this.perfusionista = perfusionista;
        this.instrumentador = instrumentador;
        this.anestesista = anestesista;
        this.circulante = circulante;
        this.hospital = hospital;
    }

    public Equipe(int usuario, String cirurgiao, String auxiliar1, String auxiliar2, String perfusionista, String instrumentador,
                  String anestesista, String circulante, String hospital) {
        this.usuario = usuario;
        this.cirurgiao = cirurgiao;
        this.auxiliar1 = auxiliar1;
        this.auxiliar2 = auxiliar2;
        this.perfusionista = perfusionista;
        this.instrumentador = instrumentador;
        this.anestesista = anestesista;
        this.circulante = circulante;
        this.hospital = hospital;
    }

    public Equipe(int usuario, String cirurgiao, String auxiliar1, String perfusionista, String hospital) {
        this.usuario = usuario;
        this.cirurgiao = cirurgiao;
        this.auxiliar1 = auxiliar1;
        this.perfusionista = perfusionista;
        this.hospital = hospital;
    }

    public Equipe() {
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    public String getInstrumentador() {
        return instrumentador;
    }

    public void setInstrumentador(String instrumentador) {
        this.instrumentador = instrumentador;
    }

    public String getAnestesista() {
        return anestesista;
    }

    public void setAnestesista(String anestesista) {
        this.anestesista = anestesista;
    }

    public String getCirculante() {
        return circulante;
    }

    public void setCirculante(String circulante) {
        this.circulante = circulante;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @NonNull
    @Override
    public String toString() {
        return "Equipe{" +
                "idEquipe=" + idEquipe +
                ", usuario=" + usuario +
                ", cirurgiao='" + cirurgiao + '\'' +
                ", auxiliar1='" + auxiliar1 + '\'' +
                ", auxiliar2='" + auxiliar2 + '\'' +
                ", perfusionista='" + perfusionista + '\'' +
                ", instrumentador='" + instrumentador + '\'' +
                ", anestesista='" + anestesista + '\'' +
                ", circulante='" + circulante + '\'' +
                ", hospital='" + hospital + '\'' +
                '}';
    }
}
