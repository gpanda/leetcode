ROOT_DIR ?= ..
include $(ROOT_DIR)/Make.defines.common
include $(ROOT_DIR)/Make.defines.$(PLATFORM)

# Makefile for misc library.
#

AR	= ar
LIBMISC	= libr.a
OBJS = r.o

all:	${OBJS}
	${AR} rv ${LIBMISC} $?

.PHONY: clean
clean:
	rm -f $(TEMPFILES) $(LIBMISC)
