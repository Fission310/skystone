package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.Mechanism;

public class Clamper extends Mechanism {

    public Servo topLeft;
    public Servo topRight;
    public Servo bottomLeft;
    public Servo bottomRight;

    public Clamper(){}
    public Clamper (LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){
        topLeft = hwMap.servo.get("topLeftClamp");
        topRight = hwMap.servo.get("topRightClamp");
        bottomLeft = hwMap.servo.get("botLeftClamp");
        bottomRight = hwMap.servo.get("botRightClamp");

    }

    public void downTopLeft(){
        topLeft.setPosition(topLeft.getPosition() + 0.001);
    }

    public void upTopLeft(){
        topLeft.setPosition(topLeft.getPosition() -0.001);
    }

    public void downTopRight(){
        topRight.setPosition(topRight.getPosition() + 0.001);
    }

    public void upTopRight(){
        topRight.setPosition(topRight.getPosition() -0.001);
    }
}
