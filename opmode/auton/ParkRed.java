package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;


@Config
@Autonomous(name = "ParkRed")
public class ParkRed extends LinearOpMode {

    Drivetrain drive = new Drivetrain(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        drive.strafeLeft();
        sleep(3000);
    }
}