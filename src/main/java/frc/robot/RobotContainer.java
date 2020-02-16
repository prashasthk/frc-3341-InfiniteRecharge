/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RotatePivot;
import frc.robot.commands.Screwing;
import frc.robot.commands.Translating;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LeadScrew;
import frc.robot.subsystems.Switch;
import frc.robot.subsystems.Pivot;

// import frc.robot.subsystems.EndGame;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  public DriveTrain drive = new DriveTrain();
  
  public static Pivot m_pivot;
  public static LeadScrew screwer;

  public static Switch switching;

  // public EndGame end = new EndGame();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
 
  // private Joystick screwJoy = new Joystick(2);

  // private Joystick switchJoy = new Joystick(3);

  private Joystick mechJoy; 
  private JoystickButton leadScrewUp;
  private JoystickButton leadScrewDown;
  public Joystick getMechJoy() {
    return mechJoy;
  }
  // public Joystick getScrewJoy(){
  //   return screwJoy;
  // }

  // public Joystick getSwtichJoy() {
  //   return switchJoy;
  // }

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    mechJoy = new Joystick(2);
    // Configure the button bindings
    m_pivot = new Pivot();
    screwer = new LeadScrew();
    switching = new Switch();

    configureButtonBindings();

  
    switching.setDefaultCommand(new Translating());
    m_pivot.setDefaultCommand(new RotatePivot());
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    leadScrewUp = new JoystickButton(mechJoy,11);
    leadScrewDown = new JoystickButton(mechJoy, 12);

    leadScrewUp.whileHeld(new Screwing(0.5));
    leadScrewDown.whileHeld(new Screwing(-0.5));

  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }


}