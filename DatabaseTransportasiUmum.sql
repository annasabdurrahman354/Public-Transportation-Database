CREATE DATABASE TransportasiUmum
GO

USE TransportasiUmum

CREATE TABLE Kota(
    IdKota VARCHAR(4),
    NamaKota VARCHAR(25),
    PRIMARY KEY (IdKota)
);
GO

INSERT INTO Kota(IdKota, NamaKota)
VALUES
('SBY', 'Surabaya'),
('JKT', 'Jakarta '),
('BDG', 'Bandung'),
('SLO', 'Solo'),
('JOG', 'Yogyakarta '),
('KRA', 'Karanganyar'),
('MKS', 'Makassar');
GO

CREATE TABLE PerusahaanJasa(
IdPerusahaan VARCHAR(6),
NamaPerusahaan VARCHAR(30),
NomorTelp VARCHAR(15),
Pemilik VARCHAR(6),
TahunBerdiri DATE,
JenisPerusahaan VARCHAR(9),
PRIMARY KEY (IdPerusahaan)
);
GO

INSERT INTO PerusahaanJasa(IdPerusahaan, NamaPerusahaan, NomorTelp, Pemilik, TahunBerdiri, JenisPerusahaan)
VALUES
('K-KAI', 'Kereta Api Indonesia', '021-1500-164', 'Negara', '1945-09-28', 'KeretaApi'),
('M-JT', 'Lion Air', '0804-177-8899', 'Swasta', '1999-10-19', 'Maskapai'),
('M-GIA', 'Garuda Indonesia', '0804-180-7807', 'Negara', '1949-01-26', 'Maskapai'),
('M-BTK', 'Batik Air', '021-6379-8000', 'Swasta', '2013-03-01', 'Maskapai'),
('P-PLNI', 'Pelayaran Nasional Indonesia', '021-2188-7000', 'Negara', '1952-04-28', 'Pelayaran'),
('P-SMDR', 'Samudera Indonesia', '0274- 885514', 'Swasta', '1964-01-01', 'Pelayaran'),
('T-BIRD', 'Blue Bird', '021-7989-111', 'Swasta', '2001-01-01', 'Taxi'),
('O-DIDH', 'Dieng Indah', '081-294-667-667', 'Swasta', '1980-01-01', 'Otobus'),
('O-TRJG', 'Trans Jogja', '080-090-090-909', 'Negara', '2008-01-01', 'Otobus');
GO

CREATE TABLE Bandara(
IdBandara VARCHAR(4),
NamaBandara VARCHAR(30),
JenisBandara VARCHAR(18),
Gate TINYINT,
Terminal TINYINT,
Kota VARCHAR(4),
PRIMARY KEY (IdBandara)
);
GO 

INSERT INTO Bandara(IdBandara, NamaBandara, JenisBandara, Gate, Terminal, Kota)
VALUES
('JOG', 'Adisucipto', 'Internasional', 18, 3, 'JOG'),
('YIA', 'Yogyakarta International', 'Internasional', 20, 3, 'JOG'),
('CGK', 'Soekarno Hatta', 'Internasional', 20, 4, 'JKT');
GO

CREATE TABLE Pelabuhan(
IdPelabuhan SMALLINT,
NamaPelabuhan VARCHAR(30),
Kota VARCHAR(4),
PRIMARY KEY (IdPelabuhan)
);
GO

INSERT INTO Pelabuhan(IdPelabuhan, NamaPelabuhan, Kota)
VALUES
(1, 'Makassar', 'MKS'),
(2, 'Tanjung Priok', 'JKT');
GO

CREATE TABLE Stasiun(
IdStasiun VARCHAR(3),
NamaStasiun VARCHAR(30),
Peron TINYINT,
Kota VARCHAR(4),
PRIMARY KEY (IdStasiun)
);

INSERT INTO Stasiun(IdStasiun, NamaStasiun, Peron, Kota)
VALUES
('LPN', 'Lempuyangan', 3, 'JOG'),
('WT', 'Wates', 5, 'JOG'),
('SLO', 'Solo Balapan', 4, 'SLO'),
('SK', 'Jebres', 5, 'SLO');
GO

