package org.firstinspires.ftc.teamcode.opmode.auton;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.TensorFlow;

@Autonomous(name="CVTest", group="Camera")
public class CVTest extends LinearOpMode {

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Arm arm = new Arm(this);
    private Platform platform = new Platform(this);
    private TensorFlow tensorflow = new TensorFlow(this);
    private int offset = 0;

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
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();
        drive.strafePID(-0.4,1.4);
        drive.driveToPos(-17.5, 0.8);
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (opModeIsActive() && time.seconds() < 2.5) {
//          telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        if (tensorflow.location == 0 || tensorflow.location >= 800 ) {
            telemetry.addData("IT'S RIGHT", "RIGHT");
            drive.strafePID(-0.4,1.5);
            offset+=0.9;
        }
        else if (tensorflow.location > 200) {
            telemetry.addData("IT'S MIDDLE", "MIDDLE");
            drive.strafePID(-0.4,0.75);
            offset+=0.4;
        }
        else if (tensorflow.location <= 200) {
            telemetry.addData("IT'S LEFT,", "LEFT");
        }

        telemetry.addData("Location", tensorflow.location);
        telemetry.addData("Num", tensorflow.number);
        telemetry.update();
        arm.armDown();
        arm.partial();
        sleep(100);
        drive.driveToPos(-10,0.8);
        sleep(100);
        arm.close();
        sleep(350);
        arm.armUp();
        sleep(200);
        drive.driveToPos(10,0.8);
        drive.strafePID(0.7,3.3+offset);
        drive.driveToPos(-11,0.8);
        arm.armDown();
        sleep(400);
        arm.open();
        sleep(500);
        arm.armUp();
        sleep(300);
        drive.driveToPos(10,0.8);
        drive.strafePID(-0.7,4.5+offset);
        arm.armDown();
        arm.partial();
        sleep(400);
        arm.close();
        sleep(350);
        arm.armUp();
        sleep(200);
        tensorflow.deactivatetfod();
    }
}