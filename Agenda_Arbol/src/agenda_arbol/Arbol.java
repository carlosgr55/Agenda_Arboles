package agenda_arbol;

public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public synchronized void insertarNodo(Contacto valorInsertar) {
        if (raiz == null) {
            raiz = new NodoArbol(valorInsertar); //crea nodo raiz
        } else {
            raiz.insertar(valorInsertar); // llama al metodo insertar
        }
    }

    public synchronized void recorridoPreorden() {
        ayudantePreorden(raiz);
    }

    private synchronized void ayudantePreorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.contacto.imprimirDatos() + "\n"); // mostrar datos del nodo
        ayudantePreorden(nodo.nIzq); //recorre subarbol izquierdo
        ayudantePreorden(nodo.nIzq); //recorre subarbol derecho
    }

    public synchronized void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    //Metodo para ordenar los nombres en orden, es el usado
    private synchronized void ayudanteInorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        ayudanteInorden(nodo.nIzq);
        System.out.print(nodo.contacto.imprimirDatos() + "\n");
        ayudanteInorden(nodo.nDer);
    }

    public void recorridoPosorden() {
        ayudantePosorden(raiz);
    }
//metodo recursivo para recorrido posorden

     public synchronized void ayudantePosorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        ayudantePosorden(nodo.nIzq);
        ayudantePosorden(nodo.nDer);
        System.out.print(nodo.contacto.imprimirDatos() + "\n ");
    }

    private boolean encontrado = false;

    public void busqueda(String nombre) {
        encontrado = false;
        busqueda(nombre, raiz);
        if (!encontrado) {
            System.out.println("No encontrado");
        }
    }

    private void busqueda(String nombre, NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        if (nombre.equalsIgnoreCase(nodo.nom)) {
            encontrado = true;
            System.out.println("Encontrado");
            System.out.println(nodo.contacto.imprimirDatos());
            return;
        } else if (nombre.compareToIgnoreCase(nodo.nom) < 0) {
            bIzq(nombre, nodo);
        } else if (nombre.compareToIgnoreCase(nodo.nom) > 0) {
            bDer(nombre, nodo);
        }
    }

    private void bIzq(String nombre, NodoArbol nodo) {
        NodoArbol noIzq = nodo.nIzq;
        busqueda(nombre, noIzq);
    }

    private void bDer(String nombre, NodoArbol nodo) {
        NodoArbol noDer = nodo.nDer;
        busqueda(nombre, noDer);
    }

    public void eliminar(String nombre) {
        raiz = eliminarNodo(raiz, nombre);
    }

    private NodoArbol eliminarNodo(NodoArbol nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        if (nombre.compareToIgnoreCase(nodo.contacto.getNom()) < 0) {
            nodo.nIzq = eliminarNodo(nodo.nIzq, nombre);
        } else if (nombre.compareToIgnoreCase(nodo.contacto.getNom()) > 0) {
            nodo.nDer = eliminarNodo(nodo.nDer, nombre);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.nIzq == null) {
                return nodo.nDer;
            } else if (nodo.nDer == null) {
                return nodo.nIzq;
            }

            // Nodo con dos hijos: encontrar el sucesor (nodo más pequeño en el subárbol derecho)
            nodo.contacto = encontrarMinimo(nodo.nDer);

            // Eliminar el sucesor
            nodo.nDer = eliminarNodo(nodo.nDer, nodo.contacto.getNom());
        }
        return nodo;
    }

    private Contacto encontrarMinimo(NodoArbol nodo) {
        while (nodo.nIzq != null) {
            nodo = nodo.nIzq;
        }
        return nodo.contacto;
    }

    private NodoArbol buscarNodo(String nombre) {
        return buscarNodo(raiz, nombre);
    }

    private NodoArbol buscarNodo(NodoArbol nodo, String nombre) {
        if (nodo == null || nombre == null) {
            return null;
        }

        if (nombre.equalsIgnoreCase(nodo.contacto.getNom())) {
            return nodo;
        } else if (nombre.compareToIgnoreCase(nodo.contacto.getNom()) < 0) {
            return buscarNodo(nodo.nIzq, nombre);
        } else {
            return buscarNodo(nodo.nDer, nombre);
        }
    }
    
    public void modificar(String nomMod, String nomNuevo){
        NodoArbol nodo = buscarNodo(nomMod);
        Contacto contacto = nodo.contacto;
        contacto.setNom(nomNuevo);
        this.eliminar(nodo.nom);
        this.eliminar(contacto.nom);
        this.insertarNodo(contacto);
    }
}
