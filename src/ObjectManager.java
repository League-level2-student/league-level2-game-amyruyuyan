import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class ObjectManager {
	
ArrayList<WireConnector> wireConnectors;

ObjectManager(){
wireConnectors = new ArrayList<WireConnector>();
wireConnectors.add(new WireConnector(0, 20, 5, 5, Color.RED));
wireConnectors.add(new WireConnector(0, 40, 5, 5, Color.YELLOW));
wireConnectors.add(new WireConnector(0, 60, 5, 5, Color.BLUE));
wireConnectors.add(new WireConnector(0, 80, 5, 5, Color.MAGENTA));
}



	void draw(Graphics g) {
		for(int i = 0; i < wireConnectors.size(); i++) {
			WireConnector wireConnector = wireConnectors.get(i);
			wireConnector.draw(g);
}
}
}
