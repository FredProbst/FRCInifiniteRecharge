/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;
import frc.robot.TestingDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class BallIntake extends SubsystemBase {
  private static BallIntake m_ballIntake;

  private VictorSPX m_intakeRoller;

  /**
   * Creates a new Ball Intake subsystem
   */
  private BallIntake() {
    m_intakeRoller = new VictorSPX(RobotMap.B_INTAKE_ROLLER);
  }

  public static BallIntake getInstance() {
    if (m_ballIntake == null) {
      m_ballIntake = new BallIntake();
      TestingDashboard.getInstance().registerSubsystem(m_ballIntake, "BallIntake");
    }
    return m_ballIntake;
  }

  public void spinIntakeRoller(double speed) {
   m_intakeRoller.set(ControlMode.PercentOutput, speed);
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
