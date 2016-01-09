package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc293.EKIPS.subsystems.*;

public class LowerWrist extends CommandGroup {

    public LowerWrist() {
        addSequential(new SetWristSetpoint(0.4));
    }
}
