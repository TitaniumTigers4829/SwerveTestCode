// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveConstants;
import frc.robot.subsystems.SwerveModule;
import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {

  /** Creates a new DriveSubsystem. */
  private final SwerveModule frontLeftModule;
  private final SwerveModule frontRightModule;
  private final SwerveModule backLeftModule;
  private final SwerveModule backRightModule;

  private final Gyro gyro = new AHRS(SPI.Port.kMXP);

  public DriveSubsystem() {
    frontLeftModule = new SwerveModule(SwerveConstants.frontLeftDriveID, SwerveConstants.frontLeftTurnID, SwerveConstants.frontLeftCANCoderID, false, false, false, SwerveConstants.frontLeftCANCoderOffset);
    frontRightModule = new SwerveModule(SwerveConstants.frontRightDriveID, SwerveConstants.frontRightTurnID, SwerveConstants.frontRightCANCoderID, false, false, false, SwerveConstants.frontRightCANCoderOffset);
    backLeftModule = new SwerveModule(SwerveConstants.backLeftDriveID, SwerveConstants.backLeftTurnID, SwerveConstants.backLeftCANCoderID, false, false, false, SwerveConstants.backLeftCANCoderOffset);
    backRightModule = new SwerveModule(SwerveConstants.backRightDriveID, SwerveConstants.backRightTurnID, SwerveConstants.backRightCANCoderID, false, false, false, SwerveConstants.backRightCANCoderOffset);
  }

  public void resetGyro() {
    gyro.reset();
  }

  /**
   * Returns the rotation of the robot in radians
   * @return
   */
  public double getHeading() {
    return (gyro.getAngle() % 360) * Math.PI / 180;
  }

  public Rotation2d getRotation2d() {
    return gyro.getRotation2d();
  }

  /**
   * Set's the speed and rotation of the swerve modules.
   * @param desiredStates An array that contains the SwerveModuleState for each
   * module. It is in the order frontLeft, frontRight, backLeft, backRight.
   */
  public void setModuleStates(SwerveModuleState[] desiredStates) {
    frontLeftModule.setDesiredState(desiredStates[0]);
    frontRightModule.setDesiredState(desiredStates[1]);
    backLeftModule.setDesiredState(desiredStates[2]);
    backRightModule.setDesiredState(desiredStates[3]);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
