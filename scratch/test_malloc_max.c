#include <limits.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
    setbuf(stdout, NULL);
    printf("2^32=%d\n", 2^32); // XOR
    // printf("(int)pow(2, 32)=%d\n", 1 << 32); // undefined
    printf("(long)pow(2, 32)=%ld\n", 1L << 32);
    printf("sizeof(int)=%ld\n", sizeof(int));
    printf("sizeof(size_t)=%ld\n", sizeof(size_t));

    int *p = malloc(sizeof(int) * (1L << 32));
    // int *q = malloc(sizeof(int) * (1L << 48)); // fail
    printf("sizeof p=%ld\n", sizeof p);
    p[(long)pow(2, 31)] = 10;
    printf("p[(long)pow(2, 31)]=%d\n", p[1L << 31]);
    printf("p[(long)pow(2, 31)-1]=%d\n", p[(1L << 31) - 1]);
    printf("1 << 32 = %ld\n", 1L << 32); // 4294967296
    printf("1 << 0 = %ld\n", 1L << 0);   // 1
    // printf("1 << -1 = %ld\n", 1L << -1); // undefined

    // int q[1L << 32]; // segment fault 11
    // memset(q, -1, (long)pow(2, 32));

    memset(p, 5, 1L << 32);
    printf("p[(long)pow(2, 31)]=%d\n", p[1L << 31]);
    printf("p[1]=%d\n", p[1]);

    // test big malloc
    printf("Test big malloc:\n");
    size_t size = 1L << 32;
    int *r = malloc(sizeof(int) * size);
    memset(r, -1, sizeof(int) * size);
    // memset(r, 5, sizeof(int) * size);
    printf("1L << 32 = %ld\n", 1L << 32);
    printf("(1L << 32) - 8= %ld\n", 1L << 32);
    for (long i = (1L << 32) - 8; i < size; i++) {
        printf("r[%ld]=0x%08x=%d\n", i, r[i], r[i]);
    }

    return 0;
}
