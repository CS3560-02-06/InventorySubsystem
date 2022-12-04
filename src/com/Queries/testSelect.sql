USE `INVENTORY_SUBSYSTEM`;
SELECT * FROM `inventory_items`;
UPDATE inventory_items SET product_id_fk = 1, inventory_id = 2, price = 1.0, amount_in_stock = 1, size = 3.5, color = 'RED', reciept_date = '1901-02-01', expiration_date 
= '1901-02-01', location_id_fk = 0 WHERE (`product_id_FK` = 1 AND `inventory_id` = 1);