package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
public class Game {
    private final String title;
    private final String genre;
    private final GameStore store;
}
