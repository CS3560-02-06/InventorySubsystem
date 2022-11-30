USE `INVENTORY_SUBSYSTEM`;

SELECT * FROM `product_items`;
UPDATE product_items SET product_name = "AMONG US" WHERE `product_id`=1;
SELECT * FROM `product_items`;