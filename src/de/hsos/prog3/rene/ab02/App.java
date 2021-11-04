package de.hsos.prog3.rene.ab02;

import de.hsos.prog3.rene.ab02.logik.Simulator;
import de.hsos.prog3.rene.ab02.ui.Steuerung;

public class App {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Steuerung steuerung = new Steuerung(simulator);
        steuerung.startDesSpiels();

        int anzahlDerSimulationsschritte;
        do {
            anzahlDerSimulationsschritte = steuerung.getNutzerEingabe().anzahlDerSimulationsschritte();
            simulator.berechneFolgeGeneration(anzahlDerSimulationsschritte);
        } while (anzahlDerSimulationsschritte != -1);
    }
}
