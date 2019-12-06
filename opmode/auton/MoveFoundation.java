package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;


@Config
@Autonomous(name = "MoveFoundation")
public class MoveFoundation extends LinearOpMode {

    public static double distance = 0.02;

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        platform.platformDown();
        drive.driveToPos(distance, .8);
        platform.platformUp();
        drive.driveToPos(distance, 8);
        drive.strafeRight();
        sleep(200);
        drive.strafeLeft();
        sleep(2000);
    }
}