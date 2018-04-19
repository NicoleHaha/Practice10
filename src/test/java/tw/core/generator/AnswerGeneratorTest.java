package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator answerGenerator;

//    @Before
//    private void setup(){
//
//    }
    @Test
    public void should_generate_answer() throws OutOfRangeAnswerException {
        Answer answer = new Answer();
        String[] array = new String[]{"1","3","4","9"};
        List<String> numList = Arrays.asList(array);
        answer.setNumList(numList);

        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 3 4 9");

        answerGenerator = new AnswerGenerator(randomIntGenerator);

        assertThat(answerGenerator.generate().getNumList()).isEqualTo(answer.getNumList());

    }
}

