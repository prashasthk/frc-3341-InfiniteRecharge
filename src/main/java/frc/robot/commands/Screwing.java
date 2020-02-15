/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Screwing extends CommandBase {
  /**
   * Creates a new Screwing.
   */
  private double speed;
  private double output;

  public Screwing(double output) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.screwer);
    this.output = output;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_pivot.canUseLeadScrew) {
    RobotContainer.screwer.spin(output);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.screwer.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(RobotContainer.screwer.getScrewTalon().getSensorCollection().isFwdLimitSwitchClosed()) {
      RobotContainer.screwer.canUsePivot = true;
      return true;
    } else if (RobotContainer.screwer.getScrewTalon().getSensorCollection().isRevLimitSwitchClosed()) {
      return true;
    }
    else {
      return false;
    }
    
  }
}

