package com.vi.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "user", schema = "aware_schema", catalog = "aware")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "register_date")
    private Date registerDate;
    @Column(name = "last_visit_date")
    private Date lastVisitDate;
    @Column(name = "level")
    private BigInteger level;
}
