package com.example.ecardorder.service;



import com.example.ecardorder.dto.CardDto;
import com.example.ecardorder.dto.CreateCardDto;
import com.example.ecardorder.dto.UpdateCardDto;

import java.util.List;
/**
 * Card Service Interface
 *
 * @author Nihad Mirzazade
 *
 */
public interface CardService {
    CardDto createCard(CreateCardDto createCardDto);

    CardDto updateCard(Long id, UpdateCardDto updateCardDto);

    List<CardDto> getCardList();

    CardDto getCardById(Long id);

}

