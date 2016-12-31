// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5587.robot.commands.modes.*;
import org.usfirst.frc.team5587.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand; //Autonomous mode (is a Command)
	Command teleOp; //TeleOperated mode (is a command)
    CameraServer server; //CameraServer to send feed to SmartDashboard
    
    public static OI oi; //Operator Interface

	public static final Hooves hooves = new Hooves(); //Drive train
	public static final BoulderLoader loader = new BoulderLoader(); //Servo that pushes boulders into the spinning wheels of death
	public static final SpinningWheelsOfDeath firingWheels = new SpinningWheelsOfDeath(); //Wheels that spin to intake and launch balls
	public static final StrongArm arm = new StrongArm(); //The motor, encoder, and limit switch responsible for positioning the shooting mechanism

	SendableChooser autoChooser; //Menu to select Autonomous mode on Smart Dashboard
	SendableChooser teleChooser; //Menu to select TeleOperated mode on Smart Dashboard
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autoChooser = new SendableChooser(); //sendableChooser is a list that appears on the smart Dashboard
        autoChooser.addDefault("Do Nothing", null ); //Has us sit and do nothing to stay out of the way of other teams
        autoChooser.addObject("Drive Forward", new BasicAuto()); //Drive forward at full power
        autoChooser.addObject("Wait then drive forward", new WaitAuto()); //Drive forward after a delay
        autoChooser.addObject( "Low Bar: Start Throttle at Bottom", new LowAuto()); //Puts arm down, then drives backwards
        autoChooser.addObject("Wait then Low Bar", new WaitLowBar() ); //Complete Low Bar after a delay
        autoChooser.addObject( "Reset Arm", new ResetAuto() ); 
        SmartDashboard.putData( "Auto Chooser", autoChooser );
        
        teleChooser = new SendableChooser();
        teleChooser.addDefault("PID TeleOp", new TeleOpPID( oi.driver ) ); //proportion integral derivative: way of regulating systems on robot (i.e. can check if you on the right speed)
        teleChooser.addObject("TeleOpManual", new TeleOpManual( oi.driver ));
        SmartDashboard.putData( "Tele Chooser", teleChooser);
        
        //setting up camera feed on smart dashboard; stays this simple unless HD stream and other stuff; I like simple;
        server = CameraServer.getInstance();
        server.setQuality(100);
        server.startAutomaticCapture("cam2");
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {
    	//if we used pneumatics or other stuff we would deactivate it here;
    }

    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run(); 
    }

    public void autonomousInit() 
    {
        // schedule the autonomous command (example)
    	autonomousCommand = (CommandGroup) autoChooser.getSelected();
        //only starts command
    	
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	teleOp = (CommandGroup) teleChooser.getSelected();
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleOp.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
