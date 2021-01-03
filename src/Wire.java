import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;

public class Wire extends GameObject{
	

	Color color;
	boolean isSelected = false;
	WireConnector start;
	WireConnector end;
	boolean isConnected = false;
	
	Wire(int x, int y, int width, int height, Color color, WireConnector start, WireConnector end) {
		super(x, y, width, height);
		this.color = color;
		this.start = start;
		this.end = end;
		start.color = color;
		end.color = color;
		
		// TODO Auto-generated constructor stub
	}
	
	void draw(Graphics g) {
		start.draw(g);
		end.draw(g);
		if(isConnected) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(color);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(start.x, start.y, end.x, end.y));
		}
		else if(isSelected) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(color);
			g2.setStroke(new BasicStroke(25));
			g2.draw(new Line2D.Float(start.x, start.y, x, y));
		}
	}
	
	void update (int x, int y) {
super.update();
this.x = x;
this.y = y;
}
}
