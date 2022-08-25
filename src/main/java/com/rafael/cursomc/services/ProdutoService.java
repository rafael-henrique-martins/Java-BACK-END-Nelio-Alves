package com.rafael.cursomc.services;

import com.rafael.cursomc.domain.Cliente;
import com.rafael.cursomc.domain.Produto;
import com.rafael.cursomc.repositories.ProdutoRepository;
import com.rafael.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;


    public Produto find(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id +
                ", Tipo: " + Cliente.class.getName()));
    }

    public Produto insert(Produto obj){
        obj.setId(null);
        return repo.save(obj);
    }
}