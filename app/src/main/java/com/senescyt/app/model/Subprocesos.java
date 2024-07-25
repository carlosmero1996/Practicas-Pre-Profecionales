package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Subprocesos")
public class Subprocesos /*departamento*/ implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;

    private String subNombre;

    @ManyToOne
    @JoinColumn(name = "procId", referencedColumnName = "procId")
    private Procesos procId;

    @JsonIgnore
    @OneToMany(mappedBy = "subId", cascade = CascadeType.ALL)
    private List<Asistencia> listaAsistencia;
}
