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
PROGRAM=del.sh
MAINPATH="src/main/java/leetcode"
TESTPATH="src/test/java/leetcode"

usage()
{
    printf "%s <problem name>\n" "$PROGRAM"
    printf "Ex. ./%s p0001\n" "$PROGRAM"
}

if [ $# -lt 1 ]; then
    usage && exit 1;
fi

PROBLEM="$1"

if [ -z "$PROBLEM" ]; then
    printf "Empty problem name. Aborted!\n"
    exit 2
fi

printf "CAUTION! The following files will be removed:\n"
printf "%s\n" "$MAINPATH/$PROBLEM"
printf "%s\n" "$TESTPATH/$PROBLEM"
printf "Are you sure? Type 'Yes' to confirm: "
read -r confirm && [ "$confirm" = "Yes" ] || (printf "Aborted!\n" && exit 3)

rm -rf "$MAINPATH/${PROBLEM:?}"
rm -rf "$TESTPATH/${PROBLEM:?}"

