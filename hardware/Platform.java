package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Platform extends Mechanism {

    public Servo platformLeft;
    public Servo platformRight;

    public Platform() { }

    public Platform(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        platformLeft = hwMap.servo.get("platformLeft");
        platformRight = hwMap.servo.get("platformRight");
        platformDown();
        platformUp();
    }

   public void platformUp() {
        platformLeft.setPosition(0.7);
        platformRight.setPosition(0.3);
   }

   public void platformDown(){
       platformLeft.setPosition(0.3);
       platformRight.setPosition(0.7);
   }

   public void platformSet(double angle) {
        platformLeft.setPosition(angle);
        platformLeft.setPosition(1-angle);
   }
}