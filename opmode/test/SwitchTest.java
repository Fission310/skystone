package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Switch;

@Config
@Disabled
@TeleOp(name="SwitchTest", group="Test")
public class SwitchTest extends LinearOpMode {
    private Drivetrain drive = new Drivetrain(this);
    private Switch limitSwitch = new Switch(this);
    FtcDashboard dashboard = FtcDashboard.getInstance();

    TelemetryPacket packet = new TelemetryPacket();

    public void runOpMode() {
        drive.init(hardwareMap);
        limitSwitch.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Switch:" , limitSwitch.isPressed());
            telemetry.update();
        }
    }
}

