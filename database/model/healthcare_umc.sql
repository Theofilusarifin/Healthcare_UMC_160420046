-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2023 at 04:57 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare_umc`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL,
  `img` text NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `rating` double NOT NULL,
  `description` text NOT NULL,
  `dob` datetime NOT NULL,
  `age` int(11) NOT NULL,
  `gender` enum('male','female') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `img`, `name`, `type`, `rating`, `description`, `dob`, `age`, `gender`) VALUES
(1, 'https://umchealthcare.000webhostapp.com/img/doctors/1.jpg', 'John Smith', 'Surgeon', 4.8, 'Dr. John Smith is a highly skilled surgeon with over 15 years of experience in complex surgical procedures.', '1978-06-12 00:00:00', 45, 'male'),
(2, 'https://umchealthcare.000webhostapp.com/img/doctors/2.jpg', 'Jane Doe', 'Paramedic', 4.2, 'Dr. Jane Doe is a paramedic with a passion for helping others in emergency situations.', '1985-02-28 00:00:00', 38, 'female'),
(3, 'https://umchealthcare.000webhostapp.com/img/doctors/3.jpg', 'Michael Lee', 'Psychologist', 4.5, 'Dr. Michael Lee is a licensed psychologist specializing in cognitive behavioral therapy and mindfulness techniques.', '1971-09-05 00:00:00', 52, 'male'),
(4, 'https://umchealthcare.000webhostapp.com/img/doctors/4.jpg', 'Sarah Johnson', 'Nurse', 4, 'Nurse Sarah Johnson is a compassionate and experienced healthcare professional who has worked in various clinical settings.', '1990-11-22 00:00:00', 33, 'female'),
(5, 'https://umchealthcare.000webhostapp.com/img/doctors/5.jpg', 'James Miller', 'ENT Doctor', 4.3, 'Dr. James Miller is an ear, nose, and throat (ENT) specialist with a focus on minimally invasive procedures.', '1982-04-17 00:00:00', 41, 'male'),
(6, 'https://umchealthcare.000webhostapp.com/img/doctors/6.jpg', 'Lisa Chen', 'Pharmacist', 4.7, 'Dr. Lisa Chen is a registered pharmacist with a deep understanding of medications and their interactions.', '1979-12-03 00:00:00', 44, 'female'),
(7, 'https://umchealthcare.000webhostapp.com/img/doctors/7.jpg', 'David Wilson', 'Consulting Doctor', 4.6, 'Dr. David Wilson is a consulting physician with expertise in internal medicine and preventive care.', '1975-07-19 00:00:00', 48, 'male'),
(8, 'https://umchealthcare.000webhostapp.com/img/doctors/8.jpg', 'Emily Davis', 'Attending Doctor', 4.9, 'Dr. Emily Davis is an attending physician who oversees patient care in a hospital setting.', '1987-01-09 00:00:00', 36, 'female'),
(9, 'https://umchealthcare.000webhostapp.com/img/doctors/9.jpg', 'Ryan Kim', 'Duty Doctor', 4.1, 'Dr. Ryan Kim is a dedicated duty doctor who provides medical care to patients in emergency and urgent care settings.', '1995-08-13 00:00:00', 28, 'male'),
(10, 'https://umchealthcare.000webhostapp.com/img/doctors/10.jpg', 'Jessica Brown', 'Family Doctor', 4.4, 'Dr. Jessica Brown is a board-certified family medicine physician who provides comprehensive care to patients of all ages.', '1980-03-27 00:00:00', 43, 'female');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `id` int(11) NOT NULL,
  `img` text NOT NULL,
  `name` varchar(45) NOT NULL,
  `stock` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `dosage` varchar(45) NOT NULL,
  `min_age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`id`, `img`, `name`, `stock`, `price`, `description`, `dosage`, `min_age`) VALUES
