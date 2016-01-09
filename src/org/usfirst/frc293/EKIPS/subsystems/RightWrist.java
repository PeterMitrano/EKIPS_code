package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class RightWrist extends PIDSubsystem {

  private final Talon motor;
  private final AnalogPotentiometer pot;

  // Initialize your subsystem here
  public RightWrist() {
    super("wrist_r", 7.0, 0.0, 10.0);
    motor = new Talon(6);
    pot = new AnalogPotentiometer(2, 1.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
	getPIDController().setSetpoint(-1.5707);
	getPIDController().enable();

    LiveWindow.addActuator("wrist_r", "motor", motor);
    LiveWindow.addSensor("wrist_r", "pot", pot);
    LiveWindow.addActuator("wrist_r", "PIDSubsystem Controller", getPIDController());

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
