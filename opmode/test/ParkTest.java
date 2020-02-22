package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.hardware.Tape;

@Disabled
@Config
@TeleOp(name = "ParkTest" ,group = "Test")
public class ParkTest extends LinearOpMode {

    public Tape parker= new Tape(this);

    @Override
    public void runOpMode(){

        parker.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {


            if(gamepad1.a){
                telemetry.addData("Arm", "Extend");
                telemetry.update();
                parker.extend();
            }
            else if(gamepad1.b){
                telemetry.addData("Arm", "Retract");
                telemetry.update();
                parker.retract();
            }
            else {
                telemetry.addData("Arm", "Stop");
                telemetry.update();
                parker.stop();
            }
        }

    }
}
