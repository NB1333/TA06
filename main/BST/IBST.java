package main.BST;

import java.util.function.Consumer;

public interface IBST<T extends Comparable<T>> {
    void insert(T element);
    void delete(T element);

    boolean contains(T element);

    int size();

    int depth();

    void inOrderTraversal(Consumer<T> consumer);
}
