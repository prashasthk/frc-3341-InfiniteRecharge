/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


//TankDrive with two traditional joysticks 
public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private final TalonSRX left = new TalonSRX(2);
  private final TalonSRX right = new TalonSRX(3);
  private static DriveTrain drive; 
  private Joystick leftJoy;
  private Joystick rightJoy;
  
  public DriveTrain() {
    leftJoy = new Joystick(2);
    rightJoy = new Joystick(3);
  } 
  //grabs instance of DriveTrain to be used in commands 
  public static DriveTrain getDrive() {
    if (drive == null) {  
      drive = new DriveTrain();
    }
    return drive;
  }
  public void tankDrive(double l, double r) {
    left.set(ControlMode.PercentOutput, 0.3 * l);
    right.set(ControlMode.PercentOutput, 0.3 * r);
  }
  @Override
  public void periodic() {
    tankDrive(leftJoy.getY(), rightJoy.getY());
    // This method will be called once per scheduler run
  }
}