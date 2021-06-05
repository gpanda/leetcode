package leetcode.p0052;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    int count;

    public int totalNQueens(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n < 4) {
            return 0;
        }
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = i;
        }
        // n's conditional permutation
        permutate(queens, 0, n);
        return count;
    }

    private void permutate(int[] queens, int start, int end) {
        if (start >= end) {
            count++;
            return;
        } else {
            for (int i = start; i < end; i++) {
                swap(queens, start, i);
                if (isValid(queens, start)) {
                    permutate(queens, start + 1, end);
                }
                swap(queens, start, i);
            }
        }
    }

    private boolean isValid (int[] queens, int r) {
        for (int i = 0; i < r; i++) {
            if (queens[i] == queens[r] 
                || queens[i] - i == queens[r] - r
                || queens[i] + i == queens[r] + r) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}

