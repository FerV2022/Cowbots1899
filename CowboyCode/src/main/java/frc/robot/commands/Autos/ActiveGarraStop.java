package frc.robot.commands.Autos;

import frc.robot.subsystems.Garra;

public class ActiveGarraStop {

    private Garra mGarra;

    public ActiveGarraStop(Garra garra){
        mGarra = garra;
    }

    public void finalActiveGarraStop2(){
        mGarra.outMotoresAuto(0.0);
    }
    
}

