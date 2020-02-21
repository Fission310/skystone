package org.firstinspires.ftc.teamcode.hardware.oldHardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.Mechanism;


public class Arm extends Mechanism {

    public Servo backArm;
    public Servo backGrip;

    public Arm() { }

    public Arm(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        backArm = hwMap.servo.get("backArm");
        backGrip = hwMap.servo.get("armRotate");
        armSet(0.7);
        close();
    }

   public void armUp() {
        backArm.setPosition(0.6);
   }

   public void armDown() {
        backArm.setPosition(0.3);
   }
   public void armPull() {backArm.setPosition(0.19);}

   public void open(){backGrip.setPosition(0.06);}

   public void partial() {backGrip.setPosition(0.4);}

   public void close(){backGrip.setPosition(1);}

   public void armSet(double angle) {
        backArm.setPosition(angle);
   }

   public void gripSet(double angle){backGrip.setPosition(angle);}

    public static class Capstone extends Mechanism {

        public Capstone(){}

        public Capstone(LinearOpMode opMode){this.opMode = opMode;}

        public Servo putCapstone;

        public void init(HardwareMap hwMap) {
            putCapstone = hwMap.servo.get("putCapstone");
        }

        public void capUp() {putCapstone.setPosition(0.55);}

        public void capDown() {
            putCapstone.setPosition(0.25);
        }

        public void capAngleSet(double angle) {
            putCapstone.setPosition(angle);
        }




    }
}