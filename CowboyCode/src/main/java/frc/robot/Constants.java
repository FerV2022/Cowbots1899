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
public static final int Garra = 0;
public static final int kShooter1Id = 0;
public static final int kIntake = 0;
public static double kShooterDemand;
}