package leetcode.scratch.regex;

import static org.junit.Assert.*;
import org.junit.Test;


import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class TestRegex {

    private static final String infile = "src/test/java/leetcode/"
        + "scratch/regex/1.dat";

    private static final String VERBOSE = "verbose";

    private static boolean isVerbose() {
        return "Y".equals(System.getProperty(VERBOSE));
    }

    final String s0 = "^";
    final String s1 = "$";
    final String ws = "\\s*";
    final String ww = "\\s+";
    final String b0 = "\\[";
    final String b1 = "\\]";
    final String tk = "[^" + b0 + b1 + "]*";
    final String c0 = "(";
    final String c1 = ")";
    final String nc = "?:";
    final String or = "|";
    final String sp = ",";
    final String as = "*";
    final String dl = ws + sp + ws + or + ww;
    final String LIST_PATTERN_STR = b0 + c0 + tk + c1 + b1;
    final Pattern LIST_PATTERN = Pattern.compile(LIST_PATTERN_STR);
    final String LIST_2D_PATTERN_STR = ""
        + b0 + ws + c0
             + LIST_PATTERN_STR
             + c0 + dl
                  + LIST_PATTERN_STR
             + c1 + as
        + c1 + ws + b1;
    final Pattern LIST_2D_PATTERN = Pattern.compile(LIST_2D_PATTERN_STR);

    public List<Integer> getList(CharSequence cs) {
        if (cs.length() == 0) return null;
        Matcher m = LIST_PATTERN.matcher(cs);
        return getList(m);
    }

    public List<Integer> getList(Matcher m) {
        if (m == null) return null;
        if (!m.find()) return null;
        String group = m.group(1).trim();
        if (group.length() == 0) {
            return new ArrayList<Integer>(0);
        }
        List<Integer> l = Arrays.stream(group.split(dl))
            .map(s -> Integer.valueOf(s))
            .collect(Collectors.toList());
        return l;
    }

    public List<List<Integer>> get2dList(CharSequence cs) {
        if (cs.length() == 0) return null;
        Matcher m0 = LIST_2D_PATTERN.matcher(cs);
        if (!m0.find()) return null;
        List<List <Integer>> ll = new ArrayList<>();
        Matcher m1 = LIST_PATTERN.matcher(m0.group(1).trim());
        List<Integer> l = null;
        while ((l = getList(m1)) != null) {
            ll.add(l);
        }
        return ll;
    }

    @Test
    public void test_0() {
        Pattern p = Pattern.compile(LIST_PATTERN_STR);
        Matcher m = p.matcher("[ -1,    -2,           -3 ]");
        assertTrue(m.matches());
        assertEquals(1, m.groupCount());
        assertEquals("[ -1,    -2,           -3 ]", m.group(0));
        assertEquals(" -1,    -2,           -3 ", m.group(1));
    }

    @Test
    public void test_00() {
        Pattern p = Pattern.compile("(aa)(,aa)*");
        Matcher m = p.matcher("aa,aa,aa");
        assertTrue(m.matches());
        assertEquals(8, m.end()); // 8
        assertEquals(2, m.groupCount());
        assertEquals("aa,aa,aa", m.group(0));
        assertEquals("aa", m.group(1));
        assertEquals(",aa", m.group(2)); // replaced by the last captured
    }

   @Test
   public void test_2() {
       try {
           Scanner sc = new Scanner(new File(infile));
           while (sc.hasNextLine()) {
               List<Integer> list = getList(sc.nextLine().trim());
               if (list != null && isVerbose()) {
                   System.out.println(list);
               }
               sc.nextLine();
           }
           sc.close();
           sc = new Scanner(new File(infile));
           while (sc.hasNextLine()) {
               List<List<Integer>> lol = get2dList(sc.nextLine().trim());
               if (lol != null && isVerbose()) {
                   System.out.println(lol);
               }
               sc.nextLine();
           }
           sc.close();
       } catch (FileNotFoundException fnfe) {
           System.out.println(fnfe);
       }
   }

   @Test
   public void test_3() {
       Scanner sc = null;
       try {
           sc = new Scanner(new File(infile));
           String line = null;
           while (sc.hasNextLine()) {
               line = sc.nextLine();
               if (isVerbose()) {
                   System.out.println(line);
               }
               Matcher m1 = LIST_PATTERN.matcher(line);
               Matcher m2 = LIST_2D_PATTERN.matcher(line);
               if (m2.find()) {
                   if (isVerbose()) {
                       System.out.println("2D list found");
                       System.out.println(get2dList(line));
                   }
               } else if (m1.find()) {
                   if (isVerbose()) {
                       System.out.println("list found");
                       System.out.println(getList(line));
                   }
               } else {
                   if (isVerbose()) {
                       System.out.println("no pattern found");
                   }
               }
           }
       } catch (FileNotFoundException fnfe) {
           System.out.println(fnfe);
       } finally {
           if (sc != null) {
               sc.close();
           }
       }
   }
}

