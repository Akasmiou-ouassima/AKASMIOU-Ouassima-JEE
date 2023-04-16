package org.sid.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;
//JaxB c'est une API c'est une librairie qui permet de faire ce qu'on appelle le mapping objet xml

@XmlRootElement(name = "compte")  // un objet compte, quand je le convertis en XML il va me donner un élément XML qui s'appelle compte
@XmlAccessorType(XmlAccessType.FIELD)
// vous dites que les annotations JaxB je voudrais les mettre sur les champs et non pas sur les getters parce que par
// défaut c'est des annotations qu'il faut mettre sur les setters et getters
public class Compte {
    private int code;

    private double solde;
    @XmlTransient //c'est une annotation de JaxB
    private Date DateCreation;

    public Compte() {
    }

    public Compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        DateCreation = dateCreation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

}
