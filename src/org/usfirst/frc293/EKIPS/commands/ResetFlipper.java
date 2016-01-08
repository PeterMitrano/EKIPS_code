package org.usfirst.frc293.EKIPS.commands;

import org.usfirst.frc293.EKIPS.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetFlipper extends Command {

  public ResetFlipper(){
    requires(Robot.flipper);
  }

  public void initialize() {
  }

  public void execute() {
    Robot.flipper.windup();
  }

  public boolean isFinished() {
    return Robot.flipper.isReset();
  }

  public void end() {
    Robot.flipper.stop();
    Robot.flipper.setTrigger();
  }

  public void interrupted() {
    end();
  }
}
