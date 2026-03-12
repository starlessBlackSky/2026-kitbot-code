/*
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.MecanumDrivetrain;
import frc.robot.subsystems.CANFuelSubsystem;
import frc.robot.subsystems.CANDriveSubsystem;

import frc.robot.commands.DriveMecanumCartesian;
import frc.robot.commands.Intake;
import frc.robot.commands.AutoDriveDistance;

public class RobotContainer {

  // Controllers
  XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  XboxController xboxController2 = new XboxController(Constants.XBOX_CONTROLLER2_PORT);

  // Subsystems
  MecanumDrivetrain mDrive = new MecanumDrivetrain(); // for teleop
  CANFuelSubsystem fuelSubsystem = new CANFuelSubsystem(); // intake
  CANDriveSubsystem canDriveSubsystem = new CANDriveSubsystem(); // for autonomous

  public RobotContainer() {
      configureBindings();

      // Default teleop drive command for Mecanum
      mDrive.setDefaultCommand(
          new DriveMecanumCartesian(
              mDrive,
              () -> -xboxController.getLeftY(),
              () -> -xboxController.getLeftX(),
              () -> -xboxController.getRightX()
          )
      );
  }

  private void configureBindings() {
      // Intake button (Right Bumper on second controller)
      new JoystickButton(xboxController2, Button.kRightBumper.value)
          .whileTrue(new Intake(fuelSubsystem));
  }

  //Autonomous command
   
  public Command getAutonomousCommand() {
      // Drive forward 2 feet at 50% motor speed using CANDriveSubsystem
      return new AutoDriveDistance(canDriveSubsystem, 2.0, 0.5);
  }
  @Override
public Command getAutonomousCommand() 
{
  return new AutoDriveDistance(canDriveSubsystem, 2.0, 0.5); // 2 feet forward
}
}
*/