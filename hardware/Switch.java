package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Switch extends Mechanism {
    private TouchSensor limitSwitch;  // Hardware Device Object

    public Switch() {}

    public Switch(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        limitSwitch = hwMap.touchSensor.get("switch");
    }

    public boolean isPressed() {
        return limitSwitch.isPressed();
    }
}

