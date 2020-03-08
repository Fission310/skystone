package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Clamper;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Lift;

@Autonomous(name="TwoStoneRed", group="Red")
public class TwoStoneRed extends LinearOpMode {

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Clamper clamper = new Clamper(this);
    private Lift lift = new Lift(this);
//    private TensorFlow tensorflow = new TensorFlow(this);

    @Override
    public void runOpMode() throws InterruptedException {
//        Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        clamper.init(hardwareMap);
        lift.init(hardwareMap);
//        tensorflow.initVuforia();
//        tensorflow.init(hardwareMap);
//        FtcDashboard.getInstance().startCameraStream(tensorflow.vuforia, 0);
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }
        waitForStart();
        drive.strafePID(-0.8,1.5);
        drive.driveToPos(-3, 0.8);
        clamper.close();
        sleep(500);
        drive.driveToPos(3, 0.8);
        drive.strafePID(0.8,0.7);
        drive.driveToPos(58,0.8);
        lift.pulley.setPower(1);
        sleep(600);
        lift.stop();
//        clamper.open();
//        sleep(500);
//        drive.driveToPos(-53,0.8);
//        drive.strafePID(-0.8,0.65);
        drive.turn(90,0.8);
        drive.driveToPos(-3, 0.8);
        clamper.open();
        drive.driveToPos(6,0.8);
        while (!lift.botIsPressed()) {
            lift.down();
        }
        lift.stop();
        drive.turn(-90,0.8);
        drive.driveToPos(-64,0.8);
        drive.strafePID(-0.8, 0.65);
        drive.driveToPos(-5, 0.8);
        clamper.close();
        sleep(500);
        drive.strafePID(0.8,0.65);
        drive.driveToPos(78,0.8);
        lift.pulley.setPower(1);
        sleep(400);
        lift.pulley.setPower(0);
        drive.turn(90,0.8);
        drive.driveToPos(-4,0.8);
        clamper.open();
        sleep(500);
        drive.strafePID(0.8,0.3);
        drive.driveToPos(-4,0.8);
        lift.pulley.setPower(-1);
        sleep(500);
        lift.pulley.setPower(0);
        drive.driveToPos(40,0.8);
        lift.pulley.setPower(1);
        sleep(400);
        lift.pulley.setPower(0);
        drive.strafePID(0.8,1);
        lift.pulley.setPower(-1);
        sleep(400);
        drive.strafePID(0.8,0.7);

    }
}