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
  public Wrist(int motorPort, int potPort) {
    super("Wrist", 1.0, 0.0, 0.0);
    motor = new Talon(motorPort);
    pot = new AnalogPotentiometer(potPort, 1.0, 0.0);

    LiveWindow.addActuator("Wrist", "motor", motor);
    LiveWindow.addSensor("Wrist", "pot", pot);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
    LiveWindow.addActuator("Wrist", "PIDSubsystem Controller", getPIDController());

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
