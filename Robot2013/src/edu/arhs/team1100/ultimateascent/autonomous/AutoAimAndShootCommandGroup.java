package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.drive.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraPIDTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.RapidFireCommandGroup;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Camera aims and shoots variable amount of discs
 *
 * @author Team 1100
 */
public class AutoAimAndShootCommandGroup extends CommandGroup {

    private long WAIT_TIME = 5000;
    private long FRISBEES = 5;
    private long sTime = 0;
    private int shots = 0;
    private boolean isIndependent = true;
    private boolean isFinished = false;
    private RapidFireCommandGroup shootCommand;
    private CameraPIDTiltShooterCommand cameraTilter;
    private SpinShooterCommand spinShootCommand;

    /**
     * Constructs AutoAimAndShootCommandGroup
     */
    public AutoAimAndShootCommandGroup(long frisbees, float wait, boolean independent) {
        this.FRISBEES = frisbees;
        this.isIndependent = independent;
        shootCommand = new RapidFireCommandGroup();
        ShooterTiltSubsystem.getInstance().setInputRange(-1.0,1.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(20.0);
        if (isIndependent) {
            cameraTilter = new CameraPIDTiltShooterCommand();

            spinShootCommand = new SpinShooterCommand(ShooterWheelSubsystem.SHOOTING_SPEED);
            addParallel(cameraTilter);

            addParallel(spinShootCommand); //replace with PID later if possible
        }
        // addParallel(new CameraPIDMecanumCommand());
        addParallel(new StopDriveCommand(wait));
        this.WAIT_TIME = (long) (wait * 1000);
        //addParallel(new TiltShooterPositionPIDCommand(RobotMap.DS_SHOOTING_ANGLE_CH));
    }

    /**
     * Gets current time. Sets shots to 0.
     */
    public void initialize() {
        sTime = System.currentTimeMillis();
        shots = 0;
        isFinished = false;
    }

    /**
     * If Drive and Shooter is on target, shoot for as long as its on target
     */
    public void execute() {
        DriverStation.getInstance();
        //if(!ShooterTiltSubsystem.getInstance().onTarget()){
        if (System.currentTimeMillis() - sTime <= WAIT_TIME || isFinished) {
            return;
        }

        if (!shootCommand.isRunning()) { //this should repeat shots as long as its on target
            shootCommand.start();
            shots++;
        }

        if (shots == FRISBEES) {
            isFinished = true;
            if (isIndependent) {
                cameraTilter.stopTracking();
                ShooterWheelSubsystem.getInstance().stop();
            }
            //
        }
    }

    /**
     * Return if done.
     *
     * @return isTimedout()
     */
    protected boolean isFinished() {
        return isFinished;
    }
}