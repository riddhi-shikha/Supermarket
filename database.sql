-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.25 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for supermarketdb
DROP DATABASE IF EXISTS `supermarketdb`;
CREATE DATABASE IF NOT EXISTS `supermarketdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `supermarketdb`;

-- Dumping structure for table supermarketdb.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` int NOT NULL,
  `modified_on` datetime DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_name` (`cat_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table supermarketdb.category: ~18 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_id`, `cat_name`, `description`, `created_on`, `created_by`, `modified_on`, `modified_by`) VALUES
	(1001, 'Electronics', 'Eletronics Items like as Mobile, Television etc.', '2021-06-10 22:29:24', 101, '2021-06-23 23:24:10', 0),
	(1002, 'Milk and Dairy foods', 'cheeses, eggs, milk, yogurt, butter', '2021-06-11 01:56:55', 102, '2021-06-24 00:21:28', 102),
	(1003, 'Food', 'All Food Items', '2021-06-24 00:13:00', 102, NULL, NULL),
	(1004, 'Processed Foods', 'All kind of processed foods', '2021-06-24 00:14:44', 102, NULL, NULL),
	(1005, 'Beverages ', 'coffee/tea, juice, soda', '2021-06-24 00:15:21', 102, '2021-06-24 00:20:16', 102),
	(1006, 'Meat ', 'lunch meat, poultry, beef, pork', '2021-06-24 00:16:35', 102, '2021-06-24 00:22:41', 102),
	(1007, 'Fresh Produce', 'All kind of vegitables', '2021-06-24 00:17:09', 102, NULL, NULL),
	(1008, 'Spices ', 'All types of spices ', '2021-06-24 00:17:32', 102, NULL, NULL),
	(1009, 'The Dry Food Grocery', 'All types of Groceries', '2021-06-24 00:18:52', 102, NULL, NULL),
	(1010, 'Bread/Bakery ', 'sandwich loaves, dinner rolls, tortillas, bagels', '2021-06-24 00:20:01', 102, NULL, NULL),
	(1011, 'Canned/Jarred Goods', 'vegetables, spaghetti sauce, ketchup', '2021-06-24 00:20:50', 102, NULL, NULL),
	(1012, 'Dry/Baking Goods', 'cereals, flour, sugar, pasta, mixes', '2021-06-24 00:21:48', 102, NULL, NULL),
	(1013, 'Frozen Foods', 'waffles, vegetables, individual meals, ice cream', '2021-06-24 00:22:06', 102, NULL, NULL),
	(1014, 'Produce', 'fruits, vegetables', '2021-06-24 00:22:58', 102, NULL, NULL),
	(1015, 'Cleaners', 'all- purpose, laundry detergent, dishwashing liquid/detergent', '2021-06-24 00:23:21', 102, NULL, NULL),
	(1016, 'Paper Goods', 'paper towels, toilet paper, aluminum foil, sandwich bags', '2021-06-24 00:23:38', 102, NULL, NULL),
	(1017, 'Personal Care', 'shampoo, soap, hand soap, shaving cream', '2021-06-24 00:23:58', 102, NULL, NULL),
	(1018, 'Other', 'baby items, pet items, batteries, greeting cards', '2021-06-24 00:24:16', 102, NULL, NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table supermarketdb.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(50) NOT NULL,
  `manufacturer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quantity` int NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double NOT NULL,
  `discount` int NOT NULL DEFAULT '0',
  `gst` int NOT NULL DEFAULT '0',
  `cat_id` int NOT NULL,
  `subcat_id` int NOT NULL,
  `created_by` int DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `modified_by` int DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `FK_product_category` (`cat_id`),
  KEY `FK_product_subcategory` (`subcat_id`),
  KEY `FK_product_user` (`created_by`),
  KEY `FK_product_user_2` (`modified_by`),
  CONSTRAINT `FK_product_category` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`),
  CONSTRAINT `FK_product_subcategory` FOREIGN KEY (`subcat_id`) REFERENCES `subcategory` (`subcat_id`),
  CONSTRAINT `FK_product_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`u_id`),
  CONSTRAINT `FK_product_user_2` FOREIGN KEY (`modified_by`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='manufacturer';

-- Dumping data for table supermarketdb.product: ~2 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`prod_id`, `prod_name`, `manufacturer`, `quantity`, `description`, `price`, `discount`, `gst`, `cat_id`, `subcat_id`, `created_by`, `created_on`, `modified_by`, `modified_on`) VALUES
	(100001, 'Apple iPhone 12 Pro Max', 'Apple', 250, NULL, 134900, 0, 18, 1001, 10001, 101, '2021-06-17 20:54:07', NULL, NULL),
	(100002, 'Apple iphone 12 Pro', 'Apple', 234, '128 GB, Midnight Blue ', 124900, 10, 18, 1001, 10001, 102, '2021-06-18 20:07:17', 101, '2021-06-23 15:23:19'),
	(100003, 'Maggie', 'Nestle', 548, 'Nestle Maggie', 20, 0, 0, 1004, 10038, 106, '2021-06-24 13:18:50', NULL, NULL),
	(100004, 'Bread', 'Britania', 100, 'Britania', 40, 0, 0, 1004, 10028, 106, '2021-06-24 13:19:45', NULL, NULL),
	(100005, 'Pepsi Black', 'Pepsi', 120, 'Pepsi', 45, 0, 0, 1005, 10031, 106, '2021-06-24 13:21:53', NULL, NULL),
	(100006, 'Chicken', 'Fresho', 100, 'Fresho', 120, 0, 0, 1006, 10039, 106, '2021-06-24 13:23:00', NULL, NULL),
	(100007, 'Apple', 'Imported', 500, 'Imported Apple', 250, 0, 0, 1007, 10048, 106, '2021-06-24 13:25:09', NULL, NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table supermarketdb.subcategory
DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE IF NOT EXISTS `subcategory` (
  `subcat_id` int NOT NULL AUTO_INCREMENT,
  `subcat_name` varchar(50) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` int NOT NULL,
  `modified_on` datetime DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `cat_id` int NOT NULL,
  PRIMARY KEY (`subcat_id`),
  UNIQUE KEY `subcat_name` (`subcat_name`),
  KEY `FK_subcategory_user` (`created_by`),
  KEY `FK_subcategory_user_2` (`modified_by`),
  KEY `FK_subcategory_category` (`cat_id`),
  CONSTRAINT `FK_subcategory_category` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`),
  CONSTRAINT `FK_subcategory_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`u_id`),
  CONSTRAINT `FK_subcategory_user_2` FOREIGN KEY (`modified_by`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10068 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table supermarketdb.subcategory: ~61 rows (approximately)
DELETE FROM `subcategory`;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` (`subcat_id`, `subcat_name`, `description`, `created_on`, `created_by`, `modified_on`, `modified_by`, `cat_id`) VALUES
	(10001, 'Mobile Phone & Accessories', 'All types of mobile phone', '2021-06-12 01:06:04', 101, '2021-06-24 00:37:13', 106, 1001),
	(10002, 'LED, LCD, Smart TV', 'All Kind of Televisions', '2021-06-24 00:31:37', 102, '2021-06-24 00:36:31', 106, 1001),
	(10003, 'Home Theater', 'All Kind of Home Theater', '2021-06-24 00:32:15', 102, NULL, NULL, 1001),
	(10004, 'Freezers, Refrigerators & Chillers', 'Freezers, Refrigerators & Chillers', '2021-06-24 00:35:15', 106, NULL, NULL, 1001),
	(10005, 'Cleaning Machines & Equipments', 'Cleaning Machines & Equipments', '2021-06-24 00:35:32', 106, NULL, NULL, 1001),
	(10006, 'Light Bulb, Lamp & Lighting Fixtures', 'Light Bulb, Lamp & Lighting Fixtures', '2021-06-24 00:35:50', 106, NULL, NULL, 1001),
	(10007, 'Adaptors, Plugs & Sockets', 'Adaptors, Plugs & Sockets', '2021-06-24 00:36:08', 106, NULL, NULL, 1001),
	(10008, 'Domestic RO Water Purifier & Filters', 'Domestic RO Water Purifier & Filters', '2021-06-24 00:36:49', 106, NULL, NULL, 1001),
	(10009, 'Domestic Fans, AC & Coolers', 'Domestic Fans, AC & Coolers', '2021-06-24 00:37:41', 106, NULL, NULL, 1001),
	(10010, 'Heater, Thermostat & Heating Devices', 'Heater, Thermostat & Heating Devices', '2021-06-24 00:37:57', 106, NULL, NULL, 1001),
	(10011, 'Decorative Light, Lamp & Lamp Shades', 'Decorative Light, Lamp & Lamp Shades', '2021-06-24 00:38:33', 106, NULL, NULL, 1001),
	(10012, 'Home Appliances & Kitchen Appliances', 'Home Appliances & Kitchen Appliances', '2021-06-24 00:38:40', 106, NULL, NULL, 1001),
	(10013, 'Indoor Lights & Lighting Accessories', 'Indoor Lights & Lighting Accessories', '2021-06-24 00:38:59', 106, NULL, NULL, 1001),
	(10014, 'Butter', 'Butter and butter blends.', '2021-06-24 00:40:13', 106, NULL, NULL, 1002),
	(10015, 'Cheese', 'Natural and processed cheese products.', '2021-06-24 00:40:34', 106, NULL, NULL, 1002),
	(10016, 'Cultured Dairy', 'Yogurt, cottage cheese, sour cream, dips and other cultured dairy foods', '2021-06-24 00:40:53', 106, NULL, NULL, 1002),
	(10017, 'Frozen Desserts', 'Ice cream cakes other frozen desserts made with dairy ingredients.', '2021-06-24 00:41:20', 106, NULL, NULL, 1002),
	(10018, 'Ice Cream/Novelties', 'Ice cream, ice milk, novelties, sherbets, sorbets and frozen yogurt.', '2021-06-24 00:41:42', 106, NULL, NULL, 1002),
	(10019, 'Milk', 'Information on milk processing, milk processors and all types of fluid milk products – whole, skim, 2%, 1%, flavored, cream and half-and-half', '2021-06-24 00:42:34', 106, NULL, NULL, 1002),
	(10020, 'Non-Dairy Beverages', 'Juices, teas, coffees, waters, soy and other beverages without dairy ingredients', '2021-06-24 00:42:54', 106, NULL, NULL, 1002),
	(10021, 'Whey, Milk Powder', 'Whey protein concentrate, whey protein isolate, milk protein concentrate and other dairy ingredients', '2021-06-24 00:43:14', 106, NULL, NULL, 1002),
	(10022, 'Wheat Flour', 'Wheat', '2021-06-24 00:45:29', 106, NULL, NULL, 1003),
	(10023, 'Rice', 'All kind of Rice', '2021-06-24 00:45:46', 106, NULL, NULL, 1003),
	(10024, 'Pulses', 'All kinds of Pulses', '2021-06-24 00:46:06', 106, NULL, NULL, 1003),
	(10025, 'Cereal', 'cereal', '2021-06-24 00:48:33', 106, '2021-06-24 00:49:50', 106, 1004),
	(10026, 'Potato chips', 'potato chips', '2021-06-24 00:48:49', 106, '2021-06-24 00:49:44', 106, 1004),
	(10027, 'Cookies', 'cookies', '2021-06-24 00:49:00', 106, '2021-06-24 00:49:37', 106, 1004),
	(10028, 'Bread', 'Bread', '2021-06-24 00:49:27', 106, NULL, NULL, 1004),
	(10029, 'COKE', 'COKE', '2021-06-24 00:51:09', 106, NULL, NULL, 1005),
	(10030, 'FANTA', 'FANTA', '2021-06-24 00:51:29', 106, NULL, NULL, 1005),
	(10031, 'PEPSI', 'PEPSI', '2021-06-24 00:51:44', 106, NULL, NULL, 1005),
	(10032, 'DR. PEPPER', 'DR. PEPPER', '2021-06-24 00:51:57', 106, NULL, NULL, 1005),
	(10033, 'SEVEN UP', 'SEVEN UP', '2021-06-24 00:52:10', 106, NULL, NULL, 1005),
	(10034, 'RED BULL', 'RED BULL', '2021-06-24 00:52:24', 106, NULL, NULL, 1005),
	(10035, 'MONSTER', 'MONSTER', '2021-06-24 00:52:35', 106, NULL, NULL, 1005),
	(10036, 'GATORADE', 'GATORADE', '2021-06-24 00:52:46', 106, NULL, NULL, 1005),
	(10037, 'NESTLE', 'NESTLE', '2021-06-24 00:53:13', 106, NULL, NULL, 1005),
	(10038, 'Maggie', 'Maggie', '2021-06-24 00:53:31', 106, NULL, NULL, 1004),
	(10039, 'Chicken', 'Chicken', '2021-06-24 00:54:19', 106, NULL, NULL, 1006),
	(10040, 'Sea food', 'Sea food', '2021-06-24 00:54:31', 106, NULL, NULL, 1006),
	(10041, 'Eggs', 'Eggs', '2021-06-24 00:54:53', 106, NULL, NULL, 1006),
	(10042, 'Fish', 'Fish', '2021-06-24 00:55:05', 106, NULL, NULL, 1006),
	(10043, 'Lamb', 'Lamb', '2021-06-24 00:55:15', 106, NULL, NULL, 1006),
	(10044, 'Mutton ', 'Mutton ', '2021-06-24 00:55:48', 106, NULL, NULL, 1006),
	(10047, 'Vegetable', 'Vegetable', '2021-06-24 00:57:13', 106, NULL, NULL, 1007),
	(10048, 'Fruits', 'Fruits', '2021-06-24 00:57:48', 106, NULL, NULL, 1007),
	(10053, 'Bun', 'Bun', '2021-06-24 00:58:36', 106, NULL, NULL, 1010),
	(10054, 'Cake', 'Cake', '2021-06-24 00:59:00', 106, NULL, NULL, 1010),
	(10055, 'Floor Cleaner', 'Floor Cleaner', '2021-06-24 00:59:30', 106, NULL, NULL, 1015),
	(10056, 'Bathroom Cleaner', 'Bathroom Cleaner', '2021-06-24 00:59:50', 106, NULL, NULL, 1015),
	(10057, 'Kitchen Cleaner', 'Kitchen Cleaner', '2021-06-24 01:00:19', 106, NULL, NULL, 1015),
	(10058, 'Shampoo', 'Shampoo', '2021-06-24 01:00:32', 106, NULL, NULL, 1017),
	(10059, 'Shop', 'Shop', '2021-06-24 01:00:46', 106, NULL, NULL, 1017),
	(10060, 'Deo', 'Deo', '2021-06-24 01:01:03', 106, NULL, NULL, 1017),
	(10061, 'Comb', 'Comb', '2021-06-24 01:01:19', 106, NULL, NULL, 1017),
	(10062, 'Hair Oil', 'Hair Oil', '2021-06-24 01:01:32', 106, NULL, NULL, 1017),
	(10063, 'Hair Gel', 'Hair Gel', '2021-06-24 01:01:44', 106, NULL, NULL, 1017),
	(10064, 'Face Cream', 'Face Cream', '2021-06-24 01:02:06', 106, NULL, NULL, 1017),
	(10065, 'Dry Fruits', 'Dry Fruits', '2021-06-24 01:02:47', 106, NULL, NULL, 1012),
	(10066, 'Moph', 'Moph', '2021-06-24 01:06:22', 106, NULL, NULL, 1018),
	(10067, 'Broom', 'Broom', '2021-06-24 01:06:34', 106, NULL, NULL, 1018);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;

-- Dumping structure for table supermarketdb.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(1000) NOT NULL,
  `photo` varchar(1000) NOT NULL,
  `id_type` varchar(50) NOT NULL,
  `id_number` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` int NOT NULL,
  `modified_on` datetime DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table supermarketdb.user: ~5 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`u_id`, `name`, `user_id`, `role`, `password`, `gender`, `contact`, `dob`, `address`, `photo`, `id_type`, `id_number`, `created_on`, `created_by`, `modified_on`, `modified_by`) VALUES
	(101, 'Admin_1', 'nits101', 'Admin', '12345', 'Male', '9001900106 ', '1992-06-08', 'M P Nagar, Bhopal, MP, IN', 'E:/SupermarketJava/Supermarket/src/org/github/supermarket/profile/USER_101.png', 'Voter ID', 'MP2018CH2020', '2021-06-10 00:00:00', 101, '2021-06-24 12:56:21', 106),
	(102, 'Kumar Deepak', 'R2H0M3', 'Admin', '12345678', 'Male', '9595959595 ', '1993-11-16', 'Mumbai, MH, India', 'E:/SupermarketJava/Supermarket/src/org/github/supermarket/profile/USER_102.png', 'Driving Liecnse', 'DL209876XYZ', '2021-06-11 03:19:32', 101, '2021-06-24 00:10:40', 101),
	(103, 'Seller_2', 'QYZX9L', 'Seller', '12345', 'Female', '9009988888 ', '2016-10-04', 'Indore, MP, India', 'E:/SupermarketJava/Supermarket/src/org/github/supermarket/profile/USER_103.png', 'Aadhar Card', '234554321678', '2021-06-11 03:21:25', 102, '2021-06-24 00:07:24', 101),
	(104, 'Seller_1', 'SVZM3X', 'Seller', '123456', 'Female', '9875643210 ', '1990-01-31', 'Jabalpur, MP, India', 'E:/SupermarketJava/Supermarket/src/org/github/supermarket/profile/USER_104.png', 'Passport', '98765430982', '2021-06-15 18:08:12', 101, '2021-06-24 00:09:15', 101),
	(106, 'Riddhi Shikha', 'MM6E5D', 'Admin', '098765', 'Female', '9999999999 ', '1998-12-26', 'Bhopal, MP, India', 'E:/SupermarketJava/Supermarket/src/org/github/supermarket/profile/USER_105.png', 'Pan Card', 'AAAAA1010A', '2021-06-24 00:06:19', 101, NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
