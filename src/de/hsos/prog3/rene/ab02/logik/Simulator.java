package de.hsos.prog3.rene.ab02.logik;

import java.util.Random;

public class Simulator implements Simulation {

    private int anzahlFelder;
    private BeiAenderung beiAenderung;
    private boolean[][] spielfeld;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedelung) {
        anzahlFelder = anzahlDerZellen;
        Random random = new Random();
        spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];

        for (int y = 0; y < anzahlFelder; y++) {
            for (int x = 0; x < anzahlFelder; x++) {
                spielfeld[y][x] = random.nextInt(100) < wahrscheinlichkeitDerBesiedelung;
            }
        }

        if (beiAenderung != null) beiAenderung.aktualisiere(spielfeld);

    }

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) {
        for (int i = 0; i < berechnungsschritte; i++) {
            boolean[][] neuSpielfeld = new boolean[anzahlFelder][anzahlFelder];

            for (int y = 0; y < anzahlFelder; y++) {
                for (int x = 0; x < anzahlFelder; x++) {

                    int anzahlNachbarn = zaehleNachbarn(y, x);

                    if (anzahlNachbarn == 2) neuSpielfeld[y][x] = spielfeld[y][x]; //bleibt wie sie ist
                    else if (anzahlNachbarn == 3) neuSpielfeld[y][x] = true; //bei 3 immer bewohnt
                    else neuSpielfeld[y][x] = false; //sonst immer unbewohnt

                }
            }

            if(spielfeld != neuSpielfeld)spielfeld = neuSpielfeld;

            if (beiAenderung != null) beiAenderung.aktualisiere(spielfeld);

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    private int zaehleNachbarn(int y, int x) {
        int count = spielfeld[y][x] ? -1 : 0; //Testfeld als Nachbar ausschließen
        for (int yNr = -1; yNr <= 1; yNr++) { //-1 oben, 0 mitte, 1 unten
            for (int xNr = -1; xNr <= 1; xNr++) {
                if (0 <= y + yNr && y + yNr < anzahlFelder && 0 <= x + xNr && x + xNr < anzahlFelder) {
                    if (spielfeld[y + yNr][x + xNr]) count++; //wenn true nachbar
                }
            }
        }
        return count;
    }


    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}
