# Mars Rover Kata - Initial Thought


## Coordination Class
It is a superclass providing x and y coordinates as long as their related getter and setter method.

## Plateau Class
It controls the size of the plateau.
It is a subclass of coordination class.
In additional to x and y coordinates, checkWithinPlateau() method is added to check if the next move of the rover will still in the plateau.

## Rover Class
It stores information of rover, including x and y coordinates from its superclass.
On the other hand, compassPoint is for controlling the direction of the rover.
We use integer to represent as it is easier to implement and convert back to N, E, S, W in getOutput() method.
0 stands for N
1 stands for E
2 stands for S
3 stands for W
When the rover moves, we can just simply +1 or -1 for the related coordinates in move(). 
