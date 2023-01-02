// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveConstants;
import frc.robot.subsystems.SwerveModule;

public class DriveSubsystem extends SubsystemBase {

  /** Creates a new DriveSubsystem. */
  SwerveModule frontLeftModule;
  SwerveModule frontRightModule;
  SwerveModule backLeftModule;
  SwerveModule backRightModule;

  public DriveSubsystem() {
    frontLeftModule = new SwerveModule(SwerveConstants.frontLeftDriveID, SwerveConstants.frontLeftTurnID, SwerveConstants.frontLeftCANCoderID, false, false, false, SwerveConstants.frontLeftCANCoderOffset);
    frontRightModule = new SwerveModule(SwerveConstants.frontRightDriveID, SwerveConstants.frontRightTurnID, SwerveConstants.frontRightCANCoderID, false, false, false, SwerveConstants.frontRightCANCoderOffset);
    backLeftModule = new SwerveModule(SwerveConstants.backLeftDriveID, SwerveConstants.backLeftTurnID, SwerveConstants.backLeftCANCoderID, false, false, false, SwerveConstants.backLeftCANCoderOffset);
    backRightModule = new SwerveModule(SwerveConstants.backRightDriveID, SwerveConstants.backRightTurnID, SwerveConstants.backRightCANCoderID, false, false, false, SwerveConstants.backRightCANCoderOffset);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
