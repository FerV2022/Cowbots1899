package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
public final class Constants {
  //-------------------controles--------------//
  //puertos donde conectas los controles
  public static final int kChassisPort = 0;
  public static final int kMecanism = 1;
  //Tolerancia del stick
  public static final double kStickTolerance = 0.15;

  //--------------------chassis--------------//
  public static final int kDriveRight1 = 1;
  public static final int kDriveRight2 = 2;
  public static final int kDriveLeft1 = 3;
  public static final int kDriveLeft2 = 4;
  public static final int kDriverControllerPort = 0;
public static final int kShooter1Id = 6;
public static final int kIntake = 7;
public static final int servo = 0;
public static final int kShooter5Id = 5;
public static final int fedeergarra = 8;
public static double kShooterDemand = 0.5;
public static double kShooterEscupir = 0.3;
public static double fedeerspeed = 0.5;
}