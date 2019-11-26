package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Acquirer extends org.firstinspires.ftc.teamcode.hardware.Mechanism {

    public CRServo acquirerLeft;
    public CRServo acquirerRight;
    public LinearOpMode opMode;

    public Acquirer() { }

    public Acquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquirerLeft = hwMap.crservo.get("acquirerLeft");
        acquirerRight = hwMap.crservo.get("acquirerRight");

    }

    public void acquirerOff(){
        acquirerLeft.setPower(0);
        acquirerRight.setPower(0);
    }

    public void acquirerForward(){
        acquirerLeft.setPower(0.3);
        acquirerRight.setPower(-0.3);
    }

    public void acquirerReverse() {
        acquirerLeft.setPower(-0.3);
        acquirerRight.setPower(0.3);
    }
}