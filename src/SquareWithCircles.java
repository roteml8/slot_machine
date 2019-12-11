import java.awt.Color;
import java.awt.Graphics;

public class SquareWithCircles extends Square {
	
	public SquareWithCircles (Color color){
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		super.draw(g);
		FilledCircle leftCircle = new FilledCircle(this.color);
		leftCircle.setX(this.getCenterX()-getWidth()/2);
		leftCircle.setY(this.getCenterY());
		leftCircle.setRadius(getWidth()/3);
		leftCircle.draw(g);
		FilledCircle rightCircle = new FilledCircle(this.color);
		rightCircle.setX(this.getCenterX()+getWidth()/2);
		rightCircle.setY(getCenterY());
		rightCircle.setRadius(getWidth()/3);
		rightCircle.draw(g);
		
	}
}


 