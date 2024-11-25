package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    //-----------------------características---------------------//
    //Hardware
    Servo servo;
    TalonSRX fedeergarra;
    //Variables de logica
    double posicion;
    boolean ClawActive = false; 
    //INPUTS

    //OUTPUTS

    //-----------------------características---------------------//

    // constructor que se ejecuta una vez
    public Garra(){
        servo  = new Servo(Constants.servo);
        fedeergarra = new TalonSRX(Constants.fedeergarra);
        posicion = 0;

    }

    public void cambiarposicion() {
        posicion = 1-posicion;
        servo.set(posicion);


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
    public void comer(boolean isClawActive){
        ClawActive = isClawActive;
        if (ClawActive){
            fedeergarra.set( ControlMode.PercentOutput, Constants.fedeerspeed);
        
        }
        else{
            fedeergarra.set(ControlMode.PercentOutput, 0);
        
        }
    }


    public void escupir(boolean isClawActive){
        ClawActive = isClawActive;
        if (ClawActive){
            fedeergarra.set( ControlMode.PercentOutput, -Constants.fedeerspeed);
        
        }
        else{
            fedeergarra.set(ControlMode.PercentOutput, 0);
        
        }
    }
    //------------------------funciones del subsystema---------------//
}