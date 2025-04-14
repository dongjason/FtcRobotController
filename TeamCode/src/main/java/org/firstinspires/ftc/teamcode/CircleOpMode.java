package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Circle Mode", group="Test")
public class CircleOpMode extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime buttonTimer = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private boolean isCircleMode = false;
    private boolean wasAPressed = false;
    private static final double DEBOUNCE_TIME = 0.25; // 250ms in seconds
    private static final double CIRCLE_SPEED = 0.5;
    private static final double TURN_RATIO = 0.4; // Adjust this to change circle size

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();
        buttonTimer.reset();

        while (opModeIsActive()) {
            if (gamepad1.a && !wasAPressed && buttonTimer.seconds() > DEBOUNCE_TIME) {
                isCircleMode = !isCircleMode;
                buttonTimer.reset();
            }
            wasAPressed = gamepad1.a;

            if (isCircleMode) {
                leftDrive.setPower(CIRCLE_SPEED);
                rightDrive.setPower(CIRCLE_SPEED * (1.0 - TURN_RATIO));
                telemetry.addData("Mode", "Circle");
            } else {
                double drive = -gamepad1.left_stick_y;
                double turn  =  gamepad1.right_stick_x;
                double leftPower  = Range.clip(drive + turn, -1.0, 1.0);
                double rightPower = Range.clip(drive - turn, -1.0, 1.0);

                leftDrive.setPower(leftPower);
                rightDrive.setPower(rightPower);
                telemetry.addData("Mode", "Manual");
            }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Circle Mode", isCircleMode);
            telemetry.update();
        }
    }
}