package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Switch;

@Config
@Disabled
@TeleOp(name="StrafeTest", group="Test")
public class StrafeTest extends LinearOpMode {
    public static double p = 0.02;
    public static double i = 0;
    public static double d = 0;

    private Drivetrain drive = new Drivetrain(this);
    private Switch limitSwitch = new Switch(this);
    FtcDashboard dashboard = FtcDashboard.getInstance();

    TelemetryPacket packet = new TelemetryPacket();

    public void runOpMode() {
        drive.init(hardwareMap);
        drive.setDash(dashboard, packet);
        drive.pidStrafe.setPID(p,i,d);
        drive.pidRotate.setPID(p,i,d);
        drive.pidDrive.setPID(p,i,d);
        limitSwitch.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        telemetry.addData("Correction", drive.varCorr);
        telemetry.addData("Angle", drive.getAngle());
        telemetry.addData("Switch:" , limitSwitch.isPressed());
        packet.put("Correction", drive.varCorr);
        while (opModeIsActive()) {

            if (gamepad1.a) {
                drive.pidStrafe.setPID(p,i,d);
                drive.strafePID(0.7, 1);

            }
            else if (gamepad1.b) {
                drive.pidStrafe.setPID(p,i,d);
                drive.strafePID(-0.7,1);
            }
            else if (gamepad1.x) {
                drive.turn(90, 0.7);
            }
            else if (gamepad1.y) {
                drive.turn(-90,0.7);
            }
            else if (gamepad1.dpad_up) {
                drive.driveToPos(20,1);
            }
            else if (gamepad1.dpad_down) {
                drive.driveToPos(-20,1);
            }
            dashboard.sendTelemetryPacket(packet);
            telemetry.update();
        }
    }
}

