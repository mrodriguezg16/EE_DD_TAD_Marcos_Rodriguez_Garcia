package Estructuras.LSE;

public class ElementoSE<T> {
    public T dato;           //El dato que vamos a introducir.
    public ElementoSE<T> siguiente; // El enlace al próximo nodo (El puntero por asi decirlo).

    // Constructor sencillo
    public ElementoSE(T valor) {
        this.dato = valor; //Cabeza de nuestra lista.
        this.siguiente = null; //Al principio, como solo hay 1 elemento, nuestro puntero no apunta a nadie,
    }                          // no hay un siguiente elemento (null).
}
