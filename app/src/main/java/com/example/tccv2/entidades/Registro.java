package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Registro {
    private int idRegistro;
    private int usuario; // FK
    private int equipe;
    private int paciente;
    private int examesAdicionais;
    private int pCir;
    private int pCec;
    private int calculoInicial;
    private int examesRep;
    private int calculoRep;
    private int procedimento;

    public Registro() {
        // contrutor vazio para popular o array
    }

    public Registro(int idRegistro, int usuario, int equipe, int paciente, int examesAdicionais, int pCir, int pCec,
                    int calculoInicial, int examesRep, int calculoRep, int procedimento) {
        this.idRegistro = idRegistro;
        this.usuario = usuario;
        this.equipe = equipe;
        this.paciente = paciente;
        this.examesAdicionais = examesAdicionais;
        this.pCir = pCir;
        this.pCec = pCec;
        this.calculoInicial = calculoInicial;
        this.examesRep = examesRep;
        this.calculoRep = calculoRep;
        this.procedimento = procedimento;
    }

    public Registro(int usuario, int equipe, int paciente, int examesAdicionais, int pCir, int pCec, int calculoInicial,
                    int examesRep, int calculoRep, int procedimento) {
        this.usuario = usuario;
        this.equipe = equipe;
        this.paciente = paciente;
        this.examesAdicionais = examesAdicionais;
        this.pCir = pCir;
        this.pCec = pCec;
        this.calculoInicial = calculoInicial;
        this.examesRep = examesRep;
        this.calculoRep = calculoRep;
        this.procedimento = procedimento;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getExamesAdicionais() {
        return examesAdicionais;
    }

    public void setExamesAdicionais(int examesAdicionais) {
        this.examesAdicionais = examesAdicionais;
    }

    public int getpCir() {
        return pCir;
    }

    public void setpCir(int pCir) {
        this.pCir = pCir;
    }

    public int getpCec() {
        return pCec;
    }

    public void setpCec(int pCec) {
        this.pCec = pCec;
    }

    public int getCalculoInicial() {
        return calculoInicial;
    }

    public void setCalculoInicial(int calculoInicial) {
        this.calculoInicial = calculoInicial;
    }

    public int getExamesRep() {
        return examesRep;
    }

    public void setExamesRep(int examesRep) {
        this.examesRep = examesRep;
    }

    public int getCalculoRep() {
        return calculoRep;
    }

    public void setCalculoRep(int calculoRep) {
        this.calculoRep = calculoRep;
    }

    public int getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(int procedimento) {
        this.procedimento = procedimento;
    }

    @NonNull
    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", usuario=" + usuario +
                ", equipe=" + equipe +
                ", paciente=" + paciente +
                ", examesAdicionais=" + examesAdicionais +
                ", pCir=" + pCir +
                ", pCec=" + pCec +
                ", calculoInicial=" + calculoInicial +
                ", examesRep=" + examesRep +
                ", calculoRep=" + calculoRep +
                ", procedimento=" + procedimento +
                '}';
    }
}
