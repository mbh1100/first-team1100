package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import java.util.Vector;

/**
 *
 * @author akshay
 */
public class PrintRecordingCodeCommand extends CommandBase {

    private RecordCommand recorder;
    private boolean finished;

    public PrintRecordingCodeCommand(RecordCommand r) {
        recorder = r;
    }

    protected void initialize() {
        finished = false;
    }

    /**
     * Prints out the recording as a command class that can be copy-pasted
     */
    protected void execute() {
        
        
        int interval = recorder.getInterval();
        Vector recording = recorder.getRecording();

        //THIS IS THE _ONLY_ CLASS TO USE SYSTEM.OUT.PRINTLN()
        System.out.println();
        System.out.println("+--------------------------------------------------+");
        System.out.println();
        
        //package declaration
        System.out.println("package edu.arhs.team1100.ultimateascent.recording;");
        
        //RoutineClass
        System.out.println("public class Routine"+System.currentTimeMillis()+" extends RecordedRoutine {");
        
            //getInterval()
            System.out.println("protected int getInterval(){");
                System.out.println("return "+interval+";");
            //end getInterval()
            System.out.println("}");
            
            //getRecording()
            System.out.println("protected ControllerState[] getRecording(){");
                System.out.println("return new ControllerState[]{");
                    for(int i = 0; i < recording.size(); i++){
                        System.out.println(recording.elementAt(i).toString());
                    }                    
                System.out.println("};");
            //end getRecording
            System.out.println("}");
        //end RoutineClass
        System.out.println("}");
        
        System.out.println();
        System.out.println("+--------------------------------------------------+");
        System.out.println();

        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        if (!finished) {
            execute();
        }
    }

    protected void interrupted() {
        end();
    }
}
