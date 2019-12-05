package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import com.acmerobotics.dashboard.FtcDashboard;


@Config
@Autonomous(name = "PIDTuning")
public class PIDTuning extends LinearOpMode {

    public static double p = 0.02;
    public static double i = 0;
    public static double d = 0;
    public static int degrees = -90;

    Drivetrain drive = new Drivetrain(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
//        drivetrain.driveToPos(6, .7);
//        drive.turn(degrees, .7, p,i,d);
//        drivetrain.driveToPos(-6, .7);
        drive.turn(degrees, .7, p,i,d);
//        drivetrain.driveToPos(6 , .7);
    }
}