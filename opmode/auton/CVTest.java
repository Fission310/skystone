package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Camera;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;

@Autonomous(name = "CVTest")
public class CVTest extends LinearOpMode {

    Camera camera = new Camera (this);
    Arm arm = new Arm(this);
    Drivetrain drive = new Drivetrain(this);

    public void runOpMode(){

        camera.init(hardwareMap);
        arm.init(hardwareMap);
        drive.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        camera.activateTrackables();
        arm.armUp();

        while(opModeIsActive()){

            if(!camera.targetVisible().equals("no target found")){
                telemetry.addData("Target", camera.targetVisible());
                telemetry.update();
                if (camera.targetVisible().equals("Stone Target") && camera.getLocation()[0] >= -10.0){
                    arm.armDown();
                }

            }


        }



    }
}
