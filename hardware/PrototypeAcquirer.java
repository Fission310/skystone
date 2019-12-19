package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PrototypeAcquirer extends Mechanism {

    public CRServo acquirerLeft;
    public CRServo acquirerRight;
    public Servo gripRight;
    public Servo gripLeft;

    public PrototypeAcquirer() { }

    public PrototypeAcquirer(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        acquirerLeft = hwMap.crservo.get("acquirerLeft");
        acquirerRight = hwMap.crservo.get("acquirerRight");
        gripLeft = hwMap.servo.get("gripLeft");
        gripRight = hwMap.servo.get("gripRight");
    }

    public void setGripLeft(double angle) {
        gripLeft.setPosition(angle);

    }

    public void setGripRight(double angle) {
        gripRight.setPosition(angle);
    }

    public void gripOpen() {
        gripLeft.setPosition(.51);
        gripRight.setPosition(.33);
    }

    public void gripClose() {
        gripLeft.setPosition(.43);
        gripRight.setPosition(.43);

    }

    public void acquirerIn() {
        acquirerLeft.setPower(-1);
        acquirerRight.setPower(1);

    }

    public void acquirerOut() {
        acquirerLeft.setPower(1);
        acquirerRight.setPower(-1);
    }

    public void acquirerOff() {
        acquirerLeft.setPower(0);
        acquirerRight.setPower(0);
    }

}