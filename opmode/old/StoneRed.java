package org.firstinspires.ftc.teamcode.opmode.old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Platform;

//@Config
@Disabled
@Autonomous(name = "StoneRed", group = "Red")

public class StoneRed extends LinearOpMode{

    Drivetrain drive = new Drivetrain(this);
    Platform platform = new Platform(this);
    Arm arm = new Arm(this);

    public void runOpMode() throws InterruptedException{
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
