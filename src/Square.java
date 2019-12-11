import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
	
	private int width;
	private int xTopLeft;
	private int yTopLeft;
	
	public Square(Color color){
		this.color=color;
	}

	public int getWidth() {
		return width;
	}

	public int getxTopLeft() {
		return xTopLeft;
	}

	public int getyTopLeft() {
		return yTopLeft;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setxTopLeft(int xTopLeft) {
		this.xTopLeft = xTopLeft;
	}

	public void setyTopLeft(int yTopLeft) {
		this.yTopLeft = yTopLeft;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawRect(xTopLeft,yTopLeft, width, width);
		
	}

	@Override
	public int getCenterX() {
		return xTopLeft+(width/2);
	}

	@Override
	public int getCenterY() {
		return yTopLeft+(width/2);
	}

}
