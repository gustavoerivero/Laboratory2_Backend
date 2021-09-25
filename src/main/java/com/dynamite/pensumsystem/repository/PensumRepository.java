package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Pensum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensumRepository extends JpaRepository<Pensum, Integer> {
    public Pensum findPensumByCodigo(String codigo);
}
