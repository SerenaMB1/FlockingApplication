package Birds;

import java.util.ArrayList;

import javax.swing.SingleSelectionModel;

import dF.Utils;
import drawing.Canvas;


public class randomBirds extends dynamicBird {

	//Setting an initial speed
	private int speed = 50;




	public randomBirds(Canvas canvas) {
		super(canvas);

	}


	public randomBirds(Canvas canvas, double xPosition, double yPosition) {
		super(canvas, xPosition, yPosition);

	}
	//Used to calculate the difference in angle between the desired point and the current point
	public double calculateAngleDifference(double angle1, double angle2){

		double difference = angle2 - angle1 ;
		while(difference < - 180)
			difference +=360;
		while(difference > 180)
			difference -=360;

		return difference;
	}
	//Receives the value from the speed slider and uses this to change the speed at which the animation is updated
	public void update(int time){
		int distance;



		distance = (int)(((double) time/1000) * speed);

		double angle;
		double rand;
		double angularVelocity;
		rand =  Utils.randomDouble();

		if(rand <0.5){
			angle = Utils.randomDouble();

			angle = Math.toDegrees(angle*Math.PI)-90;

			angularVelocity = angle/time;	    
			turn(angularVelocity);
		}

		else {
			//if the random probability is not met the angle 
			//won't change. This will minimise erratic behaviour. 
			turn(0);
		}


		move(distance);

	}


	//Used to calculate the average angle and align the birds to that angle 
	public void alignment(ArrayList<randomBirds> birds, double time, double kA){

		double angleT = 0;
		double averageAngle;
		double angularVelocityA;
		double turnA;


		for (randomBirds ss : birds){
			angleT += ss.getAngle();
		}


		averageAngle = angleT/birds.size();

		turnA = calculateAngleDifference(this.getAngle(), averageAngle);


		kA = (kA/100);


		angularVelocityA = turnA/time;
		turn(angularVelocityA*kA); 



	}

	//Used to calculate the average point and align the birds to move to that point
	public void Cohesion(ArrayList<randomBirds> birds, double time, double kC){


		double xTotal = 0;
		double yTotal = 0;

		double turn;

		double xDiff = 0;
		double yDiff = 0;

		double turnC;
		double averageX = 0;
		double averageY = 0;

		double angularVelocityC;




		for (randomBirds ss : birds){
			xTotal += ss.getxPosition();
			yTotal += ss.getyPosition();


		}


		averageX = xTotal/birds.size();
		averageY = yTotal/birds.size();

		xDiff = averageX - pos.getX();

		yDiff =  pos.getY() - averageY;

		turn = Math.toDegrees(Math.atan2(yDiff, xDiff));	  

		turnC = calculateAngleDifference(this.getAngle(), (turn*-1));
		//turnC = turn - this.getAngle();

		kC = (kC/100);

		angularVelocityC = turnC/time;
		System.out.println(angularVelocityC);

		turn(angularVelocityC*kC);

	}
	//Used to calculate the average point and align the birds to move away from that point
	public void separation(ArrayList<randomBirds> birds, double time, double kS){

		double xTotal = 0;
		double yTotal = 0;

		double turn;
		double angularVelocityS;
		double xDiffS = 0;
		double yDiffS = 0;


		double turnS;
		double averageXS = 0;
		double averageYS = 0;

		for (randomBirds ss : birds){
			xTotal += ss.getxPosition();
			yTotal += ss.getyPosition();

		}

		averageXS = xTotal/birds.size();
		averageYS = yTotal/birds.size();

		xDiffS =  averageXS - pos.getX();

		yDiffS =  pos.getY() - averageYS;

		turn = Math.toDegrees(Math.atan2(yDiffS, xDiffS));	  

		turnS = calculateAngleDifference(this.getAngle()*-1,turn);

		kS = (kS/100);

		angularVelocityS = (turnS/time);

		turn(angularVelocityS*kS);
	}


}




