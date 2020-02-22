package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.oldHardware.Platform;
import org.firstinspires.ftc.teamcode.hardware.TensorFlow;
@Disabled
@Autonomous(name="TwoSkystone", group="Blue")
public class TwoSkystone extends LinearOpMode {

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
//        acquirer.slidesOff();
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
        drive.driveToPos(-13.5,1);
        arm.close();
        sleep(600);
        arm.armUp();
        sleep(200);

        //Strafe and place
        drive.driveToPos(6,1);
        drive.strafePID(0.7,2.9+offsetStrafe);
        drive.driveToPos(-9.5,1);
        arm.armDown();
        sleep(400);
        arm.partial();
        sleep(500);
        arm.armUp();
        drive.driveToPos(3.5, 1);

        //Turn and pull
        drive.turn(-165,0.7);
        drive.driveToPos(7,1);
        platform.platformDown();
        drive.driveToPos(-20,1);

//        drive.driveToPos(8,1);
//        drive.strafePID(-0.7,3.4+offset);
//        arm.armDown();
//        arm.partial();
//        drive.driveToPos(-5,1);
//        arm.close();
//        sleep(600);
//        arm.armUp();
//        drive.driveToPos(5,1);
//        drive.strafePID(0.7, 3.5 + offset);
//        drive.driveToPos(-5,1);
//        arm.armDown();
//        sleep(400);
//        arm.open();
//        sleep(500);
//        arm.armUp();
        tensorflow.deactivatetfod();
    }
}