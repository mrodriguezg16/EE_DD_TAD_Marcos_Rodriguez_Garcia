package Estructuras.LDE;

public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
//Debemos desarrollar un método add que respete el orden propio de este tipo de estructura.
    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);

        if (isEmpty()) {
            primero = ultimo = nuevo;//Si está vacío (null), lo añadimos al final
        }
        // Caso: insertar al principio (el dato es menor que el primero)
        else if (dato.compareTo(primero.dato) < 0) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo; //al ser menor que el elemento dato, desplazamos el elemento dato como siguiente y el nuevo pasa a ser el anterior.
        }                    //Es decir, queda atras del elemento dato.
        // Caso: insertar al final (el dato es mayor o igual que el último)
        else if (dato.compareTo(ultimo.dato) >= 0) {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;//Caso contrario al metodo de arriba, aqui dato pasa a ser el anterior y el nuevo pasa a ser el siguiente (por ser mayor que dato).
        }
        // Caso: insertar en medio
        else {
            ElementoDE<T> aux = primero;
            while (aux != null && dato.compareTo(aux.dato) > 0) {
                aux = aux.siguiente;
            }
            // Insertamos antes de 'aux'
            nuevo.siguiente = aux;
            nuevo.anterior = aux.anterior;//los nuevos anteriores (elemnetos menores que dato).
            aux.anterior.siguiente = nuevo;
            aux.anterior = nuevo;//De este modo hemos desplazado los elementos menores que dato y los hemos reclasificado como anteriores.
        }
        tamaño++;
    }
}
