package com.neph.main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "continent_name", nullable = false)
    private String continentName;

    @Column(name = "abbreviation", nullable = false, length = 10)
    private String abbreviation;

}