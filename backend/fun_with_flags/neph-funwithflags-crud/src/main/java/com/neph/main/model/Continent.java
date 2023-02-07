package com.neph.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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