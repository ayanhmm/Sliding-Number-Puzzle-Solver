# Sliding Number Puzzle Solver
 code to solve the number sliding puzzles we used to play on pc as kids 

enter the input as follows ::

##column1      ##column2      ##column3      ##column4
   V               v              v               v
   v               v              v               v
box 1 == 22    box 2 == 23    box 3 == 24    box 4 == 25    > > row 1

box 5 == 32    box 6 == 33    box 7 == 34    box 8 == 35    > > row 2

box 9 == 42    box 10 == 43   box 11 == 44   box 12 == 45   > > row 3

box 13 == 52   box 14 == 53   box 15 == 54   box 16 == 99   > > row 4

**box 16 is the empty space in which boxes slide

Algorithm used::

It works on the fact that in a sliding puzzle once you arrange box1 you dont have to disturb it to arrange the other boxes.
then you can arrange box 2 and you dont have to disturb it either for furthur arranging.
box 3 and box 4 have to be arranged such that box 3 goes at position 25 and box 4 goes at position 35 followed by one clockwise rotation 

row 2 can be arranged using the same above principle

row 3,column1 and row 4,column1 have to be simultaneously arranged followed by row 3,column2 and row 4,column2

then the remaining four boxed can be arranged by rotation. if even after rotating 4 times they donot arrange themselves, then the puzzle cannot be solved.

this same algorithm can be applied to any NxN sliding puzzle and hence the code is applicable for any size of sliding puzzles.just change the rowsize and columnsize variables in the code




