package frc.robot.commands.Autos;
import frc.robot.subsystems.Garra;

public class ActiveGarra {

    private Garra mGarra;

    public ActiveGarra(Garra garra){
        mGarra = garra;
    }

    public void FinalActiveGarra(){
        mGarra.outMotoresAuto(-0.40);
    }
    
}
