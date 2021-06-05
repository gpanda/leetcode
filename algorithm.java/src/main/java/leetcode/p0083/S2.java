package leetcode.p0083;

import java.util.*;
import java.util.stream.*;

import leetcode.libs.ListNode;

public class S2 implements Solution {
    // TEST BEST SAMPLE CODE
    // Actually, S1's runntime is better than this, see profiling report below.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            if(cur.next != null && cur.val == next.val){
                ListNode tail = next;
                while(tail != null && tail.val == next.val) {
                    tail = tail.next;
                }
                cur.next = tail;
            }
            cur = cur.next;
        }
        return head;
    }
}

/*
 
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running leetcode.p0083.SolutionTests
test_1[0](leetcode.p0083.SolutionTests):succeeded:1,532(us).
test_1[0](leetcode.p0083.SolutionTests):finished:1,532(us).
test_2[0](leetcode.p0083.SolutionTests):succeeded:358(us).
test_2[0](leetcode.p0083.SolutionTests):finished:358(us).
test_1[1](leetcode.p0083.SolutionTests):succeeded:22(us).
test_1[1](leetcode.p0083.SolutionTests):finished:22(us).
test_2[1](leetcode.p0083.SolutionTests):succeeded:17(us).
test_2[1](leetcode.p0083.SolutionTests):finished:17(us).
test_1[2](leetcode.p0083.SolutionTests):succeeded:17(us).
test_1[2](leetcode.p0083.SolutionTests):finished:17(us).
test_2[2](leetcode.p0083.SolutionTests):succeeded:18(us).
test_2[2](leetcode.p0083.SolutionTests):finished:18(us).
test_1[3](leetcode.p0083.SolutionTests):succeeded:13(us).
test_1[3](leetcode.p0083.SolutionTests):finished:13(us).
test_2[3](leetcode.p0083.SolutionTests):succeeded:15(us).
test_2[3](leetcode.p0083.SolutionTests):finished:15(us).
test_1[4](leetcode.p0083.SolutionTests):succeeded:17(us).
test_1[4](leetcode.p0083.SolutionTests):finished:17(us).
test_2[4](leetcode.p0083.SolutionTests):succeeded:23(us).
test_2[4](leetcode.p0083.SolutionTests):finished:23(us).
test_1[5](leetcode.p0083.SolutionTests):succeeded:18(us).
test_1[5](leetcode.p0083.SolutionTests):finished:18(us).
test_2[5](leetcode.p0083.SolutionTests):succeeded:20(us).
test_2[5](leetcode.p0083.SolutionTests):finished:20(us).
test_1[6](leetcode.p0083.SolutionTests):succeeded:44(us).
test_1[6](leetcode.p0083.SolutionTests):finished:44(us).
test_2[6](leetcode.p0083.SolutionTests):succeeded:45(us).
test_2[6](leetcode.p0083.SolutionTests):finished:45(us).
test_1[7](leetcode.p0083.SolutionTests):succeeded:27(us).
test_1[7](leetcode.p0083.SolutionTests):finished:27(us).
test_2[7](leetcode.p0083.SolutionTests):succeeded:39(us).
test_2[7](leetcode.p0083.SolutionTests):finished:39(us).
Tests run: 16, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.139 sec

Results :

Tests run: 16, Failures: 0, Errors: 0, Skipped: 0




==================================================================
Test cases:
#0
[1,1,2]
[1,2]
#1
[1,1,2,3,3]
[1,2,3]
#2
[1,1,1,1,1]
[1]
#3
[]
[]
#4
[1]
[1]
#5
[1,1]
[1]
#6
[1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,6]
[1,2,3,4,5,6]
#7
[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,26]
[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]
#8
[1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,25,26,26]
[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]

=====================================================================

 */
