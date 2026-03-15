package Estructuras.ListaCircular.Basado_en_LSE;

import Estructuras.Interfaces.Lista;
import Estructuras.Interfaces.MiIterador;

public class ListaCircularSE<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero;
    protected ElementoSE<T> ultimo; // Mantener el último nos ahorra mucho trabajo
    protected int tamaño;

    public ListaCircularSE() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);

        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            ultimo.siguiente = primero; // Aquí se crea el círculo
        } else {
            // El nuevo se pone después del último
            ultimo.siguiente = nuevo;
            // El nuevo ahora apunta al primero para cerrar el círculo
            nuevo.siguiente = primero;
            // Actualizamos quién es el último
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        if (isEmpty()) return null;

        ElementoSE<T> aux = primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.equals(dato)) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T del(T dato) {
        if (isEmpty()) return null;

        ElementoSE<T> actual = primero;
        ElementoSE<T> anterior = ultimo; // En una circular, el anterior al primero es el último

        for (int i = 0; i < tamaño; i++) {
            if (actual.dato.equals(dato)) {
                if (tamaño == 1) {
                    primero = null;
                    ultimo = null;
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual == primero) primero = actual.siguiente;
                    if (actual == ultimo) ultimo = anterior;
                }
                tamaño--;
                return actual.dato;
            }
            anterior = actual;
            actual = actual.siguiente;
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
        return new IteradorCircularSE<>(primero, tamaño);
    }

    // 1. Vaciar la lista
    @Override
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
        System.out.println("Lista circular vaciada.");
    }

    // 2. Comprobar si existe un dato
    @Override
    public boolean existe(T dato) {
        if (isEmpty()) return false;

        ElementoSE<T> aux = primero;
        // Usamos un for con el tamaño para no dar vueltas infinitas
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
            System.out.println("Error: Posición inválida");
            return null;
        }

        ElementoSE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    // 4. Cambiar el dato en una posición
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No se puede cambiar");
            return;
        }

        ElementoSE<T> aux = primero;
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente;
        }
        aux.dato = nuevoDato;
    }

    // 5. Mostrar la lista (formato circular)
    @Override
    public String mostrarLista() {
        if (isEmpty()) return "Lista circular vacía";

        String resultado = "(Inicio) ";
        ElementoSE<T> aux = primero;

        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + "[" + aux.dato + "]";
            // Siempre ponemos flecha porque el último apunta al primero
            resultado = resultado + " -> ";
            aux = aux.siguiente;
        }
        resultado = resultado + "(vuelve al Inicio)";
        return resultado;
    }
  
}
