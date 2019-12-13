package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Camera;
import org.firstinspires.ftc.teamcode.hardware.Arm;
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

        arm.armUp();
        drive.driveToPos(-22.5, 0.5);
        drive.strafeLeft();
        sleep(1500);

        for(int i = 0; i <= 100; i++){

            if (camera.targetVisible().equals("Stone Target") && camera.getLocation()[0] <= 0.5 ){
                arm.armDown();
                break;

            }
            drive.strafeLeft();
            sleep(10);


        }








    }



}
