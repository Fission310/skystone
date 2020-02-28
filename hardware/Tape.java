package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;


public class Tape extends Mechanism {

    private CRServo tapeExtend;

    public Tape(){}
    public Tape(LinearOpMode opmode){this.opMode = opmode;}

    public void init(HardwareMap hwMap){
        tapeExtend = hwMap.crservo .get("tapeExtend");

    }

    public void extend(){tapeExtend.setPower(1);}
    public void retract(){tapeExtend.setPower(-1);}
    public void stop(){tapeExtend.setPower(0);}




}
