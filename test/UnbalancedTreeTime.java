package test;

import main.BST.RecursiveBST;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UnbalancedTreeTime {

    @Test
    @Order(1)
    void addingTime() {
        RecursiveBST<Integer> BSTtree = new RecursiveBST<>();

        int limit = 10_000;

        long start = System.nanoTime();

        for (int i = 0; i < limit; i++) {
            BSTtree.insert(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("BST adding random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        BSTtree = new RecursiveBST<>();

        start = System.nanoTime();

        for (int i = 0; i < limit; i++) {
            BSTtree.insert(i);
        }

        System.out.println("BST adding consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs\n");
    }

    @Test
    @Order(2)
    void deletingTime() {
        RecursiveBST<Integer> BSTtree = new RecursiveBST<>();
        List<Integer> list = new ArrayList<>();

        int limit = 10_000;

        for (int i = 0; i < limit; i++) {
            list.add(ThreadLocalRandom.current().nextInt());
            BSTtree.insert(ThreadLocalRandom.current().nextInt());
        }

        long start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            BSTtree.delete(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("BST deleting random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        BSTtree = new RecursiveBST<>();

        for (int i = 0; i < list.size(); i++) {
            BSTtree.insert(i);
        }

        start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            BSTtree.delete(i);
        }

        System.out.println("BST deleting consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs\n");
    }

    @Test
    @Order(3)
    void searchingTime() {
        RecursiveBST<Integer> BSTtree = new RecursiveBST<>();
        List<Integer> list = new ArrayList<>();

        int limit = 10_000;

        for (int i = 0; i < limit; i++) {
            list.add(i);
            BSTtree.insert(ThreadLocalRandom.current().nextInt());
        }

        long start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            BSTtree.contains(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("BST searching random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        BSTtree = new RecursiveBST<>();

        for (int i = 0; i < limit; i++) {
            BSTtree.insert(i);
        }

        start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            BSTtree.contains(i);
        }

        System.out.println("BST searching consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs");
    }
}
