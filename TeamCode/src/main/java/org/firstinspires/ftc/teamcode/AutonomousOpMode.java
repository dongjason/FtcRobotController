package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Basic: Autonomous", group="Robot")
public class AutonomousOpMode extends LinearOpMode {
    // Declare OpMode members
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        // Most robots need the motor on one side to be reversed to drive forward
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // Autonomous code goes here
        // Drive forward for 2 seconds
        leftDrive.setPower(0.5);
        rightDrive.setPower(0.5);
        sleep(2000);  // Wait for 2 seconds

        // Stop the robot
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }
}