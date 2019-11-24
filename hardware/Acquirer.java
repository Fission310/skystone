package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Acquirer extends Mechanism {

    public DcMotor acquireLeft;
    public DcMotor acquireRight;
    public LinearOpMode opMode;

    public Acquirer() { }

    public Acquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquireLeft = hwMap.dcMotor.get("acquireLeft");
        acquireRight = hwMap.dcMotor.get("acquireRight");
        acquireLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        acquireRight.setDirection(DcMotorSimple.Direction.FORWARD);

        acquireLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        acquireRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void acquirerOff(){
        acquireLeft.setPower(0);
        acquireRight.setPower(0);
    }

    public void acquirerForward(){
        acquireLeft.setPower(0.6);
        acquireRight.setPower(0.6);
    }

    public void acquirerReverse() {
        acquireLeft.setPower(-0.6);
        acquireRight.setPower(-0.6);
    }
}