package com.betest.gsolusindo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.betest.gsolusindo.models.Consumtion;

@Repository
public interface ConsumtionRepository extends ListCrudRepository<Consumtion, UUID> {

    Optional<Consumtion> findByName(String name);
}
