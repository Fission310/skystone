package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Acquirer extends org.firstinspires.ftc.teamcode.hardware.Mechanism {

    public CRServo acquirerLeft;
    public CRServo acquirerRight;
    public DcMotor acquirerSlides;

    public Acquirer() { }

    public Acquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquirerLeft = hwMap.crservo.get("acquirerLeft");
        acquirerRight = hwMap.crservo.get("acquirerRight");
        acquirerSlides = hwMap.dcMotor.get("acquirerSlides");
        acquirerSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        acquirerSlides.setDirection(DcMotor.Direction.FORWARD);
        acquirerSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slidesOff();
        acquirerOff();
    }

    public void acquirerOff(){
        acquirerLeft.setPower(0.0);
        acquirerRight.setPower(0.0);
    }

    public void acquirerUp(){
        acquirerLeft.setPower(1);
        acquirerRight.setPower(-1);
    }

    public void acquirerDown() {
        acquirerLeft.setPower(-1);
        acquirerRight.setPower(1);
    }

    public void acquirerSet(double power) {
        acquirerLeft.setPower(power);
        acquirerRight.setPower(- power);
    }

    public void slidesUp() {
        acquirerSlides.setPower(-1);
    }

    public void slidesDown() {
        acquirerSlides.setPower(1);
    }

    public void slidesOff() {
        acquirerSlides.setPower(0);
    }

    public void slidesSet(double power) {
        acquirerSlides.setPower(power);
    }

    public void scoring() {
        slidesSet(-0.6);
        acquirerSet(-0.6);
    }

    public void acquiring () {
        slidesSet(0.6);
        acquirerSet(0.6);
    }
}