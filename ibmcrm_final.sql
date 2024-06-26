-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2024 at 12:51 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ibmcrm`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `contact_number` varchar(100) NOT NULL,
  `contact_email` varchar(100) DEFAULT NULL,
  `customer_type` varchar(100) DEFAULT NULL,
  `customer_note` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `first_name`, `middle_name`, `last_name`, `company_name`, `contact_number`, `contact_email`, `customer_type`, `customer_note`) VALUES
(1, 'John', 'A.', 'Doe', 'Acme Corp', '123-456-7890', 'john.doe@example.com', 'Regular', 'Ongoing issue from product since 6/23/2024'),
(2, 'Jane', NULL, 'Smith', 'Beta Inc', '987-654-3210', 'jane.smith@beta.com', 'VIP', 'Follow up call on 6/27/2024'),
(3, 'Mike', 'B.', 'Johnson', NULL, '555-666-7777', 'mike.johnson@example.com', 'Regular', 'Resolved Ticket 6/24/2024'),
(4, 'Emily', 'C.', 'Davis', 'Gamma Ltd', '444-555-6666', NULL, 'New', 'New Customer @ 6/27/2024'),
(5, 'Alice', NULL, 'Brown', NULL, '333-444-5555', 'alice.brown@example.com', 'VIP', 'Pitch other products '),
(6, 'Robert', 'D.', 'Williams', 'Delta Corp', '222-333-4444', 'robert.williams@delta.com', 'Regular', 'Address raised issue'),
(7, 'Sophia', NULL, 'Martinez', 'Epsilon LLC', '111-222-3333', 'sophia.martinez@epsilon.com', 'VIP', 'Contact on friday @6/28/2024'),
(8, 'James', 'E.', 'Brown', 'Zeta Ltd', '666-777-8888', 'james.brown@zeta.com', 'New', 'New Customer @ 6/25/2024'),
(12, 'John Efren ', 'Viray', 'Gannaban', 'AlphaOmega', '09XXXXX', 'Jefjef2392@gmail.com', 'VIP', NULL),
(13, 'Diana Nicole', 'Diego', 'Danga', 'AlphaGoogle', '09XXXXXX', 'NicoleNaur@gg', 'bossq', ''),
(14, 'Jascent Pearl', 'G', 'Navarro', 'Alpha', '09XXXXXXX', 'JP@Alpha.com', 'VIP', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `customer_id` int(100) NOT NULL,
  `product_id` int(11) NOT NULL,
  `feedback_comment` text,
  `feedback_rating` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`customer_id`, `product_id`, `feedback_comment`, `feedback_rating`) VALUES
(1, 1, 'Great product, highly recommended!', 4),
(2, 2, 'Excellent service and fast delivery!', 4),
(3, 3, 'Product quality could be better.', 3),
(4, 4, 'Issues with functionality, needs improvement.', 2),
(5, 5, 'Fantastic experience overall!', 4),
(1, 2, 'test', 3),
(1, 4, 'Awful', 1),
(6, 1, 'Very satisfied with the product!', 4),
(7, 2, 'Good quality, will buy again.', 4),
(8, 3, 'Average product, nothing special.', 3),
(1, 3, 'Good value for the price.', 3),
(2, 4, 'Decent, but could be better.', 2),
(3, 5, 'Satisfied with the purchase.', 4),
(4, 1, 'It works as expected.', 3),
(5, 2, 'Happy with the purchase.', 4),
(6, 3, 'Needs improvement in quality.', 2),
(7, 4, 'Good product, fair price.', 3),
(8, 5, 'Excellent value for money.', 4),
(1, 5, 'Not what I expected.', 1),
(2, 1, 'It’s okay.', 3),
(3, 2, 'Very happy with the service.', 4),
(4, 3, 'Expected better.', 2),
(5, 4, 'Great product, will buy again.', 4);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`email`, `password`) VALUES
('admin@ibm.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `product_price`) VALUES
(1, 'IBM Security MaaS360', '4.00'),
(2, 'IBM Cloud Pak for Data', '6.00'),
(3, 'IBM Storage Defender', '8.00'),
(4, 'IBM Power Solution editions for healthcare', '10.00'),
(5, 'Storage Scale System', '9.00');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `purchase_id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `product_id` int(11) NOT NULL,
  `purchase_datetime` datetime NOT NULL,
  `purchase_servicelength` varchar(50) DEFAULT NULL,
  `purchase_quantity` int(11) NOT NULL,
  `purchase_total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`purchase_id`, `customer_id`, `product_id`, `purchase_datetime`, `purchase_servicelength`, `purchase_quantity`, `purchase_total`) VALUES
(1, 1, 1, '2024-05-15 10:30:00', '1 month', 1, '4.00'),
(2, 2, 2, '2024-05-15 11:45:00', '1 year', 2, '12.00'),
(3, 3, 3, '2024-05-15 12:00:00', '6 months', 1, '8.00'),
(4, 4, 4, '2024-05-15 12:30:00', '6 months', 1, '10.00'),
(5, 5, 5, '2024-05-15 13:00:00', '3 months', 1, '9.00'),
(6, 6, 1, '2024-05-16 09:15:00', '3 months', 2, '8.00'),
(7, 7, 2, '2024-05-16 10:20:00', '1 month', 1, '6.00'),
(8, 8, 3, '2024-05-16 11:30:00', '1 year', 3, '24.00'),
(12, 1, 2, '2024-05-17 09:05:00', '1 year', 2, '12.00'),
(13, 2, 3, '2024-05-17 10:15:00', '6 months', 1, '8.00'),
(14, 3, 4, '2024-05-17 11:25:00', '3 months', 1, '9.00'),
(15, 4, 5, '2024-05-17 12:35:00', '1 year', 1, '12.00'),
(16, 5, 1, '2024-05-17 13:45:00', '1 month', 1, '4.00'),
(17, 6, 2, '2024-05-18 08:15:00', '6 months', 2, '16.00'),
(18, 7, 3, '2024-05-18 09:20:00', '3 months', 1, '8.00'),
(19, 8, 4, '2024-05-18 10:30:00', '1 year', 2, '20.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD KEY `product_id` (`product_id`),
  ADD KEY `feedback_ibfk_1` (`customer_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`purchase_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `purchase_ibfk_1` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `purchase_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
