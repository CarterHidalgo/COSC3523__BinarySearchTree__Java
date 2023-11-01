# Binary Search Tree (Lab)

## Overview

The purpose of this lab is to play with Binary Search Trees and determine performance ranges based on tree height. The analysis will perform a slightly enhanced version of the proposed lab to expose and explain the results of the experiment. 

### Scenario
The program will be given three parameters, `start`, `stop`, and `step` which will dictate the behavior of the experiment. `start` represents the initial input size of the BST (i.e. if `start` equals 100_000 the tree will have 100_000 values entered). `stop` will represent the final input size and `step` the increment size. For each step from `start` to `stop`, the program will `sample` a set number of BSTs and find the `min`, the `max`, and the `average`. It will report back these three values for a given step size at which point the program will increment to the next step size and again re-sample to find a new `min`, `max`, and `average`. 

The values of these parameters are as follows. 
- `start` is 100_000
- `stop` is 10_000_000
- `step` is 100_000
- `sample size` is 50

The random integer values being generated are in the range from 0 to 1_000_000. The reason for this is to attempt to demonstrate how the height of the BST is dependent on *both* the number and range of values being input into the tree. The starting values have been chosen so that the number of values will initially be much smaller than the range, increase until it is equal with range, and finally be much larger than the range. 

NOTE: Sample size has been decreased to 50 in the interest of turning in this report on time. Testing on small data sets revealed that increasing the sample size from 50 or 100 to 1_000 did not substantially alter minimum and maximum tree height values, so we will make the assumption that this holds for larger data sets as well. Nevertheless, a modified version of the program was run with a sample size of 1_000 and those results have also been included. 

## Folder Structure

The workspace contains four folders

- `.vscode`: this folder contains the `settings.json` file
- `bin`: this folder contains compiled Java bytecode
- `lib`: this folder contains any dependencies 
- `src`: this folder contains source code

## GitHub

A copy of this Java project can be found in the GitHub repository linked [here]([url](https://github.com/CarterHidalgo/COSC3523__BinarySearchTree__Java.git))