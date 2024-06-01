package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

public class Paciente {
    private int idPaciente;
    private int usuario;
    private int idade;
    private  String genero;
    private double peso;
    private double estatura;
    private double superficieCorporea;
    private double fluxo1;
    private double fluxo2;
    private double fluxo3;
    private String diagnostico;

    public Paciente(int idPaciente, int usuario, int idade, String genero, double peso, double estatura, double superficieCorporea,
                    double fluxo1, double fluxo2, double fluxo3, String diagnostico) {
        this.idPaciente = idPaciente;
        this.usuario = usuario;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        this.superficieCorporea = superficieCorporea;
        this.fluxo1 = fluxo1;
        this.fluxo2 = fluxo2;
        this.fluxo3 = fluxo3;
        this.diagnostico = diagnostico;
    }

    public Paciente(int usuario, int idade, String genero, double peso, double estatura, double superficieCorporea,
                    double fluxo1, double fluxo2, double fluxo3, String diagnostico) {
        this.usuario = usuario;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        this.superficieCorporea = superficieCorporea;
        this.fluxo1 = fluxo1;
        this.fluxo2 = fluxo2;
        this.fluxo3 = fluxo3;
        this.diagnostico = diagnostico;
    }

    public Paciente(int usuario, int idade, String genero, String diagnostico) {
        this.usuario = usuario;
        this.idade = idade;
        this.genero = genero;
        this.diagnostico = diagnostico;
    }

    public Paciente() {
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public double getSuperficieCorporea() {
        return superficieCorporea;
    }

    public void setSuperficieCorporea(double superficieCorporea) {
        this.superficieCorporea = superficieCorporea;
    }

    public double getFluxo1() {
        return fluxo1;
    }

    public void setFluxo1(double fluxo1) {
        this.fluxo1 = fluxo1;
    }

    public double getFluxo2() {
        return fluxo2;
    }

    public void setFluxo2(double fluxo2) {
        this.fluxo2 = fluxo2;
    }

    public double getFluxo3() {
        return fluxo3;
    }

    public void setFluxo3(double fluxo3) {
        this.fluxo3 = fluxo3;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @NonNull
    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", usuario=" + usuario +
                ", idade=" + idade +
                ", genero='" + genero + '\'' +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", superficieCorporea=" + superficieCorporea +
                ", fluxo1=" + fluxo1 +
                ", fluxo2=" + fluxo2 +
                ", fluxo3=" + fluxo3 +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }
}
