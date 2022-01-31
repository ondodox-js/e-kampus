package com.ekampus.models.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang", nullable = false)
    private Long id;

    private String namaBarang;

    private Integer stokBarang;

    private Integer hargaBarang;
}
