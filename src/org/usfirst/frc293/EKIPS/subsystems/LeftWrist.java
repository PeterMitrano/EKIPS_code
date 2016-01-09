package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LeftWrist extends PIDSubsystem {

  private final Talon motor;
  private final AnalogPotentiometer pot;

  // Initialize your subsystem here
  public LeftWrist() {
    super("wrist_l", 7.0, 0.0, 10.0);
    motor = new Talon(7);
    pot = new AnalogPotentiometer(3, 1.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
	getPIDController().setSetpoint(-1.5707);
	getPIDController().enable();

    LiveWindow.addActuator("wrist_l", "motor", motor);
    LiveWindow.addSensor("wrist_l", "pot", pot);
    LiveWindow.addActuator("wrist_l", "PIDSubsystem Controller", getPIDController());

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
