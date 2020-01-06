package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm extends Mechanism {

    public Servo backArm;
    public CRServo Rotate;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        armUp();
    }

   public void armUp() {
        backArm.setPosition(0.75);
   }

   public void armDown() {
        backArm.setPosition(0.2);
   }

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }
}