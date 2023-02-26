// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveTrain_Reset_Encoders extends InstantCommand {
  private DriveTrain m_driveTrain;
  private Arm m_Arm;
  public DriveTrain_Reset_Encoders(DriveTrain driveTrain, Arm arm) {
    m_driveTrain = driveTrain;
    m_Arm = arm;
;    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveTrain.my_resetRightEncoder();
    m_Arm.my_resetarmEncoder();
  }
  

  @Override
  public boolean runsWhenDisabled() {
    
      return true;

  }

}
