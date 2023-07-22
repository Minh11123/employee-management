package com.vti.finalexamservice.config.sercurity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Token")
public class Token {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "token", length = 500)
    private String token;

    @Column(name = "ip")
    private String ip;

    @Column(name = "isBlackList")
    private boolean isBlackList;

    @Column(name = "refreshTime")
    private LocalDateTime refreshTime;

    @Column(name = "expiration")
    private LocalDateTime expiration;

    public Token(String token, String ip, boolean isBlackList, LocalDateTime refreshTime, LocalDateTime expiration) {
        this.token = token;
        this.ip = ip;
        this.isBlackList = isBlackList;
        this.refreshTime = refreshTime;
        this.expiration = expiration;
    }
}
