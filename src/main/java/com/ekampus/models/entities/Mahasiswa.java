package com.ekampus.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mahasiswa", nullable = false)
    private Integer id;
    private String nim;
    private String namaMahasiswa;
    private String jenisKelamin;
    private String noHp;
    private String email;
    private String alamat;

    @ManyToOne()
    @JsonIgnoreProperties({"mahasiswas", "fakultas"})
    @JoinColumn(name = "id_jurusan", nullable = false)
    private Jurusan jurusan;
}
