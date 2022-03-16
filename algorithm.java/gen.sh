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
PROGRAM=gen.sh

usage()
{
    printf "%s <problem name> <main method signature>\n" "$PROGRAM"
    printf "Ex. ./%s p0001 \"int[] twoSum(int[] nums, int target)\"\n" \
        "$PROGRAM"
}

if [ $# -lt 2 ]; then
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
SIGNATURE="$2"
FNAME=$(get_func_name "$SIGNATURE")

cp -r src/templates/pXXX "src/main/java/leetcode/$PROBLEM"
cp -r src/templates/pXXX.test "src/test/java/leetcode/$PROBLEM"
substr "src/main/java/leetcode/$PROBLEM" "%%PROBLEM%%" "$PROBLEM"
substr "src/main/java/leetcode/$PROBLEM" "%%SIGNATURE%%" "$SIGNATURE"
substr "src/test/java/leetcode/$PROBLEM" "%%PROBLEM%%" "$PROBLEM"
substr "src/test/java/leetcode/$PROBLEM" "%%SIGNATURE%%" "$SIGNATURE"
substr "src/test/java/leetcode/$PROBLEM" "%%FNAME%%" "$FNAME"


