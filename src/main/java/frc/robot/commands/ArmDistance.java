// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Arm;

public class ArmDistance extends CommandBase {

  private double m_distance;
  private double m_ArmSpeed;
  private Arm m_arm;


  /** Creates a new ArmDistance. */
  public ArmDistance(double distance, double ArmSpeed, Arm subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_distance = distance;
    m_ArmSpeed = ArmSpeed;
      m_arm = subsystem;
    addRequirements(m_arm);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.my_resetarmEncoder();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.myarmmove(m_ArmSpeed);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.myarmmove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    
    return (Math.abs(m_arm.my_getarm_Distance_Inches())) >= m_distance;
  }
}
