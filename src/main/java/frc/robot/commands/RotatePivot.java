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

public class RotatePivot extends CommandBase {
  /**
   * Creates a new RotatePivot.
   */
  private double output;
  public RotatePivot() {
    //this.output = output;

    addRequirements(RobotContainer.m_pivot);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.screwer.canUsePivot) {
    RobotContainer.m_pivot.Pivot(Robot.m_robotContainer.getMechJoy().getY());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_pivot.Pivot(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(RobotContainer.m_pivot.getPivotTalon().getSensorCollection().isFwdLimitSwitchClosed()) {
      RobotContainer.m_pivot.canUseLeadScrew = true;
      return true;
    } else if (RobotContainer.m_pivot.getPivotTalon().getSensorCollection().isRevLimitSwitchClosed()) {
      return true;
    }
  
else {
  return false;
}

    
  }
}
