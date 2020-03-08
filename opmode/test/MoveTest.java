package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;

@Config
//@Disabled
@TeleOp(name="MoveTest", group="Test")
public class MoveTest extends LinearOpMode {
    public static double p = 0.02;
    public static double i = 0.0002;
    public static double d = 0;

    private Drivetrain drive = new Drivetrain(this);
    FtcDashboard dashboard = FtcDashboard.getInstance();

    TelemetryPacket packet = new TelemetryPacket();

    public void runOpMode() {
        drive.init(hardwareMap);
        drive.pidStrafe.setPID(p,i,d);
        drive.pidRotate.setPID(p,i,d);
        drive.pidDrive.setPID(p,i,d);
        telemetry.addData("Status",
                 "vvInitialized");
        telemetry.update();
        waitForStart();
        telemetry.addData("Correction", drive.varCorr);
        telemetry.addData("Angle", drive.getAngle());
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
                drive.pidDrive.setPID(p,i,d);
                drive.driveToPos(20,0.7);
            }
            else if (gamepad1.dpad_down) {
                drive.pidDrive.setPID(p,i,d);
                drive.driveToPos(-20,0.7);
            }
            else if (gamepad1.dpad_left) {
                drive.pidDrive.setPID(p,i,d);
                drive.strafeEncoder(10,0.7);
            }
            else if (gamepad1.dpad_left) {
                drive.pidDrive.setPID(p,i,d);
                drive.strafeEncoder(-10,0.7);
            }
            dashboard.sendTelemetryPacket(packet);
            telemetry.update();
        }
    }
}
