#include <stdio.h>

#define FLOAT .75

int
main(int argc, char** argv)
{
    int a = 100;
    int b = a * FLOAT;
    printf("%d\n", b);
    return 0;
}
