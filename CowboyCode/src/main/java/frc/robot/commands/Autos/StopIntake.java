package frc.robot.commands.Autos;

import frc.robot.subsystems.Intake;

public class StopIntake {
        Intake mIntake = new Intake();

        
    public void FinalStopIntake(){
        mIntake.outMotoresAuto(0.0);
}
}