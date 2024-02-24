# Delivery microservice

---

## Instructions
- create an account on graphhopper.
- get an api key.
- create a file in resources folder named `secrets.properties`.
- add the following:
  - `graphhopper.api.key=your_api_key`
  - `store.location=store_location`
    - use `" "` for strings with multiple spaces. 

## Database

```mysql

CREATE DATABASE delivery;

CREATE TABLE delivery
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    user_id  INT  NOT NULL,
    address  VARCHAR(255),
    datetime DATE NOT NULL,
    status   VARCHAR(10)
);

CREATE TABLE item
(
  id          INT PRIMARY KEY AUTO_INCREMENT,
  oid         INT,
  itemid      INT,
  name        VARCHAR(255),
  price       FLOAT,

  FOREIGN KEY (oid) REFERENCES delivery (id)

);
)
```