CONTRIB_DIR=contrib
BIN_DIR=bin
DATA_STRUCTURE=../data-structure
OPT=g
CC=javac

all:
	$(CC) \
	-$(OPT) \
	-d $(BIN_DIR) \
	-cp $(CONTRIB_DIR)/algs4.jar \
	src/DepthFirstSearch.java \
	src/Bag.java \
	src/UndirectedGraph.java
	
clean:
	rm -f $(BIN_DIR)/*