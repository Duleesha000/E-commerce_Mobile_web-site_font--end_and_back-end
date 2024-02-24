# userservice authentication API microservice 

---

## TODO
- [x] Register functionality
- [x] Login functionality
- [ ] Validation on register & login
- [ ] Security context test
- [ ] JWT? 



## Database
```mysql
create database Users;
create table user_tlb
(
    id       int primary key auto_increment,
    name     varchar(40),
    email    varchar(50),
    password varchar(60),
    role    varchar(20) default 'USER'
);
```