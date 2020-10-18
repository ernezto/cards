package org.logmein.cards.web.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreatePlayerDto {
    @NotEmpty
    private String nickname;
}
