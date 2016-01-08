package org.usfirst.frc293.EKIPS;

import org.usfirst.frc293.EKIPS.commands.Auto;
import org.usfirst.frc293.EKIPS.subsystems.Claw;
import org.usfirst.frc293.EKIPS.subsystems.DriveBase;
import org.usfirst.frc293.EKIPS.subsystems.Flipper;
import org.usfirst.frc293.EKIPS.subsystems.Wrist;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

  Command autonomousCommand;

  public static OI oi;
  public static DriveBase driveBase;
  public static Wrist leftWrist, rightWrist;
  public static Claw leftClaw, rightClaw;
  public static Flipper flipper;



  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public void robotInit() {
    driveBase = new DriveBase();
    rightWrist = new Wrist(6,2);
    leftWrist = new Wrist(7,3);
    rightClaw = new Claw(8,4);
    leftClaw = new Claw(9,5);
    flipper = new Flipper();
    oi = new OI();
    autonomousCommand = new Auto();
  }

  /**
   * This function is called when the disabled button is hit.
   * You can use it to reset subsystems before shutting down.
   */
  public void disabledInit(){

  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
    if (autonomousCommand != null) autonomousCommand.start();
  }

  /**
   * This function is called periodically during autonomous
   */
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    if (autonomousCommand != null) autonomousCommand.cancel();
  }

  /**
   * This function is called periodically during operator control
   */
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode
   */
  public void testPeriodic() {
    LiveWindow.run();
  }
}
