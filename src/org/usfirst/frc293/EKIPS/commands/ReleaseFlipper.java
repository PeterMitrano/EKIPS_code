package org.usfirst.frc293.EKIPS.commands;

import org.usfirst.frc293.EKIPS.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseFlipper extends Command {

  public void initialize(){
  }

  public void execute(){
    Robot.flipper.pullTrigger();
  }

  public boolean isFinished(){
    return true;
  }

  public void end(){}

  public void interrupted(){
    end();
  }

}
