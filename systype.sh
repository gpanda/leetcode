#!/bin/sh
case `uname -s` in
"FreeBSD")
    PLATFORM="freebsd"
    ;;
"Linux")
    PLATFORM="linux"
    ;;
"Darwin")
    PLATFORM="macos"
    ;;
"SunOS")
    PLATFORM="solaris"
    ;;
*)
    echo "Unknown platform" >&2
    exit 1
esac
# Why does this echo always run twice
# I guess it is about sub-make and variable passing
# echo `date` >> ~/tmp/a
echo $PLATFORM
exit 0
