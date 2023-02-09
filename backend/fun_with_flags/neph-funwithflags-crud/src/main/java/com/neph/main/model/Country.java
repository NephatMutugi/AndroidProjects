package com.neph.main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "country")
public class Country {
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