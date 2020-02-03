package com.bambey2019.myciteuniv.Model;

public class Users {
    private String nom, codePerm, motPass, numCni, filiere, niveau, tel, numeroChamre;

    public Users(){

    }

    public Users(String numeroChamre, String nom, String codePerm, String motPass, String numCni, String filiere, String niveau, String tel) {
        this.nom = nom;
        this.codePerm = codePerm;
        this.motPass = motPass;
        this.numCni = numCni;
        this.filiere = filiere;
        this.niveau = niveau;
        this.tel = tel;
        this.numeroChamre = numeroChamre;
    }

    public String getNumeroChamre() {
        return numeroChamre;
    }

    public void setNumeroChamre(String numeroChamre) {
        this.numeroChamre = numeroChamre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePerm() {
        return codePerm;
    }

    public void setCodePerm(String codePerm) {
        this.codePerm = codePerm;
    }

    public String getMotPass() {
        return motPass;
    }

    public void setMotPass(String motPass) {
        this.motPass = motPass;
    }

    public String getNumCni() {
        return numCni;
    }

    public void setNumCni(String numCni) {
        this.numCni = numCni;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
