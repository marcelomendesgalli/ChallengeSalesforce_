package org.example.entities;

public class Formulario {
    private int id;
    private String nome;
    private String empresanome;
    private String emailcorporativo;
    private String telefone;
    private String pais;
    private String aceitarpolitica;

    public Formulario(){};

    public Formulario(String nome, String empresanome, String emailcorporativo, String telefone, String pais, String aceitarpolitica) {
        this.nome = nome;
        this.empresanome = empresanome;
        this.emailcorporativo = emailcorporativo;
        this.telefone = telefone;
        this.pais = pais;
        this.aceitarpolitica = aceitarpolitica;
    }

    public Formulario(int id, String nome, String empresanome, String emailcorporativo, String telefone, String pais, String aceitarpolitica) {
        this.id = id;
        this.nome = nome;
        this.empresanome = empresanome;
        this.emailcorporativo = emailcorporativo;
        this.telefone = telefone;
        this.pais = pais;
        this.aceitarpolitica = aceitarpolitica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresanome() {
        return empresanome;
    }

    public void setEmpresanome(String empresanome) {
        this.empresanome = empresanome;
    }

    public String getEmailcorporativo() {
        return emailcorporativo;
    }

    public void setEmailcorporativo(String emailcorporativo) {
        this.emailcorporativo = emailcorporativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAceitarpolitica() {
        return aceitarpolitica;
    }

    public void setAceitarpolitica(String aceitarpolitica) {
        this.aceitarpolitica = aceitarpolitica;
    }

    @Override
    public String toString() {
        return "Formulario:" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + empresanome + '\'' +
                ", email='" + emailcorporativo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pais='" + pais + '\'' +
                ", idioma='" + aceitarpolitica + '\'' +
                '.';
    }
}
