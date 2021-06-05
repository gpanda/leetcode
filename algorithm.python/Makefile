ROOT_DIR ?= ..
include $(ROOT_DIR)/Make.defines.common
include $(ROOT_DIR)/Make.defines.$(PLATFORM)

DIRS = \
    p0001 \
    scratch

all: $(PLATFORM)

.PHONY: clean $(PLATFORM)
clean:
	for i in $(DIRS); do \
		(cd $$i && $(MAKE) -f Makefile clean) || exit 1; \
	done

test:
	nosetests -v -s
