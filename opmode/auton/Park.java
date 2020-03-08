package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Acquirer;
import org.firstinspires.ftc.teamcode.hardware.Clamper;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.Tape;

@Autonomous(name="Park", group="Blue")
public class Park extends LinearOpMode {

    private Drivetrain drive = new Drivetrain(this);
    private Acquirer acquirer = new Acquirer(this);
    private Clamper clamper = new Clamper(this);
    private Lift lift = new Lift(this);
    private Tape tape = new Tape(this);
//    private TensorFlow tensorflow = new TensorFlow(this);

    @Override
    public void runOpMode() throws InterruptedException {
//        Initializing
        acquirer.init(hardwareMap);
        drive.init(hardwareMap);
        clamper.init(hardwareMap);
        lift.init(hardwareMap);
        tape.init(hardwareMap);
//        tensorflow.initVuforia();
//        tensorflow.init(hardwareMap);
//        FtcDashboard.getInstance().startCameraStream(tensorflow.vuforia, 0);
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }
        waitForStart();
        tape.extend();
        sleep(5000);
        tape.stop(); 
    }
}