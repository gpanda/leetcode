package leetcode.scratch.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestDataGenerator {
    public TestDataGenerator() {}
    public static int[] generate_list_of_integers(
            int size, int originIncl, int boundExcl, boolean dup)  {
        if (size <= 0) return null;
        Random rng = new Random();
        /*
        HashSet<Integer> set = null;
        if (!dup) {
            set = new HashSet<>(count);
        }
        int[] a = new int[size];
        int c = 0;
        while (c < size) {
            int n = rng.nextInt(boundExcl-originIncl) + originIncl;
            if (!dup && set.contains(n)) continue;
            a[c++] = n;
        }
        */
        IntStream is = rng.ints(size, originIncl, boundExcl);
        if (!dup) is = is.distinct();
        return is.toArray();
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("TestDataGenerator <size> <originIncl>"
                + "<boundExcl> <dup>");
            System.out.println("args.length=" + args.length + "\n" +
                Arrays.toString(args));
            return;
        }
        int size = Integer.valueOf(args[0]);
        int originIncl = Integer.valueOf(args[1]);
        int boundExcl = Integer.valueOf(args[2]);
        boolean dup = Boolean.valueOf(args[3]);
        int[] a = generate_list_of_integers(size, originIncl, boundExcl, dup);
        System.out.println(Arrays.toString(a));
    }
}
