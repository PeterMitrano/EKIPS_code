package org.usfirst.frc293.EKIPS.subsystems;

import org.usfirst.frc293.EKIPS.commands.DriveWithGamepad;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends PIDSubsystem {
	private final Talon frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
	private final RobotDrive robotDrive;
	private final AnalogInput rangefinder;

	public DriveBase() {
		super("DriveBase", -1.5, 0.0, -4.0);
		frontLeftMotor = new Talon(3);
		frontRightMotor = new Talon(1);
		backLeftMotor = new Talon(4);
		backRightMotor = new Talon(2);

		robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);

		rangefinder = new AnalogInput(6);
		
		setAbsoluteTolerance(0.15);
	    getPIDController().setContinuous(false);

		LiveWindow.addActuator("DriveBase", "pid", getPIDController());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithGamepad());
	}

	public void drive(Joystick gamepad) {
		robotDrive.tankDrive(-gamepad.getRawAxis(1), -gamepad.getRawAxis(4));
	}

	public double distanceToObstacle() {
		SmartDashboard.putNumber("range", rangefinder.getVoltage());
		return rangefinder.getVoltage();
	}

	@Override
	public boolean onTarget() {
		double e = Math.abs(getPIDController().getError());
		System.out.println("error="+e);
		SmartDashboard.putNumber("error", e);
		return e < 0.15;
	}

	@Override
	protected double returnPIDInput() {
		return distanceToObstacle();
	}

	@Override
	protected void usePIDOutput(double output) {
		
		robotDrive.tankDrive(output,output);
	}
}
