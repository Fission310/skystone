package org.firstinspires.ftc.teamcode.hardware;

import org.firstinspires.ftc.teamcode.hardware.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Leg extends Mechanism {

    private DcMotor leg;

    public Leg(){}
    public Leg(LinearOpMode opMode){this.opMode = opMode;}

    public void init(HardwareMap hwMap){
        leg = hwMap.dcMotor.get("stonePusher");
        leg.setDirection(DcMotorSimple.Direction.FORWARD);
        leg.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leg.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void push() {
        leg.setPower(-0.45);
    }

    public void resetLeg() {
        leg.setPower(0.45);
    }

    public void stopLeg() {
        leg.setPower(0);
    }




}
