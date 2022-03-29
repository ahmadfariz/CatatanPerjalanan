-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2022 at 05:04 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cttjalan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_catatan`
--

CREATE TABLE `tb_catatan` (
  `nik` varchar(16) NOT NULL,
  `tgl_catatan` varchar(11) NOT NULL,
  `jam` varchar(8) NOT NULL,
  `lokasi` text NOT NULL,
  `suhu_tubuh` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_catatan`
--

INSERT INTO `tb_catatan` (`nik`, `tgl_catatan`, `jam`, `lokasi`, `suhu_tubuh`) VALUES
('0544421932171768', '29-03-2022', '08:20:52', 'Jln. Adisumarmo No. 411, Tual 98228, Papua', 21),
('0544421932171768', '12-12-2021', '10:11:31', 'Jln. Adisumarmo No. 411, Tual 98228, Papua', 20),
('0544421932171768', '14-03-2022', '18:24:37', 'Ds. Soekarno Hatta No. 359, Langsa 11746, Jambi', 19),
('0544421932171768', '11-02-2022', '19:10:19', 'Jr. Achmad No. 157, Balikpapan 42024, NTB', 17),
('0544421932171768', '18-01-2022', '20:20:10', 'Ki. Wahidin Sudirohusodo No. 899, Blitar 56142, NTB', 27),
('0544421932171768', '06-03-2022', '17:21:54', 'Ki. Batako No. 143, Payakumbuh 37199, Banten', 30),
('0544421932171768', '15-01-2022', '14:54:52', 'Jln. Bah Jaya No. 754, Lubuklinggau 91605, SulBar', 29),
('0544421932171768', '07-03-2022', '15:07:52', 'Jln. Ters. Buah Batu No. 371, Pariaman 71807, KalUt', 26),
('0544421932171768', '05-01-2022', '12:20:52', 'Ds. Bahagia No. 983, Banjar 40061, Bengkulu', 19),
('0544421932171768', '21-02-2022', '21:20:20', 'Kpg. Yos No. 665, Pangkal Pinang 11138, Banten', 16);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengguna`
--

CREATE TABLE `tb_pengguna` (
  `nik` varchar(16) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` text NOT NULL,
  `jenkel` enum('Laki - Laki','Perempuan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pengguna`
--

INSERT INTO `tb_pengguna` (`nik`, `nama`, `alamat`, `jenkel`) VALUES
('0544421932171768', 'Lukita Damanik', 'Jr. Jagakarsa No. 771, Administrasi Jakarta Barat 62107, Bengkulu', 'Laki - Laki'),
('1425802335779552', 'Azalea Halimah', 'Ds. Ahmad Dahlan No. 308, Lubuklinggau 31608, SulBar', 'Perempuan'),
('1941757676312814', 'Jasmin Pertiwi', 'Ds. Uluwatu No. 773, Bau-Bau 28365, MalUt', 'Perempuan'),
('2330271874343983', 'Danu Sihotang', 'Dk. Nakula No. 451, Tidore Kepulauan 61706, Riau', 'Laki - Laki'),
('2976631123368895', 'Yuni Rahayu', 'Dk. Sutoyo No. 993, Serang 88837, Riau', 'Perempuan'),
('3001090349589621', 'Ahmad Fariz Dwi Putra', 'Perum Karya Bhakti D15 Rt 01 Rw 07, Gentong 67139, Jatim ', 'Laki - Laki'),
('5158565970361847', 'Maya Susanti', 'Dk. Yosodipuro No. 996, Denpasar 68944, KalBar', 'Perempuan'),
('5771453635883510', 'Syahrini Palastri', 'Ds. Babah No. 151, Ambon 71398, KalSel', 'Perempuan'),
('7921351971350699', 'Darijan Lazuardi', 'Jln. Ketandan No. 685, Lubuklinggau 52039, KalTeng', 'Laki - Laki'),
('9407767363531476', 'Bagas Uwais', 'Kpg. Dago No. 163, Denpasar 22288, Banten', 'Laki - Laki');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_catatan`
--
ALTER TABLE `tb_catatan`
  ADD KEY `nik` (`nik`);

--
-- Indexes for table `tb_pengguna`
--
ALTER TABLE `tb_pengguna`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
