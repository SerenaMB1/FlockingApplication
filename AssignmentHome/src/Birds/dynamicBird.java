package Birds;


import drawing.Canvas;
import drawing.birds;
import geometry.CartesianCoordinate;
import geometry.LineSegment;



public class dynamicBird extends birds {
	//defining a speed
	private int speed = 100;
	private double angle;



	private double angle2;
	CartesianCoordinate posEnd;

	public dynamicBird(Canvas canvas) {
		super(canvas);
		draw();
	}


	//method overloading
	public dynamicBird(Canvas canvas, double xPosition, double yPosition) {

		super(canvas);

		//defining new setof coordinates
		posEnd = new CartesianCoordinate(xPosition,yPosition);

		//defining starting pos of turtle to move to and start at new defined
		//coordinates
		LineSegment posLength = new LineSegment(pos, posEnd);

		//working out the new angle for the new starting coordinates
		angle = Math.atan(yPosition/xPosition);

		//converting angle to degrees
		angle2 = Math.toDegrees(angle);

		//turning new angle 
		turn(angle2);

		//moving length to new coordinates
		move(posLength.Length());

		draw();





	}
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




	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	//This update function will be used to update the bird over a distance with
	//relation to speed and time.
	public void update(int time){
		int distance;

		distance = (int)(((double) time/1000) * speed);


		putPenUp();
		move(distance);

	}


}


