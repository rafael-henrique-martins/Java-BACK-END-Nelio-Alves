package com.rafael.cursomc.domain;

import com.rafael.cursomc.domain.enums.TipoCliente;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String cpfOuCnpj;

    private Integer tipo;  // TipoCliente

    @ManyToOne
    @JoinColumn(name= "endereco_id")
    private List<Endereco> enderecos = new ArrayList<>();

    private Set<String> telefones = new HashSet<>();

    public TipoCliente getTipo() throws IllegalAccessException {
        return TipoCliente.toEnum(tipo);
    }

    public TipoCliente setTipo(TipoCliente tipo){
        this.tipo = tipo.getCod();
    }
}
