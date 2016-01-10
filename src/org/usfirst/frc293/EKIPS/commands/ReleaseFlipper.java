package org.usfirst.frc293.EKIPS.commands;

import org.usfirst.frc293.EKIPS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReleaseFlipper extends Command {

  public ReleaseFlipper(){
	  requires(Robot.flipper);
  }
	
  public void initialize(){
  }

  public void execute(){
    Robot.flipper.pullTrigger();
  }

  public boolean isFinished(){
    return Robot.flipper.fullyExtended();
  }

  public void end(){}

  public void interrupted(){
    end();
  }

}
