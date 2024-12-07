
package frc.robot.commands.Autos;

import frc.robot.subsystems.TankDrive;


public class movebackward{
  
  private TankDrive mTankDrive; 

  public movebackward(TankDrive tankDrive){
    mTankDrive= tankDrive;

  }
      
  
  public void finalmovebackwardACtion(){
    mTankDrive.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
  }
}