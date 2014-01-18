package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.recording.ControllerState;
import edu.arhs.team1100.ultimateascent.recording.RecordedRoutine;

/**
 * @author Team 1100
 */
public class PyramidTowardsFeederCommand extends RecordedRoutine {

    protected int getInterval() {
        return 50;
    }

    /**
     * Recorded autonomous routine to go towards feeder station
     *
     * @return ControllerState[]
     */
    protected ControllerState[] getRecording() {
        return new ControllerState[]{new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.0, 0.0, 1),
            new ControllerState(0.0, 0.2440944881889764, 0.0, 1),
            new ControllerState(0.0, 0.3543307086614173, 0.0, 1),
            new ControllerState(0.0, 0.5039370078740157, 0.0, 1),
            new ControllerState(0.0, 0.5196850393700787, 0.0, 1),
            new ControllerState(0.0, 0.5196850393700787, 0.0, 1),
            new ControllerState(0.0, 0.5196850393700787, 0.0, 1),
            new ControllerState(0.0, 0.4330708661417323, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.3228346456692913, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.29133858267716534, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.29133858267716534, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.4015748031496063, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.4015748031496063, 0.0, 1),
            new ControllerState(0.13385826771653545, 0.44881889763779526, 0.0, 1),
            new ControllerState(0.14960629921259844, 0.44881889763779526, 0.0, 1),
            new ControllerState(0.14960629921259844, 0.44881889763779526, 0.0, 1),
            new ControllerState(0.14960629921259844, 0.44881889763779526, 0.0, 1),
            new ControllerState(0.0, 0.4645669291338583, 0.0, 1),
            new ControllerState(0.0, 0.5039370078740157, 0.0, 1),
            new ControllerState(0.0, 0.5039370078740157, 0.0, 1),
            new ControllerState(-0.28125, 0.4330708661417323, 0.0, 1),
            new ControllerState(-0.296875, 0.4330708661417323, 0.0, 1),
            new ControllerState(-0.296875, 0.4330708661417323, 0.0, 1),
            new ControllerState(-0.328125, 0.5039370078740157, 0.0, 1),
            new ControllerState(-0.5, 0.5039370078740157, 0.0, 1),
            new ControllerState(-0.5234375, 0.5039370078740157, 0.0, 1),
            new ControllerState(-0.5703125, 0.5039370078740157, 0.0, 1),
            new ControllerState(-0.5859375, 0.4015748031496063, 0.0, 1),
            new ControllerState(-0.640625, 0.3228346456692913, 0.0, 1),
            new ControllerState(-0.6953125, 0.2125984251968504, 0.0, 1),
            new ControllerState(-0.6953125, 0.1968503937007874, 0.0, 1),
            new ControllerState(-0.6953125, 0.14960629921259844, 0.0, 1),
            new ControllerState(-0.609375, 0.0, 0.0, 1),
            new ControllerState(-0.5859375, 0.0, 0.0, 1),
            new ControllerState(-0.640625, 0.0, 0.0, 1),
            new ControllerState(-0.65625, 0.0, 0.0, 1),
            new ControllerState(-0.6953125, 0.10236220472440945, 0.0, 1),
            new ControllerState(-0.6953125, 0.10236220472440945, 0.0, 1),
            new ControllerState(-0.6953125, 0.11811023622047244, 0.0, 1)
        };
    }
}