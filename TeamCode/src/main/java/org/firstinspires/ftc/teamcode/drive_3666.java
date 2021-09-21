package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="drive 3666")
@Disabled
public class drive_3666 extends LinearOpMode {
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    public ElapsedTime runtime = new ElapsedTime();


    public static final int corrections = -1;
    public static final int off = 0;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        setUpHardware();
    }


    public void setUpHardware() {
        leftDrive = hardwareMap.dcMotor.get("left drive");
        rightDrive = hardwareMap.dcMotor.get("right drive");
    }


    //Driving functions
    public void F(double p, double t){
        runtime.reset();
        while(runtime.seconds() < t) {
            LW(p);
            RW(p);
        }
        if(runtime.seconds() >= t){
            LW(off);
            RW(off);
        }
    }
    public void B(double p, double t){
        runtime.reset();
        while(runtime.seconds() < t) {
            LW(-p);
            RW(-p);
        }
        if(runtime.seconds() >= t){
            LW(off);
            RW(off);
        }
    }
    public void leftRightTime(double pl, double pr, double t){
        runtime.reset();
        while(runtime.seconds() < t) {
            LW(pl);
            RW(pr);
        }
        if(runtime.seconds() >= t){
            LW(off);
            RW(off);
        }
    }





    //Primative functions
    public void LW(double d) { leftDrive.setPower(d*corrections*-1); }
    public void RW(double d) { rightDrive.setPower(d * corrections); }
    public void leftRight(double pl, double pr){ LW(pl); RW(pr);}
}
