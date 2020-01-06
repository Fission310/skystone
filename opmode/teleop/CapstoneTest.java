package org.firstinspires.ftc.teamcode.opmode.teleop;

import android.graphics.Paint;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Capstone;

@Config
@TeleOp(name = "Capstone" , group = "Teleop")
public class CapstoneTest extends LinearOpMode {

    public Capstone capstone= new Capstone(this);

    @Override
    public void runOpMode() throws InterruptedException{

        capstone.init(hardwareMap);
        double toSet = 0.5;

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        capstone.capAngleSet(toSet);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                toSet += 0.001;

                capstone.capAngleSet(toSet);

            }
            if (gamepad1.dpad_down) {
                toSet -= 0.001;
                capstone.capAngleSet(toSet);

            }

            if(gamepad1.a){
                capstone.capUp();
            }
            if(gamepad1.b){
                capstone.capDown();
            }
            telemetry.addData("toSet", toSet);
            telemetry.update();


        }
    }


}