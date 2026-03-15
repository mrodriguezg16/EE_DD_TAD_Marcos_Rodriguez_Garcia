package Estructuras.LDE;

import Estructuras.Interfaces.MiIterador;

public class IteradorLDE<T> implements MiIterador<T> {
    private ElementoDE<T> actual;

    public IteradorLDE(ElementoDE<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T valor = actual.dato;
        actual = actual.siguiente;
        return valor;
    }
}
