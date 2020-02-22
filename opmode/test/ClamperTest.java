package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.oldHardware.Clamper;


@Config
@TeleOp(group = "Test", name = "ClamperTest")
public class ClamperTest extends LinearOpMode {

    public Clamper clamper = new Clamper(this);

    public void runOpMode(){

        clamper.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                clamper.upTopLeft();
            }
            else if(gamepad1.b){
                clamper.downTopLeft();
            }

            if(gamepad1.x){
                clamper.upTopRight();
            }
            else if(gamepad1.y){
                clamper.downTopRight();
            }

            telemetry.addData("TopLeft", clamper.topLeft.getPosition());
            telemetry.addData("TopRight", clamper.topRight.getPosition());
            telemetry.update();
        }

    }

}
