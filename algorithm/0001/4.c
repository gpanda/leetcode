#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct btNode {
    int i;
    int v;
    struct btNode *l;
    struct btNode *r;
} btNode;
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

btNode* newBtNode(int i, int v)
{
    btNode *p = malloc(sizeof(btNode));
    p->i = i;
    p->v = v;
    p->l = NULL;
    p->r = NULL;
    return p;
}

void insertBtNode(btNode *tree, btNode *node)
{
    if (!node) return;
    btNode *p = tree;
    while (p) {
        if (node->v > p->v) {
            if (!(p->r)) {
                p->r = node;
                break;
            } else {
                p = p->r;
            }
        } else {
            if (!(p->l)) {
                p->l = node;
                break;
            } else {
                p = p->l;
            }
        }
    }
}

btNode* searchBtNode(btNode *tree, int v)
{
    btNode *p = tree;
    while (p) {
        if (v == p->v) {
            return p;
        } else if (v > p->v) {
            p = p->r;
        } else {
            p = p->l;
        }
    }
    return NULL;
}

int* twoSum(int* nums, int numsSize, int target)
{
    int *ret = malloc(sizeof(int) * 2);
    ret[0] = -1;
    ret[1] = -1;
    int mid = target / 2;
    int pivot = mid;
    if (mid < 0) {
        pivot = mid - 1;
    }
    btNode *bTree = newBtNode(-1, pivot);
    btNode *tmp[numsSize];
    btNode *p = NULL;
    int l = 0, h = numsSize - 1;
    int i = 0;
    for (i = 0; i < numsSize; i++) {
        p = newBtNode(i, nums[i]);
        insertBtNode(bTree, p);
        if (nums[i] > pivot) {
            tmp[h--] = p;
        } else {
            tmp[l++] = p;
        }
    }
    p = NULL;
    if (l <= (numsSize / 2)) {
        for (i = 0; i < l; i++) {
            p = searchBtNode(bTree->r, target - tmp[i]->v);
            if (p) break;
        }
    } else {
        for (i = h + 1; i < numsSize; i++) {
            p = searchBtNode(bTree->l, target - tmp[i]->v);
            if (p) break;
        }
    }
    if (p) {
        if (tmp[i]->i < p->i) {
            ret[0] = tmp[i]->i;
            ret[1] = p->i;
        } else {
            ret[0] = p->i;
            ret[1] = tmp[i]->i;
        }
    } else {// target even, two same mid in one sub-tree
        if (mid >= 0) {
            p = searchBtNode(bTree->l, mid);
            if (p) {
                i = p->i;
                p = searchBtNode(p->l, mid);
                if (p) {
                    ret[0] = i;
                    ret[1] = p->i;
                } else {
                    printf("abnormal 2\n");
                }
            } else {
                printf("abnormal 1\n");
            }
        } else {
            p = searchBtNode(bTree->r, mid);
            if (p) {
                i = p->i;
                p = searchBtNode(p->l, mid);
                if (p) {
                    ret[0] = i;
                    ret[1] = p->i;
                } else {
                    printf("abnormal 4\n");
                }
            } else {
                printf("abnormal 3\n");
            }
        }
    }
    return ret;
}

int test(int* a, int size, int target) {
    int* ret = NULL; // 2 ints
    ret = twoSum(a, size, target);
    printf("indices:[%d, %d] for %d\n", ret[0], ret[1], target);
    return 0;
}

int main(int argc, char** argv)
{
    int a1[] = {3, 2, 4};
    test(a1, 3, 6);
    int a2[] = {2, 1, 997, -998, 10002};
    test(a2, 5, -1);
    int a3[] = {3, 3};
    test(a3, 2, 6);
    int a31[] = {3, 4};
    test(a31, 2, 7);
    int a312[] = {4, 3};
    test(a312, 2, 7);
    int a32[] = {-3, -3};
    test(a32, 2, -6);
    int a33[] = {-3, -4};
    test(a33, 2, -7);
    int a332[] = {-4, -3};
    test(a332, 2, -7);
    int a4[] = {5, 75, 25};
    test(a4, 3, 100);
    int a5[] = {INT_MIN/2, INT_MIN/2};
    test(a5, 2, INT_MIN);
    int a51[] = {(INT_MIN + 1)/2, (INT_MIN + 1)/2 - 1};
    test(a51, 2, INT_MIN + 1);
    return 0;
}
