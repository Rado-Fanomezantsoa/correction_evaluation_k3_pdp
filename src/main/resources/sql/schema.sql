CREATE TYPE marque_enum AS ENUM (
    'KIA',
    'HYUNDAI',
    'DAEWOO'
    );

CREATE TYPE modele_enum AS ENUM (
    'SPORTAGE',
    'SORENTO',
    'WINDSTORM'
    );


CREATE TABLE Modele_voiture (
                                id SERIAL PRIMARY KEY,
                                marque marque_enum NOT NULL,
                                modele modele_enum NOT NULL
);
CREATE TABLE Piece_auto (
                            id SERIAL PRIMARY KEY,
                            id_modele_voiture INT NOT NULL,
                            numero_serie VARCHAR(50) UNIQUE NOT NULL,

                            CONSTRAINT fk_modele_voiture
                                FOREIGN KEY (id_modele_voiture)
                                    REFERENCES Modele_voiture(id)
                                    ON DELETE CASCADE
);
CREATE TABLE Vente (
                       id SERIAL PRIMARY KEY,
                       id_piece_auto INT NOT NULL,
                       quantite INT NOT NULL CHECK (quantite > 0),
                       date DATE NOT NULL,

                       CONSTRAINT fk_piece_auto
                           FOREIGN KEY (id_piece_auto)
                               REFERENCES Piece_auto(id)
                               ON DELETE CASCADE
);