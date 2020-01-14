package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm extends Mechanism {

    public Servo backArm;
    public CRServo armRotate;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        armRotate = hwMap.crservo.get("armRotate");
        armUp();
    }

   public void armUp() {
        backArm.setPosition(0.75);
   }

   public void armDown() {
        backArm.setPosition(0.1);
   }

   public void aquire(){armRotate.setPower(3);}

   public void unaquire(){armRotate.setPower(-3);}

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }

   public void armPivot(double power){armRotate.setPower(power);}
}