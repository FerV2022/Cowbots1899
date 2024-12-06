package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    //private CANSparkMax motor1 = new CANSparkMax(Constants.kShooter1Id, MotorType.kBrushless);
    //private CANSparkMax motor2 = new CANSparkMax(Constants.kShooter2Id, MotorType.kBrushless);
    private  CANSparkMax shooterMotor = new CANSparkMax(Constants.kShooter5Id,MotorType.kBrushless);
    //INPUTS ------------------------------------------------------------------>
    boolean shooterActive = false; 
    double shootervelocity;

    public Shooter() {
        shootervelocity = 0;
    } //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//
  //Funcion para disparar
    public void shoot(double Left, double Right){
        shootervelocity = Right - Left;
        if (Math.abs(shootervelocity)<0.15){
            shooterMotor.set(0);
        }
        if(shootervelocity<0){
            shooterMotor.set( 0.5);
        }
        else if(shootervelocity>0){   
            shooterMotor.set(-0.4);
        }
        else{
            shooterMotor.set(0);
        
        }
    }

    //Funcion para poner salidas a SmartDashBoard 
    public void ShooterLogsOutput(){//codigo para dar salidas a SmartDashBoard/
        //SmartDashboard.putBoolean("Shooter Active", shooterActive);
    }
        
    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation }
    }
}
