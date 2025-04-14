package com.test.lld.dsaquestion;

import java.util.Arrays;

public class ShuffleArray {

    public static int[] shuffle(int[] arr) {
        int n = arr.length / 2;
        int[] result = new int[arr.length];

        for (int i = 0; i < n; i++) {
            result[2 * i] = arr[i];       // A[i]
            result[2 * i + 1] = arr[i + n]; // B[i]
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] output = shuffle(input);

        System.out.println("Shuffled: " + Arrays.toString(output));
        // Output: Shuffled: [1, 4, 2, 5, 3, 6]
    }
}
