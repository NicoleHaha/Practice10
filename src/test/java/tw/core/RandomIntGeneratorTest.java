package tw.core;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected =IllegalArgumentException.class)
    public void should_get_Exception_when_inputwrong(){
        randomIntGenerator = new RandomIntGenerator();
        Integer digmax = 4;
        Integer numbersOfNeed = 5;
        randomIntGenerator.generateNums(digmax,numbersOfNeed);
    }
    @Test
    public void should_get_numberString_when_inputCorrect(){
        randomIntGenerator = new RandomIntGenerator();

        Integer digmax = 9;
        Integer numbersOfNeed = 4;

        String result = randomIntGenerator.generateNums(digmax,numbersOfNeed);
        String[] numList= result.split(" ");
        assertThat(numList.length).isEqualTo(numbersOfNeed);
    }
}