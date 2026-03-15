package Estructuras.Pila;

public class Pila<T> {
    // El "tope" es simplemente el "primero" de una lista simple
    private ElementoSE<T> tope;
    private int tamaño;

    public Pila() {
        this.tope = null;
        this.tamaño = 0;
    }

    // Método PUSH: Equivale a un addAlPrincipio
    public void push(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        if (tope != null) {
            nuevo.siguiente = tope;
        }
        tope = nuevo;
        tamaño++;
    }

    // Método POP: Quita el elemento del tope y lo devuelve
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T valor = tope.dato;
        tope = tope.siguiente; // El nuevo tope es el que estaba debajo
        tamaño--;
        return valor;
    }

    // Método PEEK: Mira qué hay en el tope sin quitarlo
    public T peek() {
        if (isEmpty()) return null;
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int getSize() {
        return tamaño;
    }
}
