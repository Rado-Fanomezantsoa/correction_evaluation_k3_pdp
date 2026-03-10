package org.garage;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataRetriever dr = new DataRetriever();
        List<VenteParMarqueModele> listeVenteParMarqueModele = dr.findNombrePiecesParMarqueModele();
        System.out.println(listeVenteParMarqueModele);

        VenteParMarquePivot venteParMarquePivot = dr.findNombrePiecesParMarquePivot();
        System.out.println(venteParMarquePivot);

        List<PourcentageVenteMarque> pourcentageVenteMarques = dr.findPourcentageAvant2026();
        System.out.println(pourcentageVenteMarques);
    }

}