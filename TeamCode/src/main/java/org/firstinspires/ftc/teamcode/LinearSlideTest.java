package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by manjeshpuram on 11/19/17.
 */

@TeleOp(name = "LinearSlideTest")
public class LinearSlideTest extends LinearOpMode
{
    //private DcMotor LinearSlideMotor; //Declare Linear Slide Motor
    private DcMotor rightMotorOutside;
    private DcMotor leftMotorOutside;
    private DcMotor rightMotorInside;
    private DcMotor leftMotorInside;
    private Servo rightServo;
    private Servo leftServo;


    @Override
    public void runOpMode() throws InterruptedException
    {
        //LinearSlideMotor = hardwareMap.dcMotor.get("LinearSlideMotor"); //Call for Linear Slide Motor
        rightMotorOutside = hardwareMap.dcMotor.get("rightMotorOutside");
        leftMotorOutside = hardwareMap.dcMotor.get("leftMotorOutside");
        rightMotorInside = hardwareMap.dcMotor.get("rightMotorInside");
        leftMotorInside = hardwareMap.dcMotor.get("leftMotorInside");
        leftMotorInside.setDirection(DcMotor.Direction.REVERSE);
        leftMotorOutside.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive())
        {
            float LinearSlide;
            float RightSide;
            float LeftSide;
            float RightSlide;
            float LeftSlide;

            LinearSlide = -gamepad2.left_stick_y;
            RightSide = -gamepad1.right_stick_y;
            LeftSide = -gamepad1.left_stick_y;
            RightSlide = -gamepad1.right_stick_x;
            LeftSlide = -gamepad1.left_stick_x;

            LinearSlide = Range.clip(LinearSlide, -1, 1);
            LeftSide = Range.clip(LeftSide, -1, 1);
            RightSide = Range.clip(RightSide, -1, 1);
            RightSlide = Range.clip(RightSlide, -1, 1);
            LeftSlide = Range.clip(LeftSlide, -1, 1);

            LinearSlide = (float) scaleInput(LinearSlide);
            RightSide = (float) scaleInput(RightSide);
            LeftSide = (float) scaleInput(LeftSide);
            RightSlide = (float) scaleInput(RightSlide);
            LeftSlide = (float) scaleInput(LeftSlide);


            if (gamepad1.left_stick_y > 0.25)
            {
                LeftSide /= 3;
            }

            if (gamepad1.right_stick_y > 0.25)
            {
                RightSide /= 3;
            }

            if (gamepad2.left_trigger > 0.25) {
                LinearSlide /= 3;
            }

            //Basic Drive
            rightMotorInside.setPower(RightSide);
            rightMotorOutside.setPower(RightSide);
            leftMotorInside.setPower(LeftSide);
            leftMotorOutside.setPower(LeftSide);
            //LinearSlideMotor.setPower(LinearSlide);
            //Side to Side Left
            rightMotorInside.setPower(LeftSlide);
            rightMotorOutside.setPower(-LeftSlide);
            leftMotorInside.setPower(-LeftSlide);
            leftMotorOutside.setPower(LeftSlide);
            //Side to Side Right
            rightMotorInside.setPower(-RightSlide);
            rightMotorOutside.setPower(RightSlide);
            leftMotorInside.setPower(RightSlide);
            leftMotorOutside.setPower(-RightSlide);

            idle();
        }

    }


    double scaleInput(double dVal)
    {
        double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};
        int index = (int) (dVal * 16.0);
        if (index < 0) {
            index = -index;
        }
        if (index > 16) {
            index = 16;
        }
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }
        return dScale;
    }
}
