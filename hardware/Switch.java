package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Switch extends Mechanism {
    private DigitalChannel limitSwitch;  // Hardware Device Object

    public Switch() {}

    public Switch(LinearOpMode opMode){ this.opMode = opMode; }

    public void init(HardwareMap hwMap) {
        limitSwitch = hwMap.digitalChannel.get("switch");
        limitSwitch.setMode(DigitalChannel.Mode.INPUT);
    }

    public boolean isPressed() {
        return !limitSwitch.getState();
    }
}
