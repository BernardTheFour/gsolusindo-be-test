package com.betest.gsolusindo.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.betest.gsolusindo.dtos.ConsumtionDto;
import com.betest.gsolusindo.models.Consumtion;
import com.betest.gsolusindo.repositories.ConsumtionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsumtionService {

    private final ConsumtionRepository consumtionRepository;

    public ConsumtionService(ConsumtionRepository consumtionRepository) {
        this.consumtionRepository = consumtionRepository;
    }

    public Consumtion saveConsumtion(ConsumtionDto dto) {
        Consumtion consumtion = new Consumtion(
                dto.id(),
                dto.name(),
                dto.max_price(),
                dto.created_at(),
                null);

        return consumtionRepository.save(consumtion);
    }

    public Consumtion getById(UUID id) {
        Consumtion consumtion = consumtionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consumtion not found"));

        return consumtion;
    }

    public Consumtion getByName(String name) {
        Consumtion consumtion = consumtionRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Consumtion not found"));

        return consumtion;
    }
}
