package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Acquirer extends org.firstinspires.ftc.teamcode.hardware.Mechanism {

    public DcMotor acquirerLeft;
    public DcMotor acquirerRight;

    public Acquirer() { }

    public Acquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquirerLeft = hwMap.dcMotor.get("acquirerLeft");
        acquirerRight = hwMap.dcMotor.get("acquirerRight");

        acquirerLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        acquirerRight.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set motor brake behavior
        acquirerLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        acquirerRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        acquirerLeft.setMode();
    }

    public void acquire() {
        acquirerLeft.setPower();
    }

    public void unacquire() {

    }



}