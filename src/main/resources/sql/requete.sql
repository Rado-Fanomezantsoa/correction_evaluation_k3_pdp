--a)
SELECT
    mv.marque,
    mv.modele,
    COALESCE(SUM(v.quantite), 0) AS nbre_pieces_vendus
FROM Modele_voiture mv
         LEFT JOIN Piece_auto pa
                   ON pa.id_modele_voiture = mv.id
         LEFT JOIN Vente v
                   ON v.id_piece_auto = pa.id
GROUP BY mv.marque, mv.modele
ORDER BY mv.marque, mv.modele;

--b)
SELECT
    SUM(CASE WHEN mv.marque = 'KIA'
                 THEN v.quantite ELSE 0 END) AS nbre_piece_kia,

    SUM(CASE WHEN mv.marque = 'DAEWOO'
                 THEN v.quantite ELSE 0 END) AS nbre_piece_daewoo
FROM Vente v
         JOIN Piece_auto pa
              ON v.id_piece_auto = pa.id
         JOIN Modele_voiture mv
              ON pa.id_modele_voiture = mv.id;

--c)
SELECT
    mv.marque,
    ROUND(
            SUM(v.quantite) * 100.0 /
            SUM(SUM(v.quantite)) OVER (),
            2
    ) AS pourcentage
FROM Vente v
         JOIN Piece_auto pa
              ON v.id_piece_auto = pa.id
         JOIN Modele_voiture mv
              ON pa.id_modele_voiture = mv.id
WHERE v.date < '2026-01-01'
GROUP BY mv.marque;