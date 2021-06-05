/*
 * ============================================================================
 *
 *       Filename:  test_strlen.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  10/15/2016 14:07:34
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Ren, Letian (), retaelppa@gmail.com
 *   Organization:  Spectrum Computing
 *
 * ============================================================================
 */

#include <stdio.h>
#include <string.h>

int
main(int argc, char *argv[])
{
    printf("strlen(\"\")=%ld\n", strlen(""));
    // Segmentation fault: 11
    // printf("strlen(NULL)=%ld\n", strlen(NULL));
    return 0;
}
