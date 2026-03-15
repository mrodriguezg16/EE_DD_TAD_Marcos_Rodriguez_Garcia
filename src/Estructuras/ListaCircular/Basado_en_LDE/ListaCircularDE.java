package Estructuras.ListaCircular.Basado_en_LDE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;

public class ListaCircularDE<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;

    public ListaCircularDE() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);

        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            // El círculo: se apuntan a sí mismos
            primero.siguiente = primero;
            primero.anterior = primero;
        } else {
            // Conectamos el nuevo entre el último y el primero
            nuevo.anterior = ultimo;
            nuevo.siguiente = primero;

            ultimo.siguiente = nuevo;
            primero.anterior = nuevo;

            // Ahora el nuevo es el último
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        if (isEmpty()) return null;

        ElementoDE<T> aux = primero;
        int cont = 0;
        // Recorremos solo una vuelta (hasta el tamaño de la lista)
        while (cont < tamaño) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
            cont++;
        }
        return null;
    }

    @Override
    public T del(T dato) {
        if (isEmpty()) return null;

        ElementoDE<T> aux = primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.equals(dato)) {
                if (tamaño == 1) {
                    primero = ultimo = null;
                } else {
                    // Saltamos el nodo aux
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;

                    if (aux == primero) primero = aux.siguiente;
                    if (aux == ultimo) ultimo = aux.anterior;
                }
                tamaño--;
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public int getSize() {
        return tamaño;
    }

    @Override
    public MiIterador<T> getIterador() {
        // Usamos un iterador especial para no entrar en bucle infinito
        return new IteradorCircular<>(primero, tamaño);
    }

    // 1. Vaciar la lista
    @Override
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
        System.out.println("Lista circular doble vaciada.");
    }

    // 2. Comprobar si existe un dato (recorrido circular)
    @Override
    public boolean existe(T dato) {
        if (isEmpty()) return false;

        ElementoDE<T> aux = primero;
        // Usamos el tamaño para saber cuándo parar
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.equals(dato)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    // 3. Obtener el dato en una posición
    @Override
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No existe esa posición.");
            return null;
        }

        ElementoDE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    // 4. Cambiar el dato en una posición
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Índice fuera de rango.");
            return;
        }

        ElementoDE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        aux.dato = nuevoDato;
    }

    // 5. Mostrar la lista (con estilo circular doble)
    @Override
    public String mostrarLista() {
        if (isEmpty()) return "Lista circular doble vacía";

        String resultado = "(Infinito) <-> ";
        ElementoDE<T> aux = primero;

        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + "[" + aux.dato + "]";
            // En una circular doble, siempre hay conexión doble
            resultado = resultado + " <=> ";
            aux = aux.siguiente;
        }
        resultado = resultado + "(Infinito)";
        return resultado;
    }
  
}
