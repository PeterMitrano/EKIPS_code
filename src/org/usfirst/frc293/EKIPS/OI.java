// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc293.EKIPS;

import org.usfirst.frc293.EKIPS.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc293.EKIPS.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public JoystickButton openClawButton;
    public JoystickButton closeClawButton;
    public JoystickButton pickupButton;
    public Joystick joystick;

    public OI() {

        joystick = new Joystick(0);

        pickupButton = new JoystickButton(joystick, 1);
        pickupButton.whenPressed(new Pickup());
        closeClawButton = new JoystickButton(joystick, 1);
        closeClawButton.whenPressed(new CloseClaw());
        openClawButton = new JoystickButton(joystick, 1);
        openClawButton.whenPressed(new OpenClaw());
    }

    public Joystick getjoystick() {
        return joystick;
    }
}

