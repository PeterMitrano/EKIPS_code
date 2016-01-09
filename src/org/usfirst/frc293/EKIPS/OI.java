package org.usfirst.frc293.EKIPS;

import org.usfirst.frc293.EKIPS.commands.CloseClaw;
import org.usfirst.frc293.EKIPS.commands.Fire;
import org.usfirst.frc293.EKIPS.commands.LowerWrist;
import org.usfirst.frc293.EKIPS.commands.OpenClaw;
import org.usfirst.frc293.EKIPS.commands.Pickup;
import org.usfirst.frc293.EKIPS.commands.RaiseWrist;
import org.usfirst.frc293.EKIPS.commands.ReleaseFlipper;
import org.usfirst.frc293.EKIPS.commands.ResetFlipper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
	public JoystickButton openClawButton;
    public JoystickButton closeClawButton;
    public JoystickButton pickupButton;
    public JoystickButton fireButton;
    public Joystick joystick;

    public OI() {

        joystick = new Joystick(0);

        pickupButton = new JoystickButton(joystick, 1);
        pickupButton.whenPressed(new Pickup());
        fireButton = new JoystickButton(joystick, 2);
        fireButton.whenPressed(new ReleaseFlipper());
        closeClawButton = new JoystickButton(joystick, 6);
        closeClawButton.whenPressed(new CloseClaw());
        openClawButton = new JoystickButton(joystick, 5);
        openClawButton.whenPressed(new OpenClaw());
        
        SmartDashboard.putData("open claw", new OpenClaw());
        SmartDashboard.putData("close claw", new CloseClaw());
        SmartDashboard.putData("lift claw", new RaiseWrist());
        SmartDashboard.putData("lower claw", new LowerWrist());
        SmartDashboard.putData("reset", new ResetFlipper());
        SmartDashboard.putData("release", new ReleaseFlipper());
    }

    public Joystick getjoystick() {
        return joystick;
    }
}

