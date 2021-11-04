package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.util.EinUndAusgabe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NutzerEingabe {

    private static final int MIN_ANZAHL = 3;

    private EinUndAusgabe io;

    public NutzerEingabe(EinUndAusgabe io) {
        this.io = io;
    }

    public int anzahlZeilenDesSpielfelds() {
        int eingabe = 0;
        do {
            System.out.print("Anzahl der Zeilen des Spielfelds (>=" + MIN_ANZAHL + "): ");
            eingabe = io.leseInteger();
        } while (eingabe < MIN_ANZAHL);
        return eingabe;
    }

    public int wahrscheinlichkeitDerBesiedlung() {
        int eingabe = 0;
        do {
            System.out.print("Wahrscheinlichkeit der Besiedlung (1-100): ");
            eingabe = io.leseInteger();
        } while (eingabe < 1 || 100 < eingabe);
        return eingabe;
    }

    public int anzahlDerSimulationsschritte() {
        int eingabe = 0;
        System.out.print("Anzahl der Simulationsschritte (>=1): ");
        eingabe = io.leseInteger();
        if (eingabe < 1) {
            eingabe = -1;
        }
        return eingabe;
    }
}
