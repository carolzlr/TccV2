package com.example.tccv2.entidades;

import androidx.annotation.NonNull;

import java.util.List;

public class Usuario {

    private int idUsuario;
    private String nome;
    private String userName;
    private  String email;
    private  String tipo;
    private String senha;
    private List<Relatorio> relatorios;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String userName, String email, String tipo, String senha) {
            this.idUsuario = idUsuario;
            this.nome = nome;
            this.userName = userName;
            this.email = email;
            this.tipo = tipo;
            this.senha = senha;
        }
    public Usuario(String nome, String userName, String email, String tipo, String senha) {
            this.nome = nome;
            this.userName = userName;
            this.email = email;
            this.tipo = tipo;
            this.senha = senha;
        }

        public Usuario(int idUsuario, String userName, String senha) {
            this.idUsuario = idUsuario;
            this.userName = userName;
            this.senha = senha;
        }

    public Usuario(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public int getIdUsuario() {
            return idUsuario;
        }

    public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

    public String getNome() {
            return nome;
        }

    public void setNome(String nome) {
            this.nome = nome;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public void adicionarRelatorio(Relatorio relatorio){
        this.relatorios.add(relatorio);
    }

    @NonNull
        @Override
        public String toString() {
            return "Usuario{" +
                    "idUsuario=" + idUsuario +
                    ", nome='" + nome + '\'' +
                    ", userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", senha='" + senha + '\'' +
                    '}';
        }
    }

