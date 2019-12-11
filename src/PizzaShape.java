import java.awt.Color;
import java.awt.Graphics;

public class PizzaShape extends FilledCircle {
	
	
	
	public PizzaShape (Color color){
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		for(int i=10; i<360; i+=40){
			g.fillArc(getCenterX()-getRadius(), getCenterY()-getRadius(), getRadius()*2, getRadius()*2, i, 30);
		}
	}





}
