package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Capstone extends Mechanism {

    public Capstone(){}

    public Capstone(LinearOpMode opMode){this.opMode = opMode;}

    public Servo putCapstone;

    public void init(HardwareMap hwMap) {
        putCapstone = hwMap.servo.get("putCapstone");
    }

    public void capUp() {putCapstone.setPosition(0.55);}

    public void capDown() {
        putCapstone.setPosition(0.25);
    }

    public void capAngleSet(double angle) {
        putCapstone.setPosition(angle);
    }




}
