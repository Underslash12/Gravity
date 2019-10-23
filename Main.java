import pkg.*;

public class Main implements InputKeyControl{
	
	public static void main(String... args)
	{
		KeyController kC = new KeyController(Canvas.getInstance(), new Main());
		
		ObjectWMass m = new ObjectWMass(10, 10, 100);
		System.out.println(m.getY());
		Canvas.pause(2000);
		m.aY = 9.8 * 6;
		m.vX = 40;
		while (true) {
			m.run(0.01);
			Canvas.pause(9);
			
			if (m.getY() > 500) {
				m.translateTo(m.getX(), 400);
				m.vY *= -2/3;
			}
		}
		// while (true) {
			// m.run(0.05);
			// Canvas.pause(50);
			// System.out.println(m.getY());
		// }
		// m.run(6);
		// System.out.println(m.getY());
	}
	
	public void keyPress(String s)
	{
		// System.out.println(s);
		if (s.equals("q")) {
			Canvas.getInstance().exit();
		}
	}
}