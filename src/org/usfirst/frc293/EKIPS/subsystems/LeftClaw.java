package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LeftClaw extends PIDSubsystem {

  private final Talon motor;
  private final AnalogPotentiometer pot;

  // Initialize your subsystem here
  public LeftClaw() {
    super("claw_l", -1.0, 0.0, -4.0);
    motor = new Talon(9);
    pot = new AnalogPotentiometer(5, 1.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
	getPIDController().setSetpoint(-1.5707);
	getPIDController().enable();

    LiveWindow.addActuator("claw_l", "motor", motor);
    LiveWindow.addSensor("claw_l", "pot", pot);
    LiveWindow.addActuator("claw_l", "PIDSubsystem Controller", getPIDController());

  }

  public void initDefaultCommand() {
  }

  protected double returnPIDInput() {
    return pot.get();
  }

  protected void usePIDOutput(double output) {
    motor.pidWrite(output);
  }
}
