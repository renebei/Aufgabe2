package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.util.EinUndAusgabe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NutzerEingabe {
    private EinUndAusgabe io;
    private Scanner scan;

    public NutzerEingabe(EinUndAusgabe io) {
        this.io = io;
        scan = new Scanner(System.in);
    }

    public int anzahlZeilen() {
        int zellen = 0;
        while (zellen == 0) {
            try {
                System.out.print("Anzahl Zellen: ");
                zellen = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Keine Gültige Eingabe");
            }
        }
        return zellen;
    }

    public int wahrscheinlichkeitDerBesiedlung() {
        int wahrscheinlichkeit = 0;
        while (wahrscheinlichkeit == 0) {
            try {
                System.out.print("Wahrscheinlichkeit: ");
                wahrscheinlichkeit = (scan.nextInt() < 101 && scan.nextInt() > 0) ? scan.nextInt() : 0;
            } catch (InputMismatchException e) {
                System.out.println("Keine Gültige Eingabe");
            }
        }
        return wahrscheinlichkeit;
    }

    public int anzahlDerSimulationsschritte() {
        int schritte = 0;
        while (schritte == 0) {
            try {
                System.out.print("Wahrscheinlichkeit: ");
                schritte = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Keine Gültige Eingabe");
            }
        }
        return schritte;
    }
}
