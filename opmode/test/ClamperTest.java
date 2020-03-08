package org.firstinspires.ftc.teamcode.opmode.test;

//import com.acmerobotics.dashboard.config.Config;
import android.graphics.Paint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Capstone;
import org.firstinspires.ftc.teamcode.hardware.Clamper;
import org.firstinspires.ftc.teamcode.hardware.Leg;
import org.firstinspires.ftc.teamcode.hardware.Lift;


//@Config
@TeleOp(group = "Test", name = "ClamperTest")
public class ClamperTest extends LinearOpMode {

    public Clamper clamper = new Clamper(this);
    public Leg score = new Leg(this);
    public Capstone cap = new Capstone(this);
    public Lift lift = new Lift(this);

    public void runOpMode(){

        clamper.init(hardwareMap);
        score.init(hardwareMap);
        cap.init(hardwareMap);
        lift.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                clamper.upBotLeft();
            }
            else if(gamepad1.b){
                clamper.downBotLeft();
            }

            if(gamepad1.x){
                clamper.upBotRight();
            }
            else if(gamepad1.y){
                clamper.downBotRight();
            }

            if(gamepad1.dpad_up) score.push();

            if(gamepad1.left_bumper) cap.down();
            else if (gamepad1.right_bumper) cap.up();

            telemetry.addData("BotLeft", clamper.botLeft.getPosition());
            telemetry.addData("BotRight", clamper.botRight.getPosition());
            telemetry.addData("capstone", cap.capstone.getPosition());
            telemetry.addData("switch", lift.botIsPressed());
            telemetry.update();        }


    }

}
