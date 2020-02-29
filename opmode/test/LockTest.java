package org.firstinspires.ftc.teamcode.opmode.test;

//import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Lock;

//@Config
@TeleOp(group = "Test", name = "LockTest")
public class LockTest extends LinearOpMode {

    public Lock lock = new Lock(this);

    public void runOpMode(){

        lock.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                lock.downStopper();
            }
            else if(gamepad1.b){
                lock.upStopper();
            }

            if(gamepad1.x){
                lock.downPusher();
            }
            else if(gamepad1.y){
                lock.upPusher();
            }

            telemetry.addData("stopper", lock.stopper.getPosition());
            telemetry.addData("pusher", lock.pusher.getPosition());
            telemetry.update();
        }

    }

}
