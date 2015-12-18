JAVA := $(wildcard *.java)
CLASS := $(patsubst %.java, %.class, $(JAVA))

CC := javac-algs

$(CLASS): %.class: %.java
	$(CC) $^

all: $(CLASS)

clean:
	rm $(CLASS)

rebuild: clean all

.PHONY:	all clean rebuild
