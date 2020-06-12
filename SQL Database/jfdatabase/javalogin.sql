-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2020 at 10:53 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javalogin`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '123'),
(2, 'admin2', '123'),
(3, 'admin3', '123');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(32) NOT NULL,
  `name` int(50) NOT NULL,
  `email` int(100) NOT NULL,
  `message` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `email_id`, `password`) VALUES
(2, 'jaffar', '123'),
(3, 'FA19-BSSE-0014', '0041462fa'),
(5, 'FA19-BSSE-0008', 'empire');

-- --------------------------------------------------------

--
-- Table structure for table `oop(object-oriented programming)`
--

CREATE TABLE `oop(object-oriented programming)` (
  `Id` int(11) NOT NULL,
  `Question` varchar(1000) NOT NULL,
  `A` varchar(1000) NOT NULL,
  `B` varchar(1000) NOT NULL,
  `C` varchar(1000) NOT NULL,
  `D` varchar(1000) NOT NULL,
  `Answer` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `oop(object-oriented programming)`
--

INSERT INTO `oop(object-oriented programming)` (`Id`, `Question`, `A`, `B`, `C`, `D`, `Answer`) VALUES
(1, 'Which is private member functions access scope?', 'Member functions which can only be used within the class', 'Member functions which can used outside the class', 'Member functions which are accessible in derived class', 'Member functions which can’t be accessed inside the class', 'A'),
(2, 'Which among the following is true?', 'The private members can’t be accessed by public members of the class', 'The private members can be accessed by public members of the class', 'The private members can be accessed only by the private members of the class', 'The private members can’t be accessed by the protected members of the class', 'B'),
(3, 'Which member can never be accessed by inherited classes?', 'Private member function', 'Public member function', 'All can be accessed', 'Protected member function', 'A'),
(4, 'Which syntax among the following shows that a member is private in a class?', 'private: functionName(parameters) ', 'private(functionName(parameters))', 'private functionName(parameters)', 'private::functionName(parameters)', 'C'),
(5, 'If private member functions are to be declared in C++ then _____________', 'private: &lt;all private members&gt;', 'private &lt;member name&gt;', 'private(private member list)', 'private :- &lt;private members&gt;', 'A'),
(6, 'In java, which rule must be followed?', 'Keyword private preceding list of private member’s', 'Keyword private with a colon before list of private member’s', 'Keyword private with arrow before each private member', 'Keyword private preceding each private member', 'D'),
(7, 'How many private member functions are allowed in a class?', 'Only 1', 'Only 7', 'Only 255', 'As many as required', 'D'),
(8, 'How to access a private member function of a class?', 'Using object of class', 'Using object pointer', 'Using address of member function', 'Using class address', 'C'),
(9, 'Private member functions ____________', 'Can’t be called from enclosing class', 'Can be accessed from enclosing class', 'Can be accessed only if nested class is private', 'Can be accessed only if nested class is public', 'A'),
(10, 'Which function among the following can’t be accessed outside the class in java in same package?', 'public void show()', 'void show()', 'protected show()', 'static void show()', 'C');

-- --------------------------------------------------------

--
-- Table structure for table `questioncurd`
--

CREATE TABLE `questioncurd` (
  `Id` int(50) NOT NULL,
  `Question` varchar(1000) NOT NULL,
  `option1` varchar(1000) NOT NULL,
  `option2` varchar(1000) NOT NULL,
  `option3` varchar(1000) NOT NULL,
  `option4` varchar(1000) NOT NULL,
  `Answer` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questioncurd`
--

INSERT INTO `questioncurd` (`Id`, `Question`, `option1`, `option2`, `option3`, `option4`, `Answer`) VALUES
(1, 'fdgsdfgfdg', 'dfgdsfg', 'dfgsdfg', 'dfgdfg', 'dfsgdf', 'dfgdfs'),
(2, 'what is my name?', 'jaffar', 'fahad', 'ahmed', 'none', 'jaffar'),
(3, 'In java, which rule must be followed?', 'Keyword private preceding list of private member’s', 'Keyword private with a colon before list of private member’s', 'Keyword private with arrow before each private member', 'Keyword private preceding each private member', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `resultofquiz`
--

CREATE TABLE `resultofquiz` (
  `id` int(11) NOT NULL,
  `UserId` varchar(20) NOT NULL,
  `QuizName` varchar(1000) NOT NULL,
  `TotalQuestion` varchar(11) NOT NULL,
  `NoOfQuestionCorrect` varchar(11) NOT NULL,
  `Percentage` varchar(11) NOT NULL,
  `Time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `resultofquiz`
--

INSERT INTO `resultofquiz` (`id`, `UserId`, `QuizName`, `TotalQuestion`, `NoOfQuestionCorrect`, `Percentage`, `Time`) VALUES
(1, 'FA19-BSSE-0014', 'oop(object-oriented programming)', '5', '4', '80%', '2020-06-10');

-- --------------------------------------------------------

--
-- Table structure for table `subjectlist`
--

CREATE TABLE `subjectlist` (
  `id` int(11) NOT NULL,
  `Field` varchar(300) NOT NULL,
  `Pincode` varchar(6) NOT NULL,
  `QuizTime` int(11) NOT NULL,
  `QuizNoofAttemp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjectlist`
--

INSERT INTO `subjectlist` (`id`, `Field`, `Pincode`, `QuizTime`, `QuizNoofAttemp`) VALUES
(2, 'oop(object-oriented programming)', 'BF8E3O', 160000, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_id` (`email_id`);

--
-- Indexes for table `oop(object-oriented programming)`
--
ALTER TABLE `oop(object-oriented programming)`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `questioncurd`
--
ALTER TABLE `questioncurd`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `resultofquiz`
--
ALTER TABLE `resultofquiz`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UserId` (`UserId`);

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
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `oop(object-oriented programming)`
--
ALTER TABLE `oop(object-oriented programming)`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `questioncurd`
--
ALTER TABLE `questioncurd`
  MODIFY `Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `resultofquiz`
--
ALTER TABLE `resultofquiz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `subjectlist`
--
ALTER TABLE `subjectlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
