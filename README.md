<h1>Game of Life</h1>

This application was created for the Advanced Topics in Computer Science: Object-Oriented Programming class. It follows the rules for Conway's Game of Life, which is a cellular automaton in which each cell has a binary state alive or dead, and can either be killed or revived based on the status of their neighbors. This app allows users to select which cells they would like to have alive and watch the scene evolve as cells live or die. <br> <br>

Link to rules: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life 

<h2>How it's made</h2>
<b>Used: Java, Processing 3, IntelliJ IDE</b> <br> <br> 

The class Cell represents each cell in the automaton. Each cell has particular dimensions which are used to display them on the screen. They have a position in the array of cells, a set of rules to use, a state, and a boolean to track user clicks. Each cell can then evolve depending on the behavior of its neighbors. The enumerator CellState is used to describe the current state of each cell, so they can evolve in coordination. They can be alive, dead, going to die, or going to revive. <br>
Using abstract classes, I created a Rules class. This class has an abstract boolean for the future of the cell: should be born or should survive. These booleans refer to the behavior of the cell in the next round. It includes a method to apply Conway's classic rules to the automaton. Using inheritance, the Moore Rules class is a subclass of Rules which specifies the rules for self-replication.<br> 
Everything is combined in the main game class. Main game displays a 2-dimensional array of cells and deals with each evolution of the automaton 

<h2>Lessons Learned</h2>
The objective of this project was to learn to utilize inheritance and polymorphism in Java. It was a formative project to learn how to organize different classes and objects when working with object-oriented programming. It was one of my first formal projects. As such, I discovered essential style rules in Java and how to organize larger code projects. 
