package leetcode.libs;

import java.util.*;

public class RPrime {

    public static boolean isPrime(int t) {
        if (t <= 1) return false;
        int root = (int) Math.sqrt(t) + 1;
        for (int i = 2; i < root; i++) {
            if (t % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int t = Integer.valueOf(args[i]);
            System.out.println(args[i] + ":" + isPrime(t));
        }
    }
}
