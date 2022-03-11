package com.demo.recursiveActions;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RecursiveActionDemo {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 11).toArray();
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n**************************************************\n");
        Action action = new Action(arr);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(action);
    }
}

class Action extends RecursiveAction {
    private int[] arr;

    public Action(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected void compute() {
        if (arr.length <= 2) {
            Arrays.stream(arr).map(e -> 2 * e)
                    .forEach(e -> System.out.print(e + "\t"));
            return;
        }
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        Action leftAction = new Action(leftArr);
        Action rightAction = new Action(rightArr);
        invokeAll(leftAction, rightAction);

    }
}
