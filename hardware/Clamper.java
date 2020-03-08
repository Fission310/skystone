package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.Mechanism;

public class Clamper extends Mechanism {

    public Servo topLeft;
    public Servo topRight;
    public Servo botLeft;
    public Servo botRight;

    public Clamper(){}
    public Clamper (LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){
        topLeft = hwMap.servo.get("topLeftClamp");
        topRight = hwMap.servo.get("topRightClamp");
        botLeft = hwMap.servo.get("botLeftClamp");
        botRight = hwMap.servo.get("botRightClamp");
        open();

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

    public void downBotLeft(){
        botLeft.setPosition(botLeft.getPosition() + 0.001);
    }

    public void upBotLeft(){
        botLeft.setPosition(botLeft.getPosition() -0.001);
    }

    public void downBotRight(){
        botRight.setPosition(botRight.getPosition() + 0.001);
    }

    public void upBotRight(){
        botRight.setPosition(botRight.getPosition() -0.001);
    }
    public void open() {
        topRight.setPosition(0.98);
        topLeft.setPosition(0.43);
        botLeft.setPosition(0.81);
        botRight.setPosition(0.15);
    }

    public void close() {
        topRight.setPosition(0.36);
        topLeft.setPosition(1);
        botLeft.setPosition(0.08);
        botRight.setPosition(0.80);
    }
}
