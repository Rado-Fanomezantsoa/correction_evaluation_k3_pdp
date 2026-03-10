package org.garage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<VenteParMarqueModele> findNombrePiecesParMarqueModele() {

        List<VenteParMarqueModele> list = new ArrayList<>();
        String sql = """
                SELECT mv.marque,
                   mv.modele,
                   COALESCE(SUM(v.quantite),0) AS nbre_pieces_vendus
            FROM Modele_voiture mv
            LEFT JOIN Piece_auto pa
                   ON pa.id_modele_voiture = mv.id
            LEFT JOIN Vente v
                   ON v.id_piece_auto = pa.id
            GROUP BY mv.marque, mv.modele
            ORDER BY mv.marque, mv.modele
                """;

        try (Connection connection = new DbConnection().getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);

             ResultSet rs = ps.executeQuery();
        )
        {


            while (rs.next()) {

                VenteParMarqueModele obj = new VenteParMarqueModele();

                obj.setMarque(rs.getString("marque"));
                obj.setModele(rs.getString("modele"));
                obj.setNbrePiecesVendus(rs.getInt("nbre_pieces_vendus"));

                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public VenteParMarquePivot findNombrePiecesParMarquePivot() {

        String sql = """
                SELECT
                SUM(CASE WHEN mv.marque='KIA'
                         THEN v.quantite ELSE 0 END) AS nbre_piece_kia,
                SUM(CASE WHEN mv.marque='DAEWOO'
                         THEN v.quantite ELSE 0 END) AS nbre_piece_daewoo
            FROM Vente v
            JOIN Piece_auto pa ON v.id_piece_auto = pa.id
            JOIN Modele_voiture mv ON pa.id_modele_voiture = mv.id
                """;
        try (Connection connection = new DbConnection().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();)
        {
            if (rs.next()) {
                VenteParMarquePivot result = new VenteParMarquePivot();

                result.setNbrePieceKia(rs.getInt("nbre_piece_kia"));
                result.setNbrePieceDaewoo(rs.getInt("nbre_piece_daewoo"));

                return result;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PourcentageVenteMarque> findPourcentageAvant2026() {

        List<PourcentageVenteMarque> list = new ArrayList<>();
        String sql ="""
        SELECT
        mv.marque,
                ROUND(
                        SUM(v.quantite) * 100.0 /
                                SUM(SUM(v.quantite)) OVER (),
                        2
                ) AS pourcentage
        FROM Vente v
        JOIN Piece_auto pa ON v.id_piece_auto = pa.id
        JOIN Modele_voiture mv ON pa.id_modele_voiture = mv.id
        WHERE v.date < '2026-01-01'
        GROUP BY mv.marque
        """;

        try (Connection connection = new DbConnection().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        )
        {

            while (rs.next()) {

                PourcentageVenteMarque obj = new PourcentageVenteMarque();

                obj.setMarque(rs.getString("marque"));
                obj.setPourcentage(rs.getDouble("pourcentage"));

                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
