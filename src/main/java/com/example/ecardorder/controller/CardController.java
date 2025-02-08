package com.example.ecardorder.controller;



import com.example.ecardorder.dto.CardDto;
import com.example.ecardorder.dto.CreateCardDto;
import com.example.ecardorder.dto.UpdateCardDto;
import com.example.ecardorder.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@Valid @RequestBody CreateCardDto createCardDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.createCard(createCardDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CardDto> updateCard(@PathVariable Long id,
                                              @Valid @RequestBody UpdateCardDto updateCardDto) {
        return ResponseEntity.ok(cardService.updateCard(id, updateCardDto));
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getCardList() {
        List<CardDto> cards = cardService.getCardList();
        if (cards.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        Optional<CardDto> card = Optional.ofNullable(cardService.getCardById(id));
        return card.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // HTTP 404 qaytarır
    }
}
