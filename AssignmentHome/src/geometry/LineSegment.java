
package geometry;


public class LineSegment {

	// defining a start and end point as a Cartesian coordinate 
	private CartesianCoordinate startPoint;
	private CartesianCoordinate endPoint;

	//using the line segment method to retrieve these coordinates 
	public LineSegment(CartesianCoordinate start, CartesianCoordinate end){
		startPoint = start;
		endPoint = end;
	}
	public CartesianCoordinate getStartPoint(){
		return startPoint;
	}

	public CartesianCoordinate getEndPoint(){
		return endPoint;
	}
	// a method to work out the length of the line between these two coordinates.
	public double Length(){

		double Length;
		Length = Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2));

		return Length;

	}
}
