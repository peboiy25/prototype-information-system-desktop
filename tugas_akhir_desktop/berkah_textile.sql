-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 18, 2024 at 02:18 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `berkah_tekstil`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(30) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `satuan` varchar(5) NOT NULL,
  `harga_per_kg` int(11) NOT NULL,
  `grand_stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `satuan`, `harga_per_kg`, `grand_stok`) VALUES
('AL', 'Aromaline', 'Kg', 62000, 5152),
('BL', 'Bertha Line', 'Kg', 64000, 4850),
('KF', 'Kafan', 'Kg', 62000, 175),
('MN', 'Miniqlo', 'Kg', 65000, 5000),
('PR', 'Paraguay', 'Kg', 65000, 5000),
('RB', 'Robusta', 'Kg', 63000, 4848),
('SC', 'Scuba', 'Kg', 64000, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_faktur_keluar`
--

CREATE TABLE `detail_faktur_keluar` (
  `id_detail` int(11) NOT NULL,
  `no_faktur_keluar` varchar(30) NOT NULL,
  `kode_barang` varchar(30) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `berat` double(4,2) NOT NULL,
  `qty` int(11) NOT NULL,
  `sub_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_faktur_keluar`
--

INSERT INTO `detail_faktur_keluar` (`id_detail`, `no_faktur_keluar`, `kode_barang`, `warna`, `berat`, `qty`, `sub_total`) VALUES
(10, 'K-005', 'RB', 'Merah', 25.55, 5, 8190000),
(11, 'K-005', 'BL', 'Merah', 25.10, 5, 8000000),
(12, 'K-006', 'BL', 'Merah', 25.00, 3, 4800000),
(13, 'K-006', 'BL', 'Merah', 25.15, 1, 1600000),
(14, 'K-008', 'KF', 'putih', 25.35, 1, 1550000);

--
-- Triggers `detail_faktur_keluar`
--
DELIMITER $$
CREATE TRIGGER `kurang_grand` AFTER INSERT ON `detail_faktur_keluar` FOR EACH ROW UPDATE barang SET  barang.grand_stok = barang.grand_stok - NEW.berat*NEW.qty WHERE NEW.kode_barang = barang.kode_barang
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `kurang_stok` AFTER INSERT ON `detail_faktur_keluar` FOR EACH ROW UPDATE stok_warna SET 
stok_warna.stok = stok_warna.stok - NEW.qty 
WHERE 
NEW.kode_barang = stok_warna.kode_barang AND
NEW.warna = stok_warna.warna AND
NEW.berat = stok_warna.berat
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_faktur_masuk`
--

CREATE TABLE `detail_faktur_masuk` (
  `id_detail` int(11) NOT NULL,
  `no_faktur` varchar(30) NOT NULL,
  `kode_barang` varchar(30) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `berat` double(4,2) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_faktur_masuk`
--

INSERT INTO `detail_faktur_masuk` (`id_detail`, `no_faktur`, `kode_barang`, `warna`, `berat`, `qty`) VALUES
(8, '1', 'AL', 'Merah', 25.99, 1),
(9, '1', 'AL', 'Merah', 25.55, 2),
(10, 'M-001', 'RB', 'Merah', 2.00, 1),
(11, '1', 'BL', 'Merah', 25.00, 2),
(12, 'M-0001', 'BL', 'Merah', 25.15, 2),
(13, 'M-001', 'AL', 'Biru', 25.15, 3);

--
-- Triggers `detail_faktur_masuk`
--
DELIMITER $$
CREATE TRIGGER `tambah_grand` AFTER INSERT ON `detail_faktur_masuk` FOR EACH ROW UPDATE barang SET barang.grand_stok = barang.grand_stok + NEW.berat * NEW.qty WHERE NEW.kode_barang = barang.kode_barang
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tambah_stok` AFTER INSERT ON `detail_faktur_masuk` FOR EACH ROW UPDATE stok_warna SET 
stok_warna.stok = stok_warna.stok + NEW.qty 
WHERE NEW.kode_barang = stok_warna.kode_barang AND NEW.warna = stok_warna.warna AND NEW.berat = stok_warna.berat
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `faktur_keluar`
--

CREATE TABLE `faktur_keluar` (
  `no_faktur_keluar` varchar(30) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `grand_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faktur_keluar`
--

INSERT INTO `faktur_keluar` (`no_faktur_keluar`, `nama_pelanggan`, `tanggal`, `grand_total`) VALUES
('K-005', 'Pelanggan', '2024-01-16', 16190000),
('K-006', 'PLG', '2024-01-16', 6400000),
('K-008', 'febycantik', '2024-01-16', 1550000);

-- --------------------------------------------------------

--
-- Table structure for table `faktur_masuk`
--

CREATE TABLE `faktur_masuk` (
  `no_faktur` varchar(30) NOT NULL,
  `nama_pabrik` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `stok_masuk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faktur_masuk`
--

INSERT INTO `faktur_masuk` (`no_faktur`, `nama_pabrik`, `tanggal`, `stok_masuk`) VALUES
('1', 'nama', '2024-01-16', 3),
('M-0001', 'solehudin', '2024-01-16', 2),
('M-001', 'Pabrik', '2024-01-16', 1);

-- --------------------------------------------------------

--
-- Table structure for table `stok_warna`
--

CREATE TABLE `stok_warna` (
  `kode_barang` varchar(30) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `no_urut` int(11) NOT NULL,
  `berat` decimal(4,2) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stok_warna`
--

INSERT INTO `stok_warna` (`kode_barang`, `warna`, `no_urut`, `berat`, `stok`) VALUES
('BL', 'Merah', 1, '25.00', 24),
('BL', 'Merah', 2, '25.10', 10),
('BL', 'Merah', 3, '25.15', 7),
('RB', 'Merah', 1, '25.55', 15),
('MN', 'Biru', 1, '25.35', 12),
('AL', 'Biru', 1, '25.25', 2),
('BL', 'Biru', 1, '25.15', 3),
('KF', 'putih', 1, '25.35', 2),
('KF', 'putih', 2, '25.40', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `kode_user` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`kode_user`, `username`, `password`, `role`) VALUES
('A1', 'admin', 'admin', 'Admin'),
('A2', 'apaya', 'apaya', 'Admin'),
('A3', 'terserah', 'kepo', 'Admin'),
('P1', 'pemilik', 'pemilik', 'Pemilik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `detail_faktur_keluar`
--
ALTER TABLE `detail_faktur_keluar`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `no_nota` (`no_faktur_keluar`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `detail_faktur_masuk`
--
ALTER TABLE `detail_faktur_masuk`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `kode_barang` (`kode_barang`),
  ADD KEY `no_nota` (`no_faktur`);

--
-- Indexes for table `faktur_keluar`
--
ALTER TABLE `faktur_keluar`
  ADD PRIMARY KEY (`no_faktur_keluar`);

--
-- Indexes for table `faktur_masuk`
--
ALTER TABLE `faktur_masuk`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `stok_warna`
--
ALTER TABLE `stok_warna`
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`kode_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_faktur_keluar`
--
ALTER TABLE `detail_faktur_keluar`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `detail_faktur_masuk`
--
ALTER TABLE `detail_faktur_masuk`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_faktur_keluar`
--
ALTER TABLE `detail_faktur_keluar`
  ADD CONSTRAINT `detail_faktur_keluar_ibfk_1` FOREIGN KEY (`no_faktur_keluar`) REFERENCES `faktur_keluar` (`no_faktur_keluar`),
  ADD CONSTRAINT `detail_faktur_keluar_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);

--
-- Constraints for table `detail_faktur_masuk`
--
ALTER TABLE `detail_faktur_masuk`
  ADD CONSTRAINT `detail_faktur_masuk_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  ADD CONSTRAINT `detail_faktur_masuk_ibfk_2` FOREIGN KEY (`no_faktur`) REFERENCES `faktur_masuk` (`no_faktur`);

--
-- Constraints for table `stok_warna`
--
ALTER TABLE `stok_warna`
  ADD CONSTRAINT `stok_warna_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