CREATE TABLE Terminal(
IdTerminal SMALLINT,
NamaTerminal VARCHAR(30),
Kota VARCHAR(4),
PRIMARY KEY (IdTerminal)
);
GO

INSERT INTO Terminal(IdTerminal, NamaTerminal, Kota)
VALUES
(1, 'Kalideres', 'JKT'),
(2, 'Giwangan', 'JOG'),
(3, 'Jombor', 'JOG');
GO

CREATE TABLE Pesawat(
NoLambung VARCHAR(6),
JenisPesawat VARCHAR(10),
KapasitasBagasiReg TINYINT,
PRIMARY KEY (NoLambung)
);

INSERT INTO Pesawat(NoLambung, JenisPesawat, KapasitasBagasiReg)
VALUES
('PK-101', 'Airbus', 6),
('PK-102', 'Airbus', 4),
('PK-103', 'Boeing', 5),
('PK-104', 'Airbus', 5);
GO

CREATE TABLE Kapal(
NoLambung VARCHAR(6),
NamaKapal VARCHAR(30),
PRIMARY KEY (NoLambung)
);

INSERT INTO Kapal(NoLambung, NamaKapal)
VALUES
('123456', 'KM Umsini'),
('123457', 'KM DobonSolo');
GO

CREATE TABLE Kereta(
IdKereta VARCHAR(6),
NamaKereta VARCHAR(30),
PRIMARY KEY (IdKereta)
);
GO

INSERT INTO Kereta(IdKereta, NamaKereta)
VALUES
('1001', 'Joglosemarkerto'),
('1002', 'Progo');
GO

CREATE TABLE Bus(
NomorPlat VARCHAR(8),
MerkBus VARCHAR(15),
Kelas VARCHAR(10),
Toilet BIT,
AC BIT,
StopKontak BIT,
FormatKursi VARCHAR(5),
KapasitasBus TINYINT,
PRIMARY KEY (NomorPlat)
);
GO

INSERT INTO Bus(NomorPlat, MerkBus, Kelas, Toilet, AC, StopKontak, FormatKursi, KapasitasBus)
VALUES
('AB9009YK', 'Honda', 'Eksekutif', 1, 1, 1, '2-2', 20),
('L4848JT', 'Mitshubishi', 'Ekonomi', 0, 1, 1, '3-3', 30),
('AA4848JT', 'Suzuki', 'Eksekutif', 1, 1, 1, '2-2', 20),
('AB3030AA', 'Mitshubishi', 'Ekonomi', 0, 1, 0, '2-2', 30);
GO

CREATE TABLE BagasiTambahan(
NoLambung VARCHAR(6),
Berat TINYINT,
Harga INT,
FOREIGN KEY (NoLambung) REFERENCES Pesawat(NoLambung) ON UPDATE CASCADE,
PRIMARY KEY (NoLambung, Berat)
);
GO

INSERT INTO BagasiTambahan(NoLambung, Berat, Harga)
VALUES
('PK-101', 5, 120000),
('PK-103', 3, 140000);
GO

CREATE TABLE KabinPesawat(
NoLambung VARCHAR(6),
IdKabin TINYINT,
Kelas VARCHAR(10),
FormatKursi VARCHAR(5),
Kapasitas TINYINT,
FOREIGN KEY (NoLambung) REFERENCES Pesawat(NoLambung) ON UPDATE CASCADE,
PRIMARY KEY (NoLambung, IdKabin)
);
GO

INSERT INTO KabinPesawat(NoLambung, IdKabin, Kelas, FormatKursi, Kapasitas)
VALUES
('PK-101', 1, 'Ekonomi', '2-4-2', 30),
('PK-101', 2, 'Eksekutif', '2-2-2', 15),
('PK-102', 1, 'Ekonomi', '2-4-2', 30),
('PK-102', 2, 'Eksekutif', '2-2-2', 15),
('PK-103', 1, 'Ekonomi', '2-4-2', 30),
('PK-104', 1, 'Ekonomi', '2-4-2', 30);
GO

