/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {
        public static final double kTrackWidth = 0.57785;
        // Distance between centers of right and left wheels on robot
        public static final double kWheelBase = 0.57785;
        // Distance between front and back wheels on robot
        public static final SwerveDriveKinematics driveKinematics = new SwerveDriveKinematics(
                new Translation2d(kWheelBase / 2, kTrackWidth / 2),
                new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

        public static final double maxVelocity = 4.5;
        public static final double maxAngularSpeedRadiansPerSecond = Math.PI;
    }

    public static final class SwerveConstants {

        public static final double driveP = 1;
        public static final double driveI = 0;
        public static final double driveD = 0;

        public static final double turnP = 8.1;
        public static final double turnI = 0;
        public static final double turnD = 0;

        public static final TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(
                4.5, 3.5); // meters/sec

        // mechanical (-_-
        public static final double DriveGearRatio = 7.13;
        public static final double WheelDiameterMeters = Units.inchesToMeters(4); // 4 inches
        public static final double WheelCircumferenceMeters = WheelDiameterMeters * Math.PI; // C = D * pi
        public static final double DrivetoMetersPerSecond = (10 * WheelCircumferenceMeters) / (DriveGearRatio * 2048);

        public static final int frontLeftTurnID = 1;
        public static final int frontLeftDriveID = 18;
        public static final int frontLeftCANCoderID = 22;
        public static final double frontLeftCANCoderOffset = 75.498046875;

        public static final int frontRightTurnID = 3;
        public static final int frontRightDriveID = 4;
        public static final int frontRightCANCoderID = 9;
        public static final double frontRightCANCoderOffset = -101.337890625;

        public static final int backLeftTurnID = 7;
        public static final int backLeftDriveID = 6;
        public static final int backLeftCANCoderID = 10;
        public static final double backLeftCANCoderOffset = 121.904296875;

        public static final int backRightTurnID = 25;
        public static final int backRightDriveID = 23;
        public static final int backRightCANCoderID = 8;
        public static final double backRightCANCoderOffset = 24.345703125;
    }

    public static final class JoystickConstants {
        public static final int controllerPortID = 0;
        public static final int leftJoystickXAxis = 0;
        public static final int leftJoystickYAxis = 1;
        public static final int rightJoystickXAxis = 4;
        public static final int rightBumperButtonID = 6;
    }

    public static final class PathPlannerConstants {

        // Autonomous Period Constants TODO: Tune all of these values
        public static final double autoMaxVelocity = 4.5; // meters/second
        public static final double autoMaxAcceleration = 3.25; // meters/second/second
        public static final double PXController = 1.25;
        public static final double PYController = 1.25;
        public static final double PThetaController = 3;
        public static final double MaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double MaxAngularSpeedRadiansPerSecondSquared = Math.PI;

        // Constraint for the motion profiled robot angle controller
        public static final TrapezoidProfile.Constraints ThetaControllerConstraints = new TrapezoidProfile.Constraints(
                MaxAngularSpeedRadiansPerSecond, MaxAngularSpeedRadiansPerSecondSquared);
    }

}
