import java.awt.Color;

public abstract class Shape implements iDrawnShape {
	
	protected Color color;
	
	public abstract int getCenterX();
	
	public  abstract int getCenterY();
	
	public boolean equals (Object other){
		
		if (this.getClass()!=other.getClass())
			return false;
		Shape otherShape = (Shape) other;
		if (this.color==otherShape.color)
			return true;
		return false;
		
		
	}
	

}
