/*markdown
# Create database
*/

DROP DATABASE IF EXISTS `INVENTORY_SUBSYSTEM`;
CREATE DATABASE `INVENTORY_SUBSYSTEM`;
USE `INVENTORY_SUBSYSTEM`;

/*markdown
# Create tables
*/

CREATE TABLE `categories` (
  `category_id` INT,
  `category_name` VARCHAR(32),
  PRIMARY KEY (`category_id`)
);
CREATE TABLE `suppliers` (
  `supplier_id` INT,
  `supplier_name` VARCHAR(32),
  `phone` VARCHAR (32),
  `email` VARCHAR (64),
  PRIMARY KEY (`supplier_id`)
);
CREATE TABLE `locations`  (
  `location_id` INT,
  `location_name` VARCHAR(32),
  PRIMARY KEY (`location_id`)
);
CREATE TABLE `product_items` (
  `product_id` INT,
  `product_name` VARCHAR(32),
  `category_id_FK` INT,
  `supplier_id_FK` INT,
  `description` VARCHAR(128),
  FOREIGN KEY (`supplier_id_FK`) REFERENCES `suppliers`(`supplier_id`),
  FOREIGN KEY (`category_id_FK`) REFERENCES `categories`(`category_id`),
  PRIMARY KEY (`product_id`)
);
CREATE TABLE `inventory_items` (
  `product_id_FK` INT,
  `inventory_id` INT,
  `price` FLOAT(2),
  `amount_in_stock` INT,
  `size` INT,
  `color` VARCHAR(16),
  `reciept_date` DATE,
  `expiration_date` DATE,
  `location_id_FK` INT,
  FOREIGN KEY (`product_id_FK`) REFERENCES `product_items`(`product_id`),
  FOREIGN KEY (`location_id_FK`) REFERENCES `locations`(`location_id`),
  PRIMARY KEY (`product_id_FK`, `inventory_id`)
);

/*markdown
# Adding in some dummy data
*/

INSERT INTO `categories` VALUES
   (1, "Clothing"),
   (2, "Household Supply"),
   (3, "Furnishing"),
   (4, "Kitchenware"),
   (5, "Perishable Consumable"),
   (6, "Non-Perishable Consumable");
INSERT INTO `suppliers` VALUES
   (1, "Garry's Drip", "909-5617-8493", "garrydrippin@garry-drip.com"),
   (2, "Larry's Drip", "909-5617-8492", "larrywasfirst@larry-drip.com"),
   (3, "JellyWare", "739-4559-5002", "jellyware@jellyjelly.com"),
   (4, "Sussy Blades", "348-3501-0897", "sharpandsus@bossimposter.com"),
   (5, "Chef Pougaire", "528-0798-9759", "pougaire@poggers.com"),
   (6, "Mogus and Co.", "416-9695-7697", "mogusandco@mogobros.com"),
   (7, "Pepe's Farm", "500-7436-7464", "pepefarm@froggers.com"),
   (8, "MOGOSMINTED", "565-0799-9324", "mogosminted@hitpopvidgame.com");
INSERT INTO `locations` VALUES
   (00, "Default"),
   (01, "Back room, Isle 1"),
   (02, "Back room, Isle 2"),
   (03, "Back room, Isle 3"),
   (04, "Back room, Isle 4"),
   (05, "Back room, Isle 5"),
   (11, "Store, Isle 1"),
   (12, "Store, Isle 2"),
   (13, "Store, Isle 3"),
   (14, "Store, Isle 4"),
   (15, "Store, Isle 5");

/*markdown
# Dummy-dummy data (remove this when we actually make the adding items part work)
*/


INSERT INTO `product_items` VALUES
   (1, "Running Shoes", 1, 2, "Features cooling meshes and shock-absorbing soles. High drip factor."),
   (2, "SUPREME Jacket", 1, 1, "Polymer lining."),
   (3, "Among Us™ t-shirt", 1, 1, "A t-shirt featuring characters from the hit popular video game Among Us™."),
   (4, "Among Us™ sports drink", 5, 8, "E-sport gamer refreshment."),
   (5, "Cat chair", 3, 6, "A small sofa that resembles a cat.");
INSERT INTO `inventory_items` VALUES
   (1, 1, 25.00, 3, "Red", "2022-11-11", NULL, 14),
   (1, 2, 26.00, 2, "Pink", "2022-11-11", NULL, 14),

   (2, 1, 124.99, 1, "Black", "2022-10-24", NULL, 13),

   (3, 1, 12.99, 6, "White", "2022-9-12", NULL, 13),
   (3, 2, 12.99, 4, "Black", "2022-9-12", NULL, 13),
   (3, 3, 12.99, 3, "Rainbow", "2022-9-12", NULL, 13),

   (4, 1, 7.99, 12, NULL, "2022-11-18", "2022-12-21", 11),

   (5, 1, 55.00, 1, NULL, "2022-8-10", NULL, 05);

/*markdown
# Show tables
*/

SELECT * FROM `product_items`;
SELECT * FROM `inventory_items`;
SELECT * FROM `suppliers`;
SELECT * FROM `categories`;
SELECT * FROM `locations`;

