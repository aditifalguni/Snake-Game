import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//1.extend class JPanel
//ADD the obj of the JPanel calss inside the JFrame obj
//JPanel is the method that we need to implement 

//11.implement the arrow key of keyboard to move snake on the panel 
//interfaces contain abstract method that needs to be implemented inside a class 
public class Gameplay extends JPanel implements KeyListener, ActionListener
{
	//6
	//define two ARRAYs for the snakes X & Y position 
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	//7
	//4 variables for which side the snake in moving 
	private boolean left = false; 
	private boolean right = false; 
	private boolean up = false; 
	private boolean down = false; 
	
	//8
	//4 variables for the snake face 
	private ImageIcon rightmouth; 
	private ImageIcon upmouth; 
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	//16. define default length of snake 
	private int lengthofsnake = 2;
	
	//9
	//Add a timer class, manage the speed of the snake inside the panel 
	private Timer timer; //define built-in calss
	private int delay = 100; //speed control
	
	//10
	private ImageIcon snakeimage; 
	
	//19. define the variable
	private int moves = 0; 
	
	//4
	private ImageIcon titleImage;
	
	//3
	//ADD new constructor for the class
	public Gameplay()
	{
		//13. add DEFAULT position of the snake on the panel 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this); //(variable, context of the snake)
		timer.start();
	}
	
	// the built-in method that draws each and everything on the panel
	//2
	public void paint(Graphics g)  
	{
		
		//18. detect if the game has just started,then set the default position of the snake to this 
		//if the game has already started, when in the play mode, moves variable will increment 
		if(moves == 0) {
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;
			
			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;
			
			
		}
		
		//5
		//draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 551, 55);
		
		 //draw the title image 
		titleImage = new ImageIcon("snaketitle.png");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border for gameplay 
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 550, 575); //the images are 25by25 
		
		
		//15. instantiate variable image icon 
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);//draw it 
		//(context, variable of graphics, array, array) 
		//first index will contain the head and the rest of the indices will carry the body of the snake
		 
		
		//17. start a loop , detect the direction of the snake 
		for (int a = 0; a< lengthofsnake; a++){
			
			if (a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
				
			}
			
			if (a==0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
				
			}
			
			if (a==0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
				
			}
			
			if (a==0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
				
			}
			
			//if a!=0 that means the snake head has been drawn and we need to draw the body of the snake 
			if(a!=0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
			
		}
		
		
		
		//14.draw the snake
		g.dispose();
		
		
		
	}

	//12. add unimplemented methods that are required
	//comes from the interface ActionListerner 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		timer.start();
		if(right) {
			for(int r = lengthofsnake-1; r>=0; r--) {
				
				snakeYlength[r+1] = snakeYlength[r];
			}
			for (int r = lengthofsnake; r>=0; r--) {
				
				if(r==0) {
					
					snakeXlength[r] = snakeXlength[r] + 25;
				} else {

					snakeXlength[r] = snakeXlength[r-1];
				}
				// goes past borders
				if (snakeXlength[r]>850) {
					
						snakeXlength[r]=25;
				}
				repaint(); //refreshes the graphics for the new snake
		
			}
		}
		
		if(left) {
			for(int r = lengthofsnake-1; r>=0; r--) {
				
				snakeYlength[r+1] = snakeYlength[r];
			}
			for (int r = lengthofsnake; r>=0; r--) {
				
				if(r==0) {
					
					snakeXlength[r] = snakeXlength[r] - 25;
				} else {

					snakeXlength[r] = snakeXlength[r-1];
				}
				// goes past borders
				if (snakeXlength[r]<25) {
					
						snakeXlength[r]=850;
				}
				repaint(); //refreshes the graphics for the new snake
		
			}
		}
		
		if(up) {
			for(int r = lengthofsnake-1; r>=0; r--) {
				
				snakeXlength[r+1] = snakeXlength[r];
			}
			for (int r = lengthofsnake; r>=0; r--) {
				
				if(r==0) {
					
					snakeYlength[r] = snakeYlength[r] - 25;
				} else {

					snakeYlength[r] = snakeYlength[r-1];
				}
				// goes past borders
				if (snakeXlength[r]<75) {
					
						snakeXlength[r]=625;
				}
				repaint(); //refreshes the graphics for the new snake
		
			}
		}
		
		if(down) {
			for(int r = lengthofsnake-1; r>=0; r--) {
				
				snakeXlength[r+1] = snakeXlength[r];
			}
			for (int r = lengthofsnake; r>=0; r--) {
				
				if(r==0) {
					
					snakeYlength[r] = snakeYlength[r] + 25;
				} else {

					snakeYlength[r] = snakeYlength[r-1];
				}
				// goes past borders
				if (snakeXlength[r]>625) {
					
						snakeXlength[r]=75;
				}
				repaint(); //refreshes the graphics for the new snake
		
			}
		}
	}

	//comes from the interface KeyListerner
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			moves++;
			right =true;
			if(!left) {
				
				right = true;
			}
			else {
				right = false;
				left = true;
			}
			
			up = false;
			down = false;
		}

		


		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			moves++;
			left =true;
			if(!right) {
				
				left = true;
			}
			else {
				left = false;
				right = true;
			}
			
			up = false;
			down = false;
		}
		

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			moves++;
			up =true;
			if(!down) {
				
				up = true;
			}
			else {
				up = false;
				down = true;
			}
			
			left = false;
			right = false;
		}
		

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			moves++;
			down =true;
			if(!up) {
				
				down = true;
			}
			else {
				down = false;
				up = true;
			}
			
			left = false;
			right = false;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
			
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
