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
    
    private String code = "";

    public PrintRecordingCodeCommand(RecordCommand r) {
        recorder = r;
    }

    protected void initialize() {
        finished = false;
        code = "";
    }

    /**
     * Prints out the recording as a command class that can be copy-pasted
     */
    protected void execute() {
        
        
        int interval = recorder.getInterval();
        Vector recording = recorder.getRecording();

        //THIS IS THE _ONLY_ CLASS TO USE SYSTEM.OUT.PRINTLN()
        code("");
        code("+---------------[START OF CODE]----------------------+");
        code("\n\n");
        
        //package declaration
        code("package edu.arhs.team1100.ultimateascent.recording;");
        
        //RoutineClass
        code("public class Routine"+System.currentTimeMillis()+" extends RecordedRoutine {");
        
            //getInterval()
            code("protected int getInterval(){");
                code("return "+interval+";");
            //end getInterval()
            code("}");
            
            //getRecording()
            code("protected ControllerState[] getRecording(){");
                code("return new ControllerState[]{");
                    for(int i = 0; i < recording.size(); i++){
                        code(recording.elementAt(i).toString());
                    }                    
                code("};");
            //end getRecording
            code("}");
        //end RoutineClass
        code("}");
        
        code("\n\n");
        code("+---------------[ END OF CODE ]-----------------------+");
        code("");
        
        System.out.println(code);

        finished = true;
    }
    
    private void code(String s){
        code += s ;//+ "\n";        
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
