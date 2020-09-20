# Relative High Utility Itemset Mining
 

Relative High Utility Itemset Mining (RHUIM) aims to find all itemsets in a transactional database that have utility and utility ratio no less than the user-specified minimum utility and minimum utility ratio constraints. 

The algorithms for Naive and RHUI-Miner, have been written in Java. The command to execute the program is as follows.

##compile:

javac Naive.java 
javac RHUIMiner.java

##executiion:

java Naive datasetName outputFile minUtil minUR
java RHUIMiner datasetName outputFile minUtil minUR

##specifying threshold values

The minUtil constraint is specified in count. The minUR constraint is specified in the interval (0, 1). (for example 0.5 implies 50%)

To test the repetability of our experiments, we have provided some databases in the *datasets* folder. 


##Examples of running above code

java Naive datasets/T10I4D100K_Utility.txt out.txt 50000 0.5

java RHUIMiner datasets/T10I4D100K_Utility.txt out.txt 50000 0.5 
