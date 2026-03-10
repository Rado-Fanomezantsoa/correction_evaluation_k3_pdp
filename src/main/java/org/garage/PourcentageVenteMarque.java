package org.garage;

public class PourcentageVenteMarque {

    private String marque;
    private double pourcentage;

    public PourcentageVenteMarque(String marque, double pourcentage) {
        this.marque = marque;
        this.pourcentage = pourcentage;
    }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public double getPourcentage() { return pourcentage; }
    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "PourcentageVenteMarque{" +
                "marque='" + marque + '\'' +
                ", pourcentage=" + pourcentage +
                '}';
    }

    public PourcentageVenteMarque() {
    }
}
