package com.example.PersonalFinanceApi.mappers;

import org.mapstruct.Mapper;


public interface Cover<Entity,Dto,CardDto> {
    Entity toEntity(Dto item);
    Dto toDto(Entity item);
    CardDto toCardDto(Entity item);


}
