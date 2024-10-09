# The box problem

[![Continuous Integration](https://github.com/benoitpas/box-problem/actions/workflows/main.yml/badge.svg)](https://github.com/benoitpas/box-problem/actions/workflows/main.yml)


## Or, How to find a good example to apply [TDD](https://en.wikipedia.org/wiki/Test-driven_development) while noodling.

I discovered the box problem in [this article](https://www.theguardian.com/science/2024/sep/30/can-you-solve-it-the-box-problem-that-baffled-the-boffins) while browsing the paper.

My initial thought to solve it without thinking too much (i.e. lazily ;-) ) was to write a [Monte Carlo simulation](https://en.wikipedia.org/wiki/Monte_Carlo_method) 
but quickly I realised the number of combinations of the problem is fairly low (225, 15 positions for the first ball times 15 combinations for the positions of the second ball) it could be solved simply using a [spreadsheet](spreadsheet.md).

Then I realised a solution could also be implemented using TDD, starting from a function that passed the number of column and rows would return 3 numbers (H, V, HV):

* 'H' is the number of boxes opened by Andrew first in the article for all combinations as he goes horizontally
* 'V' is the number of boxes opened by Barbara first as she goes vertically
* 'HV' is the number of boxes they open together

I first implemented a test for a high level function that returns the final result.

Then I implemented first the test and then function that fulfills it for the following actions:
* returning all possible combinations
* computing both distances for a cell

Finally I used the 2 functions to implement the high level function. Then I realized my expectations were not correct because of a bug in the excel spreadsheet !

After fixing the excel spreadsheet and the expectations, both solutions gave the same results. In retrospect the initial spread sheet result was suspicious because the difference between combinations was too high.