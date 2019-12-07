package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;


@Config
@Autonomous(name = "ParkLeft")
public class ParkLeft extends LinearOpMode {

    Drivetrain drive = new Drivetrain(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        drive.driveToPos(10, 0.5);
        sleep(500);
        drive.strafeLeft();
        sleep(2800);
    }
}