#!/bin/sh
# Copyright 2022 RLT
# Author: rbach (except10n.rlt@gmail.com)
# Revision: 0.1
# Last udpate: 2022-01-01
set -o nounset                              # Treat unset variables as an error
set -e                                      # Exit when there is an error

ctags -R --exclude=".*" --exclude="target"

# vim: tw=78:ts=8:sts=4:sw=4:et:ft=sh:norl:

