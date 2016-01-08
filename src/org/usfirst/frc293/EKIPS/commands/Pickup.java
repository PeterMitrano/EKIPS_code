package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pickup extends CommandGroup {

    public Pickup() {
        addSequential(new CloseClaw());
        addSequential(new RaiseWrist());
        addSequential(new OpenClaw());
        addSequential(new LowerWrist());
    }
}
