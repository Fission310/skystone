package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.TensorFlow;
import org.firstinspires.ftc.teamcode.hardware.Park;

@Autonomous(name="OneStoneBlue", group="Blue")
public class OneStoneBlue extends LinearOpMode {

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
        drive.driveToPos(-13.7, 0.8);
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (opModeIsActive() && time.seconds() < 2) {
//          telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        if (tensorflow.location == 0 || tensorflow.location >= 1000 ) {
            telemetry.addData("IT'S RIGHT", "RIGHT");
            drive.strafePID(-0.9, 0.90);
            offsetStrafe+=1.0;
        }
        else if (tensorflow.location > 450) {
            telemetry.addData("IT'S MIDDLE", "MIDDLE");
            drive.strafePID(-0.9,0.52);
            offsetStrafe+=0.7;
        }
        else if (tensorflow.location <= 450) {
            telemetry.addData("IT'S LEFT,", "LEFT");
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
        drive.driveToPos(5,0.8);
        drive.strafePID(0.9,3.4+offsetStrafe);
        drive.strafePID(-0.9,0.65);
        drive.driveToPos(-10, 0.8);
        arm.partial();
        arm.armDown();
        sleep(300);
        arm.armUp();
        drive.driveToPos(6,0.8);
        drive.turn(171,0.5);

        //Drag foundation
        drive.driveToPos(9,0.8);
        platform.platformDown();
        sleep(200);
        drive.driveToPos(-34,1);
        drive.turn(95,0.9);
        drive.driveToPos(6,0.9);
        drive.strafePID(0.9,0.5);
        park.extend();
        sleep(1500);
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