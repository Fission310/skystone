package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;


//@Config
@Autonomous(name = "MoveFoundationRed", group = "Red")
public class MoveFoundationRed extends LinearOpMode  {

    public static double distance = 22;

    private ElapsedTime runtime = new ElapsedTime();

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Acquirer acquirer = new Acquirer(this);

    public void runOpMode() throws InterruptedException {
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
        drive.strafePID( 0.5,0.8 );
        sleep(900);
        drive.driveToPos(34, .5);
        platform.platformDown();
        sleep(500);
        drive.driveToPos(-34, .5);
        platform.platformUp();
        sleep(1000);
        acquirer.acquirerUp();
        sleep(500);
        drive.strafePID(-0.5, 2.8);
    }
}