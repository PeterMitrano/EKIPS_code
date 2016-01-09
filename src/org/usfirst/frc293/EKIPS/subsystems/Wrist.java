package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Wrist extends PIDSubsystem {

  private final Talon motor;
  private final AnalogPotentiometer pot;

  // Initialize your subsystem here
  public Wrist(int motorPort, int potPort, String nickname) {
    super("wrist_"+nickname, 7.0, 0.0, 10.0);
    motor = new Talon(motorPort);
    pot = new AnalogPotentiometer(potPort, 1.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
	getPIDController().setSetpoint(0);
	getPIDController().enable();

    LiveWindow.addActuator("wrist_"+nickname, "motor", motor);
    LiveWindow.addSensor("wrist_"+nickname, "pot", pot);
    LiveWindow.addActuator("wrist_"+nickname, "PIDSubsystem Controller", getPIDController());

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
