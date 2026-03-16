package Estructuras.LDE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;
//Diseño modular: En este planteamiento, hemos decidido plantear los TAD de modo que se pueda reutilizar el código de forma optima
// Para ello, hemos establecido interfaces para las listas y el iterador, así como la clase Elemento en todos los TAD de forma que todos ellos
// la usan, cabe destacar que hemos creado 2 clases elemento: una correspondiente con
//los elementos simplemente enlazados, y otra con los doblemente enlazados (Las pilas y colas tambien usan esas clases).
public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;
//constructor vacío
    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;//pasa a ser un nuevo (y único) elemento de la lista.
        } else {
            // Al ser doble, conectamos el nuevo con el último actual en ambos sentidos
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamaño++;//podemos añadir indefinidamente objetos, aumenta de tamaño con cada adición.
    }
//Getter
    @Override
    public T get(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }
//Método que nos permite borrar elementos de la lista
    @Override
    public T del(T dato) {
        if (isEmpty()) return null;//si está vacío, queda vacío.
        ElementoDE<T> aux = primero;

        while (aux != null) {
            if (aux.dato.equals(dato)) {
                // Si es el primero
                if (aux == primero) {
                    primero = primero.siguiente;
                    if (primero != null) primero.anterior = null;
                    else ultimo = null;
                }
                // Si es el último
                else if (aux == ultimo) {
                    ultimo = ultimo.anterior;
                    ultimo.siguiente = null;
                }
                // Si está en medio
                else {
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;
                }
                tamaño--;//Disminuye su tamaño
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }
//Método que detecta si la lista está vacía.
    @Override
    public boolean isEmpty() { return primero == null; }
//Método que nos permite ver su tamaño.
    @Override
    public int getSize() { return tamaño; }
//Método que nos permite iterar nuestra lista
    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLDE<>(primero);
    }

    // Método que permite vaciar la lista
    @Override
    public void vaciar() {
        // En una LDE es importante poner ambos a null
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
        System.out.println("Lista doble vaciada.");
    }

    // Método que permite comprobar si existe un dato en nuestra lista
    @Override
    public boolean existe(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    // Método que permite obtener el dato en una posición (0, 1, 2...)
    @Override
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Posición fuera de los límites");
            return null;
        }

        ElementoDE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    // Método que permite cambiar el dato en una posición específica
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No se puede cambiar esa posición");
            return;
        }

        ElementoDE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        aux.dato = nuevoDato;
    }

    //Método que permite mostrar la lista (con flechas dobles para que se note que es LDE)
    @Override
    public String mostrarLista() {
        if (isEmpty()) return "Lista doble vacía";

        String resultado = "null <-> ";
        ElementoDE<T> aux = primero;
        while (aux != null) {
            resultado = resultado + aux.dato;
            if (aux.siguiente != null) {
                resultado = resultado + " <=> ";
            }
            aux = aux.siguiente;
        }
        resultado = resultado;
        return resultado;
    }
//Devuelve la lista del revés, mostrando el final como el inicio y el inicio como el final
    public String mostrarAlReves() {
        if (isEmpty()) return "Vacía";
        String resultado = "Al revés: ";
        ElementoDE<T> aux = ultimo; // Empezamos por el final
        while (aux != null) {
            resultado = resultado + aux.dato;
            if (aux.anterior != null) {
                resultado = resultado + " <=> ";
            }
            aux = aux.anterior; // Vamos hacia atrás
        }
        return resultado;
    }
}
