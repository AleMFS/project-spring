package com.example.projetospring.resource;

import com.example.projetospring.model.Cachorro;
import com.example.projetospring.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CachorroResource {
    @Autowired
    private CachorroRepository repository;
    @PostMapping("/cachorros")
    public ResponseEntity<Cachorro> adicionarCachorro(@RequestBody Cachorro cachorro){
        repository.save(cachorro);
        System.out.println("Cachorro Adicionado!" );
        return new ResponseEntity<Cachorro>(HttpStatus.CREATED);
    }
    @GetMapping("/cachorros")
    public List<Cachorro> getTodos(){
        return repository.findAll();
    }

    @GetMapping("/cachorros/{id}")
    public Object getUnico(@PathVariable(value = "id")int id){
        return repository.findById(id);

    }

    @PutMapping("/cachorros/{id}")
    public ResponseEntity<Cachorro> updateCachorro(@PathVariable(value = "id") Integer id, @RequestBody Cachorro cachorro) {
        Optional<Cachorro> cachorroExistente = repository.findById(id);

        if (cachorroExistente.isPresent()) {
            Cachorro cachorroAtualizado = cachorroExistente.get();
            cachorroAtualizado.setNome(cachorro.getNome());
            cachorroAtualizado.setCor(cachorro.getCor());
            cachorroAtualizado.setIdade(cachorro.getIdade());

            repository.save(cachorroAtualizado);

            System.out.println("Cachorro atualizado com sucesso!");
        }
        return new ResponseEntity<Cachorro>(HttpStatus.OK);
    }

    @DeleteMapping("/cachorros/{id}")
    public ResponseEntity<Cachorro> deleteCachorro(@PathVariable(value = "id") int id) {
        Optional<Cachorro> cachorroExistente = repository.findById(id);

        if (cachorroExistente.isPresent()) {
            repository.delete(cachorroExistente.get());
            System.out.println("Cachorro excluído com sucesso!");
            return new ResponseEntity<Cachorro>(HttpStatus.OK);
        } else {
            System.out.println("Cachorro não encontrado!");
            return new ResponseEntity<Cachorro>(HttpStatus.NOT_FOUND);
        }
    }

}
