package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
// import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;

@TeleOp(name="Drive", group="Teleop")
public class DriveTest extends LinearOpMode {

    double leftInput, rightInput, slideInput;

    // private Drivetrain drive = new Drivetrain();
    private Acquirer acquirer = new Acquirer();
    @Override
    public void runOpMode() throws InterruptedException {
        acquirer.init(hardwareMap);

        while(!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();

        while(opModeIsActive()) {
            leftInput = gamepad1.left_stick_y;
            rightInput = gamepad1.right_stick_y;
            slideInput = -gamepad1.left_trigger + gamepad1.right_trigger;
            if (gamepad1.a) {
                acquirer.acquirerForward();
            }
            else if (gamepad1.b) {
                acquirer.acquirerReverse();
            }
            else {
                acquirer.acquirerOff();
            }
        }
    }
}