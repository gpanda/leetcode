#include <stdio.h>
#include <stdlib.h>


typedef struct nodeData
{
    int v;
    int iArr[2];
} nodeData;

typedef struct btNode
{
    nodeData d;
    struct btNode* l;
    struct btNode* r;
} btNode;

btNode* newBtNode()
{
    btNode* p = malloc(sizeof(btNode));
    p->d.iArr[0] = -1;
    p->d.iArr[1] = -1;
    p->l = NULL;
    p->r = NULL;
    return p;
}

btNode* insertBtNode(nodeData d, btNode* pT)
{
    if (pT == NULL) {
        return NULL;
    }
    while(1) {
        if (pT->d.v == d.v) {
            if(pT->d.iArr[0] == -1) {
                pT->d.iArr[0] = d.iArr[0];
            } else {
                pT->d.iArr[1] = d.iArr[0];
            }
            return pT;
        } else if (pT->d.v > d.v) {
            if (pT->l == NULL) {
                pT->l = newBtNode();
                pT->l->d.v = d.v;
                pT->l->d.iArr[0] = d.iArr[0];
                return pT->l;
            } else {
                pT = pT->l;
            }
        } else {
            if (pT->r == NULL) {
                pT->r = newBtNode();
                pT->r->d.v = d.v;
                pT->r->d.iArr[0] = d.iArr[0];
                return pT->r;
            } else {
                pT = pT->r;
            }
        }
    }
}

btNode* searchBt(int target, btNode* pT)
{
    while(pT) {
        if (pT->d.v == target) {
            return pT;
        } else if (pT->d.v > target) {
            pT = pT->l;
        } else {
            pT = pT->r;
        }
    }
    return NULL;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target)
{
    if(numsSize <= 0) return NULL;
    btNode* pT = newBtNode();
    pT->d.v = target / 2;
    // build binary tree from nums
    for (int i = 0; i < numsSize; i++) {
        nodeData d;
        d.v = nums[i];
        d.iArr[0] = i;
        d.iArr[1] = -1;
        insertBtNode(d, pT);
    }
    // search the binary tree for the target
    int* ret = NULL;
    btNode* pN = NULL;
    for (int i = 0; i < numsSize; i++) {
        if ((pN = searchBt(target - nums[i], pT)) != NULL) {
            if (pN->d.iArr[0] == -1) {
                continue;
            }
            if (pN->d.iArr[0] == i) {
                if (pN->d.iArr[1] == -1) {
                    continue;
                } else {
                    ret = malloc(sizeof(int) * 2);
                    ret[1] = pN->d.iArr[1];
                }
            } else {
                ret = malloc(sizeof(int) * 2);
                ret[1] = pN->d.iArr[0];
            }
            ret[0] = i;
            break;
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
