import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class ObjectManager {
	
ArrayList<Wire> wires;

ObjectManager(){
//wireConnectors = new ArrayList<WireConnector>();
//wireConnectors.add(new WireConnector(0, 50, 25, 25, Color.RED));
//wireConnectors.add(new WireConnector(0, 150, 25, 25, Color.YELLOW));
//wireConnectors.add(new WireConnector(0, 250, 25, 25, Color.BLUE));
//wireConnectors.add(new WireConnector(0, 350, 25, 25, Color.MAGENTA));

//wireConnectors.add(new WireConnector(775, 50, 25, 25, Color.RED));
//wireConnectors.add(new WireConnector(775, 150, 25, 25, Color.YELLOW));
//wireConnectors.add(new WireConnector(775, 250, 25, 25, Color.BLUE));
//wireConnectors.add(new WireConnector(775, 350, 25, 25, Color.MAGENTA));
	wires = new ArrayList<Wire>();
	wires.add(new Wire(0, 0, 0, 0, Color.RED, new WireConnector(0, 50, 25, 25), new WireConnector(775, 50, 25, 25)));
	wires.add(new Wire(0, 0, 0, 0, Color.YELLOW, new WireConnector(0, 150, 25, 25), new WireConnector(775, 150, 25, 25)));
	wires.add(new Wire(0, 0, 0, 0, Color.BLUE, new WireConnector(0, 250, 25, 25), new WireConnector(775, 250, 25, 25)));
	wires.add(new Wire(0, 0, 0, 0, Color.MAGENTA, new WireConnector(0, 350, 25, 25), new WireConnector(775, 350, 25, 25)));
}


	void draw(Graphics g) {
		for(int i = 0; i < wires.size(); i++) {
			Wire wire = wires.get(i);
			wire.draw(g);
}
}
	void wireClicked(int mouseX, int mouseY){
		for (int l = 0; l < wires.size(); l++) {
			Wire wire = wires.get(l);
			WireConnector connector = wire.start;
			if (connector.collisionBox.contains(mouseX, mouseY)) {
				wire.isSelected = true;
				System.out.println(wire.isSelected);
			}
			else {
				wire.isSelected = false;
			}
		}
	}
	
	void wireMoved(int mouseX, int mouseY) {
		for(int m = 0; m < wires.size(); m++) {
			Wire wire = wires.get(m);
			wire.x = mouseX;
			wire.y = mouseY;
		}
	}
	
	
	
	
}
