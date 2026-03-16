package Estructuras.LDE;

import Estructuras.Interfaces.MiIterador;

public class IteradorLDE<T> implements MiIterador<T> {
    private ElementoDE<T> actual;
//Empezamos a recorrer la lista desde un inicio.
    public IteradorLDE(ElementoDE<T> comienzo) {
        this.actual = comienzo;
    }
//Si tiene siguiente y este no es nulo, devuelve el elemento en cuestion
    @Override
    public boolean hasNext() {
        return actual != null;
    }
//Función que nos permite recorrer toda la lista elemento a elemento, marcando el elemento siguiente.
    @Override
    public T next() {
        T valor = actual.dato;
        actual = actual.siguiente;//apuntamos al siguiente elemento de la lista
        return valor;//Este valor vuelve al método hasNext y si hay siguiente imprime el siguiente y se selecciona el elemento sucedaneo al siguiente.
    }
}
