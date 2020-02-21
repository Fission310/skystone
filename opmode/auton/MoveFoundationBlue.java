package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Park;


//@Config
@Autonomous(name = "MoveFoundationBlue", group = "Blue")
public class MoveFoundationBlue extends LinearOpMode {


    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Acquirer acquirer = new Acquirer(this);
    Park park = new Park(this);

    public void runOpMode() throws InterruptedException{
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        acquirer.init(hardwareMap);
        park.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("power", drive.varPower);
        telemetry.addData("corr", drive.varCorr);
        telemetry.update();
        waitForStart();
        platform.platformUp();
        sleep(500);
        drive.strafePID( -0.5,0.9 );
        sleep(900);
        drive.driveToPos(36, .5);
        platform.platformDown();
        sleep(500);
        drive.driveToPos(-24, .5);
        drive.turn(95,0.9);
        drive.driveToPos(10,.9);
        drive.strafePID(0.9,0.5);
        platform.platformUp();
        sleep(1000);
        park.extend();
        sleep(1500);
        park.stop();
//        platform.platformUp();
//        drive.strafeLeft();
//        sleep(time2);
    }
}