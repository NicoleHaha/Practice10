package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer;
    @Before
    public void setup(){
       answer = new Answer();
    }
    @Test
    public void should_get_answerlist_when_creatanswer(){
        String[] array = new String[]{"1","3","4","9"};
        List<String> answerList = Arrays.asList(array);

        String anwserstr = "1 3 4 9";
        this.answer = answer.createAnswer(anwserstr);

        assertThat(answer.getNumList()).isEqualTo(answerList);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = OutOfRangeAnswerException.class)
    public void  should_validate_when_input_numList() throws OutOfRangeAnswerException {
        String anwserstr = "1 3 3 11";
        this.answer = answer.createAnswer(anwserstr);
        answer.validate();
    }



    @Test
    public void should_get_record_after_check(){
        String anwserstr = "1 3 4 9";
        this.answer = answer.createAnswer(anwserstr);

        Record record = mock(Record.class);
        Answer inputAnwser = new Answer();
        String[] array = new String[]{"1","4","5","9"};
        List<String> inputList = Arrays.asList(array);
        inputAnwser.setNumList(inputList);
        int[] expected = new int[]{2,1};
        when(record.getValue()).thenReturn(expected);

        assertThat(answer.check(inputAnwser).getValue()).isEqualTo(expected);
    }
}