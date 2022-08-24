package com.rafael.cursomc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name= "estado_id")
    private Estado estado;
}
