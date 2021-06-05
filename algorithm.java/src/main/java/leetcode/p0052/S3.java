package leetcode.p0052;

import java.util.*;
import java.util.stream.*;

public class S3 implements Solution {
    // optimal version of S1, reduce to half of its time consumption
    int count;
    boolean isOdd;

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
        if (n % 2 == 0) {
            isOdd = false;
        } else {
            isOdd = true;
        }
        // n's conditional permutation
        permutate(queens, 0, n);
        return count;
    }

    private void permutate(int[] queens, int start, int end) {
        if (start >= end) {
            if (queens[0] < end / 2) {
                count += 2;
            } else if (queens[0] == end / 2 && isOdd) {
                count += 1;
            }
            return;
        } else {
            for (int i = start; i < end; i++) {
                if (start == 0) {
                    if (isOdd && i > end / 2) {
                        return;
                    } else if (!isOdd && i >= end / 2) {
                        return;
                    }
                }
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

