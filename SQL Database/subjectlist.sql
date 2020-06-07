-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 07:14 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_choicelist`
--

-- --------------------------------------------------------

--
-- Table structure for table `subjectlist`
--

CREATE TABLE `subjectlist` (
  `id` int(11) NOT NULL,
  `Field` varchar(200) NOT NULL,
  `Pincode` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjectlist`
--

INSERT INTO `subjectlist` (`id`, `Field`, `Pincode`) VALUES
(1, 'BSSE', 'BF8E3O'),
(3, 'BSCS', 'gOMWTQ'),
(4, 'BBA', 'zenvtP'),
(9, 'BEEE', 'vDbutW');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `subjectlist`
--
ALTER TABLE `subjectlist`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Field` (`Field`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `subjectlist`
--
ALTER TABLE `subjectlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
