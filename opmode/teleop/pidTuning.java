package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.acmerobotics.dashboard.FtcDashboard;

@Config
@TeleOp(name="pidTuning", group="utils")
public class pidTuning extends LinearOpMode {
    public static double p = 0;
    public static double i = 0;
    public static double d = 0;
    Drivetrain drive = new Drivetrain(this);


    @Override
    public void runOpMode() throws InterruptedException {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        drive.init(hardwareMap);
        telemetry.addData("imu heading", drive.getHeading());
        waitForStart();

        /*
         * Main loop
         */
        while (opModeIsActive()) {
            telemetry.update();

            if (gamepad1.a) {
                telemetry.update();
                drive.turn(90, 0.7, p, i, d);
            }
            else if (gamepad1.b) {
                break;
            }
        }

    }
}

