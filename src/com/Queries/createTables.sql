CREATE TABLE `categories` (`category_id` INT, `category_name` VARCHAR(32), PRIMARY KEY (`category_id`))
CREATE TABLE `suppliers` (`supplier_id` INT, `supplier_name` VARCHAR(32), `phone` VARCHAR (32), `email` VARCHAR (64), PRIMARY KEY (`supplier_id`))
CREATE TABLE `locations`  (`location_id` INT, `location_name` VARCHAR(32), PRIMARY KEY (`location_id`))
CREATE TABLE `product_items` (`product_id` INT, `product_name` VARCHAR(32), `category_id_FK` INT, `supplier_id_FK` INT, `description` VARCHAR(128), FOREIGN KEY (`supplier_id_FK`) REFERENCES `suppliers`(`supplier_id`), FOREIGN KEY (`category_id_FK`) REFERENCES `categories`(`category_id`), PRIMARY KEY (`product_id`))
CREATE TABLE `inventory_items` (`product_id_FK` INT, `inventory_id` INT, `price` FLOAT(2), `amount_in_stock` INT, `size` INT, `color` VARCHAR(16), `reciept_date` DATE, `expiration_date` DATE, `location_id_FK` INT, FOREIGN KEY (`product_id_FK`) REFERENCES `product_items`(`product_id`), FOREIGN KEY (`location_id_FK`) REFERENCES `locations`(`location_id`), PRIMARY KEY (`product_id_FK`, `inventory_id`))