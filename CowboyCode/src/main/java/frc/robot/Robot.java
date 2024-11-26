package frc.robot;

import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.ControlBoard.ControlBoard;

import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Garra;
import frc.robot.subsystems.Shooter;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private TankDrive mTankDrive;
  private Intake mIntake;
  private ControlBoard mControlBoard;
  private Garra mGarra;
  private Shooter mShooter;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private static final int PDH_CAN_ID = 1;
  private static final int NUM_PDH_CHANNELS = 24;

  PowerDistribution m_pdh = new PowerDistribution(PDH_CAN_ID, ModuleType.kRev);


  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    mTankDrive = new TankDrive();
    mIntake = new Intake();
    mControlBoard = new ControlBoard();
    mGarra = new Garra();
    mShooter = new Shooter();

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    mTankDrive.avanzar(mControlBoard.left_y_stick_driver(), mControlBoard.right_x_stick_driver());


    // -----------------------------------Intake------------------------  
    mIntake.comer(mControlBoard.getDriverRightTigger()); // Trigger derecho comes
    mIntake.escupir(mControlBoard.getDriverLeftTrigger()); // Trigger izquierdo escupe 

// ------------------------  SERVO LINEAL -----------------------al presionar "A" una vez se extiende 
    if (mControlBoard.getmecanismosAButton()){
      mGarra.cambiarposicion(); // 
    }

      // -------------------------  Shooter -----------------------------------------------------------
if (mControlBoard.getMecanismosLeftTrigger()>0.1){
  mShooter.escupir(true);
}

else{
  mShooter.escupir(false);
}

if (mControlBoard.getMecanismosRightTrigger()>0.1){
  mShooter.shoot(true);
}

else{
  mShooter.shoot(false);
}

///// -----------------------------------  Garra Motor---------------------------------------------------------

mGarra.comer(mControlBoard.getMecanismosRightBumper());
mGarra.escupir(mControlBoard.getMecanismosLeftBumper());
  }




  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
