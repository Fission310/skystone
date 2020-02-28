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
    }
    public void push() {
        leg.setTargetPosition(200);
        leg.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (opMode.opModeIsActive() && !leg.isBusy()) {
            leg.setPower(0.7);
        }
        leg.setPower(0);
        leg.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void resetLeg() {
        leg.setTargetPosition(-200);
        leg.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (opMode.opModeIsActive() && !leg.isBusy()) {
            leg.setPower(-0.7);
        }
        leg.setPower(0);
        leg.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }




}
