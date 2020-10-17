package org.logmein.cards.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FaceType {
    ACE(1, "ACE"),
    NUMBER_2(2, "2"),
    NUMBER_3(3, "3"),
    NUMBER_4(4, "4"),
    NUMBER_5(5, "5"),
    NUMBER_6(6, "6"),
    NUMBER_7(7, "7"),
    NUMBER_8(8, "8"),
    NUMBER_9(9, "9"),
    NUMBER_10(10, "10"),
    JACK(11, "JACK"),
    QUEEN(12, "QUEEN"),
    KING(13, "KING");

    @Getter
    private final int value;
    @Getter
    private final String name;

}
