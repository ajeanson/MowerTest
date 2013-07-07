Architect / Developer -­‐ Object Design
1.1 Scenario
The company MowItNow have decided to develop an automatic lawn mower, designed for rectangular surfaces.
The mower can be programmed to cover the entire surface. The position of the mower is represented by a combination of coordinates (x, y) and a letter indicating the orientation in the English cardinal notation (N, E, W, S). The lawn is divided into a grid to simplify navigation.
For example, the position of the mower can be “0, 0, N”, meaning that it is in the lower left corner of the lawn, and oriented north.
The mower is controlled by a simple sequence of commands represented by characters. The permissable control characters are “D”, “G” and “A”. Characters “D” and “G” will rotate the trimmer 90 ° to the left or right respectively, without moving. Character “A” advances the mower one step in the direction it is facing without changing its orientation. If the position after movement would be out of bounds or disallowed, then the lawn mower does not move. Instead it retains its orientation and processes the next command.
It is assumed that the box directly north of the position (x, y) is coordinates (x, y +1). The mower program is an input file constructed as follows:
• The first line corresponds to the coordinates of the upper right corner of the lawn. The coordinates of the bottom left corner is assumed to be (0,0)
• The following lines are sequences used to instruct all mowers that have been deployed. There is one sequence for each mower. Each sequence has two lines of information:
o The first line gives the initial position of the mower as well as its orientation. The position and orientation are in the form of a letter and two digits, separated by a space
o The second line is a series of instructions that direct the lawn mower to move about the lawn. The instructions are a series of characters without spaces.
• Each mower moves sequentially, which means that the second mower moves only when the first one has run its full set of instructions.
• When a mower completes its sequence instructions, it communicates its position and orientation. 1.2 OBJECTIVE
Design and write a program running on a 1.6 JVM that implements the above specification and that passes the test below.
TEST
The following data is input: 55
12N
GAGAGAGAA
33E
AADAADADDA
The following result is expected (final mowers position): 13N
51E
NB: The input data can be read in another form, such as a file (e.g. as in an automated test).
