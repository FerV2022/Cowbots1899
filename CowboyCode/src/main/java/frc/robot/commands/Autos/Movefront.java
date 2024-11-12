package frc.robot.commands.Autos;

import frc.robot.subsystems.TankDrive;


public class Movefront{
  TankDrive mAutoDrive = new TankDrive();
  
  public void finalMoveForwardACtion(){
    mAutoDrive.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
    mAutoDrive.getOdometry();
  }
}