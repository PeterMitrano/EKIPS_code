package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc293.EKIPS.Robot;

public class SetClawSetpoint extends Command {

    private double m_setpoint;

    public SetClawSetpoint(double setpoint) {
        m_setpoint = setpoint;
        requires(Robot.leftClaw);
        requires(Robot.rightClaw);
    }

    protected void initialize() {
        Robot.leftClaw.enable();
        Robot.rightClaw.enable();
        Robot.leftClaw.setSetpoint(m_setpoint);
        Robot.rightClaw.setSetpoint(m_setpoint);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.leftClaw.onTarget() && Robot.rightClaw.onTarget();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
