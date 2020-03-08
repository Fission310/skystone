package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Capstone extends Mechanism {

    public Servo capstone;

    public Capstone(){}
    public Capstone(LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){
        capstone = hwMap.servo.get("capstone");
    }

    public void up(){
        capstone.setPosition(capstone.getPosition() + 0.01);
    }
    public void down(){
        capstone.setPosition(capstone.getPosition() - 0.01);
    }
}
