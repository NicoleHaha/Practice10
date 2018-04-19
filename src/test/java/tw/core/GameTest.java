package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;
    @Before
    public void setup() throws OutOfRangeAnswerException{
        String[] array = new String[]{"1","4","5","9"};
        List<String> inputList = Arrays.asList(array);
        Answer answer = new Answer();
        answer.setNumList(inputList);

        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_get_guessResult_when_guess() throws OutOfRangeAnswerException {
        String[] array1 = new String[]{"1","4","5","9"};
        List<String> inputList1 = Arrays.asList(array1);
        Answer answer1 = new Answer();
        answer1.setNumList(inputList1);

        String[] array2 = new String[]{"1","5","4","3"};
        List<String> inputList2 = Arrays.asList(array2);
        Answer answer2 = new Answer();
        answer2.setNumList(inputList2);

        String result = "4A0B";
        String result2 = "1A2B";

        assertThat(game.guess(answer2).getResult()).isEqualTo(result2);
        assertThat(game.guess(answer1).getResult()).isEqualTo(result);

    }

    @Test
    public void shoult_get_guessHistory_when_ask() throws OutOfRangeAnswerException{
        String result = "4A0B";
        String result2 = "1A2B";

        String[] array1 = new String[]{"1","4","5","9"};
        List<String> inputList1 = Arrays.asList(array1);
        Answer answer1 = new Answer();
        answer1.setNumList(inputList1);

        String[] array2 = new String[]{"1","5","4","3"};
        List<String> inputList2 = Arrays.asList(array2);
        Answer answer2 = new Answer();
        answer2.setNumList(inputList2);

        game.guess(answer2);
        game.guess(answer1);

        assertThat(game.guessHistory().get(0).getResult()).isEqualTo(result2);
        assertThat(game.guessHistory().get(1).getResult()).isEqualTo(result);
    }

    @Test
    public void should_get_status_when_checkStatus(){
        String[] array1 = new String[]{"1","4","5","9"};
        List<String> inputList1 = Arrays.asList(array1);
        Answer answer1 = new Answer();
        answer1.setNumList(inputList1);

        String[] array2 = new String[]{"1","5","4","3"};
        List<String> inputList2 = Arrays.asList(array2);
        Answer answer2 = new Answer();
        answer2.setNumList(inputList2);

        game.guess(answer2);
        assertThat(game.checkStatus()).isEqualTo("continue");
        game.guess(answer1);
        assertThat(game.checkStatus()).isEqualTo("success");
    }
}
