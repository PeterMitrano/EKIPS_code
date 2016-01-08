package org.usfirst.frc293.EKIPS.subsystems;

import org.usfirst.frc293.EKIPS.commands.DriveWithGamepad;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveBase extends Subsystem {
	private final Talon frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
	private final RobotDrive robotDrive;
	private final AnalogInput rangefinder;

	public DriveBase() {
		frontLeftMotor = new Talon(1);
		LiveWindow.addActuator("DriveBase", "frontLeftMotor", frontLeftMotor);

		frontRightMotor = new Talon(3);
		LiveWindow.addActuator("DriveBase", "frontRightMotor", frontRightMotor);

		backLeftMotor = new Talon(2);
		LiveWindow.addActuator("DriveBase", "backLeftMotor", backLeftMotor);

		backRightMotor = new Talon(4);
		LiveWindow.addActuator("DriveBase", "backRightMotor", backRightMotor);

		robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);

		rangefinder = new AnalogInput(6);
		LiveWindow.addSensor("DriveBase", "rangefinder", rangefinder);

	}

	public void initDefaultCommand() {
    setDefaultCommand(new DriveWithGamepad());
	}

  public void drive(Joystick gamepad){
    robotDrive.tankDrive(gamepad.getRawAxis(1),
        gamepad.getRawAxis(3));
  }

  public int distanceToObstacle(){
    return rangefinder.getValue();
  }
}
