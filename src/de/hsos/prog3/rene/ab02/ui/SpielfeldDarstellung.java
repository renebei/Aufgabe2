package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellung {

    private Interaktionsbrett ib;

    private final int SEITENLAENGE = 30;
    private final int MARGIN = 3;

    public SpielfeldDarstellung(Interaktionsbrett ib) {
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        for (int y = 0; y < spielfeld.length; y++) {
            for (int x = 0; x < spielfeld[0].length; x++) {

                Quadrat q = new Quadrat(SEITENLAENGE * x + MARGIN, SEITENLAENGE * y + MARGIN, SEITENLAENGE);

                if (spielfeld[y][x]) q.darstellenFuellung(ib);
                else q.darstellenRahmen(ib);

            }
        }
    }

    public void abwischen() {
        ib.abwischen();
    }
}
