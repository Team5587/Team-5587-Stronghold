package org.usfirst.frc.team5587.robot.commands.PIDarm;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmReset extends Command {

    public ArmReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.reset();
    	Robot.arm.setSetpoint( 0 );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
