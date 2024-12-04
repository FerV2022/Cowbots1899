package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    TalonSRX Intake2; // nombre del talon que usaremos para el intake 2
    double velocidad; 
    boolean IntakeActive = false;  


    public Intake(){
    Intake2 = new TalonSRX(Constants.kIntake);
    velocidad = 0;
    }

    public void comer(double Left, double Right){
        velocidad = Right - Left;
        if(Math.abs(velocidad)<.15){
            velocidad=0;
        }
        if(velocidad<0){
            Intake2.set(TalonSRXControlMode.PercentOutput, 0.3);    
        }
        else if(velocidad>0){   
            Intake2.set(TalonSRXControlMode.PercentOutput, -0.4);
        }
        else{
            Intake2.set(TalonSRXControlMode.PercentOutput, 0);
        }
    }
} 
