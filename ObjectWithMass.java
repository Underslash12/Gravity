// HIDE
import pkg.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class ObjectWithMass
{
	private double screenWidth;
	private double screenHeight;

	private double mass;
	private double scale = 1;

	private boolean hasShape;
	// private Shape s;
	private Rectangle r;

	//position x-component
	public double x;
	//position y-component
	public double y;

	//velocity x-component
	public double vX;
	//velocity y-component
	public double vY;

	//acceleration x-component
	public double aX;
	//acceleration y-component
	public double aY;

	public ObjectWithMass (double x, double y, double kg)
    {
		// System.out.println(y);
        this.x = x;
        this.y = y;
		mass = kg;
		hasShape = false;

		r = new Rectangle(scale * x - 10, scale * y - 10, 20, 20);
		// System.out.println(r);
		r.fill();

		vX = 0;
		vY = 0;
		aX = 0;
		aY = 0;
    }


    // public double getX()
    // {
    //     return x;
    // }
	//
	//
    // public double getY()
    // {
    //     return y;
    // }


	public double getMass ()
	{
		return mass;
	}


	public void setMass (double kg)
	{
		mass = kg;
	}


	// runs a simulation of it for time t in seconds
	public void run (double t)
	{
		double x_dist = vX * t + aX * t * t / 2;
		double y_dist = vY * t + aY * t * t / 2;
		vX += aX * t;
		vY += aY * t;

		x += x_dist;
		y += y_dist;
		r.translate(scale * x_dist, scale * y_dist);
	}

	public void setScale(double s)
	{
		scale = s;
		r.translate(scale * x - x, scale * y - y);
	}

	public double distanceBetween (ObjectWithMass o)
	{
		return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
	}

	public double angleBetween (ObjectWithMass o)
	{
		return Math.atan((y - o.y) / (x - o.x));
	}

	public double slopeBetween (ObjectWithMass o)
	{
		return (y - o.y) / (x - o.x);
	}

	// public double getVMag()
	// {
		// return vM;
	// }


	// public void setVMag(double M)
	// {
		// vM = M;
	// }


	// public double get


	// public void addNewShape(Shape nS)
	// {
		// s = nS;
		// hasShape = true;
	// }


	// public void removeCurrentShape()
	// {
		// s = null;
		// hasShape = false;
	// }

    // public int getWidth()
    // {
        // return (int) Math.round(label.getPreferredSize().getWidth() + 2 * xGrow);
    // }


    // public int getHeight()
    // {
        // return (int) Math.round(label.getPreferredSize().getHeight() + 2 * yGrow);
    // }


    public void translate (double dx, double dy)
    {
        x += dx;
        y += dy;
		// s.translate(dx, dy);
    }


	public void translateTo (double x, double y)
    {
        this.x = x;
        this.y = y;
		// s.translate(-s.getX() + x, -s.getY() + y);
	}

    // public void draw()
    // {
        // Canvas.getInstance().show(this);
		// s.draw();
    // }

    public String toString ()
    {
        return "ObjectWMass[x = " + x + ", y = " + y + ", mass = " + mass + "]";
    }
}
