#!/bin/bash - 
#==============================================================================
#
#          FILE: gen-ctags.sh
# 
#         USAGE: ./gen-ctags.sh 
# 
#   DESCRIPTION: 
# 
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Ren, Letian (), retaelppa@gmail.com
#  ORGANIZATION: ---
#       CREATED: 03/17/2017 08:40:31
#      REVISION:  ---
#==============================================================================

set -o nounset                              # Treat unset variables as an error
echo "$PATH"
ctags -R --c++-kinds=+p --fields=+iaS --extra=+q .
cscope -bR

cd algorithm.java
ctags -R --languages=Java .

cd -

cd algorithm.python
ctags -R --languages=Python .

cd -
