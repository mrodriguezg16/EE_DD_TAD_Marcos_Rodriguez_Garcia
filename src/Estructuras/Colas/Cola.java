package Estructuras;
//Como digimos en los otros modelos modulares, la clase cola implementa la superclase ElementoDE de las listas doblemente enlazadas
//De forma que el código se reutiliza en esta interpretación de los TAD.
public class Cola<T> {
    // Usamos los nodos de la Lista Doble
    private ElementoDE<T> frente; // El primero de la cola
    private ElementoDE<T> fin;    // El último de la cola
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    // Método ENQUEUE: Insertar al final
    public void enqueue(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            // Conectamos el nuevo nodo al final
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            // El nuevo nodo ahora es el fin
            fin = nuevo;
        }
        tamaño++;
    }

    // Método DEQUEUE: Quitar del frente y devolver el dato
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T valor = frente.dato;
        frente = frente.siguiente; // El segundo pasa a ser el primero

        if (frente != null) {
            frente.anterior = null; // Limpiamos el enlace al nodo que salió
        } else {
            fin = null; // Si la cola quedó vacía, el fin también es null
        }

        tamaño--;
        return valor;
    }

    // Método FRONT: Ver el primer elemento sin sacarlo
    public T front() {
        if (isEmpty()) return null;
        return frente.dato;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int getSize() {
        return tamaño;
    }
}
