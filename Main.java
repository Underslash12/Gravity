import pkg.*;

public class Main implements InputKeyControl, InputControl{

	static Plane p;

	public static void main(String... args)
	{
		KeyController kC = new KeyController(Canvas.getInstance(), new Main());
		MouseController mC = new MouseController(Canvas.getInstance(), new Main());

		Rectangle r;

		ObjectWithMass m1 = new ObjectWithMass(600, 600, 50);
		m1.vX = 50;
		ObjectWithMass m2 = new ObjectWithMass(600, 400, 50);
		m2.vX = -50;

		p = new Plane(1);
		p.addObject(m1);
		p.addObject(m2);

		// System.out.println(m1.angleBetween(m2));
		// System.out.println(m2.angleBetween(m1));

		Canvas.pause(2000);
		while (true) {
			p.simulate(0.000003);
			// Canvas.pause(10);

		}
	}

	public void onMousePress(double x, double y)
	{
		p.addObject(new ObjectWithMass(x, 1080 - y, 500));
	}
	public void onMouseRelease(double x, double y){}
	public void onMouseDrag(double x, double y){}
	public void onMouseMove(double x, double y){}
	public void onMouseEnter(double x, double y){}
	public void onMouseExit(double x, double y){}
	public void onMouseClick(double x, double y){}

	public void keyPress(String s)
	{
		// System.out.println(s);
		if (s.equals("q")) {
			Canvas.getInstance().exit();
		}
	}
}
