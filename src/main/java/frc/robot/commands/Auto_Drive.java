// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

public class Auto_Drive extends CommandBase {
  /** Creates a new Auto_Drive. */
  public Auto_Drive(DriveTrain m_DriveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    
      
      new DriveDistance(10, .5, .5, m_DriveTrain);
  
  
  
  }

 
}
