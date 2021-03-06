package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.util.EinUndAusgabe;


public class NutzerEingabe {

    private static final int MIN_ROWS = 10;

    private EinUndAusgabe io;

    public NutzerEingabe(EinUndAusgabe io) {
        this.io = io;
    }

    public int anzahlZellenDesSpielfelds() {
        int input = 0;
        do {
            System.out.print("Anzahl der Zellen des Spielfelds (>=" + MIN_ROWS + "): ");
            input = io.leseInteger();
        } while (input < MIN_ROWS);
        return input;
    }

    public int wahrscheinlichkeitDerBesiedlung() {
        int input = 0;
        do {
            System.out.print("Wahrscheinlichkeit der Besiedlung (1-100): ");
            input = io.leseInteger();
        } while (input < 1 || 100 < input);
        return input;
    }

    public int anzahlDerSimulationsschritte() {
        int input = 0;
        System.out.print("Anzahl der Simulationsschritte ( <1 Abbruch): ");
        input = io.leseInteger();
        if (input < 1) System.exit(0);
        return input;
    }
}
