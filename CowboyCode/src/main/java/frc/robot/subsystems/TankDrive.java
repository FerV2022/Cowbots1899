package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.ControlBoard.ControlBoard;

public class TankDrive extends SubsystemBase {

    //-----------------------CARASTERÍSTICAS---------------------//
    //Hardware
    static TalonSRX Right1;
    static TalonSRX Right2;
    static TalonSRX Left1;
    static TalonSRX Left2;
    
    //Variables de logica
    double velocidad;
    double rightSpeed;
    double leftSpeed;
    double realRightSpeed;
    double realLeftSpeed;

    //INPUTS

    //OUTPUTS

    //-----------------------características---------------------//

    // constructor que se ejecuta una vez
    public TankDrive(){
        Right1 = new TalonSRX(Constants.kDriveRight1);
        Right2 = new TalonSRX(Constants.kDriveRight2);
        Left1 = new TalonSRX(Constants.kDriveLeft1);
        Left2 = new TalonSRX(Constants.kDriveLeft2);
        //cosas que iniciamos
        velocidad=0;
    }

    //------------------------funciones del subsystema---------------//
    /*public void avanzar(double yInput){
      //cosas de la funcion
      Right1.set(ControlMode.PercentOutput, yInput);
      Right2.set(ControlMode.PercentOutput, yInput);
      Left1.set(ControlMode.PercentOutput, -yInput);
      Left2.set(ControlMode.PercentOutput, -yInput);
    }*/
    public void avanzar(double yInput, double xInput){
        if(yInput>0){
        rightSpeed = yInput - xInput;
        leftSpeed = yInput + xInput;
        }else{
        rightSpeed = yInput + xInput;
        leftSpeed = yInput - xInput;
        }

        if(Math.abs(realRightSpeed)>Math.abs(rightSpeed)){
            realRightSpeed = realRightSpeed - 0.01;
        }else if(Math.abs(realRightSpeed)<Math.abs(rightSpeed)){
            realRightSpeed = realRightSpeed + 0.01;
        }else{
            realRightSpeed = rightSpeed;
        }



        //cosas de la funcion
        Right1.set(ControlMode.PercentOutput, rightSpeed);
        Right2.set(ControlMode.PercentOutput, rightSpeed);
        Left1.set(ControlMode.PercentOutput, -leftSpeed);
        Left2.set(ControlMode.PercentOutput, -leftSpeed);
      }

    public void stop(){
        velocidad=0;
    }

    public void getOdometry() {
    }

    public void outMotoresAuto(double d, double e, double f, double g) {
    }

    //------------------------funciones del subsystema---------------//
}
