package Estructuras.ListaCircular.Basado_en_LDE;

import Estructuras.Interfaces.MiIterador;

public class IteradorCircular<T> implements MiIterador<T> {
    private ElementoDE<T> actual;
    private int elementosVisitados;
    private int total;

    public IteradorCircular(ElementoDE<T> comienzo, int total) {
        this.actual = comienzo;
        this.total = total;
        this.elementosVisitados = 0;
    }

    @Override
    public boolean hasNext() {
        return elementosVisitados < total;
    }

    @Override
    public T next() {
        T valor = actual.dato;
        actual = actual.siguiente;
        elementosVisitados++;
        return valor;
    }
}
