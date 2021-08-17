

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Hashtable;

import Birds.randomBirds;
import dF.Utils;
import drawing.Canvas;



public class assignmentMain {


	//Initial Coordinates
	public double x = 100.0;
	public double y = 100.0;

	//
	double addX;
	double addY;

	//initial amount of birds
	int maxBirds = 10;
	double rand;

	//Declaring 
	ArrayList<randomBirds> birds;

	//Bird Speed - Slider values 
	//Initial time increments
	int deltaTime;
	static final int speedMin = 20;
	static final int speedMax = 100;
	static final int speedInit = 20;

	//Alignment - Slider values 
	//
	double kA;
	static final int alignmentMin = 0;
	static final int alignmentMax = 100;
	static final int alignmentInit = 0;

	//Alignment - Slider values 
	//
	double kC;
	static final int cohesionMin = 0;
	static final int cohesionMax = 100;
	static final int cohesionInit = 0;

	//Alignment - Slider values 
	//
	double kS;
	static final int seperationMin = 0;
	static final int seperationMax = 100;
	static final int seperationInit = 0;

	//Game loop
	boolean continueRunning = true;


	public assignmentMain() {


		//SLIDER - Bird Speed

		deltaTime = speedInit;

		//Declaring new instance of slider
		JSlider birdSpeed = new JSlider(JSlider.HORIZONTAL, speedMin,speedMax,speedInit);
		//adding ticks to the slider
		birdSpeed.setMajorTickSpacing(20);
		birdSpeed.setMinorTickSpacing(5);
		birdSpeed.setPaintTicks(true);
		birdSpeed.setPaintLabels(true);
		Hashtable speed = new Hashtable();
		speed.put(new Integer(50), new JLabel("Speed"));
		birdSpeed.setLabelTable(speed);

		birdSpeed.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e){
				deltaTime = birdSpeed.getValue();
			}
		});


		//Slider For Alignment 

		kA = alignmentInit;
		//Declaring new instance of slider
		JSlider alignment = new JSlider(JSlider.HORIZONTAL, alignmentMin,alignmentMax,alignmentInit);
		//adding ticks to the slider
		alignment.setMajorTickSpacing(25);
		alignment.setMinorTickSpacing(5);
		alignment.setPaintTicks(true);
		alignment.setPaintLabels(true);
		Hashtable alignment1 = new Hashtable();
		alignment1.put(new Integer(50), new JLabel("Alignment"));
		alignment.setLabelTable(alignment1);

		alignment.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e){
				kA = alignment.getValue();


			}
		});

		//Slider For Cohesion 

		kC = cohesionInit;
		//Declaring new instance of slider
		JSlider Cohesion = new JSlider(JSlider.HORIZONTAL, cohesionMin,cohesionMax,cohesionInit);
		//adding ticks to the slider
		Cohesion.setMajorTickSpacing(25);
		Cohesion.setMinorTickSpacing(5);
		Cohesion.setPaintTicks(true);
		Cohesion.setPaintLabels(true);
		Hashtable Cohesion1 = new Hashtable();
		Cohesion1.put(new Integer(50), new JLabel("Cohesion"));
		Cohesion.setLabelTable(Cohesion1);

		Cohesion.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e){
				kC = Cohesion.getValue();


			}
		});

		//Slider For separation 

		kS = seperationInit;
		//Declaring new instance of slider
		JSlider separation = new JSlider(JSlider.HORIZONTAL, cohesionMin,cohesionMax,cohesionInit);
		//adding ticks to the slider
		separation.setMajorTickSpacing(25);
		separation.setMinorTickSpacing(5);
		separation.setPaintTicks(true);
		separation.setPaintLabels(true);
		Hashtable separation1 = new Hashtable();
		separation1.put(new Integer(50), new JLabel("Separation"));
		separation.setLabelTable(separation1);

		separation.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e){
				kS = separation.getValue();


			}
		});


		//Instantiating new frame
		JFrame frame = new JFrame(); 
		//Instantiating new canvas
		Canvas canvas = new Canvas();
		//Instantiating new label for program title 
		JLabel label = new JLabel("Flockety Flock Flock");
		//Instantiating new Lower panel 
		JPanel lowerpanel = new JPanel();
		//Instantiating new button to add more birds to the frame
		JButton addBirdButton = new JButton("Add new bird");

		JButton removeBirdButton = new JButton("Remove Bird");

		//Changing lower panel layout from border to flowlayout
		lowerpanel.setLayout(new FlowLayout());



		//adding items to the frame
		frame.setTitle("Flock the Frame");
		frame.setSize(1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(canvas);
		frame.add(lowerpanel, BorderLayout.SOUTH);

		//adding items to the canvas
		canvas.add(label);

		//adding items to the lower panel

		lowerpanel.add(addBirdButton, BorderLayout.PAGE_END);
		lowerpanel.add(removeBirdButton, BorderLayout.PAGE_END);
		lowerpanel.add(birdSpeed,BorderLayout.PAGE_END);
		lowerpanel.add(alignment,BorderLayout.PAGE_END);
		lowerpanel.add(Cohesion,BorderLayout.PAGE_END);
		lowerpanel.add(separation,BorderLayout.PAGE_END);


		label.setHorizontalAlignment(SwingConstants.CENTER);

		//instantiating new array list for the birds
		ArrayList<randomBirds> birds = new ArrayList<randomBirds>();

		//Adding and listening for the add bird button
		addBirdButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				System.out.println("Button Clicked!");
				addBirdButton.setText("done");
				double xCoordinate = x+(int)addX ;
				double yCoordinate = y+(int)addY;

				addX = (Utils.randomDouble())*500;
				addY = (Utils.randomDouble())*500;

				birds.add(new randomBirds(canvas, xCoordinate, yCoordinate));
			}

		});

		//Adding and listening for the add bird button
		removeBirdButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				System.out.println("Button Clicked!");			 
				birds.remove(0).undraw();

			}

		});

		//Loop used to add the initial 10 birds to the flock 
		for (int i  = 0; i < maxBirds; i++){

			double xCoordinate = x+(int)addX ;
			double yCoordinate = y+(int)addY;
			//Used to randomise the angles in which they appear on the screen 
			addX = (Utils.randomDouble())*500;
			addY = (Utils.randomDouble())*500;
			//Adds the birds to the array as they are made 
			birds.add(new randomBirds(canvas, xCoordinate, yCoordinate));			
		}

		// game loop
		// The game loop will undraw then update and then draw each bird again to 
		//ensure the smooth running of the graphics. 
		while (continueRunning) {

			Utils.pause(deltaTime);

			for (randomBirds ss: birds) {
				ss.undraw();
			}

			for (randomBirds ss: birds) {

				ss.update(deltaTime);
			}

			for (randomBirds ss : birds) {
				ss.draw();

			}
			for ( randomBirds ss : birds){
				//these are the flocking methods that have been asigned to the 
				//array.
				ss.alignment(birds, deltaTime, kA);
				ss.Cohesion(birds, deltaTime, kC);
				ss.separation(birds, deltaTime, kS);
				ss.wrapPosition(1200,900);

			}

		}

	}


	public static void main(String[] args) {
		new assignmentMain(); 

	}	

}