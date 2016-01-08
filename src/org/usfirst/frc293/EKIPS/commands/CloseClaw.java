package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CloseClaw extends CommandGroup {

    public CloseClaw() {
        addParallel(new SetClawSetpoint(0));
        addSequential(new SetClawSetpoint(0));
    }
}
