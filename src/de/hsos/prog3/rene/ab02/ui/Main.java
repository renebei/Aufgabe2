package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.logik.Simulator;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Steuerung steuerung = new Steuerung(simulator);
        steuerung.startDesSpiels();

        int anzahlDerSimulationsschritte = 1;

        while (anzahlDerSimulationsschritte > 0) {
            anzahlDerSimulationsschritte = steuerung.getNutzerEingabe().anzahlDerSimulationsschritte();
            simulator.berechneFolgeGeneration(anzahlDerSimulationsschritte);
        }
    }
}
