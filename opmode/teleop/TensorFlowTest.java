package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.TensorFlow;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;

@TeleOp(name="TensorFlowTest", group="Camera")
public class TensorFlowTest extends LinearOpMode {

    double leftInput1, rightInput1, slideInput1, leftInput2, rightInput2, slideInput2;
//    Unused; fix later;
    double armPosition = 0.5;

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Arm arm = new Arm (this);
    private Platform platform = new Platform (this);
    private TensorFlow tensorflow = new TensorFlow(this);
    @Override
    public void runOpMode() throws InterruptedException {
//        Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        arm.init(hardwareMap);
        platform.init(hardwareMap);
        tensorflow.initVuforia();
        tensorflow.init(hardwareMap);
        FtcDashboard.getInstance().startCameraStream(tensorflow.vuforia, 0);
        while(!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();

        while(opModeIsActive()) {
//            telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();
//            Inputs for the stick and triggers
//            Sticks are [0,1], triggers are [-1,1] as a sum
//            leftInput1 = gamepad1.left_stick_y;
//            rightInput1 = gamepad1.right_stick_y;
            slideInput1 = -gamepad1.left_trigger + gamepad1.right_trigger;
//            Second controller
            leftInput2 = gamepad2.left_stick_y;
            rightInput2 = gamepad2.right_stick_y;
            slideInput2 = -gamepad2.left_trigger + gamepad2.right_trigger;
//            How far the stick goes
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
//            scuffed way to smooth inputs by cubing
            r = Math.pow(r,3);
            leftInput2 = Math.pow(leftInput2, 3);
//            Angle of the stick
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
//            How far the right stick goes from side to side (turning)
            double rightX1 = gamepad1.right_stick_x;

//            Controller 1: Driver

//            Driving
//            Precision mode if trigger is held, else left stick is vector driving and right stick is turning
            if (slideInput1 > 0.3) {
                drive.teleDrive(r/2, robotAngle, rightX1/2);
            }
            else if (gamepad1.dpad_left) {
                drive.strafeLeft();
            }
            else if (gamepad1.dpad_right) {
                drive.strafeRight();
                }
            else {
                drive.teleDrive(r, robotAngle, rightX1);
            }

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        tensorflow.deactivatetfod();
    }
}