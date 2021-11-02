package de.hsos.prog3.rene.ab02.logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZeilen, int wahrscheinlichkeitDerBesiedlung);

    void berechneFolgeGeneration(int berechnungschritte);

    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}
