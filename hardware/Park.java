package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Park extends Mechanism {

    public DcMotor tapeExtend;

    public Park(){}
    public Park(LinearOpMode opmode){this.opMode = opmode;}

    public void init(HardwareMap hwMap){
        tapeExtend = hwMap.dcMotor.get("tapeExtend");
        tapeExtend.setDirection(DcMotorSimple.Direction.REVERSE);
        tapeExtend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void extend(){tapeExtend.setPower(1);}
    public void retract(){tapeExtend.setPower(-1);}
    public void stop(){tapeExtend.setPower(0);}




}
