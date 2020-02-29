package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Lock extends Mechanism {

    public Servo stopper;
    public Servo pusher;


    public Lock(){}
    public Lock(LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){
        stopper = hwMap.servo.get("stopper");
        pusher = hwMap.servo.get("pusher");

    }

    public void downStopper(){
        stopper.setPosition(stopper.getPosition() + 0.001);
    }

    public void upStopper(){
        stopper.setPosition(stopper.getPosition() -0.001);
    }

    public void downPusher(){
        pusher.setPosition(pusher.getPosition() + 0.001);
    }

    public void upPusher(){
        pusher.setPosition(pusher.getPosition() -0.001);
    }

    public void stopperDown() {
        stopper.setPosition(0.8);
    }

    public void stopperUp() {
        stopper.setPosition(0.66);
    }

    public void pusherDown() {
        pusher.setPosition(0.6);
    }

    public void pusherUp() {
        pusher.setPosition(0.21);

    }
}
