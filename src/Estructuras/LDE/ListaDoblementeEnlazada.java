package Estructuras.LDE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;

public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;

    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else {
            // Al ser doble, conectamos el nuevo con el último actual en ambos sentidos
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T del(T dato) {
        if (isEmpty()) return null;
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
                tamaño--;
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public boolean isEmpty() { return primero == null; }

    @Override
    public int getSize() { return tamaño; }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLDE<>(primero);
    }

    // 1. Vaciar la lista
    @Override
    public void vaciar() {
        // En una LDE es importante poner ambos a null
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
        System.out.println("Lista doble vaciada.");
    }

    // 2. Comprobar si existe un dato
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

    // 3. Obtener el dato en una posición (0, 1, 2...)
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

    // 4. Cambiar el dato en una posición específica
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

    // 5. Mostrar la lista (con flechas dobles para que se note que es LDE)
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
        resultado = resultado + " -> null";
        return resultado;
    }

    public String mostrarAlReves() {
        if (isEmpty()) return "Vacía";
        String resultado = "Al revés: null <- ";
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
