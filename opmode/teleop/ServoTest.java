package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Config
@TeleOp(name="ServoTest", group="Teleop")
public class ServoTest extends LinearOpMode {
    public static double armAngle = 0;
    public static double leftAngle = 0;
    public static double rightAngle = 0;

    Arm arm = new Arm(this);
    Platform platform = new Platform(this);
    public void runOpMode() {
        arm.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
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

