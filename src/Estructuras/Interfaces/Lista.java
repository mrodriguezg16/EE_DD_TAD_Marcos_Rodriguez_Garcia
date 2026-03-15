package Estructuras.Interfaces;

// Interfaz para la Lista de todos los TAD
public interface Lista<T extends Comparable<T>> {
    void add(T dato);
    T get(T dato);
    T del(T dato);
    boolean isEmpty();
    int getSize();
    MiIterador<T> getIterador();

    // Los extras para subir nota (fáciles de leer)
    void vaciar();
    boolean existe(T dato);
    T obtenerPorPosicion(int puesto);
    void cambiarEnPosicion(int puesto, T nuevoDato);
    String mostrarLista(); // Un toString pero con nombre más sencillo
}

