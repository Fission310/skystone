package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;

@TeleOp(name="Main", group="Teleop")
public class Main extends LinearOpMode {

    double leftInput, rightInput, slideInput;
    boolean precisionMode = false;

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    @Override
    public void runOpMode() throws InterruptedException {
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);

        while(!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
             // Note: telemetry is super scuffed! will fix later
        }

        waitForStart();

        while(opModeIsActive()) {
            leftInput = gamepad1.left_stick_y;
            rightInput = gamepad1.right_stick_y;
            slideInput = -gamepad1.left_trigger + gamepad1.right_trigger;

            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;

            if (gamepad1.x) {
                precisionMode = !precisionMode;
            }
            if (precisionMode) {
                drive.teleDrive(r/4, robotAngle, rightX);
            }
            else {
                drive.teleDrive(r, robotAngle, rightX);
            }

            if (slideInput > 0.5) {
                acquirer.acquirerForward();
                acquirer.slidesDown(0.3);
            }
            else if (slideInput < 0.5) {
                acquirer.acquirerReverse();
                acquirer.slidesUp(0.3);
            }

            if (gamepad1.a) {
                acquirer.acquirerForward();
                sleep(500);
            }
            else if (gamepad1.b) {
                acquirer.acquirerReverse();
                sleep(500);
            }
            else {
                acquirer.acquirerOff();
            }

            if (gamepad1.right_bumper) {
                acquirer.slidesUp(0.7);
            }

            else if (gamepad1.left_bumper) {
                acquirer.slidesDown(0.7);
            }
            else {
                acquirer.slidesOff();
            }
            telemetry.update();
        }
    }
}