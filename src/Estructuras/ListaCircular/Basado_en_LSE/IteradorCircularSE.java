package Estructuras.ListaCircular;

import Estructuras.Interfaces.MiIterador;

public class IteradorCircularSE<T> implements MiIterador<T> {
    private ElementoSE<T> actual;
    private int contador = 0;
    private int total;

    public IteradorCircularSE(ElementoSE<T> inicio, int total) {
        this.actual = inicio;
        this.total = total;
    }

    @Override
    public boolean hasNext() {
        return contador < total;
    }

    @Override
    public T next() {
        T valor = actual.dato;
        actual = actual.siguiente;
        contador++;
        return valor;
    }
}
