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

@Autonomous(name="CVTest", group="Test")
public class CVTest extends LinearOpMode {

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Arm arm = new Arm(this);
    private Platform platform = new Platform(this);
    private TensorFlow tensorflow = new TensorFlow(this);
    private int offsetStrafe = 0;
    private int offsetDrive = 0;

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
        acquirer.slidesOff();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        waitForStart();
        drive.driveToPos(-13.7, 0.8);
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (opModeIsActive() && time.seconds() < 1.5) {
//          telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        if (tensorflow.location == 0 || tensorflow.location >= 1000 ) {
            telemetry.addData("IT'S RIGHT", "RIGHT");
            drive.strafePID(-0.7,0.9);
            offsetStrafe+=0.9;
        }
        else if (tensorflow.location > 500) {
            telemetry.addData("IT'S MIDDLE", "MIDDLE");
            drive.strafePID(-0.7,0.45);
            offsetStrafe+=0.4;
        }
        else if (tensorflow.location <= 500) {
            telemetry.addData("IT'S LEFT,", "LEFT");
        }

        telemetry.addData("Location", tensorflow.location);
        telemetry.addData("Num", tensorflow.number);
        telemetry.update();

        //Get block
        arm.armDown();
        arm.partial();
        drive.driveToPos(-13.5,0.8);
        arm.close();
        sleep(600);
        arm.armUp();
        sleep(200);

        //Strafe and place
        drive.driveToPos(6.5,0.8);
        drive.strafePID(0.9,3.0+offsetStrafe);
        arm.open();
        arm.armDown();
        sleep(300);
        drive.strafePID(-0.9,3.5 + offsetStrafe);
        arm.armDown();
        arm.partial();
        drive.driveToPos(-13.5,0.8);
        arm.close();
        sleep(600);
        arm.armUp();
        sleep(200);

        //Turn and pull

        tensorflow.deactivatetfod();
    }
}