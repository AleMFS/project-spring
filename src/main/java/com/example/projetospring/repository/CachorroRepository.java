package com.example.projetospring.repository;

import com.example.projetospring.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro,Integer> {

}
