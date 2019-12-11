import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SlotMachinePanel extends JPanel implements ISlotMachine {


	private final static double SLOT_MACHINE_WIDTH_FRACTION = 0.8;
	private final static int RADIUS_DIVISOR = 6;
	private final static double SLOT_MACHINE_HEIGHT_DIVISOR = 1.4;
	
	private Square mainMachineCell = new Square(Color.black);
	private Square rightCell = new Square(Color.black);
	private Square leftCell = new Square(Color.black);
	private Square midCell = new Square(Color.black);
	
	private Shape[] shapesAtCells = new Shape[3]; // saves current shapes of all cells 
	private int[] randoms = new int[3]; // saves values of random integers for each cell 
	private boolean isWin; //boolean value to save current game's result 
	public static int flag=0; // a flag to keep count of the games, also a flag for first game 
	
	

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		//get the shortest length when resized
		int minPanelLength = Math.min(panelWidth, panelHeight);
		
		double slotMachineWidth = minPanelLength * SLOT_MACHINE_WIDTH_FRACTION;

		int xCenter = panelWidth / 2;
		int yCenter = panelHeight / 2;

		//set the squares for the slot machine skeleton
		setSquares((int) slotMachineWidth, xCenter, yCenter);
		
		

		g.setColor(Color.black);

		mainMachineCell.draw(g);
		leftCell.draw(g);
		rightCell.draw(g);
		midCell.draw(g);
		
		if (flag!=0){ // if not first paint, draw shapes
			for (int i=0;i<shapesAtCells.length;i++)
				getShapeAtIndex(i).draw(g);
		}
		

	}

	// setting all cells and assigning shapes to the array 
	private void setSquares(int slotMachinLength,
			int xCenter, int yCenter) {

		mainMachineCell.setWidth(slotMachinLength);
		mainMachineCell.setxTopLeft(xCenter - (slotMachinLength / 2));
		int mainBottomY = yCenter - slotMachinLength / 2;
		mainMachineCell.setyTopLeft((int)(mainBottomY/SLOT_MACHINE_HEIGHT_DIVISOR));
		leftCell.setWidth(slotMachinLength/4);
		leftCell.setxTopLeft(mainMachineCell.getxTopLeft()+slotMachinLength/16);
		leftCell.setyTopLeft(mainMachineCell.getyTopLeft()+35);
		midCell.setWidth(slotMachinLength/4);
		midCell.setxTopLeft(leftCell.getxTopLeft()+5*slotMachinLength/16);
		midCell.setyTopLeft(leftCell.getyTopLeft());
		rightCell.setWidth(slotMachinLength/4);
		rightCell.setxTopLeft(midCell.getxTopLeft()+5*slotMachinLength/16);
		rightCell.setyTopLeft(leftCell.getyTopLeft());
		shapesAtCells[0] = createShape(randoms[0],leftCell);
		shapesAtCells[1]= createShape(randoms[1],midCell);
		shapesAtCells[2]= createShape(randoms[2],rightCell);
		
		

	}


	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	public Shape createShape(int index, Square cell) {

		switch (index) {
		case 0:
			FilledCircle fc = new FilledCircle(Color.RED);
			setFilledCircle(fc, cell);
			return fc;

		case 1:
			SquareWithCircles swc = new SquareWithCircles(Color.BLACK);
			setSquareWithCircles(swc, cell);
			return swc;

		case 2:
			PizzaShape ps = new PizzaShape(Color.orange);
			setPizza(ps, cell);
			return ps;

		}
	
		return null;

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	private void setFilledCircle(FilledCircle fc, Square cell){
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		fc.setRadius(radius);
		fc.setX(cell.getCenterX());
		fc.setY(cell.getCenterY());
	}

	/**
	 * sets a PizzaShape size to fit the center of a cell
	 */
	private void setPizza(PizzaShape ps, Square cell){
		setFilledCircle(ps,cell);
	}
	
	/**
	 * sets a SquareWithCircles size to fit the center of a cell
	 */
	private void setSquareWithCircles(SquareWithCircles swc, Square cell){
		
		swc.setWidth((cell.getWidth()/RADIUS_DIVISOR)*2);
		swc.setxTopLeft(cell.getxTopLeft()+cell.getWidth()/3);
		swc.setyTopLeft(cell.getyTopLeft()+cell.getWidth()/3);
	
	}


	@Override
	// getting each cell's random integer, checking for a win, increasing flag by 1 and repainting the panel
	public void play() {
		for (int i=0;i<randoms.length;i++)
			randoms[i]=getRandomInt();
		if (randoms[0]==randoms[1] && randoms[1]==randoms[2])
			isWin = true; 
		else
			isWin = false;
		flag++;
		repaint();
		
		
	}
	


	@Override
	public Shape getShapeAtIndex(int index) {
		return shapesAtCells[index];
	}
	
	//getting a random integer in the range of 0-3 
	public int getRandomInt(){
		return (int)(Math.random()*3);
	}
	
	// returning current game's result 
	public boolean getIsWin (){
		return isWin;
	}
	
	
}
