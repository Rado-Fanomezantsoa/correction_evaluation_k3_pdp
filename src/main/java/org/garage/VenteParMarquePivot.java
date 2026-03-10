package org.garage;

public class VenteParMarquePivot {

    private int nbrePieceKia;
    private int nbrePieceDaewoo;

    public VenteParMarquePivot(int nbrePieceDaewoo, int nbrePieceKia) {
        this.nbrePieceDaewoo = nbrePieceDaewoo;
        this.nbrePieceKia = nbrePieceKia;
    }

    public int getNbrePieceKia() { return nbrePieceKia; }
    public void setNbrePieceKia(int nbrePieceKia) {
        this.nbrePieceKia = nbrePieceKia;
    }

    public int getNbrePieceDaewoo() { return nbrePieceDaewoo; }
    public void setNbrePieceDaewoo(int nbrePieceDaewoo) {
        this.nbrePieceDaewoo = nbrePieceDaewoo;
    }

    public VenteParMarquePivot() {
    }

    @Override
    public String toString() {
        return "VenteParMarquePivot{" +
                "nbrePieceDaewoo=" + nbrePieceDaewoo +
                ", nbrePieceKia=" + nbrePieceKia +
                '}';
    }
}
