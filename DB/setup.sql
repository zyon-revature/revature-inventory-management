-- REQUIRED
-- product
-- product_stock

-- Run if not created
-- CREATE USER groupc WITH PASSWORD 'postgres';
-- CREATE ROLE readwrite;
-- GRANT readwrite TO  groupc;

GRANT USAGE, CREATE ON SCHEMA inventory TO readwrite;
GRANT ALL ON TABLE inventory.product TO readwrite;
GRANT ALL ON TABLE inventory.productStock TO readwrite;





CREATE TABLE inventory.product(
    id SERIAL,
    title VARCHAR(40) UNIQUE,
    category VARCHAR(20),
    manufacturer VARCHAR(20) NOT NULL,
    minLimit int8,
    PRIMARY KEY (id)
);

CREATE TABLE inventory.productStock(
    id SERIAL,
    productId int8,
    transactionDate DATE NOT NULL DEFAULT CURRENT_DATE,
    vendor VARCHAR(40) NOT NULL,
    batchCode VARCHAR(10),
    invoiceNumber VARCHAR(10),
    quantity int4 NOT NULL,
    transactionType VARCHAR(3),
    PRIMARY KEY (id),
    CONSTRAINT product_fk FOREIGN KEY (productId) REFERENCES inventory.product(id)
);