CREATE TABLE KabinKapal(
NoLambung VARCHAR(6),
IdKabin TINYINT,
Kelas VARCHAR(10),
Kapasitas TINYINT,
FOREIGN KEY (NoLambung) REFERENCES Kapal(NoLambung) ON UPDATE CASCADE,
PRIMARY KEY (NoLambung, IdKabin)
);
GO

INSERT INTO KabinKapal(NoLambung, IdKabin, Kelas, Kapasitas)
VALUES
('123456', 1, 'Ekonomi', 40),
('123456', 2, 'Eksekutif', 15),
('123457', 1, 'Ekonomi', 40);
GO

CREATE TABLE GerbongKereta(
IdKereta VARCHAR(6),
IdGerbong TINYINT,
Kelas VARCHAR(10),
SubKelas VARCHAR(2),
Kapasitas TINYINT,
FOREIGN KEY (IdKereta) REFERENCES Kereta(IdKereta) ON UPDATE CASCADE,
PRIMARY KEY (IdKereta, IdGerbong)
);
GO

INSERT INTO GerbongKereta(IdKereta, IdGerbong, Kelas, SubKelas, Kapasitas)
VALUES
('1001', 1, 'Ekonomi', 'A', 30),
('1001', 2, 'Ekonomi', 'C', 30),
('1001', 3, 'Eksekutif', 'AA', 30),
('1002', 1, 'Ekonomi', 'A', 30),
('1002', 2, 'Ekonomi', 'B', 30),
('1002', 3, 'Ekonomi', 'C', 30);
GO

CREATE TABLE Penerbangan(
IdPenerbangan VARCHAR(7),
TglBerangkat DATE,
WaktuBoarding TIME,
WaktuBerangkat TIME,
TglTiba DATE,
WaktuTiba TIME,
TarifDewasa INT,
TarifAnak INT,
JenisRute VARCHAR(8),
DariKota VARCHAR(4),
KeKota VARCHAR(4),
Maskapai VARCHAR(6),
Pesawat VARCHAR(6),
FOREIGN KEY (DariKota) REFERENCES Kota(IdKota),
FOREIGN KEY (KeKota) REFERENCES Kota(IdKota),
FOREIGN KEY (Maskapai) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
FOREIGN KEY (Pesawat) REFERENCES Pesawat(NoLambung) ON UPDATE CASCADE,
PRIMARY KEY (IdPenerbangan)
);
GO

INSERT INTO Penerbangan(IdPenerbangan, TglBerangkat, WaktuBoarding, WaktuBerangkat, TglTiba, WaktuTiba, TarifDewasa, TarifAnak, JenisRute, DariKota, KeKota, Maskapai, Pesawat)
VALUES
('GIA-208', '2020-12-31', '06:30:00', '06:45:00', '2020-12-31', '07:45:00', 250000, 200000, 'Direct', 'JKT', 'JOG', 'M-GIA', 'PK-101'),
('JT-303', '2020-12-31', '08:30:00', '08:45:00', '2020-12-31', '09:45:00', 230000, 190000, 'Direct', 'JKT', 'JOG', 'M-JT', 'PK-102'),
('BTK-112', '2021-01-01', '12:25:00', '12:35:00', '2021-01-01', '13:55:00', 230000, 190000, 'Direct', 'JOG', 'JKT', 'M-BTK', 'PK-103');
GO

CREATE TABLE Pelayaran(
IdPelayaran VARCHAR(9),
TglBerangkat DATE,
WaktuBerangkat TIME,
TglTiba DATE,
WaktuTiba TIME,
TarifDewasa INT,
TarifAnak INT,
JenisRute VARCHAR(8),
DariKota VARCHAR(4),
KeKota VARCHAR(4),
Penyedia VARCHAR(6),
Kapal VARCHAR(6),
FOREIGN KEY (DariKota) REFERENCES Kota(IdKota),
FOREIGN KEY (KeKota) REFERENCES Kota(IdKota),
FOREIGN KEY (Penyedia) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
FOREIGN KEY (Kapal) REFERENCES Kapal(NoLambung) ON UPDATE CASCADE,
PRIMARY KEY (IdPelayaran)
);
GO

