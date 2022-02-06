package com.ekampus.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Jurusan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurusan", nullable = false)
    private Integer id;
    private String namaJurusan;

    @ManyToOne()
    @JsonIgnoreProperties({"jurusans"})
    @JoinColumn(name = "id_fakultas", nullable = false)
    private Fakultas fakultas;

    @OneToMany(mappedBy = "jurusan")
    @JsonIgnore
    private List<Mahasiswa> mahasiswas;


}
