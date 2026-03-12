package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MecanumDrivetrain;

public class DriveMecanumCartesian extends Command {
  private final MecanumDrivetrain drivetrain;
  private final DoubleSupplier ySpeedSupplier;
  private final DoubleSupplier xSpeedSupplier;
  private final DoubleSupplier zRotationSupplier;

  public DriveMecanumCartesian(
      MecanumDrivetrain drivetrain,
      DoubleSupplier ySpeedSupplier,
      DoubleSupplier xSpeedSupplier,
      DoubleSupplier zRotationSupplier) {
    this.drivetrain = drivetrain;
    this.ySpeedSupplier = ySpeedSupplier;
    this.xSpeedSupplier = xSpeedSupplier;
    this.zRotationSupplier = zRotationSupplier;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    drivetrain.driveCartesian(
        ySpeedSupplier.getAsDouble(),
        xSpeedSupplier.getAsDouble(),
        zRotationSupplier.getAsDouble());
  }

  @Override
  public boolean isFinished() {
    return false; // Runs continuously
  }
}