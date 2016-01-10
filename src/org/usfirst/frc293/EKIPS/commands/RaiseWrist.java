package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RaiseWrist extends CommandGroup {

    public RaiseWrist() {
        addParallel(new SetWristSetpoint(-2));
    }
}
