package org.usfirst.frc293.EKIPS.subsystems;

import org.usfirst.frc293.EKIPS.commands.ResetFlipper;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flipper extends Subsystem {

	private static final double EXTENDED_POSITION = 1.5;
	private Talon motor;
	private Servo trigger;
	private AnalogPotentiometer pot;

	public Flipper() {
		motor = new Talon(5);
		trigger = new Servo(10);
		pot = new AnalogPotentiometer(1, 1.0, 0.0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ResetFlipper());
	}

	public void windup() {
		motor.set(1);
	}

	public void stop() {
		motor.set(0);
	}

	public void pullTrigger() {
		trigger.set(0);
		stop();
	}

	public void setTrigger() {
		trigger.set(1);
	}

	public boolean isReset() {
		return pot.get() <= 0;
	}

	public boolean fullyExtended() {
		SmartDashboard.putNumber("flipper pos", pot.get());
		return pot.get() > EXTENDED_POSITION;
	}

}
