package com.KonstantinZhee.ShortUrlService2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UrlInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "originalurl")
    private String originalUrl;
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;
}