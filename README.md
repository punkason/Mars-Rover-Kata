# Mars Rover Kata

## Introduction

This repo is designed to stimulate rovers movement around the surface of Mars.

## Welcome to the Mars Rover Kata System! 
You will be exploring a Mars Rover Kata System.

## Assumption
- The Plateau is a rectangular grid.
- Rovers move sequentially.
- If any collision, the condition of rover that is being hit is normal. The one hits other is damaged.
- Size of rovers are 1 x 1.


## Key Features 

- Position of rover is represented by x and y co-ordinates and the letters N, S, W, E to represent North, South, West, East respectively.

- To move a Rover around the Plateau, a string of letters is sent to a Rover.
   Here are the letters and their resultant action:
    - L - Spins the Rover 90 degrees Left without moving from the current coordinate point.
    - R - Spins the Rover 90 degrees Right without moving from the current coordinate point.
    - M - Moves the Rover forward by one grid point, maintaining the same heading (i.e. from where the Rover is facing (its orientation)).

- The first line inputted into the program represents the upper-right coordinates of the Plateau.

- Subsequent Lines of Input will represent the instructions to move the rovers. Each rover receives two lines of input.
  - First Line of Input to a Rover
    The Rover’s position is represented by two integers representing the X and Y coordinates and a letter representing where the Rover is facing (its orientation).
    e.g. 1 2 N
  - Second Line of Input to a Rover
    A string of letters representing the instructions to move the Rover around the Plateau.
   
-   Each Rover will return output, it represents its final position (final coordinates and where it is facing).

## Pre-Requisites

- Java SE Development Kit 
- Maven

## Running the Unit Tests

You can run the unit tests in IntelliJ, or you can go to your terminal and inside the root of this directory, run:

`mvn test`


## Further enhancement

Other type of plateau are supported by extending from PlateauTemplate.java
