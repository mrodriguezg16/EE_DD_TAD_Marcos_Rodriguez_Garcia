package Estructuras.LDE;
//Esta superclase, es empleada en todos los TAD 
public class ElementoDE<T> {
    T dato;
    ElementoDE<T> siguiente;//nos permite establecer una correlación con el siguiente elemento.
    ElementoDE<T> anterior; // Nuevo componente para la lista doble, permite relacionar nuestro elemento con otro anterior a este.
//Al inicio, solo disponemos en nuestra lista de 1 elemento, por ende, siguiente y anterior son nulos por defecto.
    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null;//En el inicio no apunta a un elemento siguiente, solo hay 1
        this.anterior = null;//En el inicio no hay un elemento anterior,solo hay uno
    }
}
