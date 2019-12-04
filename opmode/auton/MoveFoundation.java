package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;


@Config
@Autonomous(name = "MoveFoundation")
public class MoveFoundation extends LinearOpMode {

    public static double distance = 0.02;

    Drivetrain drive = new Drivetrain(this);
    Arm arm = new Arm(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        drive.driveToPos(distance, .8);
        drive.driveToPos(distance, 8);
    }
}