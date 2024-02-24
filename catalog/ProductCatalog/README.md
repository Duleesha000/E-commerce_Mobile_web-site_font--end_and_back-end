# ProductCatalog

---

Product product microservice for an e-commerce application

## Database

```mysql
create database productcatalog;
use productcatalog;

CREATE TABLE product
(
    id                 INT AUTO_INCREMENT,
    productname        VARCHAR(50) NOT NULL,
    Productdescription VARCHAR(255) NOT NULL,
    category           VARCHAR(10) NOT NULL,
    brand              VARCHAR(30) NOT NULL,
    price              double       NOT NULL,
    currency           VARCHAR(3) NOT NULL,
    weight             FLOAT          NOT NULL,
    dimension          VARCHAR(20) NOT NULL,
    stockquantity      INT          NOT NULL,
    imgurl            varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO product (productname, Productdescription, category, brand, price, currency, weight, dimension,
                     stockquantity, imgurl)
VALUES ('samsung j4', 'Description for Product 1', 'medium budget', 'samsung', 299.99, 'USD', 20, '10x5x3', 100,
        'image_url_1'),
       ('samsungMAX', 'Description for Product 2', 'high budget', 'samsung', 599.99, 'USD', 20, '10x5x3', 100,
        'image_url_2'),
       ('nokia', 'Description for Product 3', 'low budget', 'Nokia', 199.99, 'USD', 20, '10x5x3', 100,
        'image_url_3');
```
