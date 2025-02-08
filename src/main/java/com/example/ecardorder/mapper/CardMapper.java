package com.example.ecardorder.mapper;


import com.example.ecardorder.dto.CardDto;
import com.example.ecardorder.dto.CreateCardDto;
import com.example.ecardorder.dto.UpdateCardDto;
import com.example.ecardorder.entity.CardEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface CardMapper {

    CardEntity toCardEntity(CreateCardDto createCardDto);

    CardDto toCardDto(CardEntity cardEntity);

    CardEntity toCardEntity(UpdateCardDto updateCardDto, @MappingTarget CardEntity cardEntity);

}
