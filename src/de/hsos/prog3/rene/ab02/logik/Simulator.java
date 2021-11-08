package de.hsos.prog3.rene.ab02.logik;

import java.util.Random;

public class Simulator implements Simulation {

    private int anzahlFelder;
    private BeiAenderung beiAenderung;
    private boolean[][] spielfeld;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZeilen, int wahrscheinlichkeitDerBesiedelung) {
        anzahlFelder = anzahlDerZeilen;
        Random random = new Random();
        spielfeld = new boolean[anzahlDerZeilen][anzahlDerZeilen];
        for (int y = 0; y < anzahlDerZeilen; y++) {
            for (int x = 0; x < anzahlFelder; x++) {
                spielfeld[y][x] = random.nextInt(100) < wahrscheinlichkeitDerBesiedelung;
            }
        }
        if (beiAenderung != null) {
            beiAenderung.aktualisiere(spielfeld);
        }
    }

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) {
        for (int i = 0; i < berechnungsschritte; i++) {
            boolean[][] neuesSpielfeld = new boolean[anzahlFelder][anzahlFelder];

            for (int y = 0; y < anzahlFelder; y++) {
                for (int x = 0; x < anzahlFelder; x++) {
                    int count = spielfeld[y][x] ? -1 : 0;
                    for (int y2 = -1; y2 <= 1; y2++) { //-1 oben, 0 mitte, 1 unten
                        for (int x2 = -1; x2 <= 1; x2++) {
                            if (0 <= y + y2 && y + y2 < anzahlFelder && 0 <= x + x2 && x + x2 < anzahlFelder) {
                                if (spielfeld[y + y2][x + x2]) {
                                    count++; //wenn true nachbar
                                }
                            }
                        }
                    }

                    if (count == 2) {
                        neuesSpielfeld[y][x] = spielfeld[y][x]; //bleibt wie sie ist
                    } else if (count == 3) {
                        neuesSpielfeld[y][x] = true; //bei 3 immer bewohnt
                    } else {
                        neuesSpielfeld[y][x] = false; //sonst immer unbewohnt
                    }
                }
            }
            spielfeld = neuesSpielfeld;

            if (beiAenderung != null) {
                beiAenderung.aktualisiere(spielfeld);
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}
