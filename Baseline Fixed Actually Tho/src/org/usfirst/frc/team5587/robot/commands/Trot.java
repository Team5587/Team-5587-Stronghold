package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.Hooves;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives Pallas based on input power and curve, over a given time period (needs to be tested)
 */
public class Trot extends Command
{

	private double power, curve, targetTime, elapsedTime;
	private long startTime, endTime;
	private Hooves hooves;
	
	/*
	 * @param p The power of the motors
	 * @param c The curve of the motion
	 * @param t The time (in seconds) to drive
	 */
    public Trot( double p, double c, double t )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.hooves );
    	hooves = Robot.hooves;
    	power = p;
    	targetTime = t;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	hooves.trot( power, curve );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	endTime = System.currentTimeMillis();
    	elapsedTime = (endTime - startTime)/1000.0;
    	
    	return (elapsedTime >= targetTime - .05) &&( elapsedTime <= targetTime +.05 );
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	hooves.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}