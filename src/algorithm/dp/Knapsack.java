package algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qun.chen on 11/5/17.
 * 1. create a matrix number of item +1  * total weight +1
 * 2. initial first column and row to 0
 * 3. if weight is enough, find the max between with this item (A[i-1]+memory[i-1][j-A[i-1]],this item value+last one before adding the weight)
 * or without this item (memory[i-1][j], current value)
 * Time: O(a*w)
 * Space: O(a*w)
 */
public class Knapsack {

    /**
     * O(a*w)
     * @param W
     * @param A
     * @param sequences
     * @return
     */
    public static int getSequenceDP(int W, int[] A, Set<Integer> sequences) {
        int[][] memory = new int[A.length + 1][W + 1];

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < A[i - 1]) {
                    memory[i][j] = memory[i - 1][j];
                } else {
                    memory[i][j] = Math.max(A[i - 1] + memory[i - 1][j - A[i - 1]], memory[i - 1][j]);
                }
            }
        }

        int j=W;
        for (int i = A.length; i >0; i--) {
            if (memory[i][j] > memory[i - 1][j]) {
                sequences.add(i-1);
                j-=A[i-1];
            }
        }

        return memory[A.length][W];
    }

    public static int getSequence(int W, int[] A, int n, Set<Integer> sequences) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (A[n - 1] > W) {
            return getSequence(W, A, n - 1, sequences);
        } else {
            int sumAdd = getSequence(W - A[n - 1], A, n - 1, sequences) + A[n - 1];
            int sumNotAdd = getSequence(W, A, n - 1, sequences);

            if (sumAdd > sumNotAdd) {
                return sumAdd;
            } else {
                return sumNotAdd;
            }

        }


    }


    public static void main(String[] args) {
        int[] A = {3, 2, 7, 1,8};

        Set<Integer> sequences = new HashSet<>();
        System.out.println("\nFrom DP: " + getSequenceDP(16, A, sequences));
        System.out.println("\nSequences: " + sequences);
    }

}