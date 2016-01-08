package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc293.EKIPS.subsystems.*;

public class Fire extends CommandGroup {

    public Fire() {
        addParallel(new OpenClaw());
        addSequential(new LowerWrist());
        addSequential(new ReleaseFlipper());
    }
}
