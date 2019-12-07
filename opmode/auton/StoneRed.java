package org.firstinspires.ftc.teamcode.opmode.auton;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;

@Config
@Autonomous(name = "StoneRed")

public class StoneRed extends LinearOpMode{

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Arm arm = new Arm(this);

    public void runOpMode(){
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        arm.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        arm.armUp();
        drive.driveToPos(-22.5, 0.5);
        sleep(500);
        arm.armDown();
        sleep(1000);
        drive.driveToPos(10, 0.5);
        drive.turn(-90,0.5);
        drive.driveToPos(-40,0.5);

        arm.armUp();
        drive.driveToPos(15, 0.5);



    }
}
