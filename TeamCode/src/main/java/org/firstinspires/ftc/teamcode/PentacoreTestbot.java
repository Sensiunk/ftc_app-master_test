package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by manjeshpuram on 10/15/17.
 */

@TeleOp(name = "Manjesh's Test")
@Disabled
public class PentacoreTestbot extends LinearOpMode
{
    private DcMotor motorRight;
    private DcMotor motorLeft;
    private DcMotor motorArm;

    private Servo rightServo;
    private Servo leftServo;

    @Override
    public void runOpMode() throws InterruptedException
    {
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorArm = hardwareMap.dcMotor.get("motorArm");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorArm.setDirection(DcMotor.Direction.REVERSE);

        leftServo = hardwareMap.servo.get("leftServo");
        rightServo = hardwareMap.servo.get("rightServo");

        waitForStart();

        while (opModeIsActive())
        {
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);
            motorArm.setPower(-gamepad2.left_stick_y);

            if(gamepad2.a)
            {
                telemetry.log().add("Test1", "Test1");
                rightServo.setPosition(-0.6);
            }
            if (gamepad2.b)
            {
                telemetry.log().add("Test2", "Test2");
                rightServo.setPosition(2);
            }
            if(gamepad2.x)
            {
                telemetry.log().add("Test1", "Test1");
                leftServo.setPosition(1.5);
            }
            if(gamepad2.y)
            {
                telemetry.log().add("Test2", "Test2");
                leftServo.setPosition(0.2);
            }
            idle();
        }
    }
}
