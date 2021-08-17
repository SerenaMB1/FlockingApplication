package geometry;

//the Cartesian Coordinate class store each of the coordinates of the Birds
//There is also a testing method which displays the coordinates as a string if 
//needed
public class CartesianCoordinate {
	private double xPosition;

	private double yPosition;

	public CartesianCoordinate(double x, double y){
		xPosition = x;
		yPosition = y;
	}

	public String toString(){
		return "(" + xPosition + "," + yPosition + ")";
	}

	public double getX(){
		return xPosition;
	}

	public double getY(){
		return yPosition;
	}
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

}

