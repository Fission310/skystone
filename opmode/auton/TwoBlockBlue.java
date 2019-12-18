package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;

@Autonomous (name = "TwoBlockBlue")
public class TwoBlockBlue extends LinearOpMode {

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Arm arm = new Arm(this);

    public void runOpMode() throws InterruptedException {
        drive.init(hardwareMap);
        platform.init(hardwareMap);
        arm.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        arm.armUp();
        drive.driveToPos(-18, 0.5);
        sleep(500);
        drive.strafeLeft();
        sleep(2000);

        drive.driveToPos(-4, 0.5);
        arm.armDown();
        sleep(500);
        drive.driveToPos(4, 0.5);
        drive.turn(90,0.5);
        sleep(500);
        drive.driveToPos(-100,0.5);

        arm.armUp();
        drive.driveToPos(80,0.5);
        drive.turn(-90, 0.5);
        sleep(500);
        drive.driveToPos(-4,0.5);
        arm.armDown();
        sleep(500);

        drive.driveToPos(4,0.5);
        drive.turn(90, 0.5);
        sleep(500);
        drive.driveToPos(-40,0.5);
        arm.armUp();
        sleep(500);
        drive.driveToPos(20,0.5);










    }
}
