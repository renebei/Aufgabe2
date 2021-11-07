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
                    for (int ry = -1; ry <= 1; ry++) {
                        for (int rx = -1; rx <= 1; rx++) {
                            if (0 <= y + ry && y + ry < anzahlFelder && 0 <= x + rx && x + rx < anzahlFelder) {
                                if (spielfeld[y + ry][x + rx]) {
                                    count++;
                                }
                            }
                        }
                    }

                    if (count == 2) {
                        neuesSpielfeld[y][x] = spielfeld[y][x];
                    } else if (count == 3) {
                        neuesSpielfeld[y][x] = true;
                    } else {
                        neuesSpielfeld[y][x] = false;
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
        });

    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}
