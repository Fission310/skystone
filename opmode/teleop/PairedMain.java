package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Switch;

@TeleOp(name="PairedMain", group="Teleop")
public class PairedMain extends LinearOpMode {

    double leftInput1, rightInput1, slideInput1, leftInput2, rightInput2, slideInput2;
//    Unused; fix later;
    double armPosition = 0.5;

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Arm arm = new Arm (this);
    private Platform platform = new Platform (this);
    private Switch limitSwitch = new Switch (this);
    @Override
    public void runOpMode() throws InterruptedException {
//        Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        arm.init(hardwareMap);
        platform.init(hardwareMap);
        limitSwitch.init(hardwareMap);

        while(!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();

        while(opModeIsActive()) {
//            Inputs for the stick and triggers
//            Sticks are [0,1], triggers are [-1,1] as a sum
//            leftInput1 = gamepad1.left_stick_y;
//            rightInput1 = gamepad1.right_stick_y;
            slideInput1 = -gamepad1.left_trigger + gamepad1.right_trigger;
//            Second controller
            leftInput2 = -gamepad2.left_stick_y;
            rightInput2 = -gamepad2.right_stick_y;
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
                drive.teleDrive(r/3, robotAngle, rightX1/2);
            }
            else if (gamepad1.dpad_left) {
                drive.strafeLeft();
            }
            else if (gamepad1.dpad_right) {
                drive.strafeRight();
                }
            else if (gamepad1.dpad_up) {
                drive.driveStraightPID(1,0.2);
            }
            else if (gamepad1.dpad_down){
                drive.driveStraightPID(-1,0.2);
            }
            else {
                drive.teleDrive(r, robotAngle, rightX1);
            }

//            Controller 2: Operator

//            Moving the Lift
//            Checks if right joystick is moved vertically
            if (Math.abs(rightInput2) > 0.3) {
//                Either scores or acquires depending on if up or down
                if (rightInput2 > 0.3) {
                    acquirer.scoring();
                }
                else if (rightInput2 < 0.3 && !limitSwitch.isPressed()) {
                    acquirer.acquiring();
                }
            }
//            Individually controlling the linear slides and the acquirer
            else {
//                Making it so that the slides and acquirer can run at the same time
//                Acquirer uses bumpers
                if (gamepad2.right_bumper) {
                    acquirer.acquirerUp();
                }
                else if (gamepad2.left_bumper) {
                    acquirer.acquirerDown();
                }
                else {
                    acquirer.acquirerOff();
                }
//                Linear slide uses the left joystick (same logic as right joystick)
                if (limitSwitch.isPressed()) {
                    if (leftInput2>0.1) {
                        acquirer.slidesUp();
                    }
                    else {
                        acquirer.slidesOff();
                    }
                }
                if (Math.abs(leftInput2) > 0.1) {
                    if (slideInput2 > 0.3) {
//                Raises or lowers depending on if up or down
                        if (leftInput2 > 0.1) {
                            acquirer.slidesDown();
                        } else if (leftInput2 < -0.1 && !limitSwitch.isPressed()) {
                            acquirer.slidesUp();
                        }
                    }
                    else {
//                Raises or lowers depending on if up or down
                        if (leftInput2 > 0.1) {
                            acquirer.slidesUp();
                        } else if (leftInput2 < -0.1 && !limitSwitch.isPressed()) {
                            acquirer.slidesDown();
                        }
                    }
                }
                else {
                    acquirer.slidesOff();
                }

            }
//            Miscellaneous arm and alignment servos
//            Arm servo uses the up and down d pad
//            Implementing incremental inputs later; for now using standard boolean
            if (gamepad2.dpad_up) {
                arm.armUp();
            }
            else if (gamepad2.dpad_down) {
                arm.armDown();
            }
//            Platform servos use a and b (operate together, not independently)
            if (gamepad2.a) {
                platform.platformUp();
            }
            else if (gamepad2.b) {
                platform.platformDown();
            }

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.addData("slide", slideInput1);
            telemetry.addData("righttrigger", gamepad1.right_trigger);
            telemetry.addData("rightx1", rightX1);
            telemetry.addData("leftx1", gamepad1.left_stick_x);
            telemetry.addData("lefty", leftInput2);
            telemetry.addData("limitSwitch", limitSwitch.isPressed());
            telemetry.update();
        }
    }
}