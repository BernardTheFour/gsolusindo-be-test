package com.betest.gsolusindo.services;

import org.springframework.stereotype.Service;

import com.betest.gsolusindo.dtos.ConsumtionDto;
import com.betest.gsolusindo.models.Consumtion;
import com.betest.gsolusindo.repositories.ConsumtionRepository;

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
                dto.maxPrice(),
                dto.createdAt(),
                null);

        return consumtionRepository.save(consumtion);
    }
}
