package org.firstinspires.ftc.teamcode.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;

@TeleOp(name="Drive", group="Test")
public class DriveTest extends LinearOpMode {

    double leftInput, rightInput, slideInput;

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

            drive.teleDrive(r, robotAngle, rightX);

            if (gamepad1.a) {
                acquirer.acquirerUp();
                sleep(500);
            }
            else if (gamepad1.b) {
                acquirer.acquirerDown();
                sleep(500);
            }
            else {
                acquirer.acquirerOff();
            }

            if (gamepad1.right_bumper) {
                acquirer.slidesUp();
            }

            else if (gamepad1.left_bumper) {
                acquirer.slidesDown();
            }
            else {
                acquirer.slidesOff();
            }
            telemetry.update();
        }
    }
}