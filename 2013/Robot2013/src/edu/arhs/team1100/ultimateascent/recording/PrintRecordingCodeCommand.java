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
        add();
        add("+--------------------------------------------------+");
        add();
        
        //package declaration
        add("package edu.arhs.team1100.ultimateascent.recording;");
        
        //RoutineClass
        add("public class Routine"+System.currentTimeMillis()+" extends RecordedRoutine {");
        
            //getInterval()
            add("protected int getInterval(){");
                add("return "+interval+";");
            //end getInterval()
            add("}");
            
            //getRecording()
            add("protected ControllerState[] getRecording(){");
                add("return new ControllerState[]{");
                    for(int i = 0; i < recording.size(); i++){
                        add(recording.elementAt(i).toString());
                    }                    
                add("};");
            //end getRecording
            add("}");
        //end RoutineClass
        add("}");
        
        add();
        add("+--------------------------------------------------+");
        add();
        
        System.out.println(code);

        finished = true;
    }
    
    private void add(String s){
        code += s + "\n";        
    }
    
    private void add(){
        add("");
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
