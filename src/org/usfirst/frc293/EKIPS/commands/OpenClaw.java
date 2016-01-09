package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OpenClaw extends CommandGroup {

    public OpenClaw() {
        addSequential(new SetClawSetpoint(.707));
    }
}
