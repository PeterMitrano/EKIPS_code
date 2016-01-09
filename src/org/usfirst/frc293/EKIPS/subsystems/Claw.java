package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends PIDSubsystem {
	private final Talon motor;
	private final AnalogPotentiometer pot;

	public Claw(int motorPort, int potPort, String nickname) {
		super("claw_"+nickname, 1.0, 0.0, 4.0);

		motor = new Talon(motorPort);
		pot = new AnalogPotentiometer(potPort, 1.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		getPIDController().setSetpoint(0);
		getPIDController().enable();
		
		LiveWindow.addActuator("claw_"+nickname, "motor", motor);
		LiveWindow.addSensor("claw_"+nickname, "pot", pot);
		LiveWindow.addActuator("claw_"+nickname, "PIDSubsystem Controller", getPIDController());
	}

	protected double returnPIDInput() {
		return pot.get();
	}

	protected void usePIDOutput(double output) {
		motor.pidWrite(output);
	}

	protected void initDefaultCommand() {
	}
}
