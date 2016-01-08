package org.usfirst.frc293.EKIPS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Claw extends PIDSubsystem {
  private final Talon motor;
  private final AnalogPotentiometer pot;

  public Claw(int motorPort, int potPort) {
    super("claw", 1.0, 0.0, 0.0);

    motor = new Talon(motorPort);
    LiveWindow.addActuator("claw", "motor", motor);

    pot = new AnalogPotentiometer(potPort, 1.0, 0.0);
    LiveWindow.addSensor("claw", "pot", pot);

    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
    LiveWindow.addActuator("claw", "PIDSubsystem Controller", getPIDController());
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
