package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;


//@Config
@Autonomous(name = "OuterParkMoveFoundationBlue")
public class OuterParkMoveFoundationBlue extends LinearOpMode {

    public static double distance = 22;

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Acquirer acquirer = new Acquirer(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        acquirer.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        platform.platformUp();
        sleep(500);
        drive.strafeLeft();
        sleep(600);
        drive.driveToPos(distance, .5);
        platform.platformDown();
        sleep(500);
        drive.driveToPos(-distance -1, .5);
        platform.platformUp();
        sleep(1000);
        acquirer.acquirerUp();
        sleep(500);
        drive.strafeLeft ();
        sleep(2000);
        drive.driveToPos(18, .5);
        drive.strafeRight ();
        sleep(800);
//        platform.platformUp();
//        drive.strafeLeft();
//        sleep(time2);
    }
}