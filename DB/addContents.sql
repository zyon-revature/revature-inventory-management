-- product
insert into inventory.product (title, category, manufacturer, minLimit)
values ('Logitech MX Keys', 'Electronics', 'Logitech', 8),
       ('Logitech Master 3','Electronics', 'Logitech', 8),
       ('Purple Pillow', 'Furniture', 'Purple', 12),
       ('Nintendo Switch', 'Electronics', 'Nintendo', 10);

-- stocks

insert into inventory.productStock (productId, vendor, batchCode, invoiceNumber, quantity, transactionType)
values
       (1, 'Tim Warehouse', 'ABC123', 'AUG101', 10, 'IN'),
       (2, 'Tim Warehouse', 'ABC123', 'AUG102', 10, 'IN'),
       (3, 'Tim Warehouse', 'ABC123', 'AUG103', 2, 'IN'),
       (4, 'JP Imports', 'NS5507', 'SEPT02', 4, 'IN');

-- test queries

SELECT * FROM inventory.product;
SELECT * FROM inventory.productStock;

-- joins
SELECT * FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id;
SELECT * FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity;
SELECT p.title, (p.minlimit - ps.quantity) AS demand FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity ORDER BY title ASC ;