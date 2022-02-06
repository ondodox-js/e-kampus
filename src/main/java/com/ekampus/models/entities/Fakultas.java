package com.ekampus.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor

public class Fakultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fakultas", nullable = false)
    private Integer id;

    @NotEmpty(message = "Nama fakultas wajib diisi!")
    private String namaFakultas;

    @OneToMany(mappedBy = "fakultas")
    @JsonIgnoreProperties({"fakultas"})
    private List<Jurusan> jurusans;
}
