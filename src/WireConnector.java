import java.awt.Color;
import java.awt.Graphics;

public class WireConnector extends GameObject{

	Color color;
	
	WireConnector(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
	}
	
}
