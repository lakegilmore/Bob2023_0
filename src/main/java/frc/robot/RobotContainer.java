// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    
    public final Arm m_arm = new Arm();
    public final Spindexer m_spindexer = new Spindexer();
    
    public final ShortExtend m_shortExtend = new ShortExtend();
    public final LongExtend m_longExtend = new LongExtend();
   // public final retractall m_retracall = new retractall(m_longExtend, m_shortExtend, m_gripper);
    public final Gripper m_gripper = new Gripper();
    public final GearboxShift m_gearboxShift = new GearboxShift();
    public final DriveTrain m_DriveTrain = new DriveTrain();

// Joysticks
private final Joystick joystickCo = new Joystick(2);
private final Joystick joystickRight = new Joystick(1);
private final Joystick joystickLeft = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    //SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    
    SmartDashboard.putData("Reset Drive Encoders", new DriveTrain_Reset_Encoders(m_DriveTrain, m_arm));

    SmartDashboard.putData("Drive Distance", new DriveDistance(12, .2, .2, m_DriveTrain));
    
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_DriveTrain.setDefaultCommand(new DriveWithJoysticks(() -> joystickLeft.getY(), () -> joystickRight.getY(), m_DriveTrain));
    m_arm.setDefaultCommand(new ArmMove(() -> joystickCo.getY(), m_arm));
    
    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        m_chooser.addOption("Auto Drive 2", new Auto_drive2(m_DriveTrain, m_arm, m_longExtend, m_shortExtend, m_gripper));
    m_chooser.setDefaultOption("Auto Drive 1", new Auto_drive1(m_DriveTrain, m_arm, m_longExtend, m_shortExtend, m_gripper));
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
//final JoystickButton joystickCo_ArmDown = new JoystickButton(joystickCo, 2);        
//joystickCo_ArmDown.whileTrue(new ArmRun(-.8, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_ArmRaise = new JoystickButton(joystickCo, 1);        
//joystickCo_ArmRaise.whileTrue(new ArmRun(.8, m_arm).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickco_retractall = new JoystickButton(joystickCo, 5);
//joystickco_retractall.onTrue(new retractall(m_retractall).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton joystickCo_SpindexerCCW = new JoystickButton(joystickCo, 6);        
joystickCo_SpindexerCCW.whileTrue(new SpindexerRun(.075, m_spindexer).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton joystickCo_SpindexerCW = new JoystickButton(joystickCo, 7);        
joystickCo_SpindexerCW.whileTrue(new SpindexerRun(-.075, m_spindexer).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_BackDoorBack = new JoystickButton(joystickCo, 13);        
//joystickCo_BackDoorBack.onTrue(new BackDoorBack( m_backDoor ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_BackDoorOut = new JoystickButton(joystickCo, 12);        
//joystickCo_BackDoorOut.onTrue(new BackDoorOut( m_backDoor ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_shortExtendBack = new JoystickButton(joystickCo, 9);        
//joystickCo_shortExtendBack.onTrue(new ShortExtendBack( m_shortExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_ShortExtendOut = new JoystickButton(joystickCo, 6);        
//joystickCo_ShortExtendOut.onTrue(new ShortExtendOut( m_shortExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_LongExtendBack = new JoystickButton(joystickCo, 8);        
//joystickCo_LongExtendBack.onTrue(new LongExtendBack( m_longExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickCo_LongExtendOut = new JoystickButton(joystickCo, 7);        
//joystickCo_LongExtendOut.onTrue(new LongExtendOut( m_longExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
 
final JoystickButton joystickCo_ShortExtendToggle = new JoystickButton(joystickCo, 3);        
joystickCo_ShortExtendToggle.onTrue(new ShortExtendToggle( m_shortExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton joystickCo_LongExtendToggle = new JoystickButton(joystickCo, 4);        
joystickCo_LongExtendToggle.onTrue(new LongExtendToggle( m_longExtend ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton joystickco_GripperRelease = new JoystickButton(joystickCo, 1);        
joystickco_GripperRelease.onTrue(new GripperRelease( m_gripper ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton joystickCo_GripperGrab = new JoystickButton(joystickCo, 2);        
joystickCo_GripperGrab.onTrue(new GripperGrab( m_gripper ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
 


final JoystickButton joystickLeft_ShiftHigh = new JoystickButton(joystickLeft, 4);        
joystickLeft_ShiftHigh.onTrue(new GearboxShiftHigh( m_gearboxShift ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton joystickRight_ShiftLow = new JoystickButton(joystickRight, 3);        
joystickRight_ShiftLow.onTrue(new GearboxShiftLow( m_gearboxShift ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                       
//final JoystickButton joystickRight_CollecterOut = new JoystickButton(joystickRight, 1);        
//joystickRight_CollecterOut.toggleOnTrue(new IntakeRun(-1, m_intakeMotors).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickRight_CollecterIn = new JoystickButton(joystickRight, 2);        
//joystickRight_CollecterIn.toggleOnFalse(new IntakeRun(1, m_intakeMotors).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        



//final JoystickButton joystickLeft_IntakeCube = new JoystickButton(joystickLeft, 3);        
//joystickLeft_IntakeCube.toggleOnTrue(new IntakeRunCube(-1, m_intakeMotors ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickLeft_Intakein = new JoystickButton(joystickLeft, 1);        
//joystickLeft_Intakein.onTrue(new IntakeRetract( m_intakeRams ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
//final JoystickButton joystickLeft_Intakeout = new JoystickButton(joystickLeft, 1);        
//joystickLeft_Intakeout.onTrue(new IntakeDeploy( m_intakeRams ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getJoystickLeft() {
        return joystickLeft;
    }

public Joystick getJoystickRight() {
        return joystickRight;
    }

public Joystick getJoystickCo() {
        return joystickCo;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
   
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

