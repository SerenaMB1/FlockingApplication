package drawing;


import drawing.Canvas;
import geometry.CartesianCoordinate;

public class birds {

	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}

	CartesianCoordinate position;
	int angle=0;
	boolean isPenDown;
	Canvas myCanvas;
	public CartesianCoordinate pos; 


	public double getxPosition() {
		return pos.getX();
	}
	public double getyPosition() {
		return pos.getY();
	}



	//Class used to draw the bird and initialises turn and move methods
	public birds(Canvas myCanvas) {
		this.myCanvas = myCanvas;
		pos = new CartesianCoordinate(0,0);
		isPenDown = false; 


	}
	//The move method will calculate the exact amount to move in the 
	//current facing direction using the x and y (cos and sin) components
	public void move(double i) {
		double newX;
		double newY;



		newX =  (pos.getX() + i*Math.cos(Math.toRadians(angle)));
		newY =  (pos.getY() + i*Math.sin(Math.toRadians(angle)));


		if(isPenDown == true){
			myCanvas.drawLineBetweenPoints(pos, new CartesianCoordinate(newX,newY));
		}
		pos = new CartesianCoordinate(newX,newY);
	}

	//the turn angle will be either turned left or right depending on the input angle. 
	public void turn(double i) {


		angle += i;
		if(angle<0) angle+=360;
		if(angle>360) angle-=360;


	}
	//Takes the drawing pen off the paper 
	public void putPenUp() {
		isPenDown = false;		
	}
	//puts the drawing pen on the paper 
	public void putPenDown() {
		isPenDown = true;

	}
	//Undraws the 3 lines which make the bird
	public void undraw(){


		for(int i = 0; i < 3; i++){
			myCanvas.removeMostRecentLine();
		}

		myCanvas.repaint();

	}
	//Draws the 3 lines which makes the bird
	public void draw() {
		putPenDown();


		turn(150);
		move(20);
		turn(120);
		move(20);
		turn(120);
		move(20);
		turn(-30);
		putPenUp();
	}


	//Wraps the birds to the current size of the frame, when the go off the edge they 
	//appear on the opposite side of the screen.
	public void wrapPosition(int maxX, int maxY){
		if(pos.getX() >= maxX){
			undraw();
			pos.setxPosition(0.0);
			draw();
			move(10);

		}
		if(pos.getX() <= 0){
			undraw();
			pos.setxPosition(maxX);

			draw();
			move(-10);
		}	
		if(pos.getY() >= maxY){
			undraw();
			pos.setyPosition(0.0);
			draw();
			move(10);

		}
		if(pos.getY() <= 0){
			undraw();
			pos.setyPosition(maxY);
			draw();
			move(10);
		}

	}
}

