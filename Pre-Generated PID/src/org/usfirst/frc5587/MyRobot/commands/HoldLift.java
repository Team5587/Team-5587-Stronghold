package org.usfirst.frc5587.MyRobot.commands;

import org.usfirst.frc5587.MyRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldLift extends Command {

    public HoldLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.strongArm );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.strongArm.enable();
    	Robot.strongArm.setSetpoint( Robot.strongArm.getSetpoint() );
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.strongArm.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
