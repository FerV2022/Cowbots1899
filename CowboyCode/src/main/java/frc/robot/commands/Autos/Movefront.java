package frc.robot.commands.Autos;

import frc.robot.subsystems.TankDrive;



public class Movefront{
  
  private TankDrive mTankDrive;
    public Movefront(TankDrive tankDrive){
        mTankDrive = tankDrive;

    }
    public void finalMoveForwardACtion(){
        mTankDrive.outMotoresAuto(-0.3, -0.3, 0.3, 0.3);
    }
  }