package leetcode.p0087;

import java.util.*;

class S1 implements Solution {
    class TwoStringKey {
        private String s1;
        private String s2;
        public TwoStringKey(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
        @Override
        public boolean equals(Object tsk) {
            if (tsk != null && tsk instanceof TwoStringKey) {
                TwoStringKey t = (TwoStringKey)tsk;
                return s1.equals(t.s1) && s2.equals(t.s2) ||
                    s1.equals(t.s2) && s2.equals(t.s1);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return s1.hashCode() / 2 + s2.hashCode() / 2;
        }
    }

    private HashMap<TwoStringKey, Boolean> m = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() <= 1)  return s1.equals(s2);
        TwoStringKey tsk = new TwoStringKey(s1, s2);
        Boolean f = false;
        if ((f = m.get(tsk)) != null) {
            return f;
        }
        for (int i = 1; i < s1.length(); i++) {
            Boolean a = false;
            Boolean b = false;
            a = isScramble(s1.substring(0, i), s2.substring(0, i));
            if (a == true) {
                b = isScramble(s1.substring(i, s1.length()), s2.substring(i, s1.length()));
                if (b == true) {
                    m.put(tsk, true);
                    return true;
                } else {
                    // swap
                }
            } else { // swap
                a = isScramble(s1.substring(i, s1.length()), s2.substring(0, s1.length()-i));
                if (a == true) {
                    b = isScramble(s1.substring(0, i), s2.substring(s1.length()-i, s1.length()));
                    if (b == true) {
                        m.put(tsk, true);
                        return true;
                    } else {
                        // continue
                    }
                } else {
                    // continue
                }
            }
        }
        m.put(tsk, false);
        return false;
    }
}
