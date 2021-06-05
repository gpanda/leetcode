#include <stdlib.h>
#include <stdio.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target)
{
    int* ret = malloc(sizeof(int) * 2);
    for (int i = 0; i < numsSize; i++) {
        for (int j =  0; j != i && j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
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
    int nums[3] = {3, 2, 4};
    int target = 6;
    int* results = twoSum(nums, 3, target);
    printf("indices:[%d, %d] for %d.\n", results[0], results[1], target);
    free(results);
}
