package org.garage;

public class VenteParMarqueModele {

    private String marque;
    private String modele;
    private int nbrePiecesVendus;

    public VenteParMarqueModele() {
    }

    public VenteParMarqueModele(String marque, String modele, int nbrePiecesVendus) {
        this.marque = marque;
        this.modele = modele;
        this.nbrePiecesVendus = nbrePiecesVendus;
    }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public int getNbrePiecesVendus() { return nbrePiecesVendus; }
    public void setNbrePiecesVendus(int nbrePiecesVendus) {
        this.nbrePiecesVendus = nbrePiecesVendus;
    }

    @Override
    public String toString() {
        return "VenteParMarqueModele{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", nbrePiecesVendus=" + nbrePiecesVendus +
                '}';
    }
}
