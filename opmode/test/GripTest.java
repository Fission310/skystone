package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.hardware.Arm;

@Disabled
@Config
@TeleOp(name = "GripTest" , group = "Test")
public class GripTest extends LinearOpMode {

    public Arm arm = new Arm (this);

    @Override
    public void runOpMode() throws InterruptedException{

        arm.init(hardwareMap);
        double toSet = 0.5;

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        arm.gripSet(toSet);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                toSet += 0.001;

                arm.gripSet(toSet);

            }
            if (gamepad1.dpad_down) {
                toSet -= 0.001;
                arm.gripSet(toSet);

            }

            if(gamepad1.a){
                arm.open();
            }
            if(gamepad1.b){
                arm.close();
            }
            telemetry.addData("toSet", toSet);
            telemetry.update();


        }
    }


}
