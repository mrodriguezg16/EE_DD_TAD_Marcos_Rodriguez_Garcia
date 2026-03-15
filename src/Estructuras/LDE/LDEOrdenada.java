package Estructuras.LDE;

public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {

    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);

        if (isEmpty()) {
            primero = ultimo = nuevo;
        }
        // Caso: insertar al principio (el dato es menor que el primero)
        else if (dato.compareTo(primero.dato) < 0) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        // Caso: insertar al final (el dato es mayor o igual que el último)
        else if (dato.compareTo(ultimo.dato) >= 0) {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        // Caso: insertar en medio
        else {
            ElementoDE<T> aux = primero;
            while (aux != null && dato.compareTo(aux.dato) > 0) {
                aux = aux.siguiente;
            }
            // Insertamos antes de 'aux'
            nuevo.siguiente = aux;
            nuevo.anterior = aux.anterior;
            aux.anterior.siguiente = nuevo;
            aux.anterior = nuevo;
        }
        tamaño++;
    }
}
