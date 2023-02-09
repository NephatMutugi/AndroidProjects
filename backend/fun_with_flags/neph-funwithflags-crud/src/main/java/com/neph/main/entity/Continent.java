package com.neph.main.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "continent_name", nullable = false)
    private String continentName;

    @Column(name = "abbreviation", nullable = false, length = 10)
    private String abbreviation;

}