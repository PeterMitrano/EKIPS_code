package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends PIDSubsystem {
	private final Talon motor;
	private final AnalogPotentiometer pot;
	private String name;

	public Claw(int motorPort, int potPort, String name) {
		super(name, 1.0, 0.0, 4.0);
		this.name = name;
		motor = new Talon(motorPort);
		pot = new AnalogPotentiometer(potPort, 1.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		getPIDController().setSetpoint(0);
		getPIDController().enable();

		LiveWindow.addActuator(this.name, "motor", motor);
		LiveWindow.addSensor(this.name, "pot", pot);
		LiveWindow.addActuator(this.name, "PIDSubsystem Controller", getPIDController());
	}

	protected double returnPIDInput() {
		return pot.get();
	}

	@Override
	public boolean onTarget() {
		double e = Math.abs(getPIDController().getError());
//		System.out.println(name+", "+e);
		return e < .15;
	}

	protected void usePIDOutput(double output) {
		if (!Double.isNaN(output)) {
			motor.pidWrite(output);
		}
	}

	protected void initDefaultCommand() {
	}
}
