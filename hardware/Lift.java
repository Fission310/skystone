package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;



public class Lift extends Mechanism {

    public DcMotor pulley;
    public DigitalChannel botSwitch;
    public Lift() {
    }

    public Lift(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public void init(HardwareMap hwMap) {

        pulley = hwMap.dcMotor.get("pulley");
        pulley.setDirection(DcMotorSimple.Direction.FORWARD);
        pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        botSwitch = hwMap.digitalChannel.get("botSwitch");
        botSwitch.setMode(DigitalChannel.Mode.INPUT);

    }

    public boolean botIsPressed() {
        return !botSwitch.getState();
    }
    public void up() {
        pulley.setPower(0.5);
    }

    public void down() {
        if (botIsPressed()) {
            pulley.setPower(0);
        }
        else {
            pulley.setPower(-0.5);
        }
    }

    public void stop() {
        pulley.setPower(0);
    }

}