(1, 'https://umchealthcare.000webhostapp.com/img/medicines/1.jpg', 'Paracetamol', 500, 20000, 'Paracetamol is a pain reliever and fever reducer commonly used to treat headaches, muscle aches, and fever.', 'Take 2 tablets every 6 hours', 12),
(2, 'https://umchealthcare.000webhostapp.com/img/medicines/2.jpg', 'Amoxicillin', 250, 40000, 'Amoxicillin is an antibiotic used to treat a variety of bacterial infections, such as strep throat, pneumonia, and ear infections.', 'Take 1 capsule every 8 hours', 18),
(3, 'https://umchealthcare.000webhostapp.com/img/medicines/3.jpg', 'Omeprazole', 100, 150000, 'Omeprazole is a proton pump inhibitor used to reduce the amount of acid produced in the stomach, and is commonly used to treat acid reflux and ulcers.', 'Take 1 capsule every morning', 18),
(4, 'https://umchealthcare.000webhostapp.com/img/medicines/4.jpg', 'Aspirin', 200, 12000, 'Aspirin is a nonsteroidal anti-inflammatory drug (NSAID) used to reduce pain, fever, and inflammation. It is commonly used to treat headaches, toothaches, and menstrual cramps.', 'Take 1 tablet every 4 hours', 18),
(5, 'https://umchealthcare.000webhostapp.com/img/medicines/5.jpg', 'Ibuprofen', 300, 25000, 'Ibuprofen is an NSAID used to relieve pain, fever, and inflammation. It is commonly used to treat headaches, menstrual cramps, and arthritis.', 'Take 1 tablet every 6 hours', 18),
(6, 'https://umchealthcare.000webhostapp.com/img/medicines/6.jpg', 'Diazepam', 50, 50000, 'Diazepam is a benzodiazepine used to treat anxiety, muscle spasms, and seizures. It is also used as a sedative before medical procedures.', 'Take 1 tablet as needed for anxiety', 18),
(7, 'https://umchealthcare.000webhostapp.com/img/medicines/7.jpg', 'Atorvastatin', 150, 300000, 'Atorvastatin is a statin medication used to lower cholesterol and prevent heart disease. It is commonly prescribed to patients with high cholesterol levels.', 'Take 1 tablet every night', 18),
(8, 'https://umchealthcare.000webhostapp.com/img/medicines/8.jpg', 'Metformin', 100, 35000, 'Metformin is an oral medication used to treat type 2 diabetes. It helps lower blood sugar levels and improve insulin sensitivity.', 'Take 1 tablet every morning and night with me', 18),
(9, 'https://umchealthcare.000webhostapp.com/img/medicines/9.jpg', 'Lisinopril', 75, 80000, 'Lisinopril is an ACE inhibitor used to treat high blood pressure and heart failure. It works by relaxing blood vessels and improving blood flow.', 'Take 1 tablet every morning', 18),
(10, 'https://umchealthcare.000webhostapp.com/img/medicines/10.jpg', 'Cetirizine', 200, 10000, 'Cetirizine is an antihistamine used to treat allergies, such as hay fever and hives. It works by blocking the effects of histamine, which can cause itching and sneezing.', 'Take 1 tablet every 24 hours', 12);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `day` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `doctor_id`, `day`, `time`) VALUES
(1, 1, 'Monday', '09.00-13.00'),
(2, 1, 'Wednesday', '14.00-18.00'),
(3, 1, 'Thursday', '08.00-12.00'),
(4, 1, 'Saturday', '10.00-14.00'),
(5, 2, 'Tuesday', '09.00-13.00'),
(6, 2, 'Wednesday', '14.00-18.00'),
(7, 2, 'Thursday', '08.00-12.00'),
(8, 2, 'Friday', '10.00-14.00'),
(9, 2, 'Saturday', '16.00-20.00'),
(10, 3, 'Monday', '08.00-12.00'),
(11, 3, 'Tuesday', '13.00-17.00'),
(12, 3, 'Wednesday', '09.00-13.00'),
(13, 3, 'Friday', '08.00-12.00'),
(14, 3, 'Saturday', '14.00-18.00'),
(15, 4, 'Monday', '14.00-18.00'),
(16, 4, 'Tuesday', '08.00-12.00'),
(17, 4, 'Thursday', '09.00-13.00'),
(18, 4, 'Saturday', '10.00-14.00'),
(19, 5, 'Tuesday', '10.00-14.00'),
(20, 5, 'Wednesday', '16.00-20.00'),
(21, 5, 'Thursday', '08.00-12.00'),
(22, 5, 'Friday', '13.00-17.00'),
(23, 5, 'Saturday', '09.00-13.00'),
(24, 6, 'Monday', '13.00-17.00'),
(25, 6, 'Tuesday', '08.00-12.00'),
(26, 6, 'Wednesday', '09.00-13.00'),
(27, 6, 'Thursday', '14.00-18.00'),
(28, 6, 'Friday', '10.00-14.00'),
(29, 6, 'Saturday', '08.00-12.00'),
(30, 7, 'Monday', '14.00-18.00'),
(31, 7, 'Wednesday', '08.00-12.00'),
(32, 7, 'Thursday', '13.00-17.00'),
(33, 7, 'Friday', '09.00-13.00'),
(34, 7, 'Saturday', '10.00-14.00'),
(35, 8, 'Tuesday', '13.00-17.00'),
(36, 8, 'Wednesday', '08.00-12.00'),
(37, 8, 'Thursday', '09.00-13.00'),
(38, 8, 'Friday', '14.00-18.00'),
(39, 8, 'Saturday', '10.00-14.00'),
(40, 9, 'Monday', '08.00-12.00'),
(41, 9, 'Tuesday', '14.00-18.00'),
(42, 9, 'Wednesday', '10.00-14.00'),
(43, 9, 'Thursday', '13.00-17.00'),
(44, 9, 'Friday', '09.00-13.00'),
(45, 9, 'Saturday', '08.00-12.00'),
(46, 10, 'Monday', '14.00-18.00'),
(47, 10, 'Wednesday', '08.00-12.00'),
(48, 10, 'Thursday', '13.00-17.00'),
(49, 10, 'Friday', '09.00-13.00'),
(50, 10, 'Saturday', '10.00-14.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`,`doctor_id`),
  ADD KEY `fk_schedule_doctors_idx` (`doctor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `fk_schedule_doctors` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
