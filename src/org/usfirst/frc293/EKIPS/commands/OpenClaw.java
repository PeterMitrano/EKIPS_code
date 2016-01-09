package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc293.EKIPS.subsystems.*;

public class OpenClaw extends CommandGroup {

    public OpenClaw() {
        addParallel(new SetClawSetpoint(.707));
        addSequential(new SetClawSetpoint(.707));
    }
}
