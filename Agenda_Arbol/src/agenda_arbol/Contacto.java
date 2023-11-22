package agenda_arbol;

import java.util.Scanner;

public class Contacto {
    Scanner sc = new Scanner(System.in);
    public String nom, apat, amat;
    private int edad;
    public String numTel;

    public Contacto() {
        nom = "";
        apat = "";
        amat = "";
        edad = 0;
        numTel = "";
    }

    public Contacto(String nom, String apat, String mat, int edad, String numTel) {
        this.nom = nom;
        this.apat = apat;
        this.amat = mat;
        this.edad = edad;
        this.numTel = numTel;
    }
   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApat() {
        return apat;
    }

    public void setApat(String apat) {
        this.apat = apat;
    }

    public String getAmat() {
        return amat;
    }

    public void setAmat(String mat) {
        this.amat = mat;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    public String imprimirDatos(){
        
        return nom + " "+ apat + " "+amat+" | "+edad+" | " +numTel;
        
    }
    
}
