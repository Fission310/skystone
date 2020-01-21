package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm extends Mechanism {

    public Servo backArm;
    public Servo armRotate;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        armRotate = hwMap.servo.get("armRotate");
        armUp();
    }

   public void armUp() {
        backArm.setPosition(0.75);
   }

   public void armDown() {
        backArm.setPosition(0.1);
   }

   public void open(){armRotate.setPosition(0);}

   public void close(){armRotate.setPosition(-0.5);}

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }

   public void armPivot(double angle){armRotate.setPosition(angle);}
}