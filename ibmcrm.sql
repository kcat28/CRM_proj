-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2024 at 04:04 PM
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
(1, 'John', 'A.', 'Doe', 'Acme Corp', '123-456-7890', 'john.doe@example.com', 'Regular', NULL),
(2, 'Jane', NULL, 'Smith', 'Beta Inc', '987-654-3210', 'jane.smith@beta.com', 'VIP', NULL),
(3, 'Mike', 'B.', 'Johnson', NULL, '555-666-7777', 'mike.johnson@example.com', 'Regular', NULL),
(4, 'Emily', 'C.', 'Davis', 'Gamma Ltd', '444-555-6666', NULL, 'New', NULL),
(5, 'Alice', NULL, 'Brown', NULL, '333-444-5555', 'alice.brown@example.com', 'VIP', NULL);

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
(1, 1, 'Great product, highly recommended!', 5),
(2, 2, 'Excellent service and fast delivery!', 4),
(3, 3, 'Product quality could be better.', 3),
(4, 4, 'Issues with functionality, needs improvement.', 2),
(5, 5, 'Fantastic experience overall!', 5);

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
(1, 'Laptop', '899.99'),
(2, 'Smartphone', '699.50'),
(3, 'Tablet', '299.99'),
(4, 'Headphones', '149.99'),
(5, 'Smartwatch', '199.99');

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
(1, 1, 1, '2024-05-15 10:30:00', '1 year', 1, '899.99'),
(2, 2, 2, '2024-05-15 11:45:00', '2 years', 2, '1399.00'),
(3, 3, 3, '2024-05-15 12:00:00', '6 months', 1, '299.99'),
(4, 4, 4, '2024-05-15 12:30:00', NULL, 1, '149.99'),
(5, 5, 5, '2024-05-15 13:00:00', '3 months', 1, '199.99');

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
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `product_id` (`product_id`);

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
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `purchase_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
