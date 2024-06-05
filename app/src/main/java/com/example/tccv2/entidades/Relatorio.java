package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Relatorio {
    private int idRelatorio;
    private Usuario usuario;
    private Equipe equipe;
    private Paciente paciente;
    private ExamesAdicionais examesAdicionais;
    private PCir pCir;
    private PCec pCec;
    private CalculoInicial calculoInicial;
    private ExamesRep examesRep;
    private Calculo_Rep calculoRep;
    private Procedimento procedimento;

    public Relatorio() {
    }

    public Relatorio(int idRelatorio, Usuario usuario, Equipe equipe, Paciente paciente,
                     ExamesAdicionais examesAdicionais, PCir pCir, PCec pCec, CalculoInicial calculoInicial,
                     ExamesRep examesRep, Calculo_Rep calculoRep, Procedimento procedimento) {
        this.idRelatorio = idRelatorio;
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

    public Relatorio(Usuario usuario, Equipe equipe, Paciente paciente, ExamesAdicionais examesAdicionais, PCir pCir,
                     PCec pCec, CalculoInicial calculoInicial, ExamesRep examesRep, Calculo_Rep calculoRep,
                     Procedimento procedimento) {
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


    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ExamesAdicionais getExamesAdicionais() {
        return examesAdicionais;
    }

    public void setExamesAdicionais(ExamesAdicionais examesAdicionais) {
        this.examesAdicionais = examesAdicionais;
    }

    public PCir getpCir() {
        return pCir;
    }

    public void setpCir(PCir pCir) {
        this.pCir = pCir;
    }

    public PCec getpCec() {
        return pCec;
    }

    public void setpCec(PCec pCec) {
        this.pCec = pCec;
    }

    public CalculoInicial getCalculoInicial() {
        return calculoInicial;
    }

    public void setCalculoInicial(CalculoInicial calculoInicial) {
        this.calculoInicial = calculoInicial;
    }

    public ExamesRep getExamesRep() {
        return examesRep;
    }

    public void setExamesRep(ExamesRep examesRep) {
        this.examesRep = examesRep;
    }

    public Calculo_Rep getCalculoRep() {
        return calculoRep;
    }

    public void setCalculoRep(Calculo_Rep calculoRep) {
        this.calculoRep = calculoRep;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @NonNull
    @Override
    public String toString() {
        return "Relatorio{" +
                "idRelatorio=" + idRelatorio +
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
