package com.example.ecardorder.service.impl;


import com.example.ecardorder.dto.CardDto;
import com.example.ecardorder.dto.CreateCardDto;
import com.example.ecardorder.dto.UpdateCardDto;
import com.example.ecardorder.entity.CardEntity;
import com.example.ecardorder.exception.CardNotFoundException;
import com.example.ecardorder.mapper.CardMapper;
import com.example.ecardorder.repository.CardRepository;
import com.example.ecardorder.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardDto createCard(CreateCardDto createCardDto) {
        log.info("Creating a new card: {}", createCardDto);

        CardEntity cardEntity = cardMapper.toCardEntity(createCardDto);
        CardEntity savedCard = cardRepository.save(cardEntity);

        return cardMapper.toCardDto(savedCard);
    }

    @Override
    public CardDto updateCard(Long id, UpdateCardDto updateCardDto) {
        log.info("Updating card with ID: {}", id);

        CardEntity cardEntity = cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException("Card not found: " + id));

        cardMapper.toCardEntity(updateCardDto, cardEntity);
        CardEntity updatedCard = cardRepository.save(cardEntity);

        return cardMapper.toCardDto(updatedCard);
    }

    @Override
    public List<CardDto> getCardList() {
        log.info("Fetching all cards");
        return cardRepository.findAll()
                .stream()
                .map(cardMapper::toCardDto)
                .toList();
    }

    @Override
    public CardDto getCardById(Long id) {
        log.info("Fetching card with ID: {}", id);

        CardEntity cardEntity = cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException("Card not found: " + id));

        return cardMapper.toCardDto(cardEntity);
    }
}

