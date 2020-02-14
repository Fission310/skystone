package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Camera;


@Disabled
//@Config
@Autonomous(name = "Skystone Test", group = "test")
public class SkystoneTest extends LinearOpMode {

    public static double distance = 22;
    private int strafeDistance = 0;
    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Acquirer acquirer = new Acquirer(this);
    Arm arm = new Arm(this);
    Camera camera = new Camera(this);

    public void runOpMode() throws InterruptedException{
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        acquirer.init(hardwareMap);
        camera.init(hardwareMap);
        arm.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        camera.activateTrackables();
        waitForStart();
        telemetry.addData("Visible:", camera.targetVisible() );
//        for (int i = 0; i < 3; i ++) {
//            sleep(500);
//            if (camera.targetVisible().equals("Stone Target")) {
//                strafeDistance = i;
//                if (Math.abs(camera.getLocation()[1] + 1) < 1) {
//                    drive.driveToPos(-4, 0.5);
//                    sleep(500);
//                    arm.armDown();
//                    sleep(1);
//                    drive.driveToPos(12, 0.5);
//                    break;
//                }
//            }
//            drive.strafePID2(0.6,0.4);
//        }
        drive.driveToPos(-10, 0.5);
        sleep(500);
        arm.armDown();
        sleep(1000);
        drive.driveToPos(12, 0.5);
        sleep(500);
        arm.armUp();
        sleep(500);
        drive.driveToPos(5, 0.5);
        drive.turn(90,0.5);
        drive.driveToPos(-15,0.5);
        drive.strafePID(0.7,-1);


    }
}