package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Platform extends Mechanism {

    private Servo platformLeft;
    private Servo platformRight;

    public Platform() { }

    public Platform(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        platformLeft = hwMap.servo.get("platformLeft");
        platformRight = hwMap.servo.get("platformRight");
        platformUp();
    }

   public void platformUp() {
        platformLeft.setPosition(0.19);
        platformRight.setPosition(1);
   }

   public void platformDown(){
       platformLeft.setPosition(0.56);
       platformRight.setPosition(0.61);
   }

   public void platformLeftSet(double angle) {
        platformLeft.setPosition(angle);
   }

    public void platformRightSet(double angle) {
        platformRight.setPosition(angle);
    }
}