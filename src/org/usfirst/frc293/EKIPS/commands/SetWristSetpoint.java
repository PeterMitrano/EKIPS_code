package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc293.EKIPS.Robot;

public class SetWristSetpoint extends Command {

    private double m_setpoint;

    public SetWristSetpoint(double setpoint) {
        m_setpoint = setpoint;
     //   requires(Robot.leftWrist);
        requires(Robot.rightWrist);
    }

    protected void initialize() {
//        Robot.leftWrist.enable();
        Robot.rightWrist.enable();
//        Robot.leftWrist.setSetpoint(m_setpoint);
        Robot.rightWrist.setSetpoint(m_setpoint);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
//        return Robot.leftWrist.onTarget() && Robot.rightWrist.onTarget();
    	return Robot.rightWrist.onTarget();
    	
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
