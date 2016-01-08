package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc293.EKIPS.subsystems.*;

public class RaiseWrist extends CommandGroup {

    public RaiseWrist() {
        addParallel(new SetWristSetpoint(0));
        addSequential(new SetWristSetpoint(0));
    }
}
