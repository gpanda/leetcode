# Makefile
# Created on: Oct 9, 2016
# Author: gpanda

# shell function + simple variable definition (::= or := instead of =)
PLATFORM := $(shell ./systype.sh)
ROOT_DIR := $(shell ./getcwd.sh)
export PLATFORM
export ROOT_DIR

include Make.defines.$(PLATFORM)

DIRS = lib scratch \
       algorithm
DIRS.JAVA = algorithm.java
DIRS.PYTHON = algorithm.python

all: $(PLATFORM)
#	Don't know why this "make <target>" will result in the duplicate running
#	the statements (at least "echo `date` >> ~/tmp/a") in ./systype.sh, while
#	the one in L25, i.e., "make -f $(PLATFORM).mk" won't.
#	$(MAKE) $(PLATFORM)

.PHONY: clean $(PLATFORM)
clean:
	for i in $(DIRS); do \
		(cd $$i && $(MAKE) -f Makefile clean) || exit 1; \
	done
	for i in $(DIRS.JAVA); do \
		(cd $$i &&  mvn clean) || exit 1; \
	done
	for i in $(DIRS.PYTHON); do \
		(cd $$i &&  $(MAKE) -f Makefile clean) || exit 1; \
	done

$(PLATFORM):
	for i in $(DIRS); do \
		(cd $$i && $(MAKE) -f Makefile) || exit 1; \
	done
	for i in $(DIRS.JAVA); do \
		(cd $$i &&  mvn compile) || exit 1; \
	done

test:
	for i in $(DIRS.JAVA); do \
		(cd $$i &&  mvn test) || exit 1; \
	done
	for i in $(DIRS.PYTHON); do \
		(cd $$i &&  $(MAKE) -f Makefile test) || exit 1; \
	done