INSERT INTO Pelayaran(IdPelayaran, TglBerangkat, WaktuBerangkat, TglTiba, WaktuTiba, TarifDewasa, TarifAnak, JenisRute, DariKota, KeKota, Penyedia, Kapal)
VALUES
('NP-132-C9', '2020-12-31', '08:45:00', '2021-01-01', '01:45:00', 230000, 190000, 'Direct', 'JKT', 'MKS', 'P-PLNI', '123456'),
('NP-123-C5', '2021-01-01', '12:35:00', '2021-01-02', '00:55:00', 230000, 190000, 'Direct', 'MKS', 'JKT', 'P-SMDR', '123457');
GO

CREATE TABLE PerjalananKereta(
IdPerjalananKereta VARCHAR(6),
TglBerangkat DATE,
WaktuBerangkat TIME,
TglTiba DATE,
WaktuTiba TIME,
TarifDewasa INT,
TarifAnak INT,
JenisRute VARCHAR(8),
DariKota VARCHAR(4),
KeKota VARCHAR(4),
Penyedia VARCHAR(6),
Kereta VARCHAR(6),
FOREIGN KEY (DariKota) REFERENCES Kota(IdKota),
FOREIGN KEY (KeKota) REFERENCES Kota(IdKota),
FOREIGN KEY (Penyedia) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
FOREIGN KEY (Kereta) REFERENCES Kereta(IdKereta) ON UPDATE CASCADE,
PRIMARY KEY (IdPerjalananKereta)
);
GO

INSERT INTO PerjalananKereta(IdPerjalananKereta, TglBerangkat, WaktuBerangkat, TglTiba, WaktuTiba, TarifDewasa, TarifAnak, JenisRute, DariKota, KeKota, Penyedia, Kereta)
VALUES
('KA1001', '2020-12-31', '08:45:00', '2021-12-31', '09:45:00', 40000, 38000, 'Indirect', 'JOG', 'SLO', 'K-KAI', '1001'),
('KA2001', '2020-12-31', '09:43:00', '2021-12-31', '11:20:00', 44000, 41000, 'Indirect', 'JOG', 'SLO', 'K-KAI', '1001'),
('KA1002', '2021-01-01', '12:35:00', '2021-01-01', '13:30:00', 30000, 25000, 'Direct', 'JOG', 'JOG', 'K-KAI', '1002');
GO

CREATE TABLE PerjalananBus(
IdPerjalananBus VARCHAR(6),
TglBerangkat DATE,
WaktuBerangkat TIME,
TglTiba DATE,
WaktuTiba TIME,
TarifDewasa INT,
TarifAnak INT,
JenisRute VARCHAR(8),
DariKota VARCHAR(4),
KeKota VARCHAR(4),
Penyedia VARCHAR(6),
Bus VARCHAR(8),
FOREIGN KEY (DariKota) REFERENCES Kota(IdKota),
FOREIGN KEY (KeKota) REFERENCES Kota(IdKota),
FOREIGN KEY (Penyedia) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
FOREIGN KEY (Bus) REFERENCES Bus(NomorPlat) ON UPDATE CASCADE,
PRIMARY KEY (IdPerjalananBus)
);
GO

INSERT INTO PerjalananBus(IdPerjalananBus, TglBerangkat, WaktuBerangkat, TglTiba, WaktuTiba, TarifDewasa, TarifAnak, JenisRute, DariKota, KeKota, Penyedia, Bus)
VALUES
('BS1001', '2020-12-31', '08:45:00', '2021-12-31', '23:45:00', 130000, 110000, 'Direct', 'JOG', 'JKT', 'O-DIDH', 'AB9009YK'),
('BS2001', '2020-12-31', '09:43:00', '2021-12-31', '23:20:00', 170000, 160000, 'Direct', 'JOG', 'JKT', 'O-DIDH', 'L4848JT'),
('BS1002', '2021-01-01', '12:35:00', '2021-01-01', '22:30:00', 150000, 155000, 'Direct', 'JKT', 'JOG', 'O-DIDH', 'AA4848JT');
GO

