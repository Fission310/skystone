package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm extends Mechanism {

    public Servo backArm;
    public Servo backGrip;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        backGrip = hwMap.servo.get("armRotate");
        armUp();
        open();
    }

   public void armUp() {
        backArm.setPosition(0.75);
   }

   public void armDown() {
        backArm.setPosition(0.3);
   }

   public void open(){backGrip.setPosition(0.06);}

   public void partial() {backGrip.setPosition(0.4);}

   public void close(){backGrip.setPosition(0.9);}

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }

   public void gripSet(double angle){backGrip.setPosition(angle);}
}