package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class RightClaw extends PIDSubsystem {

  private final Talon motor;
  private final AnalogPotentiometer pot;

  // Initialize your subsystem here
  public RightClaw() {
    super("claw_r", -1.0, 0.0, -4.0);
    motor = new Talon(8);
    pot = new AnalogPotentiometer(4, 1.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
	getPIDController().setSetpoint(-1.5707);
	getPIDController().enable();

    LiveWindow.addActuator("claw_r", "motor", motor);
    LiveWindow.addSensor("claw_r", "pot", pot);
    LiveWindow.addActuator("claw_r", "PIDSubsystem Controller", getPIDController());

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
