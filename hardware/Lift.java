package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Lift extends Mechanism {

    private DcMotor pulley;

    public Lift() {
    }

    ;

    public Lift(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public void init(HardwareMap hwMap) {

        pulley = hwMap.dcMotor.get("pulley");
        pulley.setDirection(DcMotorSimple.Direction.FORWARD);
        pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void up() {
        pulley.setPower(1);
    }

    public void down() {
        pulley.setPower(-1);
    }

    public void stop() {
        pulley.setPower(0);
    }

}