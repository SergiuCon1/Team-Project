package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

    @Test
    public void shouldGetBestPlayerWithSeveralGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game gameTwo = store.publishGame("Нетология Баттл Онлайн.Второй версии", "Приключения");

        Player playerOne = new Player("Petya");
        Player playerTwo = new Player("Vasya");
        playerOne.installGame(game);
        playerTwo.installGame(game);
        playerOne.installGame(gameTwo);
        playerTwo.installGame(gameTwo);

        playerOne.play(game, 4);
        playerTwo.play(game, 5);
        playerOne.play(gameTwo, 2);
        playerTwo.play(gameTwo, 2);

        String expected = playerTwo.getName();
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetBestPlayerTest() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player playerOne = new Player("Petya");
        Player playerTwo = new Player("Vasya");
        playerOne.installGame(game);
        playerTwo.installGame(game);

        playerOne.play(game, 4);
        playerOne.play(game, 4);
        playerTwo.play(game, 5);
        playerTwo.play(game, 2);

        String expected = playerOne.getName();
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNullWhenPlayersNotFound() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumTimeOfAllPlayers() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game gameTwo = store.publishGame("Нетология Баттл Онлайн.Второй версии", "Приключения");

        Player playerOne = new Player("Petya");
        Player playerTwo = new Player("Vasya");
        playerOne.installGame(game);
        playerTwo.installGame(game);
        playerOne.installGame(gameTwo);
        playerTwo.installGame(gameTwo);

        playerOne.play(game, 4);
        playerTwo.play(game, 5);
        playerOne.play(game, 2);
        playerTwo.play(gameTwo, 2);

        int expected = 13;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

}
