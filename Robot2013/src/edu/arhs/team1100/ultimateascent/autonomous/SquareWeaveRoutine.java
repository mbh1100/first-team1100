package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.recording.ControllerState;
import edu.arhs.team1100.ultimateascent.recording.RecordedRoutine;

/**
 * @author Team 1100
 */
public class SquareWeaveRoutine extends RecordedRoutine {

    protected int getInterval() {
        return 50;
    }

    /**
     * [S]tart, [E]nd
     *
     * -----E / ---- / / \ | 0 / 0 | \------/ | / /-----------/ / ---- | / \ \ 0
     * / 0 | ---- /-----/ S/
     *
     * Drives robot in a square
     *
     * @return
     */
    protected ControllerState[] getRecording() {
        return new ControllerState[]{
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, -0.140625, 0.0, 0),
            new ControllerState(0.0, -0.2265625, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.2421875, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(-0.109375, 0.0, 0.0, 0),
            new ControllerState(-0.140625, 0.0, 0.0, 0),
            new ControllerState(-0.2265625, 0.0, 0.0, 0),
            new ControllerState(-0.2421875, 0.0, 0.0, 0),
            new ControllerState(-0.265625, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.3984375, 0.0, 0.0, 0),
            new ControllerState(-0.3984375, 0.0, 0.0, 0),
            new ControllerState(-0.3984375, 0.0, 0.0, 0),
            new ControllerState(-0.3984375, 0.0, 0.0, 0),
            new ControllerState(-0.3984375, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.11023622047244094, 0.0, 0),
            new ControllerState(0.0, 0.18110236220472442, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(0.0, 0.2677165354330709, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.31496062992125984, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.2125984251968504, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.10236220472440945, 0.0, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.25984251968503935, 0.0, 0.0, 0),
            new ControllerState(0.23622047244094488, 0.0, 0.0, 0),
            new ControllerState(0.23622047244094488, 0.0, 0.0, 0),
            new ControllerState(0.23622047244094488, 0.0, 0.0, 0),
            new ControllerState(0.23622047244094488, 0.0, 0.0, 0),
            new ControllerState(0.31496062992125984, 0.0, 0.0, 0),
            new ControllerState(0.3543307086614173, 0.0, 0.0, 0),
            new ControllerState(0.3700787401574803, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.4251968503937008, 0.0, 0.0, 0),
            new ControllerState(0.3700787401574803, 0.0, 0.0, 0),
            new ControllerState(0.3543307086614173, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.23622047244094488, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.11023622047244094, 0.0, 0),
            new ControllerState(0.0, 0.2677165354330709, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.31496062992125984, 0.0, 0),
            new ControllerState(0.0, 0.31496062992125984, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.2677165354330709, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(0.0, 0.2283464566929134, 0.0, 0),
            new ControllerState(-0.140625, 0.28346456692913385, 0.0, 0),
            new ControllerState(-0.2109375, 0.2992125984251969, 0.0, 0),
            new ControllerState(-0.265625, 0.2283464566929134, 0.0, 0),
            new ControllerState(-0.3125, 0.18110236220472442, 0.0, 0),
            new ControllerState(-0.328125, 0.18110236220472442, 0.0, 0),
            new ControllerState(-0.3515625, 0.13385826771653545, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.46875, 0.0, 0.0, 0),
            new ControllerState(-0.484375, 0.0, 0.0, 0),
            new ControllerState(-0.484375, 0.0, 0.0, 0),
            new ControllerState(-0.484375, 0.0, 0.0, 0),
            new ControllerState(-0.484375, 0.0, 0.0, 0),
            new ControllerState(-0.484375, -0.1015625, 0.0, 0),
            new ControllerState(-0.484375, -0.1015625, 0.0, 0),
            new ControllerState(-0.484375, -0.125, 0.0, 0),
            new ControllerState(-0.484375, -0.1640625, 0.0, 0),
            new ControllerState(-0.5, -0.203125, 0.0, 0),
            new ControllerState(-0.5, -0.2421875, 0.0, 0),
            new ControllerState(-0.5, -0.265625, 0.0, 0),
            new ControllerState(-0.5, -0.265625, 0.0, 0),
            new ControllerState(-0.5, -0.265625, 0.0, 0),
            new ControllerState(-0.5, -0.265625, 0.0, 0),
            new ControllerState(-0.3828125, -0.28125, 0.0, 0),
            new ControllerState(-0.3515625, -0.3203125, 0.0, 0),
            new ControllerState(-0.328125, -0.359375, 0.0, 0),
            new ControllerState(-0.296875, -0.359375, 0.0, 0),
            new ControllerState(-0.296875, -0.359375, 0.0, 0),
            new ControllerState(-0.28125, -0.3828125, 0.0, 0),
            new ControllerState(-0.265625, -0.3984375, 0.0, 0),
            new ControllerState(-0.265625, -0.421875, 0.0, 0),
            new ControllerState(-0.2265625, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.3984375, 0.0, 0),
            new ControllerState(0.0, -0.34375, 0.0, 0),
            new ControllerState(0.0, -0.28125, 0.0, 0),
            new ControllerState(-0.109375, -0.203125, 0.0, 0),
            new ControllerState(-0.1953125, 0.0, 0.0, 0),
            new ControllerState(-0.2265625, 0.0, 0.0, 0),
            new ControllerState(-0.265625, 0.0, 0.0, 0),
            new ControllerState(-0.28125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, -0.1015625, 0.0, 0),
            new ControllerState(-0.2421875, -0.1796875, 0.0, 0),
            new ControllerState(-0.2421875, -0.1796875, 0.0, 0),
            new ControllerState(-0.2421875, -0.1796875, 0.0, 0),
            new ControllerState(-0.296875, -0.1796875, 0.0, 0),
            new ControllerState(-0.3125, -0.1796875, 0.0, 0),
            new ControllerState(-0.3125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.328125, 0.0, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.46875, 0.0, 0.0, 0),
            new ControllerState(-0.46875, 0.0, 0.0, 0),
            new ControllerState(-0.46875, 0.0, 0.0, 0),
            new ControllerState(-0.46875, 0.11023622047244094, 0.0, 0),
            new ControllerState(-0.46875, 0.11023622047244094, 0.0, 0),
            new ControllerState(-0.484375, 0.13385826771653545, 0.0, 0),
            new ControllerState(-0.3671875, 0.18110236220472442, 0.0, 0),
            new ControllerState(-0.3515625, 0.1968503937007874, 0.0, 0),
            new ControllerState(-0.328125, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.296875, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.265625, 0.2677165354330709, 0.0, 0),
            new ControllerState(-0.2265625, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2992125984251969, 0.0, 0),
            new ControllerState(0.0, 0.2125984251968504, 0.0, 0),
            new ControllerState(0.0, 0.1968503937007874, 0.0, 0),
            new ControllerState(0.0, 0.14960629921259844, 0.0, 0),
            new ControllerState(0.14173228346456693, 0.0, 0.0, 0),
            new ControllerState(0.16535433070866143, 0.0, 0.0, 0),
            new ControllerState(0.2204724409448819, 0.0, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.0, 0.0, 0),
            new ControllerState(0.3543307086614173, 0.0, 0.0, 0),
            new ControllerState(0.3858267716535433, 0.0, 0.0, 0),
            new ControllerState(0.3858267716535433, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.4094488188976378, 0.0, 0.0, 0),
            new ControllerState(0.3543307086614173, 0.0, 0.0, 0),
            new ControllerState(0.33070866141732286, 0.0, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.14960629921259844, 0.0, 0),
            new ControllerState(0.14173228346456693, 0.2125984251968504, 0.0, 0),
            new ControllerState(0.25984251968503935, 0.28346456692913385, 0.0, 0),
            new ControllerState(0.25984251968503935, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.3858267716535433, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.4015748031496063, 0.0, 0),
            new ControllerState(0.2755905511811024, 0.4015748031496063, 0.0, 0),
            new ControllerState(0.2204724409448819, 0.4015748031496063, 0.0, 0),
            new ControllerState(0.14173228346456693, 0.4015748031496063, 0.0, 0),
            new ControllerState(0.0, 0.4015748031496063, 0.0, 0),
            new ControllerState(0.0, 0.33070866141732286, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(0.0, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.109375, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.125, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.140625, 0.25196850393700787, 0.0, 0),
            new ControllerState(-0.15625, 0.2283464566929134, 0.0, 0),
            new ControllerState(-0.1953125, 0.2125984251968504, 0.0, 0),
            new ControllerState(-0.2421875, 0.1968503937007874, 0.0, 0),
            new ControllerState(-0.265625, 0.18110236220472442, 0.0, 0),
            new ControllerState(-0.3125, 0.16535433070866143, 0.0, 0),
            new ControllerState(-0.328125, 0.14960629921259844, 0.0, 0),
            new ControllerState(-0.3515625, 0.0, 0.0, 0),
            new ControllerState(-0.3671875, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.3828125, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4140625, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, 0.0, 0.0, 0),
            new ControllerState(-0.4375, -0.1015625, 0.0, 0),
            new ControllerState(-0.3671875, -0.1640625, 0.0, 0),
            new ControllerState(-0.3671875, -0.203125, 0.0, 0),
            new ControllerState(-0.3671875, -0.2265625, 0.0, 0),
            new ControllerState(-0.3671875, -0.265625, 0.0, 0),
            new ControllerState(-0.3125, -0.3203125, 0.0, 0),
            new ControllerState(-0.28125, -0.359375, 0.0, 0),
            new ControllerState(-0.2265625, -0.4453125, 0.0, 0),
            new ControllerState(-0.1796875, -0.4453125, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.4609375, 0.0, 0),
            new ControllerState(0.0, -0.3984375, 0.0, 0),
            new ControllerState(0.0, -0.359375, 0.0, 0),
            new ControllerState(0.0, -0.3203125, 0.0, 0),
            new ControllerState(0.0, -0.265625, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),
            new ControllerState(0.0, 0.0, 0.0, 0),};
    }
}