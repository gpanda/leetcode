ROOT_DIR ?= ../..
include $(ROOT_DIR)/Make.defines.common
include $(ROOT_DIR)/Make.defines.$(PLATFORM)

.PHONY: clean

clean:
	rm -rf $(TEMPFILES.python)

test:
	nosetests -v -s
