-- product
insert into inventory.product (title, category, manufacturer, minLimit)
values ('Canned Beans', 'Canned Goods', 'Franks', 8),
       ('Mango', 'Fruit', 'Tropic', 12),
       ('Lucky Jacks', 'Cereal', 'Millers', 4);

-- stocks

insert into inventory.productStock (productId, vendor, batchCode, invoiceNumber, quantity, transactionType) 
values (1, 'Tim Warehouse', 'ABC123', 'AUG101', 10, 'IN'),
       (2, 'Tim Warehouse', 'ABC123', 'AUG102', 10, 'IN'),
       (3, 'Tim Warehouse', 'ABC123', 'AUG103', 2, 'IN');

-- test queries

SELECT * FROM inventory.product;
SELECT * FROM inventory.productStock;

-- joins
SELECT * FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id;
SELECT * FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity;
SELECT p.title, (ps.quantity - p.minlimit) AS demand FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity;