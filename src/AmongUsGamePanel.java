
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AmongUsGamePanel extends JPanel implements MouseMotionListener, ActionListener, MouseListener {
	Font titleFont;
	Font secondFont;
	Font thirdFont;
	Font endFont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState;
	Timer frameDraw;
	boolean playIsGreen = false;
	boolean howToPlay = false;
	
	AmongUsGamePanel(){
		currentState = MENU;
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		titleFont = new Font("Courier New", Font.PLAIN, 96);
		secondFont = new Font("Courier New", Font.PLAIN, 48);
		thirdFont = new Font("Courier New", Font.PLAIN, 36);
	}
	
		void drawMenuState(Graphics g){
			g.setColor(Color.black);
			g.fillRect(0, 0, AmongUsGame.WIDTH, AmongUsGame.HEIGHT);
			
			g.setFont(titleFont);
			g.setColor(Color.white);
			g.drawString("Among Us", 170, 100);
			
			g.setFont(secondFont);
			g.setColor(Color.white);
			g.drawString("Press 'Play' To Play", 100, 350);
			
			if (playIsGreen) {
			g.setFont(secondFont);
			g.setColor(Color.green);
			g.drawString("Play", 303, 350);
			}
			
			g.setFont(thirdFont);
			g.setColor(Color.white);
			g.drawString("Press 'How To Play' For Instructions", 5, 225);
			
			if (howToPlay) {
				g.setFont(thirdFont);
				g.setColor(Color.green);
				g.drawString("How To Play", 159, 225);
				}
		}
	
		void drawGameState(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 450);
		}
		
		void drawEndState(Graphics g) {
			
		}
		
		public void paintComponent(Graphics g){
			if(currentState == MENU){
			    drawMenuState(g);}		
			else if(currentState == GAME) {
				drawGameState(g);
			}
			else if(currentState == END){
		    drawEndState(g);
		}
		}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (mouseX >288 && mouseX < 432 && mouseY > 344 && mouseY < 383) {
			playIsGreen = true;
		}
		else {
			playIsGreen = false;
		}
		if (mouseX > 147 && mouseX < 411 && mouseY > 228 && mouseY < 253) {
			howToPlay = true;
		}
		else {
			howToPlay = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    //updateMenuState();
		}else if(currentState == GAME){
		    //updateGameState();
		}else if(currentState == END){
		    //updateEndState();
		    
		}
		//System.out.println("action");
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("X " + e.getX());
		System.out.println("Y " + e.getY());
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (mouseX > 147 && mouseX < 411 && mouseY > 228 && mouseY < 253) {
			JOptionPane.showMessageDialog(null, "drag the same colored wires together to complete the task");
		}
		if (mouseX >288 && mouseX < 432 && mouseY > 344 && mouseY < 383) {
			currentState = GAME;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	}
