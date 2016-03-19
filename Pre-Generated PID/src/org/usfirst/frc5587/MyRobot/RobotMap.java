// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5587.MyRobot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder strongArmencoder;
    public static DigitalInput strongArmupperLimit;
    public static SpeedController strongArmmotor;
    public static DigitalInput strongArmlowerLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        strongArmencoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("StrongArm", "encoder", strongArmencoder);
        strongArmencoder.setDistancePerPulse(1.0);
        strongArmencoder.setPIDSourceType(PIDSourceType.kDisplacement);
        strongArmupperLimit = new DigitalInput(2);
        LiveWindow.addSensor("StrongArm", "upperLimit", strongArmupperLimit);
        
        strongArmmotor = new VictorSP(7);
        LiveWindow.addActuator("StrongArm", "motor", (VictorSP) strongArmmotor);
        
        strongArmlowerLimit = new DigitalInput(3);
        LiveWindow.addSensor("StrongArm", "lowerLimit", strongArmlowerLimit);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
