package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Park;

//@Config
@Autonomous(name = "Parking", group = "Red")
public class Parking extends LinearOpMode {

    Drivetrain drive = new Drivetrain(this);
    Park park = new Park(this);
    public void runOpMode() throws InterruptedException{
        drive.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        park.extend();
        sleep(1000);
        park.stop();

    }
}