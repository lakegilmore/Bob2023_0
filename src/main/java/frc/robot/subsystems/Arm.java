// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; 
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Arm extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX armMotor;
private double kUnitsPerRevoltion = 2048;
private double kGearRatio = 1500;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Arm() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
armMotor = new WPI_TalonFX(4);
 
    /* Factory default hardware to prevent unexpected behavior */
armMotor.configFactoryDefault();
armMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        /* Invert Motor? and set Break Mode */
armMotor.setInverted(true);
armMotor.setNeutralMode(NeutralMode.Brake);

        /* Set the peak and nominal outputs */
armMotor.configNominalOutputForward(0, 30);
armMotor.configNominalOutputReverse(0, 30);
armMotor.configPeakOutputForward(1, 30);
armMotor.configPeakOutputReverse(-1, 30);
        
armMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Arm Motor Rotation", my_getarmMotor_Rotations());
        SmartDashboard.putNumber("Arm Distance Inches", my_getarm_Distance_Inches());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void myarmmove(double speed) {
        armMotor.set(speed);
    }

    public double my_getarmEncoderCounts(){
        return armMotor.getSelectedSensorPosition(0);
    }

    public double my_getarmMotor_Rotations(){
        return my_getarmEncoderCounts() / kUnitsPerRevoltion;
    }

    public double my_getarm_Distance_Inches(){
        return (my_getarmMotor_Rotations() / kGearRatio);

    }

    public void my_resetarmEncoder(){
        armMotor.setSelectedSensorPosition(0);

    }
}

