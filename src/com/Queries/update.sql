USE `INVENTORY_SUBSYSTEM`;

--INSERT INTO `product_items` VALUES(1, "Running Shoes", 1, 2, "Features cooling meshes and shock-absorbing soles. High drip factor.");
SELECT * FROM `product_items`;
UPDATE product_items SET product_name = "AMONG US" WHERE `product_id`=1;
SHOW COLUMNS FROM `inventory_items`;
INSERT INTO `inventory_items` VALUES (1, 0, 1.0, 1, 3.5, 'Blue', '1901-02-01', '1901-02-01', 0);
SELECT * FROM `product_items`;