package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.DeckEntity;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Deck;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Mapper(componentModel = "spring", uses = CardEntityMapper.class)
public interface DeckEntityMapper {

    @AfterMapping
    default void filterDecks(DeckEntity deckEntity, @MappingTarget Deck deck) {
        List<Card> filteredCards = deck.getCards().stream().filter(Card::isInDeck).collect(toList());
        deck.setCards(filteredCards);
    }

    Deck toDomain(DeckEntity entity);

    List<Deck> toDomain(List<DeckEntity> entities);

    @Mapping(target = "gameId", ignore = true)
    DeckEntity toData(Deck deck);

    List<DeckEntity> toData(List<Deck> decks);
}
