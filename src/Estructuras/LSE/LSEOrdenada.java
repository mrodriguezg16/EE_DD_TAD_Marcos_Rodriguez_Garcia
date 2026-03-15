package Estructuras.LSE;

public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T> {

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);

        // Caso 1: Lista vacía o el dato es menor que el primero
        if (isEmpty() || dato.compareTo(primero.dato) < 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        }
        // Caso 2: Buscar su posición en medio o al final
        else {
            ElementoSE<T> ant = primero;
            ElementoSE<T> act = primero.siguiente;

            while (act != null && dato.compareTo(act.dato) > 0) {
                ant = act;
                act = act.siguiente;
            }
            nuevo.siguiente = act;
            ant.siguiente = nuevo;
        }
        tamaño++;
    }
}
