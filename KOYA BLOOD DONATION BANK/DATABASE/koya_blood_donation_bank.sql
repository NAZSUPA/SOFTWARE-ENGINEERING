-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 05, 2025 at 05:07 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `koya_blood_donation_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `APPOINTMENT_ID` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `HOUR` varchar(8) NOT NULL,
  `DONOR_ID` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`APPOINTMENT_ID`, `DATE`, `HOUR`, `DONOR_ID`) VALUES
(21, '2026-04-08', '8:00 AM', 2);

-- --------------------------------------------------------

--
-- Table structure for table `donors`
--

CREATE TABLE `donors` (
  `DONOR_ID` int(11) UNSIGNED NOT NULL,
  `FIRST_NAME` varchar(25) NOT NULL,
  `LAST_NAME` varchar(25) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `GENDER` varchar(5) NOT NULL,
  `BLOOD_GROUP` varchar(3) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `PASS_WORD` varchar(60) NOT NULL,
  `LAST_BLOOD_DONATION_DATE` date DEFAULT NULL,
  `NUMBER_OF_DONATION` int(11) NOT NULL DEFAULT 0,
  `ACCOUNT_ACTIVATION` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donors`
--

INSERT INTO `donors` (`DONOR_ID`, `FIRST_NAME`, `LAST_NAME`, `BIRTHDAY`, `GENDER`, `BLOOD_GROUP`, `USER_NAME`, `PASS_WORD`, `LAST_BLOOD_DONATION_DATE`, `NUMBER_OF_DONATION`, `ACCOUNT_ACTIVATION`) VALUES
(2, 'ARAM', 'AHMAD', '2000-11-06', 'MALE', 'B+', 'ARAM_AHMAD_2000', '123ABCX', '2025-12-05', 2, b'1'),
(3, 'sara', 'hamid', '2000-06-13', 'FEMAL', 'A+', 'sara_hamid@2000', '$2y$10$zdMD6VTVqhcZ4WqONuLh0exrEnQ7xL4I6KtvPaFEQWA5M5fV0m6o6', '2025-12-04', 0, b'0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`APPOINTMENT_ID`),
  ADD KEY `D_ID_FK` (`DONOR_ID`);

--
-- Indexes for table `donors`
--
ALTER TABLE `donors`
  ADD PRIMARY KEY (`DONOR_ID`),
  ADD UNIQUE KEY `USER NAME` (`USER_NAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `APPOINTMENT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `donors`
--
ALTER TABLE `donors`
  MODIFY `DONOR_ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `DONOR_ID_FK` FOREIGN KEY (`DONOR_ID`) REFERENCES `donors` (`DONOR_ID`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
