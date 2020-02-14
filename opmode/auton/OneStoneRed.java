package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Park;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.TensorFlow;

@Autonomous(name="OneStoneRed", group="Red")
public class OneStoneRed extends LinearOpMode {

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Arm arm = new Arm(this);
    private Platform platform = new Platform(this);
    private TensorFlow tensorflow = new TensorFlow(this);
    private Park park = new Park(this);
    private int offsetStrafe = 0;
    private int offsetDrive = 0;

    @Override
    public void runOpMode() throws InterruptedException {
//        Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        arm.init(hardwareMap);
        platform.init(hardwareMap);
        park.init(hardwareMap);
        tensorflow.initVuforia();
        tensorflow.init(hardwareMap);
//        FtcDashboard.getInstance().startCameraStream(tensorflow.vuforia, 0);
        acquirer.slidesOff();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();
        drive.driveToPos(-13.5, 0.8);
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (opModeIsActive() && time.seconds() < 2) {
//          telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        if (tensorflow.location == 0) {
            telemetry.addData("IT'S LEFT,", "LEFT");
            drive.strafePID(0.9,0.7);
            offsetStrafe+=0.85;

        }
        else if (tensorflow.location > 450) {
            telemetry.addData("IT'S RIGHT", "RIGHT");
            drive.strafePID(-0.9,0.8);
            offsetStrafe-=0.9;
        }
        else if (tensorflow.location <= 450) {
            telemetry.addData("IT'S MIDDLE", "MIDDLE");
        }

        telemetry.addData("Location", tensorflow.location);
        telemetry.addData("Num", tensorflow.number);
        telemetry.update();

        //Get block
        arm.armDown();
        arm.partial();
        drive.driveToPos(-13,0.8);
        arm.close();
        sleep(500);
        arm.armUp();
        sleep(200);

        //Strafe and place
        drive.driveToPos(6.5,0.8);
        drive.strafePID(-0.9,3.1+offsetStrafe);
        drive.driveToPos(-9, 0.8);
        arm.partial();
        arm.armDown();
        sleep(300);
        arm.armUp();
        drive.driveToPos(6,0.8);
        drive.turn(165,0.5);

        //Drag foundation
        drive.driveToPos(12,0.8);
        platform.platformDown();
        sleep(200);
        drive.driveToPos(-36,1);
        drive.turn(-89,0.9);
        park.extend();
        sleep(1000);
        park.stop();

//        drive.driveToPos(3,0.8);
//        drive.strafePID(-0.9,3.5 + offsetStrafe);
//        arm.armDown();
//        arm.partial();
//        drive.driveToPos(-6,0.8);
//        arm.close();
//        sleep(600);
//        arm.armUp();
//        sleep(200);

        //Turn and pull
        platform.platformUp();
        tensorflow.deactivatetfod();
    }
}