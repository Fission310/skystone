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
        drive.strafePID(-0.5,1);
        drive.driveToPos(-18, 0.5);
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (opModeIsActive() && time.seconds() < 3) {
//          telemetry.addData("location:", tensorflow.skystoneLocation());
            tensorflow.printTelemetry();

//            Random telemetry for testing purposes
//            telemetry.addData("Driving", "");
            telemetry.update();
        }
        if (tensorflow.location == 0  ) {
            telemetry.addData("IT'S RIGHT", "RIGHT");
            drive.strafePID(-0.7,0.8);
        }
        else if (tensorflow.location > 200) {
            telemetry.addData("IT'S MIDDLE", "MIDDLE");
            drive.strafePID(-0.7,0.5);
        }
        else if (tensorflow.location <= 200) {
            telemetry.addData("IT'S LEFT,", "LEFT");
        }

        telemetry.addData("Location", tensorflow.location);
        telemetry.addData("Num", tensorflow.number);
        telemetry.update();
        drive.driveToPos(-10,0.7);
        arm.armDown();
        arm.acquire();
        sleep(1000);
        arm.armUp();
        sleep(1000);
        arm.armPivot(0);
        drive.driveToPos(10,1);
        sleep(20000);
        tensorflow.deactivatetfod();
    }
}