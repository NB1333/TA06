package test;

import main.RedBlackTree.RedBlackTree;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BalancedTreeTime {

    @Test
    @Order(1)
    void addingTime() {
        RedBlackTree redBlackTree = new RedBlackTree();

        int limit = 10_000;

        long start = System.nanoTime();

        for (int i = 0; i < limit; i++) {
            redBlackTree.insert(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("RBT adding random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        redBlackTree = new RedBlackTree();

        start = System.nanoTime();

        for (int i = 0; i < limit; i++) {
            redBlackTree.insert(i);
        }

        System.out.println("RBT adding consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs\n");
    }

    @Test
    @Order(2)
    void deletingTime() {
        RedBlackTree redBlackTree = new RedBlackTree();
        List<Integer> list = new ArrayList<>();

        int limit = 10_000;

        for (int i = 0; i < limit; i++) {
            list.add(ThreadLocalRandom.current().nextInt());
            redBlackTree.insert(ThreadLocalRandom.current().nextInt());
        }

        long start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            redBlackTree.deleteNode(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("RBT deleting random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        redBlackTree = new RedBlackTree();

        for (int i = 0; i < list.size(); i++) {
            redBlackTree.insert(i);
        }

        start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            redBlackTree.deleteNode(i);
        }

        System.out.println("RBT deleting consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs\n");
    }

    @Test
    @Order(3)
    void searchingTime() {
        RedBlackTree redBlackTree = new RedBlackTree();
        List<Integer> list = new ArrayList<>();

        int limit = 10_000;

        for (int i = 0; i < limit; i++) {
            list.add(i);
            redBlackTree.insert(ThreadLocalRandom.current().nextInt());
        }

        long start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            redBlackTree.searchTree(ThreadLocalRandom.current().nextInt());
        }

        System.out.println("RBT searching random elements time: " + (System.nanoTime() - start) / 1000 + " mcs");

        redBlackTree = new RedBlackTree();

        for (int i = 0; i < limit; i++) {
            redBlackTree.insert(i);
        }

        start = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            redBlackTree.searchTree(i);
        }

        System.out.println("RBT searching consecutive elements time: " + (System.nanoTime() - start) / 1000 + " mcs");
    }
}
