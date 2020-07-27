package org.example;

import java.util.HashSet;
import java.util.Set;

public class SumTask {

    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask = new SumTask();
        int[] inputArray = new int[] {3,4,5,5,8};

        Set<Integer> uniqueSumList = sumTask.getSum(inputArray);
        for (Integer n : uniqueSumList) {
            System.out.println(n);
        }
    }


    public Set<Integer> getSum(final int[] digits) {
        Set<Integer> uniqueSum = new HashSet<>();
        final int digitsLength = digits.length;
        for (int i = 0; i < digitsLength-1; i++) {
            for (int k = i+1; k < digitsLength; k++) {
                uniqueSum.add(digits[i]+digits[k]);
            }
        }

        return uniqueSum;
    }
}

/*
3,4,5,5,8

3+4=7
3+5=8
3+5=8
3+8=11

4+5=9
4+5=9
4+8=12

5+5=10
5+8=13

5+8=13

*/
