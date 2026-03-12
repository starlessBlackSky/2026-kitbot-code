// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

public class CANDriveSubsystem extends SubsystemBase {

    private final CANSparkMax leftLeader;
    private final CANSparkMax leftFollower;
    private final CANSparkMax rightLeader;
    private final CANSparkMax rightFollower;

    private final DifferentialDrive drive;

    public CANDriveSubsystem() {
        // Initialize motors
        leftLeader = new CANSparkMax(LEFT_LEADER_ID, MotorType.kBrushed);
        leftFollower = new CANSparkMax(LEFT_FOLLOWER_ID, MotorType.kBrushed);
        rightLeader = new CANSparkMax(RIGHT_LEADER_ID, MotorType.kBrushed);
        rightFollower = new CANSparkMax(RIGHT_FOLLOWER_ID, MotorType.kBrushed);

        // Set followers
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        // Invert left side so positive goes forward
        leftLeader.setInverted(true);
        leftFollower.setInverted(true);
        rightLeader.setInverted(false);
        rightFollower.setInverted(false);

        // Idle mode and current limits
        leftLeader.setIdleMode(IdleMode.kBrake);
        rightLeader.setIdleMode(IdleMode.kBrake);
        leftFollower.setIdleMode(IdleMode.kBrake);
        rightFollower.setIdleMode(IdleMode.kBrake);

        leftLeader.setSmartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
        rightLeader.setSmartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
        leftFollower.setSmartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
        rightFollower.setSmartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);

        // Create DifferentialDrive (only needs leaders)
        drive = new DifferentialDrive(leftLeader, rightLeader);
    }

    @Override
    public void periodic() {
        // Called once per scheduler run
    }

    // Arcade drive method for teleop
    public void driveArcade(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }

    // Stop all motors
    public void stopMotors() {
        leftLeader.set(0);
        rightLeader.set(0);
        leftFollower.set(0);
        rightFollower.set(0);
    }
}