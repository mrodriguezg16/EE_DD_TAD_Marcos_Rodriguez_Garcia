package Estructuras.LSE;

import Estructuras.Interfaces.MiIterador;
//Clase iterador para poder recorrer nuestra lista.
public class IteradorLSE<T> implements MiIterador<T> {
    private ElementoSE<T> actual;

    // El constructor recibe el comienzo de la lista
    public IteradorLSE(ElementoSE<T> comienzo) {
        this.actual = comienzo;
    }
//Detecta si hay un siguiente elemento
    @Override
    public boolean hasNext() {
        return actual != null;
    }
//Si hay siguiente, devuelve por pantalla el elemento, salta al siguiente, y si detecta otro siguiente repite el ciclo hasta recorrer la lista entera
//(y no queden mas elementos siguientes)
    @Override
    public T next() {
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}
