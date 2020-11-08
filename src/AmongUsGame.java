import javax.swing.JFrame;

public class AmongUsGame {

	AmongUsGamePanel GamePanel; 
	JFrame frame;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	
	public static void main(String[] args){
		AmongUsGame AmongUsGame = new AmongUsGame();
		AmongUsGame.setup();
	}
	
	void setup() {
		frame = new JFrame();
		GamePanel = new AmongUsGamePanel();
		frame.add(GamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.addMouseMotionListener(GamePanel);
		frame.addMouseListener(GamePanel);
	}
}
