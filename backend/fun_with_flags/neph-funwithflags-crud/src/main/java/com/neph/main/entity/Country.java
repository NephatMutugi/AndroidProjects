package com.neph.main.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "country")
public class Country {

    public Country(String countryName, Continent continent){
        this.countryName = countryName;
        this.continent = continent;
    }
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "continent_id", nullable = false)
    @ToString.Exclude
    private Continent continent;

}