package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.PrototypeAcquirer;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Config
@TeleOp(name="PrototypeTest", group="Test")
public class PrototypeTest extends LinearOpMode {
    public static double leftAngle = 0;
    public static double rightAngle = 0;

    PrototypeAcquirer acquirer = new PrototypeAcquirer(this);
    public void runOpMode() {
        acquirer.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                acquirer.gripOpen();
            }
            else if (gamepad1.b) {
                acquirer.gripClose();
            }
            if (gamepad1.x) {
                acquirer.acquirerIn();
            }
            if (gamepad1.y) {
                acquirer.acquirerOut();
            }

            else {
                acquirer.acquirerOff();
            }

        }
    }
}