CREATE TABLE LayananBusLokal(
IdLayananBusLokal VARCHAR(6),
WilayahOperasi VARCHAR(4),
Penyedia VARCHAR(6),
Bus VARCHAR(8),
FOREIGN KEY (WilayahOperasi) REFERENCES Kota(IdKota) ON UPDATE CASCADE,
FOREIGN KEY (Penyedia) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
FOREIGN KEY (Bus) REFERENCES Bus(NomorPlat) ON UPDATE CASCADE,
PRIMARY KEY (IdLayananBusLokal)
);
GO

INSERT INTO LayananBusLokal(IdLayananBusLokal, WilayahOperasi, Penyedia, Bus)
VALUES
('LO1001', 'JOG', 'O-TRJG', 'AB3030AA');
GO

CREATE TABLE LayananTaksi(
IdLayananTaksi VARCHAR(6),
WilayahOperasi VARCHAR(4),
NomorTelp VARCHAR(12),
Penyedia VARCHAR(6),
FOREIGN KEY (WilayahOperasi) REFERENCES Kota(IdKota) ON UPDATE CASCADE,
FOREIGN KEY (Penyedia) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
PRIMARY KEY (IdLayananTaksi)
);
GO

INSERT INTO LayananTaksi(IdLayananTaksi, WilayahOperasi, NomorTelp, Penyedia)
VALUES
('TX1001', 'JOG', '022-211-211', 'T-BIRD'),
('TX1002', 'SLO', '022-211-222', 'T-BIRD');
GO

CREATE TABLE Taksi(
NomorPlat VARCHAR(8),
IdLayananTaksi VARCHAR(6),
FOREIGN KEY (IdLayananTaksi) REFERENCES LayananTaksi(IdLayananTaksi) ON UPDATE CASCADE,
PRIMARY KEY (NomorPlat)
);
GO

INSERT INTO Taksi( NomorPlat, IdLayananTaksi)
VALUES
('AB2021JT', 'TX1001'),
('AB2121AS', 'TX1001'),
('AB3221BD', 'TX1001'),
('AD7021JT', 'TX1002'),
('AD6531JA', 'TX1002');
GO

CREATE TABLE LokasiTransitBus(
IdLokasi VARCHAR(6),
NamaLokasi VARCHAR(30),
JenisLokasi VARCHAR(15),
Kota VARCHAR(4),
FOREIGN KEY (Kota) REFERENCES Kota(IdKota) ON UPDATE CASCADE,
PRIMARY KEY (IdLokasi)
);
GO

INSERT INTO LokasiTransitBus( IdLokasi, NamaLokasi, JenisLokasi, Kota)
VALUES
('1001', 'Terminal Prambanan', 'Terminal', 'JOG'),
('1002', 'Plaza Ambarukmo', 'Mall', 'JOG'),
('1003', 'XXI','Bioskop', 'JOG'),
('1004', 'Tugu', 'Pariwisata', 'JOG'),
('1005', 'Stasiun Tugu', 'Stasiun', 'JOG');
GO

CREATE TABLE RutePenerbangan(
IdRutePenerbangan VARCHAR(6),
IdPenerbangan VARCHAR(7),
FOREIGN KEY (IdPenerbangan) REFERENCES Penerbangan(IdPenerbangan) ON UPDATE CASCADE,
PRIMARY KEY (IdRutePenerbangan)
);
GO

INSERT INTO RutePenerbangan(IdRutePenerbangan, IdPenerbangan)
VALUES
('1001', 'GIA-208'),
('1002', 'JT-303'),
('1003', 'BTK-112');
GO

CREATE TABLE RutePenerbanganTerdiri(
IdRutePenerbangan VARCHAR(6),
NoTransit TINYINT,
IdBandara VARCHAR(4),
FOREIGN KEY (IdRutePenerbangan) REFERENCES RutePenerbangan(IdRutePenerbangan) ON UPDATE CASCADE,
FOREIGN KEY (IdBandara) REFERENCES Bandara(IdBandara) ON UPDATE CASCADE,
PRIMARY KEY (IdRutePenerbangan, NoTransit)
);
GO

