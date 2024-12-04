package frc.robot.ControlBoard;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class ControlBoard {
    public static final TalonSRXControlMode PercentOutput = null;
    //hardware
    XboxController driver;
    XboxController mecanisms;
    double tolerance;


    public ControlBoard(){
        driver = new XboxController(Constants.kChassisPort);
        mecanisms = new XboxController(Constants.kMecanism);
        tolerance = Constants.kStickTolerance;
    }
    //--------------funciones para chasis-----------//
    public double left_x_stick_driver(){
        double xValue = driver.getLeftX();
        if (Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
    }
    public double left_y_stick_driver(){
        double yValue = driver.getLeftY();
        if (Math.abs(yValue)<tolerance){
            yValue = 0;
        }
        return yValue;
    }


// Control de driver para chasis, comer y escupir con intake
    public double getDriverLeftTrigger(){
        double LeftTrigger  = driver.getLeftTriggerAxis(); // Left Trigger escupe
        return LeftTrigger;
    }
    public double getDriverRightTrigger(){
        double RightTrigger = driver.getRightTriggerAxis(); // Right Trigger come
        return RightTrigger;
    }

    public boolean getDriverXButton(){
        boolean XButton = driver.getXButton(); // Right Trigger come
        return XButton;
    }

    
    public boolean getDriverBButton(){
        boolean XButton = driver.getBButton(); // Right Trigger come
        return XButton;
    }



// Control de mecanismos shooter, garra 


    // Shooter--------------------------------------
    public double getMecanismosLeftTrigger(){
        double LeftTrigger  = mecanisms.getLeftTriggerAxis(); // Left Trigger escupe
        return LeftTrigger;
    }
    public double getMecanismosRightTrigger(){
        double RightTrigger = mecanisms.getRightTriggerAxis(); // Right Trigger dispara
        return RightTrigger;
    }


    // Garra motor
    public boolean getMecanismosLeftBumper(){
        return mecanisms.getLeftBumper(); // Left bumper escupe
    }

    public boolean getMecanismosRightBumper(){
        return mecanisms.getRightBumper(); // Right bumper come
    }

    public boolean getMecanismosAButton(){
        return mecanisms.getAButton();
    }

    
    public boolean getMecanismosBButton(){
        return mecanisms.getBButton();
    }


    public double right_x_stick_driver(){
        double xValue = driver.getRightX();
        if (Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
   }
    public boolean driver_A_button(){
        return driver.getAButton();
    }
    public boolean driver_B_button(){
        return driver.getBButton();
    }
}
