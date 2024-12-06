package frc.robot.commands.Autos;

import frc.robot.subsystems.Intake;

public class ActiveIntake {
    Intake mIntake = new Intake();

    public void FinalActiveIntake(){
        mIntake.outMotoresAuto(0.3);
    }
}
