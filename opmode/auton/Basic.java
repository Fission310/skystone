package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;

@Autonomous(name = "Basic")
public class Basic extends LinearOpMode {
    Drivetrain drive = new Drivetrain(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
//        drivetrain.driveToPos(6, .7);
        drive.turn(90, .7);
//        drivetrain.driveToPos(-6, .7);
//        drivetrain.turn(-90, .7  );
//        drivetrain.driveToPos(6 , .7);
    }
}