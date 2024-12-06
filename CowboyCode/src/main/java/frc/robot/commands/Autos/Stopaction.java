package frc.robot.commands.Autos;

import frc.robot.subsystems.TankDrive;

public class Stopaction {
    TankDrive mAutoDrive = new TankDrive();
  
  public void finalStopactionACtion(){
    mAutoDrive.outMotoresAuto(0, 0, -0, -0);
  }
}