INSERT INTO RutePenerbanganTerdiri(IdRutePenerbangan, NoTransit, IdBandara)
VALUES
('1001', 1, 'CGK'),
('1001', 2, 'YIA'),
('1002', 1, 'CGK'),
('1002', 2, 'JOG'),
('1003', 1, 'JOG'),
('1003', 2, 'CGK');
GO

CREATE TABLE RutePelayaran(
IdRutePelayaran VARCHAR(6),
IdPelayaran VARCHAR(9),
FOREIGN KEY (IdPelayaran) REFERENCES Pelayaran(IdPelayaran) ON UPDATE CASCADE,
PRIMARY KEY (IdRutePelayaran)
);
GO

INSERT INTO RutePelayaran(IdRutePelayaran, IdPelayaran)
VALUES
('1001', 'NP-132-C9'),
('1002', 'NP-123-C5');
GO

CREATE TABLE RutePelayaranTerdiri(
IdRutePelayaran VARCHAR(6),
NoTransit TINYINT,
IdPelabuhan SMALLINT,
FOREIGN KEY (IdRutePelayaran) REFERENCES RutePelayaran(IdRutePelayaran) ON UPDATE CASCADE,
FOREIGN KEY (IdPelabuhan) REFERENCES Pelabuhan(IdPelabuhan) ON UPDATE CASCADE,
PRIMARY KEY (IdRutePelayaran, NoTransit)
);
GO

INSERT INTO RutePelayaranTerdiri(IdRutePelayaran, NoTransit, IdPelabuhan)
VALUES
('1001', 1, 2),
('1001', 2, 1),
('1002', 1, 1),
('1002', 2, 2);
GO

CREATE TABLE RuteKereta(
IdRuteKereta VARCHAR(6),
IdPerjalananKereta VARCHAR(6),
FOREIGN KEY (IdPerjalananKereta) REFERENCES PerjalananKereta(IdPerjalananKereta) ON UPDATE CASCADE,
PRIMARY KEY (IdRuteKereta)
);
GO

INSERT INTO RuteKereta(IdRuteKereta, IdPerjalananKereta)
VALUES
('1001', 'KA1001'),
('1002', 'KA2001'),
('1003', 'KA1002');
GO

CREATE TABLE RuteKeretaTerdiri(
IdRuteKereta VARCHAR(6),
NoTransit TINYINT,
IdStasiun VARCHAR(3),
FOREIGN KEY (IdRuteKereta) REFERENCES RuteKereta(IdRuteKereta) ON UPDATE CASCADE,
FOREIGN KEY (IdStasiun) REFERENCES Stasiun(IdStasiun) ON UPDATE CASCADE,
PRIMARY KEY (IdRuteKereta, NoTransit)
);
GO

INSERT INTO RuteKeretaTerdiri(IdRuteKereta, NoTransit, IdStasiun)
VALUES
('1001', 1, 'LPN'),
('1001', 2, 'SK'),
('1001', 3, 'SLO'),
('1002', 1, 'WT'),
('1002', 2, 'LPN'),
('1002', 3, 'SK'),
('1002', 4, 'SLO'),
('1003', 1, 'WT'),
('1003', 2, 'LPN');
GO

CREATE TABLE RuteBus(
IdRuteBus VARCHAR(6),
IdPerjalananBus VARCHAR(6),
FOREIGN KEY (IdPerjalananBus) REFERENCES PerjalananBus(IdPerjalananBus) ON UPDATE CASCADE,
PRIMARY KEY (IdRuteBus)
);
GO

INSERT INTO RuteBus(IdRuteBus, IdPerjalananBus)
VALUES
('1001', 'BS1001'),
('1002', 'BS2001'),
('1003', 'BS1002');
GO

CREATE TABLE RuteBusTerdiri(
IdRuteBus VARCHAR(6),
NoTransit TINYINT,
IdTerminal SMALLINT,
FOREIGN KEY (IdRuteBus) REFERENCES RuteBus(IdRuteBus) ON UPDATE CASCADE,
FOREIGN KEY (IdTerminal) REFERENCES Terminal(IdTerminal) ON UPDATE CASCADE,
PRIMARY KEY (IdRuteBus, NoTransit)
);
GO

