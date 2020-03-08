package org.firstinspires.ftc.teamcode.opmode.teleop;

import android.graphics.Paint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Capstone;
import org.firstinspires.ftc.teamcode.hardware.Clamper;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Leg;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.Lock;

import org.firstinspires.ftc.teamcode.hardware.Tape;


@TeleOp(name="PairedMain", group="Main")
public class PairedMain extends LinearOpMode {

    private double leftInput1, rightInput1, slideInput1, leftInput2, rightInput2, slideInput2;
    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Tape tape = new Tape(this);
    private Leg leg = new Leg(this);
    private Lock lock = new Lock (this);
    private Lift lift = new Lift(this);
    private Clamper clamper = new Clamper(this);
    private Capstone cap = new Capstone(this);
    private boolean clampBool = false;
    private String pusher;

    @Override
    public void runOpMode() throws InterruptedException {
        //Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        lock.init(hardwareMap);
        lift.init(hardwareMap);
        clamper.init(hardwareMap);
        leg.init(hardwareMap);
        tape.init(hardwareMap);
        cap.init(hardwareMap);

        while(!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }
        waitForStart();

        while(opModeIsActive()) {
            //Inputs for the stick and triggers
            // Sticks are [0,1], triggers are [-1,1] as a sum
            leftInput1 = gamepad1.left_stick_y;
            rightInput1 = gamepad1.right_stick_y;
            slideInput1 = -gamepad1.left_trigger + gamepad1.right_trigger;

            //Second controller
            leftInput2 = -gamepad2.left_stick_y;
            rightInput2 = -gamepad2.right_stick_y;
            slideInput2 = -gamepad2.left_trigger + gamepad2.right_trigger;

            //How far the stick goes
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);

            //\scuffed way to smooth inputs by cubing
            r = Math.pow(r,3);
            leftInput2 = Math.pow(leftInput2, 3);

            //Angle of the stick
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;

            //How far the right stick goes from side to side (turning)
            double rightX1 = gamepad1.right_stick_x;

            // Controller 1: Driver
            if (gamepad1.dpad_left) {
                drive.strafeLeft();
            }
            else if (gamepad1.dpad_right) {
                drive.strafeRight();
            }
            else if (slideInput1 < -0.3) {
                drive.teleDrive(r/3, robotAngle, rightX1/3);
            }
            else {
                drive.teleDrive(r, robotAngle, rightX1);
            }
            if(gamepad1.right_bumper) {
                lock.pusherUp();
                acquirer.acquire();

            }
            else if(gamepad1.left_bumper) {

                acquirer.unacquire();
            }
            else {
                acquirer.off();
            }

            if (gamepad1.dpad_up) {
                tape.extend();
            }
            else if (gamepad1.dpad_down) {
                tape.retract();
            }
            else {
                tape.stop();
            }


            if(gamepad2.y) {
                pusher = "down";
                lock.pusherDown();
                lock.stopperUp();
                sleep(500);
                leg.push();
                lock.pusherUp();
                pusher = "up";
                lock.stopperDown();
            }
            if (gamepad2.a) {
                pusher = "up";
                lock.pusherUp();
            }
            else if (gamepad2.b) {
                pusher = "down";
                lock.pusherDown();
            }
            if (clampBool) {
                clamper.close();
            }
            else {
                clamper.open();
            }
            if (gamepad2.x) {
                clampBool = !clampBool;
                sleep(200);
            }

            if (leftInput2 > 0.3 ) {
                lift.up();
            }
            else if (leftInput2 < -0.3 && !lift.botIsPressed()) {
                lift.down();
            }
            else lift.stop();

            if(gamepad2.left_bumper){
                cap.down();
                sleep(400);
                cap.up();
            }

            telemetry.addData("angle", drive.getAngle());
//            telemetry.addData("slide", slideInput1);
//            telemetry.addData("righttrigger", gamepad1.right_trigger);
//            telemetry.addData("rightx1", rightX1);
//            telemetry.addData("leftx1", gamepad1.left_stick_x);
//            telemetry.addData("lefty", leftInput2);
            telemetry.addData("pusher", pusher);
            telemetry.addData("clamper", clampBool);
            telemetry.update();

        }
    }
}