package leetcode.p0039;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    private List<List<Integer>> ___ (int[] cand, int tgt, int offset) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = offset; i < cand.length; i++) {
            int head = cand[i];
            int newtgt = tgt - head;
            if (newtgt < 0) {
                break;
            } else if (newtgt == 0) {
                results.add(new ArrayList<Integer>(Arrays.asList(head)));
                break;
            }
            List<List<Integer>> tails = ___(cand, newtgt, i);
            for (List<Integer> tail : tails) {
                tail.add(0, head);
                results.add(tail);
            }
        }
        return results;
    }

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return ___(candidates, target, 0);
    }
}
