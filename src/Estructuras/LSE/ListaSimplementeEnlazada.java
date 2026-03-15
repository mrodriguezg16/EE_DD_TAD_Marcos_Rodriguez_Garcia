package Estructuras.LSE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;

public class ListaSimplementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero; // El símbolo rombo (◊) es protected
    protected int tamaño;

    public ListaSimplementeEnlazada() {
        this.primero = null;
        this.tamaño = 0;
    }

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            ElementoSE<T> aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        ElementoSE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T del(T dato) {
        // Lógica sencilla de borrado
        if (isEmpty()) return null;
        if (primero.dato.equals(dato)) {
            T valor = primero.dato;
            primero = primero.siguiente;
            tamaño--;
            return valor;
        }
        // ... búsqueda y borrado del nodo intermedio ...
        return null;
    }

    @Override
    public boolean isEmpty() { return primero == null; }

    @Override
    public int getSize() { return tamaño; }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLSE<>(primero);
    }

    // Borra todo de golpe
    @Override
    public void vaciar() {
        this.primero = null;
        this.tamaño = 0;
        System.out.println("La lista se ha vaciado.");
    }

    // Dice si un dato está o no
    @Override
    public boolean existe(T dato) {
        ElementoSE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return true; // ¡Lo encontramos!
            }
            aux = aux.siguiente;
        }
        return false; // Si llega aquí, es que no estaba
    }

    // Busca por el número de la "cajita" (0, 1, 2...)
    @Override
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Esa posición no existe");
            return null;
        }

        ElementoSE<T> aux = primero;
        // Caminamos por la lista tantas veces como diga el puesto
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    // Cambia el dato de una cajita específica
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No puedo cambiar nada ahí");
            return;
        }

        ElementoSE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        aux.dato = nuevoDato; // Sobreescribimos el dato viejo
    }

    // Crea un texto para imprimir la lista en consola
    @Override
    public String mostrarLista() {
        if (isEmpty()) {
            return "Lista vacía";
        }

        String resultado = "Elementos: ";
        ElementoSE<T> aux = primero;

        while (aux != null) {
            resultado = resultado + aux.dato; // Vamos sumando el texto
            if (aux.siguiente != null) {
                resultado = resultado + " -> ";
            }
            aux = aux.siguiente;
        }
        return resultado;
    }
}