INSERT INTO RuteBusTerdiri(IdRuteBus, NoTransit, IdTerminal)
VALUES
('1001', 1, 2),
('1001', 2, 1),
('1002', 1, 3),
('1002', 2, 1),
('1003', 1, 1),
('1003', 2, 2);
GO

CREATE TABLE RuteBusLokal(
IdRuteBusLokal VARCHAR(6),
IdPerjalananBus VARCHAR(6),
FOREIGN KEY (IdPerjalananBus) REFERENCES LayananBusLokal(IdLayananBusLokal) ON UPDATE CASCADE,
PRIMARY KEY (IdRuteBusLokal)
);
GO

INSERT INTO RuteBusLokal(IdRuteBusLokal, IdPerjalananBus)
VALUES
('1001', 'LO1001');
GO

CREATE TABLE RuteBusLokalTerdiri(
IdRuteBusLokal VARCHAR(6),
NoTransit TINYINT,
IdLokasiTransit VARCHAR(6),
FOREIGN KEY (IdRuteBusLokal) REFERENCES RuteBusLokal(IdRuteBusLokal),
FOREIGN KEY (IdLokasiTransit) REFERENCES LokasiTransitBus(IdLokasi),
PRIMARY KEY (IdRuteBusLokal, NoTransit)
);
GO

INSERT INTO RuteBusLokalTerdiri(IdRuteBusLokal, NoTransit, IdLokasiTransit)
VALUES
('1001', 1, '1001'),
('1001', 2, '1002'),
('1001', 3, '1003'),
('1001', 4, '1004'),
('1001', 5, '1005');
GO

CREATE TABLE CabangKota(
IdCabangKota VARCHAR(6),
NomorTelp VARCHAR(15),
TahunDibuka DATE,
IdKota VARCHAR(4),
IdPerusahaan VARCHAR(6),
FOREIGN KEY (IdKota) REFERENCES Kota(IdKota) ON UPDATE CASCADE,
FOREIGN KEY (IdPerusahaan) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
PRIMARY KEY (IdCabangKota)
);
GO

INSERT INTO CabangKota(IdCabangKota, NomorTelp, TahunDibuka, IdKota, IdPerusahaan)
VALUES
('1001', '021-0689-821', '2001-09-09', 'JOG', 'T-BIRD'),
('1002', '020-0002-333', '1949-01-26', 'JKT', 'M-GIA'),
('1003', '020-0002-332', '1949-01-26', 'JOG', 'M-GIA');
GO

CREATE TABLE CabangBandara(
IdCabangBandara VARCHAR(6),
TahunDibuka DATE,
IdBandara VARCHAR(4),
IdMaskapai VARCHAR(6),
FOREIGN KEY (IdBandara) REFERENCES Bandara(IdBandara) ON UPDATE CASCADE,
FOREIGN KEY (IdMaskapai) REFERENCES PerusahaanJasa(IdPerusahaan) ON UPDATE CASCADE,
PRIMARY KEY (IdCabangBandara)
);
GO

INSERT INTO CabangBandara(IdCabangBandara, TahunDibuka, IdBandara, IdMaskapai)
VALUES
('1001', '1949-01-26', 'CGK', 'M-GIA'),
('1002', '1949-04-26', 'JOG', 'M-GIA');
GO

CREATE VIEW  ViewKota AS
SELECT *
FROM Kota;
GO

CREATE VIEW  ViewPerusahaan AS
SELECT IdPerusahaan, NamaPerusahaan, NomorTelp, Pemilik, TahunBerdiri
FROM PerusahaanJasa
WHERE PerusahaanJasa.JenisPerusahaan = 'Maskapai'
GO

CREATE VIEW ViewBandara AS
SELECT IdBandara, NamaBandara, JenisBandara, Gate, Terminal, NamaKota FROM Bandara
INNER JOIN Kota ON Bandara.Kota = Kota.IdKota
GO

CREATE VIEW ViewPesawat AS
SELECT * FROM Pesawat
GO

CREATE VIEW ViewPenerbangan AS
SELECT * FROM Penerbangan
GO
