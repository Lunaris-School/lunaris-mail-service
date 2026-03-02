package com.lunarismailapi.model;

public class Mensagem {
    private String nomeAluno;
    private String emailProfessor;
    private String assunto;
    private String conteudo;

    public Mensagem(){}
    public Mensagem(String nomeAluno, String emailProfessor, String assunto, String conteudo) {
        this.nomeAluno = nomeAluno;
        this.emailProfessor = emailProfessor;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
