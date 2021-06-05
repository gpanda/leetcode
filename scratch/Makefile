ROOT_DIR ?= ..
include $(ROOT_DIR)/Make.defines.common
include $(ROOT_DIR)/Make.defines.$(PLATFORM)

.PHONY: clean

MAIN = test_float test_strlen test_malloc_max test_unsigned_int \

all: $(MAIN)

clean:
	rm -rf $(MAIN) $(TEMPFILES)
