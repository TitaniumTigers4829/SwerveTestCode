// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderStatusFrame;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveConstants;

public class SwerveModule extends SubsystemBase {
  /** Creates a new SwerveModule. */
  WPI_TalonFX driveMotor;
  WPI_TalonFX turnMotor;

  CANCoder turnEncoder;

  PIDController drivePidController = new PIDController(SwerveConstants.driveP,
   SwerveConstants.driveI, SwerveConstants.driveD);
  ProfiledPIDController turnPIDController = new ProfiledPIDController(SwerveConstants.turnP, 
    SwerveConstants.turnI, SwerveConstants.turnD, SwerveConstants.constraints);

  int id = 0;

  // __init__
  /**
   * Creates a new SwerveModule
   * @param driveMotorID ID of the drive motor
   * @param turnMotorID ID of the turn motor
   * @param CANCoderID ID of the CANCoder
   * @param isDriveInverted if the drive motor is inverted
   * @param isTurnInverted if the turn motor is inverder
   * @param isCANCoderInverted if the CANCoder is inverted
   * @param CANCoderZero CANCoder offset
   */
  public SwerveModule(int driveMotorID, int turnMotorID, int CANCoderID, boolean isDriveInverted,
    boolean isTurnInverted, boolean isCANCoderInverted, double CANCoderZero) {
    // create drive and turn motors
    // driveMotor = new WPI_TalonFX(driveMotorID);
    // turnMotor = new WPI_TalonFX(turnMotorID);

    // set inverted 
    // driveMotor.setInverted(isDriveInverted);
    // turnMotor.setInverted(isTurnInverted);


    /* Motor and Encoder Configuration */
    driveMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 0);
    // Makes the robot stop moving when you let go of the controller sticks
    driveMotor.setNeutralMode(NeutralMode.Brake);

    turnEncoder = new CANCoder(CANCoderID);
    turnEncoder.configSensorDirection(isCANCoderInverted);
    // config the magnet offset from forward
    // can be debugged with SmartDashboard.putNumber(turnEncoder.getAbsolutePosition());
    turnEncoder.configMagnetOffset(CANCoderZero);
    // loop the encoder values so that the value is always from -180 to 180
    turnEncoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);
    // Makes the robot stop moving when you let go of the controller sticks
    turnMotor.setNeutralMode(NeutralMode.Brake);
 
     // Limit the PID Controller's input range between -pi and pi and set the input
     // to be continuous.
     turnPIDController.enableContinuousInput(-Math.PI, Math.PI);
  }

  /* 
    returns drive motor speed in meters per second
  */
  public double getDriveSpeed() {
    return driveMotor.getSelectedSensorVelocity() * SwerveConstants.kDrivetoMetersPerSecond;
  }

  public void resetEncoders() {
    turnEncoder.setPosition(0);
    // We don't reset the drive encoders because there's not really much of a point 
    // driveMotor.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Abs pos for encoder " + id, turnEncoder.getAbsolutePosition());
  }
}
