package main;

import main.RedBlackTree.RedBlackTree;
import main.BST.IBST;
import main.BST.RecursiveBST;

public class Main {

    public static void main(String[] args) {
        IBST<Integer> binarySearchTree =
                RecursiveBST.of(1, 12, 5, 9, 18, 4, 2, 13, 11, 20, 19, 22, 7, 9, 6);

        binarySearchTree.delete(5);

        System.out.println("This is recursive unbalanced tree:");

        binarySearchTree.inOrderTraversal(System.out::println);

        System.out.println("Depth: " + binarySearchTree.depth());

        RedBlackTree balancedTree = new RedBlackTree();
        balancedTree.insert(3);
        balancedTree.insert(32);
        balancedTree.insert(1);
        balancedTree.insert(64);
        balancedTree.insert(51);
        balancedTree.insert(59);
        balancedTree.insert(13);

        System.out.println("\nThe next is balanced tree (Red-Black tree)\nBefore deleting:");

        balancedTree.printTree();

        balancedTree.deleteNode(1);

        System.out.println("\nAfter deleting:");

        balancedTree.printTree();

    }
}
