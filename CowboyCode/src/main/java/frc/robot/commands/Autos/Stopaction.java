package frc.robot.commands.Autos;

import frc.robot.subsystems.Garra;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.TankDrive;


public class Stopaction {
      
  public void finalStopactionACtion(Intake mIntake){

    mIntake.outMotoresAuto(0);
  }

   public void finalStopactionACtion(Garra mGarra){

    mGarra.outMotoresAuto(0);
  }

   public void finalStopactionACtion(TankDrive mTankDrive){

    mTankDrive.outMotoresAuto(0, 0, 0, 0);
  }


}

