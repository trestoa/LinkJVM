
/*
 * Very simple line following program.
 */

import libkovan.*;

public class LineFollow {
	public static void main(String[] args){
		Motor leftMotor = new Motor(0);
		Motor rightMotor = new Motor(1);
		Sensor leftSensor = new AnalogSensor(0);
		Sensor rightSensor = new AnalogSensor(1);
		while(true){
		if(leftSensor.getValue() < 600){
		leftMotor.drive(100);
		rightMotor.drive(0);
		}
		else if(rightSensor.getValue() < 600){
		leftMotor.drive(0);
		rightMotor.drive(100);
		}
		else{
		leftMotor.drive(100);
		rightMotor.drive(100);
		}
		}
	}
}
