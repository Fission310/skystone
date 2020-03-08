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
//    public void push(int ticks, double power) {
//        leg.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        while (Math.signum(ticks) * (ticks - leg.getCurrentPosition() ) > 15) {
//            leg.setPower(power * Math.signum(ticks));
//        }
//        leg.setPower(0);
//        leg.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//    }

    public void push() {
        leg.setPower(0.37);
        opMode.sleep(700);
        leg.setPower(-0.37);
        opMode.sleep(800);
        leg.setPower(0);

    }






}
