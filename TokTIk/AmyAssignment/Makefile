# binary search program makefile
# Hussein Suleman
# 22 March 2017

CLASSES = BinaryTreeNode BTQueueNode BTQueue BinaryTree \
         BinarySearchTree BinarySearchTreeTest \
         Posts Account Toktik

.SUFFIXES: .java .class

bin/%.class:src/%.java
	javac -d bin -cp bin $< 


classes: $(CLASSES:%=bin/%.class)


clean:
	rm bin/*.class
