package agenda_arbol;

import java.util.Scanner;

public class NodoArbol {
    Scanner sc = new Scanner(System.in);
    Contacto contacto;
    String nom;
    NodoArbol nIzq, nDer;

    public NodoArbol(Contacto contacto) {
        this.contacto = contacto;
        nom = this.contacto.nom;
        nIzq = nDer = null;
    }
    
    public NodoArbol(){
        this.contacto = null;
        nIzq = nDer = null;
        nom = "";
    }

    public void insertar(Contacto contacto) {
        if (contacto.nom.compareToIgnoreCase(this.nom) < 0) {
            if (nIzq == null) {
                nIzq = new NodoArbol(contacto);
            } else {
                nIzq.insertar(contacto);
            }
        } else if (contacto.nom.compareToIgnoreCase(this.nom) > 0) {
            if (nDer == null) {
                nDer = new NodoArbol(contacto);
            } else {
                nDer.insertar(contacto);
            }
        }
    }

    public Contacto crearContacto() {
        Contacto contact;
        System.out.println("Nombre");
        String nom = sc.nextLine();
        System.out.println("Apellido paterno");
        String apat = sc.nextLine();
        System.out.println("Apellido materno");
        String amat = sc.nextLine();
        System.out.println("Edad");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Número de telefono");
        String num = sc.nextLine();
        contact = new Contacto(nom, apat, amat, edad, num);
        return contact;
    }
}
