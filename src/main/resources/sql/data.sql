INSERT INTO Modele_voiture (marque, modele) VALUES
                                                ('KIA', 'SPORTAGE'),
                                                ('KIA', 'SORENTO'),
                                                ('DAEWOO', 'WINDSTORM'),
                                                ('HYUNDAI', 'SPORTAGE');

INSERT INTO Piece_auto (id_modele_voiture, numero_serie) VALUES
                                                             (1, 'KIA-SP-001'),
                                                             (1, 'KIA-SP-002'),
                                                             (2, 'KIA-SO-001'),
                                                             (3, 'DAE-WI-001'),
                                                             (4, 'HYU-SP-001');
INSERT INTO Vente (id_piece_auto, quantite, date) VALUES
                                                      (1, 3, '2026-01-10'),
                                                      (1, 2, '2026-01-15'),
                                                      (2, 5, '2026-02-01'),
                                                      (3, 1, '2026-02-05'),
                                                      (4, 4, '2026-02-10'),
                                                      (5, 6, '2026-03-01'),
                                                      (1, 2, '2026-03-05'),
                                                      (3, 3, '2026-03-07');