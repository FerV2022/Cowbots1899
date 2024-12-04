package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    //-----------------------características---------------------//
    //Hardware
    Servo servo;
    TalonSRX fedeergarra;
    double garravelocity;
    //Variables de logica
    double posicion;
    boolean ClawActive = false; 
    //INPUTS

    //OUTPUTS

    //-----------------------características---------------------//
 // constructor que se ejecuta una vez
    public Garra(){
        servo  = new Servo(Constants.servo);
        servo.setBoundsMicroseconds(2000, 1800, 1500, 1200, 1000);
        fedeergarra = new TalonSRX(Constants.fedeergarra);
        posicion = -1;

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
    public void comer(boolean Left, boolean Right,  boolean Abutton, boolean Bbutton){
        if(Abutton){
            posicion = 1.0; 
        } 
        else if(Bbutton){
            posicion = -1.0;
        }
        servo.setSpeed(posicion);
        
        if(Left){
            fedeergarra.set(TalonSRXControlMode.PercentOutput,0.6);
        }
        else if(Right){
            fedeergarra.set(TalonSRXControlMode.PercentOutput,-0.6);
        }
        else{
            fedeergarra.set(ControlMode.PercentOutput, 0);
        
        }

        
    }

    public double getPosicion(){
        return servo.get();
    }

    //------------------------funciones del subsystema---------------//
}