package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    //-----------------------características---------------------//
    //Hardware
    TalonSRX Garra;
    //Variables de logica
    double velocidad;

    //INPUTS

    //OUTPUTS

    //-----------------------características---------------------//

    // constructor que se ejecuta una vez
    public Garra(){
        Garra = new TalonSRX(Constants.Garra);
        velocidad = 0;
    }
//ver dirección
    /*public void eat(double Rtrigger, double Ltrigger){
        double direct=Rtrigger-Ltrigger; //varibale que suma velocidad
        if (Rtrigger>Constants.kStickTolerance){
            intake.set(ControlMode.PercentOutput, Rtrigger);
        }else if(Ltrigger>Constants.kStickTolerance){
            intake.set(ControlMode.PercentOutput, -Ltrigger);
        }else{
            intake.set(ControlMode.PercentOutput, 0);
        }

    }*/
    public void eat(double Rstick){
        if(Rstick>Constants.kStickTolerance){
            Garra.set(ControlMode.PercentOutput, 0.4);
        }else if(Rstick<-Constants.kStickTolerance){
            Garra.set(ControlMode.PercentOutput, -0.4);
        }else{
            Garra.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public void stop(){
        velocidad=0;
    }

    //------------------------funciones del subsystema---------------//
}
    