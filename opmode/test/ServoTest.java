package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Platform;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@Config
@TeleOp(name="ServoTest", group="Test")
public class ServoTest extends LinearOpMode {
    public static double armAngle = 0;
    public static double leftAngle = 0;
    public static double rightAngle = 0;

    Arm arm = new Arm(this);
    Platform platform = new Platform(this);
    public void runOpMode() {
        arm.init(hardwareMap);
        platform.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                arm.armSet(armAngle);
            }
            if (gamepad1.x) {
                platform.platformLeftSet(leftAngle);
            }
            if (gamepad1.y) {
                platform.platformRightSet(rightAngle);
            }

        }
    }
}

