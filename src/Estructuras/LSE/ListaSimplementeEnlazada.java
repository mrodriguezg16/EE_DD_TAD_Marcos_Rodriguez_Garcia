package Estructuras.LSE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;
//Diseño modular: En este planteamiento, hemos decidido plantear los TAD de modo que se pueda reutilizar el código de forma optima
// Para ello, hemos establecido interfaces para las listas y el iterador, así como la clase Elemento en todos los TAD de forma que todos ellos
// la usan, cabe destacar que hemos creado 2 clases elemento: una correspondiente con
//los elementos simplemente enlazados, y otra con los doblemente enlazados (Las pilas y colas tambien usan esas clases).
public class ListaSimplementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero; // El símbolo rombo (◊) es protected
    protected int tamaño;
//Constructor de lista vacía
    public ListaSimplementeEnlazada() {
        this.primero = null;
        this.tamaño = 0;
    }
//Método que permite añadir a la lista un elemento.
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
        tamaño++;//Aumenta el tamaño siempre que añadimos un nuevo elemento.
    }
//Getter
    @Override
    public T get(T dato) {
        ElementoSE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }
//Método para eliminar elementos de la lista.
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
//Método que analiza si la lista está vacía
    @Override
    public boolean isEmpty() { return primero == null; }
//Método que devuelve el tamaño de la lista
    @Override
    public int getSize() { return tamaño; }
//Método que nos permite recorrer la lista
    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLSE<>(primero);
    }

    //Método que borra todo de golpe
    @Override
    public void vaciar() {
        this.primero = null;
        this.tamaño = 0;
        System.out.println("La lista se ha vaciado.");
    }

    //Método que dice si un dato está o no
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

    //Método que busca por el número de la posición (0, 1, 2...)
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

    //Método que cambia el dato de una posición a otra
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

    //Método que muestra un texto para imprimir la lista en consola
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
