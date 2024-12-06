
package frc.robot.commands.Autos;

import frc.robot.subsystems.TankDrive;


public class movebackward{
  TankDrive mAutoDrive = new TankDrive();
  
  public void finalmovebackwardACtion(){
    mAutoDrive.outMotoresAuto(-0.3, -0.3, 0.3, 0.3);
  }
}