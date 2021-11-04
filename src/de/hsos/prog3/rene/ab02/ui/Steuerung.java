package de.hsos.prog3.rene.ab02.ui;

import de.hsos.prog3.rene.ab02.logik.BeiAenderung;
import de.hsos.prog3.rene.ab02.logik.Simulation;
import de.hsos.prog3.rene.ab02.util.EinUndAusgabe;
import de.hsos.prog3.rene.ab02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {

    private NutzerEingabe nutzerEingabe;
    private SpielfeldDarstellung spielfeldDarstellung;
    private Simulation simulation;

    public Steuerung(Simulation simulation) {
        this.simulation = simulation;
    }


    public NutzerEingabe getNutzerEingabe() {
        return nutzerEingabe;
    }

    public void startDesSpiels() {
        initialisierung();

        int anzahlZeilenDesSpielfelds = nutzerEingabe.anzahlZeilenDesSpielfelds();
        int wahrscheinlichkeitDerBesiedlung = nutzerEingabe.wahrscheinlichkeitDerBesiedlung();
        simulation.berechneAnfangsGeneration(anzahlZeilenDesSpielfelds, wahrscheinlichkeitDerBesiedlung);
    }

    private void initialisierung() {
        EinUndAusgabe einUndAusgabe = new EinUndAusgabe();
        nutzerEingabe = new NutzerEingabe(einUndAusgabe);

        Interaktionsbrett interaktionsbrett = new Interaktionsbrett();
        spielfeldDarstellung = new SpielfeldDarstellung(interaktionsbrett);

        simulation.anmeldenFuerAktualisierungBeiAenderung(this);
    }

    public void aktualisiere(boolean[][] neueGeneration) {
        spielfeldDarstellung.abwischen();
        spielfeldDarstellung.spielfeldDarstellen(neueGeneration);
    }
}
