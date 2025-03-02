# Draw Snake

Algorithm: 

1. **Variables** → position of snake inside the panel → define two arrays for X position and Y position
2. 4 variables for detecting on which side the snake in moving
3. Timer class- manage the speed of the snake
4. 1. **Implement arrow** keys of our keyboard (move snake on the panel) 
- implement interface KeyListener , ActionListener (contain abstract method inside a class) → add unimplemented method
5. Add **default position** of the snake on the panel (set formalities)
6. define the snake at top left corner (Default position ) 
7. instantiate variable image icon
8. (c, g, x, y) → (context, variable of graphics, array, array)
9. first index will contain the head and the rest of the indices will carry the body of the snake
10. define default length of snake 
11. start a loop , detect the direction of the snake
12. if a!=0 that means the snake head has been drawn and we need to draw the body of the snake
13. detect if the game has just started,then set the default position of the snake to this
