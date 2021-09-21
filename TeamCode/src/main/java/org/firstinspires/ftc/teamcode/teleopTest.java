package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

public class teleopTest extends drive_3666{
    private static double adjust = .6;


    public void runOpMode(){
        telemetry.addData("Say", "Hello, all powerful Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while(opModeIsActive()){
            leftRight(gamepad1.left_stick_y*adjust, gamepad1.right_stick_y*adjust);
        }
    }
}
