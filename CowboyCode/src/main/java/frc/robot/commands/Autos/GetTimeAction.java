package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;

public class GetTimeAction {
    double absoluteTimer;
    double relativeTimer;

    public void autoAbsoluteTimeControl(){
        absoluteTimer = Timer.getFPGATimestamp();
    }
    public void autoRelativeTimeControl(){
        relativeTimer = Timer.getFPGATimestamp();
    }
    public double getAbsoluteTimer(){
        return absoluteTimer;
    }
    public double getRelativeTimer(){
        return relativeTimer;
    }
}
