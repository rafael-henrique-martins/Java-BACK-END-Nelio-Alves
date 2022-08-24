package com.rafael.cursomc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lagradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;


    @OneToMany(mappedBy= "enderecos")
    private Cliente cliente;

    @OneToOne
    private Cidade cidade;
}
