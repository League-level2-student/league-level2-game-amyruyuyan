
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

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
	int mouseX;
	int mouseY;
	Timer frameDraw;
	boolean playIsGreen = false;
	boolean howToPlay = false;
	boolean wires = false;
	boolean redWire = false;
	boolean yellowWire = false;
	boolean blueWire = false;
	boolean magentaWire = false;
	ObjectManager manager = new ObjectManager();
	
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
			manager.draw(g);
			Graphics2D g2 = (Graphics2D) g;
			if(redWire) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(0, 62, mouseX, mouseY));
			}
			if(yellowWire) {
			g2 = (Graphics2D) g;
			g2.setColor(Color.YELLOW);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(0, 160, mouseX, mouseY));
			}
			if(blueWire) {
			g2 = (Graphics2D) g;
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(0, 260, mouseX, mouseY));
			}
			if(magentaWire) {
			g2 = (Graphics2D) g;
			g2.setColor(Color.MAGENTA);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(0, 360, mouseX, mouseY));
			}
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
		mouseX = e.getX();
	    mouseY = e.getY();
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
		
		if (currentState == GAME) {
			wires = true;
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
		redWire = false;
		yellowWire = false;
		blueWire = false;
		magentaWire = false;
		
		
		if (mouseX > 0 && mouseX < 25 && mouseY > 75 && mouseY <  97) {
			redWire = true;
		}
		else{
			redWire = false;
		}
		if (mouseX > 0 && mouseX < 25 && mouseY > 175 && mouseY <  197) {
			yellowWire = true;
		}
		else{
			yellowWire = false;
		}
		if (mouseX > 0 && mouseX < 25 && mouseY > 275 && mouseY <  297) {
			blueWire = true;
		}
		else{
			blueWire = false;
		}
		if (mouseX > 0 && mouseX < 25 && mouseY > 375 && mouseY <  397) {
			magentaWire = true;
		}
		else{
			magentaWire = false; 
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
