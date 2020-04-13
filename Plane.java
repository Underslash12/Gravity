// HIDE
import pkg.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.ArrayList;

public class Plane
{
	private double scale;

	private ArrayList<ObjectWithMass> objects;

	public Plane(double scale)
    {
		this.scale = scale;
		objects = new ArrayList<ObjectWithMass>();
    }

	public void addObject (ObjectWithMass o)
	{
		o.setScale(scale);
		objects.add(o);
	}

	public void simulate (double t)
	{
		if (objects.size() == 0) return;

		ObjectWithMass oi, oj;
		for (int i = 0; i < objects.size(); i++) {
			oi = objects.get(i);
			double aX = 0, aY = 0;
			for (int j = 0; j < objects.size(); j++) {
				if (i == j) continue;
				oj = objects.get(j);

				// acceleration
				// double a = k * oj.getMass() / oi.distanceBetween(oj);
				double a = 3000000 * oj.getMass() / Math.pow(oi.distanceBetween(oj), 2);
				// angle
				double aa = oi.angleBetween(oj);

				// System.out.println(-Math.signum(oi.x - oj.x));
				// System.out.println(-Math.signum(oi.y - oj.y));

				double s = oi.slopeBetween(oj);

				aX += -Math.signum(oi.x - oj.x) * a * Math.cos(aa);
				aY += -Math.signum(oi.y - oj.y) * a * Math.sin(aa);
			}
			oi.aX = aX;
			oi.aY = aY;
		}

		for (ObjectWithMass o : objects) {
			o.run(t);
		}
	}
}
