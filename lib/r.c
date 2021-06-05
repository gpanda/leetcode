/*
 * rlib.c
 *
 *  Created on: Oct 2, 2015
 *      Author: gpanda
 */

#include <stdio.h>
#include <string.h>

/**
 * Common structure operating functions
 */
void reverse(char a[]){
    int temp = 0;
    int i = 0;
    int j = strlen(a) - 1;
    while(i < j){
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
        j--;
    }
}

/**
 * Print functions
 */
void print_separator(char *msg){
    printf("================ separator %s ================\n", msg);
}

void assert(int real, int expected, const char* msg)
{
    if (real != expected) {
        printf("[msg:%s]FAILED.\n", msg);
    } else {
        printf("[msg:%s]PASSED.\n", msg);
    }
}

void assert_false(int real, int not_expected, const char* msg)
{
    if (real == not_expected) {
        printf("[msg:%s]FAILED.\n", msg);
    } else {
        printf("[msg:%s]PASSED.\n", msg);
    }
}
