// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.LongExtend;
import frc.robot.subsystems.ShortExtend;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto_drive1 extends SequentialCommandGroup {
  /** Creates a new Auto_drive1. */
  public Auto_drive1(DriveTrain m_DriveTrain, Arm m_arm, LongExtend m_longextend, ShortExtend m_shortextend, Gripper m_gripper) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    //new  ArmDistance(-.2, 1, m_arm),
   
   
  new ArmRun(-1,m_arm).withTimeout(1.8),
    
    new WaitCommand(1),
    new LongExtendOut(m_longextend),
    new WaitCommand(3),
    new ShortExtendOut(m_shortextend),
    new WaitCommand(2),
    new GripperGrab(m_gripper),
    new WaitCommand(1.5),
    new ShortExtendBack(m_shortextend),
    new WaitCommand(1),
    new LongExtendBack(m_longextend),
    new WaitCommand(1),
   // new  ArmDistance(.1, -1, m_arm),
    new ArmRun(1, m_arm).withTimeout(1.8),
    new DriveDistance(84, -.5, -.5, m_DriveTrain)
      
    );
  }
}
