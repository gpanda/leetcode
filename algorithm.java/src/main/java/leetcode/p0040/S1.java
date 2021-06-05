package leetcode.p0040;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    private int[] pattern;

    private List<List<Integer>> ___ (int[] cand, int tgt, int offset) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = offset; i < cand.length; i=pattern[i]) {
            int head = cand[i];
            int residue = tgt - head;
            if (residue < 0) {
                break;
            }
            if (residue == 0) {
                results.add(new ArrayList<Integer>(Arrays.asList(head)));
                break;
            }
            List<List<Integer>> tails = ___(cand, residue, i+1);
            for (List<Integer> tail : tails) {
                tail.add(0, head);
                results.add(tail);
            }
        }
        return results;
    }

    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        pattern = new int[candidates.length];
        int j = 0;
        int a = candidates[0];
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] != a) {
                while (j < i) {
                    pattern[j++] = i;
                }
                a = candidates[i];
            }
        }
        while (j < candidates.length) {
            pattern[j++] = candidates.length;
        }
        return ___(candidates, target, 0);
    }
}
