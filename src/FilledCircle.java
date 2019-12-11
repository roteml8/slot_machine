import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle extends Shape {
	
	private int radius;
	private int x;
	private int y;
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public FilledCircle(Color color){
		this.color=color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(x-radius,y-radius,radius*2,radius*2);
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public int getCenterX() {
		return x;
	}

	@Override
	public int getCenterY() {
		return y;
	}

}
