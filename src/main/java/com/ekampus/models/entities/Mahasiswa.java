package com.ekampus.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mahasiswa", nullable = false)
    private Long id;
    private String nim;
    private String namaMahasiswa;
    private String jurusan;
    private String jenisKelamin;
    private String noHp;
    private String email;
    private String alamat;
}
