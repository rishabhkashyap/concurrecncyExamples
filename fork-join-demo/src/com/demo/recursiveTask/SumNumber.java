package com.demo.recursiveTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

//Find sum of all number in a array using fork join framework
public class SumNumber {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 11).toArray();
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
        System.out.println("\nRegular array sum = " + Arrays.stream(arr).sum());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AdditionTask additionTask = new AdditionTask(arr);
        System.out.println("Fork join sum of array = " + forkJoinPool.invoke(additionTask));

    }
}

class AdditionTask extends RecursiveTask<Integer> {
    private int[] arr;

    public AdditionTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length <= 2) {
            return Arrays.stream(arr).sum();
        }
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        AdditionTask additionTaskLeft = new AdditionTask(leftArr);
        AdditionTask additionTaskRight = new AdditionTask(rightArr);
        additionTaskLeft.fork();
        /**
         * Do not invoke join on both left and right tasks.Invoke fork on one task so that it
         * can use new thread to complete computation and invoke compute on other task so that it
         * can complete computation in current task.This way less threads are created.
         * */
        int rightSum = additionTaskRight.compute();
        int leftSum = additionTaskLeft.join();
        return leftSum + rightSum;
    }
}
