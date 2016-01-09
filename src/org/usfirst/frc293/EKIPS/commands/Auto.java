package org.usfirst.frc293.EKIPS.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto extends CommandGroup {

    public Auto() {
    	addSequential(new DriveUntilDistance(2));
    	addSequential(new ReleaseFlipper());
    }
}
