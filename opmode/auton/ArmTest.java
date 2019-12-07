package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import com.acmerobotics.dashboard.FtcDashboard;


@Config
@Autonomous(name = "ArmTest")
public class ArmTest extends LinearOpMode {

    public static double angle = 0.02;

    Arm arm = new Arm(this);

    public void runOpMode() throws InterruptedException{
        arm.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        arm.armSet(angle);
    }
}
