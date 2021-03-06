-- MySQL Script generated by MySQL Workbench
-- Sat May 22 21:44:20 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mis_projekat
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mis_projekat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mis_projekat` DEFAULT CHARACTER SET utf8 ;
USE `mis_projekat` ;

-- -----------------------------------------------------
-- Table `mis_projekat`.`RadnoMesto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`RadnoMesto` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`RadnoMesto` (
  `idRM` INT NOT NULL AUTO_INCREMENT,
  `opisRM` VARCHAR(45) NULL,
  PRIMARY KEY (`idRM`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Radnik`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Radnik` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Radnik` (
  `idRad` INT NOT NULL AUTO_INCREMENT,
  `idRM` INT NOT NULL,
  `imeRad` VARCHAR(45) NULL,
  `przRad` VARCHAR(45) NULL,
  `jmbgRad` VARCHAR(45) NULL,
  `adrRad` VARCHAR(45) NULL,
  `emailRad` VARCHAR(45) NULL,
  `telRad` VARCHAR(45) NULL,
  `pltRad` DOUBLE NULL,
  `passRad` VARCHAR(45) NULL,
  PRIMARY KEY (`idRad`),
  INDEX `fk_Radnik_RadnoMesto1_idx` (`idRM` ASC) VISIBLE,
  CONSTRAINT `fk_Radnik_RadnoMesto1`
    FOREIGN KEY (`idRM`)
    REFERENCES `mis_projekat`.`RadnoMesto` (`idRM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Odsustvo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Odsustvo` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Odsustvo` (
  `idOds` INT NOT NULL AUTO_INCREMENT,
  `pocOds` DATETIME NOT NULL,
  `krajOds` DATETIME NOT NULL,
  `opisOds` VARCHAR(45) NULL,
  `idMen` INT NOT NULL,
  `idKon` INT NOT NULL,
  PRIMARY KEY (`idOds`),
  INDEX `fk_Odsustvo_Radnik1_idx` (`idMen` ASC) VISIBLE,
  INDEX `fk_Odsustvo_Radnik2_idx` (`idKon` ASC) VISIBLE,
  CONSTRAINT `fk_Odsustvo_Radnik1`
    FOREIGN KEY (`idMen`)
    REFERENCES `mis_projekat`.`Radnik` (`idRad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Odsustvo_Radnik2`
    FOREIGN KEY (`idKon`)
    REFERENCES `mis_projekat`.`Radnik` (`idRad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Smena`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Smena` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Smena` (
  `idSme` INT NOT NULL AUTO_INCREMENT,
  `pocSme` DATETIME NOT NULL,
  `krajSme` DATETIME NOT NULL,
  `idMen` INT NOT NULL,
  `idKon` INT NOT NULL,
  PRIMARY KEY (`idSme`),
  INDEX `fk_Smena_Radnik1_idx` (`idMen` ASC) VISIBLE,
  INDEX `fk_Smena_Radnik2_idx` (`idKon` ASC) VISIBLE,
  CONSTRAINT `fk_Smena_Radnik1`
    FOREIGN KEY (`idMen`)
    REFERENCES `mis_projekat`.`Radnik` (`idRad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Smena_Radnik2`
    FOREIGN KEY (`idKon`)
    REFERENCES `mis_projekat`.`Radnik` (`idRad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Sto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Sto` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Sto` (
  `idSto` INT NOT NULL AUTO_INCREMENT,
  `opisSto` VARCHAR(45) NULL,
  PRIMARY KEY (`idSto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mis_projekat`.`SmenaSto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`SmenaSto` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`SmenaSto` (
  `idSme` INT NOT NULL,
  `idSto` INT NOT NULL,
  INDEX `fk_Smena_has_Sto_Sto1_idx` (`idSto` ASC) VISIBLE,
  INDEX `fk_Smena_has_Sto_Smena1_idx` (`idSme` ASC) VISIBLE,
  PRIMARY KEY (`idSto`, `idSme`),
  CONSTRAINT `fk_Smena_has_Sto_Smena1`
    FOREIGN KEY (`idSme`)
    REFERENCES `mis_projekat`.`Smena` (`idSme`),
  CONSTRAINT `fk_Smena_has_Sto_Sto1`
    FOREIGN KEY (`idSto`)
    REFERENCES `mis_projekat`.`Sto` (`idSto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Racun`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Racun` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Racun` (
  `idRac` INT NOT NULL AUTO_INCREMENT,
  `datRac` DATETIME NOT NULL,
  `uplRac` DOUBLE NOT NULL,
  `idSto` INT NOT NULL,
  `idSme` INT NOT NULL,
  PRIMARY KEY (`idRac`),
  INDEX `fk_Racun_SmenaSto1_idx` (`idSto` ASC, `idSme` ASC) VISIBLE,
  CONSTRAINT `fk_Racun_SmenaSto1`
    FOREIGN KEY (`idSto` , `idSme`)
    REFERENCES `mis_projekat`.`SmenaSto` (`idSto` , `idSme`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Dobavljac`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Dobavljac` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Dobavljac` (
  `idDob` INT NOT NULL AUTO_INCREMENT,
  `nazDob` VARCHAR(45) NOT NULL,
  `adrDob` VARCHAR(45) NULL,
  `emailDob` VARCHAR(45) NULL,
  `telDob` VARCHAR(45) NULL,
  PRIMARY KEY (`idDob`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Nabavka`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Nabavka` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Nabavka` (
  `idNab` INT NOT NULL AUTO_INCREMENT,
  `datNab` DATETIME NOT NULL,
  `idDob` INT NOT NULL,
  `idMen` INT NOT NULL,
  PRIMARY KEY (`idNab`),
  INDEX `fk_Nabavka_Dobavljac1_idx` (`idDob` ASC) VISIBLE,
  INDEX `fk_Nabavka_Radnik1_idx` (`idMen` ASC) VISIBLE,
  CONSTRAINT `fk_Nabavka_Dobavljac1`
    FOREIGN KEY (`idDob`)
    REFERENCES `mis_projekat`.`Dobavljac` (`idDob`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nabavka_Radnik1`
    FOREIGN KEY (`idMen`)
    REFERENCES `mis_projekat`.`Radnik` (`idRad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Artikal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Artikal` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Artikal` (
  `idArt` INT NOT NULL AUTO_INCREMENT,
  `nazArt` VARCHAR(45) NULL,
  PRIMARY KEY (`idArt`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Dostavljac`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Dostavljac` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Dostavljac` (
  `idDos` INT NOT NULL AUTO_INCREMENT,
  `nazDos` VARCHAR(45) NULL,
  `adrDos` VARCHAR(45) NULL,
  `emailDos` VARCHAR(45) NULL,
  `telDos` VARCHAR(45) NULL,
  PRIMARY KEY (`idDos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Klijent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Klijent` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Klijent` (
  `idKli` INT NOT NULL AUTO_INCREMENT,
  `imeKli` VARCHAR(45) NOT NULL,
  `przKli` VARCHAR(45) NULL,
  `adrKli` VARCHAR(45) NULL,
  `telKli` VARCHAR(45) NULL,
  `emailKli` VARCHAR(45) NOT NULL,
  `passKli` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idKli`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Narudzbina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Narudzbina` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Narudzbina` (
  `idNar` INT NOT NULL AUTO_INCREMENT,
  `idDos` INT NULL,
  `idRac` INT NOT NULL,
  `idKli` INT NOT NULL,
  PRIMARY KEY (`idNar`),
  INDEX `fk_Narudzbina_Dostavljac1_idx` (`idDos` ASC) VISIBLE,
  INDEX `fk_Narudzbina_Racun1_idx` (`idRac` ASC) VISIBLE,
  INDEX `fk_Narudzbina_Klijent1_idx` (`idKli` ASC) VISIBLE,
  CONSTRAINT `fk_Narudzbina_Dostavljac1`
    FOREIGN KEY (`idDos`)
    REFERENCES `mis_projekat`.`Dostavljac` (`idDos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Narudzbina_Racun1`
    FOREIGN KEY (`idRac`)
    REFERENCES `mis_projekat`.`Racun` (`idRac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Narudzbina_Klijent1`
    FOREIGN KEY (`idKli`)
    REFERENCES `mis_projekat`.`Klijent` (`idKli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Rezervacija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Rezervacija` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Rezervacija` (
  `idRez` INT NOT NULL AUTO_INCREMENT,
  `datRez` DATETIME NULL,
  `opisRez` VARCHAR(45) NULL,
  `idSto` INT NOT NULL,
  `idKli` INT NOT NULL,
  PRIMARY KEY (`idRez`),
  INDEX `fk_Rezervacija_Sto1_idx` (`idSto` ASC) VISIBLE,
  INDEX `fk_Rezervacija_Klijent1_idx` (`idKli` ASC) VISIBLE,
  CONSTRAINT `fk_Rezervacija_Sto1`
    FOREIGN KEY (`idSto`)
    REFERENCES `mis_projekat`.`Sto` (`idSto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rezervacija_Klijent1`
    FOREIGN KEY (`idKli`)
    REFERENCES `mis_projekat`.`Klijent` (`idKli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Komentar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Komentar` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Komentar` (
  `idKom` INT NOT NULL AUTO_INCREMENT,
  `datKom` DATETIME NULL,
  `txtKom` VARCHAR(45) NULL,
  `idKli` INT NOT NULL,
  `idArt` INT NOT NULL,
  PRIMARY KEY (`idKom`),
  INDEX `fk_Komentar_Klijent1_idx` (`idKli` ASC) VISIBLE,
  INDEX `fk_Komentar_Artikal1_idx` (`idArt` ASC) VISIBLE,
  CONSTRAINT `fk_Komentar_Klijent1`
    FOREIGN KEY (`idKli`)
    REFERENCES `mis_projekat`.`Klijent` (`idKli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Komentar_Artikal1`
    FOREIGN KEY (`idArt`)
    REFERENCES `mis_projekat`.`Artikal` (`idArt`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`Reklama`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`Reklama` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`Reklama` (
  `idRek` INT NOT NULL AUTO_INCREMENT,
  `txtRek` VARCHAR(45) NULL,
  PRIMARY KEY (`idRek`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`KlijentReklama`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`KlijentReklama` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`KlijentReklama` (
  `idKli` INT NOT NULL,
  `idRek` INT NOT NULL,
  PRIMARY KEY (`idKli`, `idRek`),
  INDEX `fk_Klijent_has_Reklama_Reklama1_idx` (`idRek` ASC) VISIBLE,
  INDEX `fk_Klijent_has_Reklama_Klijent1_idx` (`idKli` ASC) VISIBLE,
  CONSTRAINT `fk_Klijent_has_Reklama_Klijent1`
    FOREIGN KEY (`idKli`)
    REFERENCES `mis_projekat`.`Klijent` (`idKli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Klijent_has_Reklama_Reklama1`
    FOREIGN KEY (`idRek`)
    REFERENCES `mis_projekat`.`Reklama` (`idRek`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`NabavkaArtikal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`NabavkaArtikal` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`NabavkaArtikal` (
  `idNab` INT NOT NULL,
  `idArt` INT NOT NULL,
  `kolArt` DOUBLE NULL,
  `cenaArt` DOUBLE NULL,
  PRIMARY KEY (`idNab`, `idArt`),
  INDEX `fk_Nabavka_has_Artikal_Artikal1_idx` (`idArt` ASC) VISIBLE,
  INDEX `fk_Nabavka_has_Artikal_Nabavka1_idx` (`idNab` ASC) VISIBLE,
  CONSTRAINT `fk_Nabavka_has_Artikal_Nabavka1`
    FOREIGN KEY (`idNab`)
    REFERENCES `mis_projekat`.`Nabavka` (`idNab`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nabavka_has_Artikal_Artikal1`
    FOREIGN KEY (`idArt`)
    REFERENCES `mis_projekat`.`Artikal` (`idArt`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mis_projekat`.`RacunArtikal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mis_projekat`.`RacunArtikal` ;

CREATE TABLE IF NOT EXISTS `mis_projekat`.`RacunArtikal` (
  `idArt` INT NOT NULL,
  `idRac` INT NOT NULL,
  `kolArt` DOUBLE NULL,
  `cenaArt` DOUBLE NULL,
  PRIMARY KEY (`idArt`, `idRac`),
  INDEX `fk_Artikal_has_Racun_Racun1_idx` (`idRac` ASC) VISIBLE,
  INDEX `fk_Artikal_has_Racun_Artikal1_idx` (`idArt` ASC) VISIBLE,
  CONSTRAINT `fk_Artikal_has_Racun_Artikal1`
    FOREIGN KEY (`idArt`)
    REFERENCES `mis_projekat`.`Artikal` (`idArt`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Artikal_has_Racun_Racun1`
    FOREIGN KEY (`idRac`)
    REFERENCES `mis_projekat`.`Racun` (`idRac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


# RadnoMesto, popunjavanje...
INSERT INTO RadnoMesto (idRM, opisRM) VALUES (1, "Admin");
INSERT INTO RadnoMesto (idRM, opisRM) VALUES (2, "Menadzer");
INSERT INTO RadnoMesto (idRM, opisRM) VALUES (3, "Konobar");
SELECT * FROM RadnoMesto;

# Radnik, popunjavanje...
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)	# admin
VALUES (1, 1, "Nikola", "Nikolic", "2604984800029", "Edvarda Kardelja 3", "nn@mm.com", "063123456", 9000, "Nikola");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)	# menadzer
VALUES (2, 2, "Franjo", "Francetic", "1604982800029", "Marsala Tita 23", "ff@aa.com", "064123456", 7000, "Franjo");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)	# konobari
VALUES (3, 3, "Aca", "Aleksandrovic", "1101991800043", "Aleksandra Rankovica 2", "aa@bb.com", "064800400", 5000, "Aca");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)
VALUES (4, 3, "Bane", "Branovic", "0904982800029", "Kraljice Marije 5", "bb@kk.com", "060654321", 5000, "Bane");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)
VALUES (5, 3, "Cane", "Cankovic", "0903982800029", "Kneza Pavla 18", "cc@mm.com", "061654321", 4500, "Cane");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad) 
VALUES (6, 3, "Dejan", "Japetovic", "0202982800029", "Sultan Murata 7", "dd@aa.com", "0644654321", 5000, "Dejan");
INSERT INTO Radnik (idRad, idRM, imeRad, przRad, jmbgRad, adrRad, emailRad, telRad, pltRad, passRad)
VALUES (7, 3, "Enceladus", "Jupiterovic", "0101982800029", "Nebeskih sfera 2", "ee@aa.com", "0644654321", 5000, "Enceladus");

SELECT r.idRad, rm.opisRM, r.imeRad, r.przRad, r.jmbgRad, r.adrRad, r.emailRad, r.telRad, r.pltRad, r.passRad
FROM Radnik r, RadnoMesto rm
WHERE r.idRM = rm.idRM;

# Odsustvo, popunjavanje...
INSERT INTO Odsustvo (idOds, pocOds, krajOds, idMen, idKon)
VALUES (1, "2021-06-01 00:00:00", "2021-06-05 00:00:00", 2, 3);

SELECT o.pocOds, o.KrajOds, r0.imeRad AS "Ime menadzera", r1.imeRad AS "Ime konobara"
FROM Odsustvo o, Radnik r0, Radnik r1
WHERE o.idMen = r0.idRad AND o.idKon = r1.idRad;

# Smena, popunjavanje...
INSERT INTO Smena (idSme, pocSme, krajSme, idMen, idKon) 
VALUES (1, "2021-05-01 10:00:00", "2021-05-01 18:00:00", 1, 2);
INSERT INTO Smena (idSme, pocSme, krajSme, idMen, idKon) 
VALUES (2, "2021-05-01 10:00:00", "2021-05-01 18:00:00", 1, 3);
INSERT INTO Smena (idSme, pocSme, krajSme, idMen, idKon) 
VALUES (3, "2021-05-01 10:00:00", "2021-05-01 18:00:00", 1, 4);
INSERT INTO Smena (idSme, pocSme, krajSme, idMen, idKon) 
VALUES (4, "2021-05-01 18:00:00", "2021-05-01 23:00:00", 1, 5);

SELECT * FROM Smena WHERE DATE(pocSme) = "2021-05-01";

SELECT s.idSme, s.pocSme, s.KrajSme, r0.imeRad AS "Ime menadzera", r1.imeRad AS "Ime konobara"
FROM Smena s, Radnik r0, Radnik r1
WHERE s.idMen = r0.idRad AND s.idKon = r1.idRad;

# Sto, popunjavanje...
INSERT INTO Sto (idSto, opisSto) VALUES (1, "Kod sanka");
INSERT INTO Sto (idSto, opisSto) VALUES (2, "Basta");
INSERT INTO Sto (idSto, opisSto) VALUES (3, "Kod ulaza");
INSERT INTO Sto (idSto, opisSto) VALUES (4, "Terasa");

SELECT * FROM Sto;

# SmenaSto, popunjavanje...
INSERT INTO SmenaSto (idSme, idSto) VALUES (1, 1);
INSERT INTO SmenaSto (idSme, idSto) VALUES (1, 2);
INSERT INTO SmenaSto (idSme, idSto) VALUES (2, 3);
INSERT INTO SmenaSto (idSme, idSto) VALUES (3, 4);
INSERT INTO SmenaSto (idSme, idSto) VALUES (4, 1);
INSERT INTO SmenaSto (idSme, idSto) VALUES (4, 2);
INSERT INTO SmenaSto (idSme, idSto) VALUES (4, 3);
INSERT INTO SmenaSto (idSme, idSto) VALUES (4, 4);

SELECT * FROM SmenaSto;

# Artikal, popunjavanje...
INSERT INTO Artikal (idArt, nazArt) VALUES (1, "Pivo");
INSERT INTO Artikal (idArt, nazArt) VALUES (2, "Vino");
INSERT INTO Artikal (idArt, nazArt) VALUES (3, "Sok");

SELECT * FROM Artikal;

# Dobavljac, popunjavanje...
INSERT INTO Dobavljac (idDob, nazDob, adrDob, emailDob, telDob) 
VALUES (1, "MS Hermes", "Gunduliceva 13, 21000 Novi Sad", "office@hermes.rs", "069800800");
INSERT INTO Dobavljac (idDob, nazDob, adrDob, emailDob, telDob)
VALUES (2, "Basta Promet", "Milosa Bajica 14, 21000 Novi Sad", "office@basta.rs", "0605000400");

SELECT * FROM Dobavljac;

# Nabavka, popunjavanje...
INSERT INTO Nabavka (idNab, datNab, idMen, idDob)
VALUES (1, "2021-05-03 10:00:00", 1, 1);

# NabavkaArtikal, popunjavanje...
INSERT INTO NabavkaArtikal (idNab, idArt, kolArt, cenaArt) VALUES (1, 1, 100.0, 50.0);
INSERT INTO NabavkaArtikal (idNab, idArt, kolArt, cenaArt) VALUES (1, 2, 200.0, 75.0);

SELECT 	n.idNab AS "ID", n.datNab AS "Datum", r.imeRad AS "Menadzer", a.nazArt AS "Artikal", 
		na.kolArt AS "Kol", na.cenaArt AS "Cena", d.nazDob as "Dobavljac"
FROM	Nabavka n, Radnik r, Artikal a, NabavkaArtikal na, Dobavljac d
WHERE	n.idNab = na.idNab AND na.idArt = a.idArt AND n.idMen = r.idRad AND n.idDob = d.idDob;

# Racun, popunjavanje...
INSERT INTO Racun (idRac, datRac, uplRac, idSto, idSme) 
VALUES (1, "2021-05-01 12:00:00", 500.0, 1, 1);

INSERT INTO RacunArtikal (idRac, idArt, kolArt, cenaArt) VALUES (1, 2, 3.0, 75.0);
INSERT INTO RacunArtikal (idRac, idArt, kolArt, cenaArt) VALUES (1, 3, 2.0, 99.0);

SELECT 	r.idRac AS "ID", r.datRac AS "Datum", a.nazArt AS "Artikal", ra.kolArt AS "Kol",
		ra.cenaArt AS "Cena", rd.imeRad AS "Konobar", r.idSto AS "Sto", r.idSme AS "Smena"
FROM	Racun r, Artikal a, RacunArtikal ra, Radnik rd, Smena s, SmenaSto ss
WHERE	r.idRac = ra.idRac AND a.idArt = ra.idArt AND r.idSme = ss.idSme AND r.idSto = ss.idSto AND
		ss.idSme = s.idSme AND s.idKon = rd.idRad;
        
# Klijent, popunjavanje...
INSERT INTO Klijent (idKli, imeKli, przKli, adrKli, telKli, emailKli, passKli)
VALUES (1, "Saban", "Saulic", "Prva ulica 4, 21000 Sangaj", "0605000400", "saban.saulic@gmail.com", "Saban");
INSERT INTO Klijent (idKli, imeKli, przKli, adrKli, telKli, emailKli, passKli)
VALUES (2, "Dzemadan", "Dzailovic", "Primorska 12, 21000 Klisa", "061234234", "dzemadan.dzemi@hotmail.com", "Dzemadan");

SELECT * FROM Klijent ORDER BY idKli ASC;
UPDATE Klijent set passKli="12345" where idKli = 1;
DELETE FROM Klijent WHERE idKli = 1;

# Rezervacija, popunjavanje...
INSERT INTO Rezervacija (idRez, datRez, opisRez, idSto, idKli) 
VALUES (1, "2021-06-01", "Preko veze", 1, 1);
INSERT INTO Rezervacija (idRez, datRez, opisRez, idSto, idKli) 
VALUES (2, "2021-06-01", "Za jarana", 2, 2);

SELECT r.idRez AS "ID", r.datRez AS "Datum", r.opisRez AS "Opis", r.idSto AS "Sto", k.imeKli AS "Klijent"
FROM Rezervacija r, Klijent k
WHERE r.idKli = k.idKli;

delete from rezervacija where idRez = 10;

# Komentar, popunjavanje...
INSERT INTO Komentar (idKom, datKom, txtKom, idKli, idArt)
VALUES (1, "2021-05-19", "'Ajme, dobrog li piva, uh...", 1, 1);
INSERT INTO Komentar (idKom, datKom, txtKom, idKli, idArt)
VALUES (2, "2021-05-19", "Dajte vina, 'ocu lom...", 2, 2);

SELECT km.datKom AS "Datum", a.nazArt AS "Artikal", k.imeKli AS "Korisnik", km.txtKom AS "Komentar"
FROM Komentar km, Artikal a, Klijent k
WHERE km.idKli = k.idKli AND km.idArt = a.idArt;

# Reklama, popunjavanje...
INSERT INTO Reklama (idRek, txtRek) VALUES (1, "Jeftini prasici!");
INSERT INTO Reklama (idRek, txtRek) VALUES (2, "Kazino Gaja!");
INSERT INTO Reklama (idRek, txtRek) VALUES (3, "Pekara Zheki!");

SELECT * FROM Reklama;

# ReklamaKlijent, popunjavanje...
INSERT INTO KlijentReklama (idKli, idRek) VALUES (1, 1);
INSERT INTO KlijentReklama (idKli, idRek) VALUES (1, 2);
INSERT INTO KlijentReklama (idKli, idRek) VALUES (2, 2);
INSERT INTO KlijentReklama (idKli, idRek) VALUES (2, 3);

SELECT k.imeKli AS "Klijent", r.txtRek AS "Reklama"
FROM Klijent k, Reklama r, KlijentReklama kr
WHERE k.idKli = kr.idKli AND r.idRek = kr.idRek;

# Dostavljac, popunjavanje...
INSERT INTO Dostavljac (idDos, nazDos, adrDos, emailDos, telDos) 
VALUES (1, "Mljacko", "Partizanskih baza 13", "mljacko@pljacko.rs", "060123123");

SELECT * FROM Dostavljac;