//HIDE
import pkg.*;

public class ObjectWMass
{
	private double x;
	private double y;
	private double mass;
	
	private boolean hasShape;
	private Shape s;
	
	//velocityMagnitude
	private double vM;
	//velocityDirection
	private double vD;
	
	//accelerationMagnitude
	private double aM;
	//accelerationDirection
	private double aD;
	
	public ObjectWMass(double x, double y, double kg)
    {
        this.x = x;
        this.y = y;
		mass = kg;
		hasShape = false;
    }
    
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
	
	public double getMass()
	{
		return mass;
	}
	
	public void setMass(double kg)
	{
		mass = kg;
	}
	
	public void addNewShape(Shape nS)
	{
		s = nS;
		hasShape = true;
	}
	
	public void removeCurrentShape()
	{
		s = null;
		hasShape = false;
	}
	
    // public int getWidth()
    // {
        // return (int) Math.round(label.getPreferredSize().getWidth() + 2 * xGrow);
    // }

  
    // public int getHeight()
    // {
        // return (int) Math.round(label.getPreferredSize().getHeight() + 2 * yGrow);
    // }
    
    
    public void translate(double dx, double dy)
    {
        x += dx;
        y += dy;
		s.translate(dx, dy);
        // Canvas.getInstance().repaint();
    }   

	public void translateTo(double x, double y)
    {
        this.x = x;
        this.y = y;
		s.translate(-s.getX() + x, -s.getY() + y);
        // Canvas.getInstance().repaint();
    } 	
    
    // public void draw()
    // {
        // Canvas.getInstance().show(this);
		// s.draw();
    // }
   
    public String toString()
    {
        return "ObjectWMass[x = " + getX() + ", y = " + getY() + ", mass = " + mass + "]";
    }
}
