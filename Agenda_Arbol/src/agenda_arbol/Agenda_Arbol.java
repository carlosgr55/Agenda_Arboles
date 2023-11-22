package agenda_arbol;

import java.util.Scanner;

public class Agenda_Arbol {

    public static Arbol arbol = new Arbol();
    public static Scanner sc = new Scanner(System.in);
    public static NodoArbol nodo = new NodoArbol();

    public static void main(String[] args) {
        // TODO code application logic here
        Contacto con1 = new Contacto("Rosalia", "Vita", "tobello", 30, "6141111111");
        Contacto con2 = new Contacto("Shakira", "Mebarak", "Ribol", 45, "6145472304");
        Contacto con3 = new Contacto("Alejandra", "Pizarnik", "Flora", 36, "6147582938");
        Contacto con4 = new Contacto("Beyonce", "Knowles", "Carter", 42, "6147895620");
        Contacto con5 = new Contacto("Ethel", "Cain", "Ptolemaea", 98, "6140000000");
        Contacto con6 = new Contacto("Rocio", "Durcal", "Aguirre", 98, "6140561000");

        arbol.insertarNodo(con2);
        arbol.insertarNodo(con1);
        arbol.insertarNodo(con3);
        arbol.insertarNodo(con4);
        arbol.insertarNodo(con6);
        arbol.insertarNodo(con5);

        Menu();
        
    }

    public static void Menu() {
        int op;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1) Insertar contactos");
            System.out.println("2) Modificar contacto");
            System.out.println("3) Mostrar contactos");
            System.out.println("4) Buscar contacto");
            System.out.println("5) Eliminar contacto");
            System.out.println("6) Salir");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1 ->
                    addCon();
                case 2 ->
                    modificarCon();
                case 3 ->
                    mostrarContactos();
                case 4 ->
                    buscar();
                case 5 ->
                    eliminarContacto();
            }
        } while (op != 6);
    }

    public static void addCon() {
        int op;
        System.out.println("Ingresa un contacto, presiona 0 al terminar");
        do {
            Contacto c = nodo.crearContacto();
            arbol.insertarNodo(c);
            System.out.println("Deseas añadir otro?");
            op = sc.nextInt();
        } while (op != 0);
    }

    public static void modificarCon() {
        System.out.println("Ingresa el nombre a modificar");
        String nombreaModificar = sc.nextLine();
        System.out.println("Ingresa el nuevo nombre");
        String nuevo = sc.nextLine();
        arbol.modificar(nombreaModificar, nuevo);
    }

    public static void mostrarContactos() {
        arbol.recorridoInorden();
    }

    public static void buscar() {
        System.out.println("Ingrese el nombre a buscar");
        String nombre = sc.nextLine();
        arbol.busqueda(nombre);
    }

    public static void eliminarContacto() {
        System.out.println("Ingrese el nombre a eliminar");
        String nombre = sc.nextLine();
        arbol.eliminar(nombre);
        arbol.recorridoInorden();
    }

}
