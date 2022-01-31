package com.ekampus.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table
public class Jurusan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurusan", nullable = false)
    private Long id;
    private String namaJurusan;

    @ManyToOne
    private Fakultas fakultas;
}
