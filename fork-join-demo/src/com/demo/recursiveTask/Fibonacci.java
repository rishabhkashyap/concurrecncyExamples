package com.demo.recursiveTask;
//Calculate nth fibonacci number using RecursiveTask and fork join pool
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int n = 6;
        FibonacciTask fibonacciTask = new FibonacciTask(n);
        System.out.println(n + "th fibonacci number = " + forkJoinPool.invoke(fibonacciTask));

    }
}

class FibonacciTask extends RecursiveTask<Integer> {
    private int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        FibonacciTask task1 = new FibonacciTask(n - 1);
        FibonacciTask task2 = new FibonacciTask(n - 2);
        task1.fork();
        return task1.join() + task2.compute();
    }
}
