import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class ObjectManager {
	
ArrayList<WireConnector> wireConnectors;

ObjectManager(){
wireConnectors = new ArrayList<WireConnector>();
wireConnectors.add(new WireConnector(0, 50, 25, 25, Color.RED));
wireConnectors.add(new WireConnector(0, 150, 25, 25, Color.YELLOW));
wireConnectors.add(new WireConnector(0, 250, 25, 25, Color.BLUE));
wireConnectors.add(new WireConnector(0, 350, 25, 25, Color.MAGENTA));

wireConnectors.add(new WireConnector(775, 50, 25, 25, Color.RED));
wireConnectors.add(new WireConnector(775, 150, 25, 25, Color.YELLOW));
wireConnectors.add(new WireConnector(775, 250, 25, 25, Color.BLUE));
wireConnectors.add(new WireConnector(775, 350, 25, 25, Color.MAGENTA));

}


	void draw(Graphics g) {
		for(int i = 0; i < wireConnectors.size(); i++) {
			WireConnector wireConnector = wireConnectors.get(i);
			wireConnector.draw(g);
}
}
}
