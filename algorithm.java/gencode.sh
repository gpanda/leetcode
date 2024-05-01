#!/bin/sh -
#===============================================================================
#
#          FILE: gen.sh
#
#         USAGE: ./gen.sh
#
#   DESCRIPTION: A utility to generate sterotype code structure for a problem.
#
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Ren, Letian (), gpanda.next@gmail.com
#  ORGANIZATION: SelfRef
#       CREATED: 06/10/2021 15:29
#      REVISION:  ---
#===============================================================================

set -o nounset                             # Treat unset variables as an error
PROGRAM=${0##/}

usage()
{
    printf "%s <problem name> <param num> <main method signature>\n" "$PROGRAM"
    printf "\nEx. %s p0001 3 \"int[] twoSum(int[] nums, int target)\"\n" "$PROGRAM"
    printf "\nNotes: Usually, the number of parameters is the number of
pararmeters in method signature plus 1 return value(3 = 2 + 1 in the above
example).\n"
}

if [ $# -lt 3 ]; then
    usage && exit 1;
fi


substr()
{
    find "$1" -type f -exec sed -i "s/$2/$3/g" {} +
}

get_func_name()
{
    echo "$1" | awk -F'[ (,)]' '{print $2}'
}

PROBLEM="$1"
PARAM_NUM="$2"
SIGNATURE="$3"
FNAME=$(get_func_name "$SIGNATURE")

cp -r src/test/java/leetcode/templates/pXXX "src/main/java/leetcode/$PROBLEM"
cp -r src/test/java/leetcode/templates/pXXX.test "src/test/java/leetcode/$PROBLEM"
substr "src/main/java/leetcode/$PROBLEM" "%%PROBLEM%%" "$PROBLEM"
substr "src/main/java/leetcode/$PROBLEM" "%%SIGNATURE%%" "$SIGNATURE"
substr "src/test/java/leetcode/$PROBLEM" "%%PROBLEM%%" "$PROBLEM"
substr "src/test/java/leetcode/$PROBLEM" "%%SIGNATURE%%" "$SIGNATURE"
substr "src/test/java/leetcode/$PROBLEM" "%%FNAME%%" "$FNAME"
substr "src/test/java/leetcode/$PROBLEM" "%%PARAM_NUM%%" "$PARAM_NUM"

