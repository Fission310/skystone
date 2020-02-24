package org.firstinspires.ftc.teamcode.hardware;

import org.firstinspires.ftc.teamcode.hardware.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Leg extends Mechanism {

    public Servo leg;

    public Leg(){}
    public Leg(LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){leg = hwMap.servo.get("stonePusher");}

    public void kick(){leg.setPosition(1);}
    public void back(){leg.setPosition(0);}

}
