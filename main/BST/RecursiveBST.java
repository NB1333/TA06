package main.BST;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBST<T extends Comparable<T>> implements IBST<T> {
    private Node<T> root;
    private int size;

    @SafeVarargs
    public static <T extends Comparable<T>> RecursiveBST<T> of(T... elements) {
        RecursiveBST<T> binarySearchTree = new RecursiveBST<>();
        Stream.of(elements).forEach(binarySearchTree::insert);
        return binarySearchTree;
    }

    @Override
    public void insert(T element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
        } else {
            insert(root, element);
        }
    }

    @Override
    public void delete(T element) {
        deleteElement(root, element);
    }

    public Node<T> deleteElement(Node<T> root, T element) {
        if (root == null) return null;
        if (element.compareTo(root.element) < 0) {
            root.left = deleteElement(root.left, element);
        } else if (element.compareTo(root.element) > 0) {
            root.right = deleteElement(root.right, element);
        } else {
            if (root.left == null) {
                Node<T> node = root.right;
                if (this.root.equals(root)) this.root = node;
                return node;
            } else if (root.right == null) {
                Node<T> node = root.left;
                if (this.root.equals(root)) this.root = node;
                return node;
            }
            root.element = getMinValue(root.right);
            root.right = deleteElement(root.right, root.element);
        }
        return root;
    }

    private T getMinValue(Node<T> root) {
        T minimum = root.element;
        while (root.left != null) {
            minimum = root.left.element;
            root = root.left;
        }
        return minimum;
    }

    private boolean insert(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) {
            if (current.left == null) {
                current.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.left, element);
            }
        } else if (element.compareTo(current.element) > 0) {
            if (current.right == null) {
                current.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.right, element);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node<T> current, T element) {
        if (current == null) {
            return false;

        } else if (element.compareTo(current.element) < 0) {
            return contains(current.left, element);

        } else if (element.compareTo(current.element) > 0) {
            return contains(current.right, element);

        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return root != null ? depth(root) - 1 : 0;
    }

    private int depth(Node<T> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(current.left), depth(current.right));
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<T> current, Consumer<T> consumer) {
        if (current != null) {
            inOrderTraversal(current.left, consumer);
            consumer.accept(current.element);
            inOrderTraversal(current.right, consumer);
        }
    }

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }
    }
}

