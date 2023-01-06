# Mars Rover Puzzle 

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously square, must be navigated by the rovers so that it’s on-board cameras can get a complete view of the surrounding terrain to send back to Earth. And the plateau is too high for the rover to get out from.
A rover’s position is represented by a combination of an x and y coordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 00N, which means the rover is in the bottom left corner and facing North. Another example is 11S, which means the rover is in the 1 square North and 1 square East from the bottom left corner and facing South. There are 4 accepted heading initials: N for North, E for East, W for West and S for South.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees Left or Right respectively, without moving from its current spot.
‘M’ means Move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1) and the square directly East from (x, y) is (x+1, y).
Build an application that can simulate this rover behaviour, application will accept 3 different text input and will produce 1 final coordinate and heading output.

Input:
The first input is the width of the plateau, the lower-left coordinates are assumed to be 0,0 so if width input is x the plateau top-right coordinates will be x-1,x-1.
The second input is the coordinate where the rover going to land and it’s heading.
And the last input is a series of instructions telling the rover how to explore and move around the plateau.
The position is made up of two integers and followed by a letter, corresponding to the x and y co-ordinates and the rover’s orientation (N/E/W/S).

Output:  
The output should be its final co-ordinates and heading.

Test Case 1:  
Width: 6   
Location: 12N  
Movement: LMLMLMLMM  
Output: 13N  

Test Case 2:  
Width: 6  
Location: 33E  
Movement: MMRMMRMRRM  
Output: 51E  

Test Case 3:  
Width: 6  
Location: 55N  
Movement: MMRMMLLMRMLLM  
Output: 44S  
