package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm extends Mechanism {

    public Servo backArm;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        armUp();
        armDown();
    }

   public void armUp() {
        backArm.setPosition(0.7);
   }

   public void armDown() {
        backArm.setPosition(0.7);
   }

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }
}