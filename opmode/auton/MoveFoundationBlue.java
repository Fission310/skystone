package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;


@Config
@Autonomous(name = "MoveFoundationBlue")
public class MoveFoundationBlue extends LinearOpMode {

    public static double distance = 22;

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Acquirer acquirer = new Acquirer(this);

    public void runOpMode() {
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        acquirer.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("power", drive.varPower);
        telemetry.addData("corr", drive.varCorr);
        telemetry.update();
        waitForStart();
        platform.platformUp();
        sleep(500);
        drive.strafeLeft();
        sleep(900);
        drive.driveToPos(distance, .5);
        platform.platformDown();
        sleep(500);
        drive.driveToPos(-distance -1, .5);
        platform.platformUp();
        sleep(1000);
        acquirer.acquirerUp();
        sleep(500);
        drive.strafeRight();
        sleep(3400);
//        platform.platformUp();
//        drive.strafeLeft();
//        sleep(time2);
    }
}