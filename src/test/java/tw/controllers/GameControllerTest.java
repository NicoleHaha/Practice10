package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private ByteArrayOutputStream outConent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outConent));
    }

    private String systemOut(){
        return outConent.toString();
    }
    @Test
    public void should_printMessageStartGame_when_beginGame() throws IOException {
        Game game = mock(Game.class);
        GameView gameView = new GameView();
        gameController = new GameController(game, gameView);

        gameController.beginGame();
        assertThat(systemOut())
                .isEqualTo("------Guess Number Game, You have 6 chances to guess!  ------\n");

    }

    @Test
    public void should_playGame_when_play() throws IOException{
        Game game = mock(Game.class);
        when(game.checkCoutinue()).thenReturn(Boolean.FALSE);
        when(game.checkStatus()).thenReturn("fail");

        GameView gameView = new GameView();

        InputCommand inputCommand = mock(InputCommand.class);

        gameController = new GameController(game,gameView);
        gameController.play(inputCommand);
        assertThat(systemOut())
                .isEqualTo("Game Status: fail\n");
    }
}