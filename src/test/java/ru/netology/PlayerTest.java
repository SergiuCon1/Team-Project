package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты


    @Test
    public void shouldSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("GTA", "action");
        Game game1 = store.publishGame("GTA Vice City", "action");
        Game game2 = store.publishGame("NFS", "Гонки");

        Player player = new Player("Max");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 5);
        player.play(game1, 4);
        player.play(game2, 3);

        int expected = 9;
        int actual = player.sumGenre("action");
        assertEquals(expected, actual);
    }


    @Test
    public void shouldMostTimePlayerToGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("GTA", "action");
        Game game1 = store.publishGame("GTA Vice City", "action");
        Game game2 = store.publishGame("NFS", "Гонки");

        Player player = new Player("Max");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 5);
        player.play(game1, 4);
        player.play(game2, 3);

        Game expected = game;
        Game actual = player.mostPlayerByGenre("action");
        assertEquals(expected, actual);
    }
}
