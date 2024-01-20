ALTER TABLE product
    ADD inventory_count INT NULL;

ALTER TABLE product
    MODIFY inventory_count INT NOT NULL;