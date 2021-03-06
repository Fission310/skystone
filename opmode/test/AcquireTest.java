package org.firstinspires.ftc.teamcode.opmode.test;

//import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;

//@Config
@TeleOp(name = "AcquireTest", group = "Test")
public class AcquireTest extends LinearOpMode {

    public Acquirer acquirer = new Acquirer(this);
    //public Leg score = new Leg (this);

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
