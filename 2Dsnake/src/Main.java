import java.awt.Color;

import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args)
	{
		JFrame obj = new JFrame();  // The window that all game runs 
		Gameplay gameplay = new Gameplay(); // New object for Gameplay class 
		
		//Properties 
		obj.setBounds(10, 10, 905, 700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);  // User may not resize the window 
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add panel and implement it inside the frame
		obj.add(gameplay); // Add the obj of Gameplay to the obj of JFrame 

		
		
	}

}
