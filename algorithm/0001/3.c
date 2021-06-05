#include <limits.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N_SIZE (sizeof(int) * (UINT_MAX + 1L))
#define reset(a) { if (a==NULL) a = malloc(N_SIZE) ; memset(a, 0xff, N_SIZE); }

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target)
{
    int* ret = malloc(sizeof(int) * 2);
    int* a = NULL;
    reset(a);
    for (int i = 0; i < numsSize; i++) {
      a[(unsigned)nums[i]] = i;
    }
    for (int i = 0; i < numsSize; i++) {
        int j = -1;
        if ((j = a[(unsigned)(target - nums[i])]) >= 0 ) {
            if (j != i) {
                ret[0] = i;
                ret[1] = j;
                break;
            }
        }
    }
    return ret;
}

int main(int argc, char** argv)
{
    int n1[3] = {3, 2, 4};
    int t1 = 6;
    int n2[5] = {1, 22, 998, -997, 3};
    int t2 = 1;
    int* r1 = twoSum(n1, 3, t1);
    printf("indices:[%d, %d] for %d.\n", r1[0], r1[1], t1);
    free(r1);
    int* r2 = twoSum(n2, 5, t2);
    printf("indices:[%d, %d] for %d.\n", r2[0], r2[1], t2);
    free(r2);
}
