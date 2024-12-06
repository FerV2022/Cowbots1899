package frc.robot;

import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.ControlBoard.ControlBoard;
import frc.robot.commands.Autos.ActiveGarra;
import frc.robot.commands.Autos.ActiveIntake;
import frc.robot.commands.Autos.GetTimeAction;
import frc.robot.commands.Autos.Movefront;
import frc.robot.commands.Autos.Stopaction;
import frc.robot.commands.Autos.movebackward;
import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Garra;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;


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
  GetTimeAction mGetTimeAction;
  Movefront mmMovefront;
  Stopaction mStopaction;
  GetTimeAction mAutoTimer = new GetTimeAction();
  Movefront mMovefront = new Movefront();
  Stopaction mStopaction2Stopaction = new Stopaction();
  ActiveIntake MActiveIntakeIntake = new ActiveIntake();
  ActiveGarra mActiveGarraGarra;
  movebackward mmMovebackward2Movebackward = new movebackward();





  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    mTankDrive = new TankDrive();
    mIntake = new Intake();
    mControlBoard = new ControlBoard();
    mGarra = new Garra();
    mShooter = new Shooter();
    mActiveGarraGarra = new ActiveGarra(mGarra);
    

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
 mAutoTimer.autoRelativeTimeControl();

  // schedule the autonomous command (example)
  if (m_autonomousCommand != null) {
    m_autonomousCommand.schedule();
  }
}

/** This function is called periodically during autonomous. */
@Override
public void autonomousPeriodic() {
  mAutoTimer.autoAbsoluteTimeControl();
  double difTime = mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer();
  if(difTime<2.5){
    mActiveGarraGarra.FinalActiveGarra();
  }
  else if (difTime > 2.5 && difTime < 4.5){
    mMovefront.finalMoveForwardACtion();
  } 
  else if (difTime > 4.5 && difTime < 5){
    MActiveIntakeIntake.FinalActiveIntake();
  }
  else if ( difTime > 5 && difTime < 6){
    mmMovebackward2Movebackward.finalmovebackwardACtion();
  }
  else {
    mStopaction.finalStopactionACtion();
  }
}

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
 public void teleopPeriodic(){

   mTankDrive.avanzar(mControlBoard.left_y_stick_driver(), mControlBoard.right_x_stick_driver());
       
   // -----------------------------------Intake------------------------  
   mIntake.comer(mControlBoard.getDriverLeftTrigger(), mControlBoard.getDriverRightTrigger()); 
   
 
   // -------------------------  Shooter -----------------------------------------------------------
   mShooter.shoot(mControlBoard.getMecanismosLeftTrigger(), mControlBoard.getMecanismosRightTrigger());


   ///// -----------------------------------  Garra Motor---------------------------------------------------------

   mGarra.comer(mControlBoard.getMecanismosLeftstickY(), mControlBoard.getMecanismosRightBumper(), mControlBoard.getMecanismosAButton(), mControlBoard.getMecanismosBButton());
   SmartDashboard.putBoolean("Get B Button", mControlBoard.getMecanismosAButton());
   SmartDashboard.putNumber("Servo position", mGarra.getPosicion());
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
 public void simulationPeriodic(){}
}
