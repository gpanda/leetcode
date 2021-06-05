#include <stdio.h>

int main(int argc, char *argv[])
{
    int a = -1;
    unsigned int ua = a;
    long la = a;
    long unsigned lua = a;
    printf("a=%d(%%d)\n", a);
    printf("a=%u(%%u)\n", a);
    printf("la=%ld(%%ld)\n", la);
    printf("unsigned int ua = a\n");
    printf("ua=%d(%%d)\n", ua);
    printf("ua=%u(%%u)\n", ua);
    printf("lua=%lu(%%lu)\n", lua);

    printf("-1=%u(%%u)\n", -1);
    printf("-2=%u(%%u)\n", -2);
    printf("1L<<32=%ld(%%l)\n", 1L<<32);
    printf("(1L<<32) - 1=%ld(%%ld)\n", (1L<<32) - 1);

    unsigned int un = (unsigned int) ((1L << 32) - 1);
    printf("un = (unsigned int) ((1L << 32) - 1); un == %u\n", un);
    return 0;
}
