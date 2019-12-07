package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;


//@Config
@Autonomous(name = "ParkRight")
public class ParkRight extends LinearOpMode {

    Drivetrain drive = new Drivetrain(this);

    public void runOpMode() throws InterruptedException{
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        drive.driveToPos(10, 0.5);
        sleep(500);
        drive.strafeRight();
        sleep(2800);
    }
}