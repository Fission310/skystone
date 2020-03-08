package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Acquirer extends org.firstinspires.ftc.teamcode.hardware.Mechanism {

    private DcMotor acquirerLeft;
    private DcMotor acquirerRight;

    public Acquirer() { }

    public Acquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquirerLeft = hwMap.dcMotor.get("acquirerLeft");
        acquirerRight = hwMap.dcMotor.get("acquirerRight");

        acquirerLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        acquirerRight.setDirection(DcMotorSimple.Direction.FORWARD);

        // Set motor brake behavior
        acquirerLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        acquirerRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        acquirerLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        acquirerRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //It spins so i called it "spin"
    public void spin(double power){
        acquirerRight.setPower(power);
        acquirerLeft.setPower(power);
    }

    public void acquire() {spin(-1);}

    public void unacquire() {spin(1);}

    public void off(){spin(0);}




}