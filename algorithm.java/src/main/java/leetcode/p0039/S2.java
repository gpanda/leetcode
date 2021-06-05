package leetcode.p0039;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {

    private void ___ (int[] cand, int tgt, int offset,
            List<List<Integer>> results) {
        for (int i = offset; i < cand.length; i++) {
            int head = cand[i];
            int residue = tgt - head;
            if (residue < 0) {
                break;
            }
            if (residue == 0) {
                results.add(new ArrayList<Integer>(Arrays.asList(head)));
                break;
            }
            List<List<Integer>> tails = new ArrayList<List<Integer>>();
            ___(cand, residue, i, tails);
            for (List<Integer> tail : tails) {
                tail.add(0, head);
                results.add(tail);
            }
        }
        return;
    }

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        ___(candidates, target, 0, results);
        return results;
    }
}
