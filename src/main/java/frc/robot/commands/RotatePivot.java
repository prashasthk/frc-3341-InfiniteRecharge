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
    System.out.print("Forward Limit switch:" + " " + RobotContainer.m_pivot.getPivotTalon().getSensorCollection().isFwdLimitSwitchClosed());
    System.out.println("Reverse Limit switch:" + " " + RobotContainer.m_pivot.getPivotTalon().getSensorCollection().isRevLimitSwitchClosed());
    if(RobotContainer.m_pivot.atBottom()) {
      RobotContainer.screwer.setLock(true);
    
    } else if (RobotContainer.m_pivot.atTop()) {
      RobotContainer.screwer.setLock(false);
    } else {
      RobotContainer.screwer.setLock(true);
    }
    if(!(RobotContainer.m_pivot.getLock())) {
    RobotContainer.m_pivot.pivot(Robot.m_robotContainer.getMechJoy().getY());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //RobotContainer.m_pivot.Pivot(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
}

    
}

