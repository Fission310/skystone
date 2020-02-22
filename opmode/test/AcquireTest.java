package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Score;

@Config
@TeleOp(name = "acquireTest", group = "Test")
public class AcquireTest extends LinearOpMode {

    public Acquirer acquirer = new Acquirer(this);
    //public Score score = new Score (this);

    @Override
    public void runOpMode() throws InterruptedException{

        acquirer.init(hardwareMap);
        //score.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()){

            if(gamepad1.a){
                acquirer.acquire();
            }
            else if (gamepad1.b){
                acquirer.unacquire();
            }
            else{acquirer.off();}


//            if(gamepad1.x){
//                score.kick();
//            }
//            else{
//                score.back();
//            }
        }

    }


}
