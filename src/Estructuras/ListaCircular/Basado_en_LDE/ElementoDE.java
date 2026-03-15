package Estructuras.ListaCircular;

public class ElementoDE<T> { //Reutilizamos el nodo de las listas doblemente enlazadas.
    T dato;
    ElementoDE<T> siguiente;
    ElementoDE<T> anterior; // Nuevo componente para la lista doble

    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
