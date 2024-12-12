// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  //Servo declarations 
  private Servo base = new Servo(0);
  private Servo claw = new Servo(1);
  private Servo rightPivot = new Servo(2);
  private Servo leftPivot = new Servo(3);
  
 
  private XboxController opController = new XboxController(0);

  // Constants declarations
  private final double kPivotDefaultPosition = 0.5;
  private final double kBaseDefaultPosition = 0.5;

  @Override
  public void teleopPeriodic() {
    //Base controls
    base.set(kBaseDefaultPosition + opController.getLeftX());
    System.out.println("LeftX: " + opController.getLeftX());
    System.out.println("Base Pos: " + base.get());

    //Claw controls
    if (opController.getAButton() && claw.get() <= 0.5) {
      claw.set(0.5);
  
    }
    else {
      claw.set(0);
    }

    //Pivot controls
    rightPivot.set(kPivotDefaultPosition + opController.getRightY());
    leftPivot.set(kPivotDefaultPosition + opController.getLeftY());
    System.out.println("LeftY: " + opController.getLeftY());
    System.out.println("Right Pivot Pos: " + rightPivot.get());
    System.out.println("Left Pivot Pos: " + leftPivot.get());


  
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
