// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms.OuterArm;

public class TeleopOuterArm extends CommandBase {
  /** Creates a new TeleopOuterArm. */
  
  private DoubleSupplier m_UpperOut;
  private OuterArm m_outerArm;
  
  public TeleopOuterArm(OuterArm outerArm, DoubleSupplier upperOut) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_UpperOut = upperOut;
    m_outerArm = outerArm;
    addRequirements(m_outerArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(((Math.abs(m_UpperOut.getAsDouble())>0.2))){
      
      m_outerArm.raiseWithInput((m_UpperOut.getAsDouble())*-0.3);
      // "Borrowed" from another team, not sure of purpose
      // m_arm.reset();
    } else {
      m_outerArm.raiseWithInput(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_outerArm.raiseWithInput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}