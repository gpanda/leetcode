package leetcode.p0030;

import java.math.*;
import java.util.*;
import leetcode.libs.*;

public class S1 implements Solution {
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        int slen = s.length();
        int wlen = words[0].length();
        if (wlen == 0) {
            for (int i = 0; i <= slen; i++) {
                results.add(i);
            }
            return results;
        }
        int wordsNum = words.length;
        int[] queue = new int[slen];
        int[] wcounts = new int[wordsNum];
        HashMap<String, Integer> wordInitOrder = new HashMap<>(wordsNum);
        for (int k = 0; k < wordsNum; k++) {
            String w = words[k];
            Integer order;
            if ((order = wordInitOrder.get(w)) != null) {
                wcounts[order]++;
                continue;
            }
            int i = 0;
            int hits = 0;
            while (i + wlen <= slen) {
                i = s.indexOf(w, i);
                if (i < 0) {
                    break;
                }
                queue[i] = k + 1;
                i++;
                hits++;
            }
            if (hits > 0) {
                wcounts[k] = 1;
                wordInitOrder.put(w, k);
            }
        }
        // System.out.println("queue:" + Arrays.toString(queue));
        // System.out.println("wcounts:" + Arrays.toString(wcounts));
        int remains = wlen * wordsNum;
        int i = 0;
        while (i <= slen - remains) {
            int[] counters = new int[wordsNum];
            if (queue[i] == 0) {
                i++;
                continue;
            }
            int initIndex = i;
            int j = 0;
            while (j < wordsNum) {
                int k = queue[i] - 1;
                if (k < 0 || counters[k] >= wcounts[k]) {
                    break;
                }
                counters[k]++;
                i += wlen;
                j++;
            }
            if (j == wordsNum) {
                results.add(initIndex);
            }
            i = initIndex + 1;
        }
        return results;
    }
}
