package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc293.EKIPS.Robot;

/**
 *
 */
public class DriveWithGamepad extends Command {

    public DriveWithGamepad() {
        requires(Robot.driveBase);
    }

    protected void initialize() {
    }

    protected void execute() {
      Robot.driveBase.drive(Robot.oi.getjoystick());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
