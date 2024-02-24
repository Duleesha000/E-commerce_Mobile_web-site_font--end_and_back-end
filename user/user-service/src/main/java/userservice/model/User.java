package userservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "user_tlb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @Column(name = "role", columnDefinition = "varchar(20) default 'USER'")
    private String role;

}
