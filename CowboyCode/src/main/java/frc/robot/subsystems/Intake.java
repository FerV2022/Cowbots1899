package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    //-----------------------características---------------------//
    //Hardware
    TalonSRX intake;
    //Variables de logica
    double velocidad;

    //INPUTS

    //OUTPUTS

    //-----------------------características---------------------//

    // constructor que se ejecuta una vez
    public Intake(){
        intake = new TalonSRX(Constants.kIntake);
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
    public void comer(double RTigger){
        if(RTigger > 0){
            intake.set(ControlMode.PercentOutput, RTigger);
        }else{
            intake.set(ControlMode.PercentOutput, 0);
        }
    }
    public void escupir(double LTrigger){
        if(LTrigger > 0.15){
            intake.set(ControlMode.PercentOutput, -LTrigger);
        }else{
            intake.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public void parar(){
        intake.set(ControlMode.PercentOutput, 0);
    }

    //------------------------funciones del subsystema---------------//
}
    
