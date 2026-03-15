package Estructuras.LDE;

public class ElementoDE<T> {
    T dato;
    ElementoDE<T> siguiente;
    ElementoDE<T> anterior; // Nuevo componente para la lista doble

    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
