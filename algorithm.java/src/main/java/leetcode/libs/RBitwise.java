package leetcode.libs;

import java.util.*;

public class RBitwise {

    public static byte[] toBytes(int n) {
        if (n == 0) {
            return new byte[] {0};
        }
        int l = 0;
        int s = n;
        while (s > 0) {
            s = s >> 8;
            l++;
        }
        byte[] byts = new byte[l];
        for (int i = 0; i < l; i++) {
            byts[i] = (byte) (n - ((n >> 8) << 8));
            n = n >> 8;
        }
        return byts;
    }
}
