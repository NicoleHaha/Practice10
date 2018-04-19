package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    @Test
    public void should_get_inputNumber_ValidateOrNot(){
        inputValidator = new InputValidator();

        String numStr1 = "1 3 4 5 6";
        assertThat(inputValidator.validate(numStr1)).isEqualTo(Boolean.FALSE);

        String numStr2 = "1 3 3 5";
        assertThat(inputValidator.validate(numStr2)).isEqualTo(Boolean.FALSE);

        String numStr3 = "1 3 12 6";
        assertThat(inputValidator.validate(numStr3)).isEqualTo(Boolean.FALSE);
        String numStr4 = "1 3 4 5";
        assertThat(inputValidator.validate(numStr4)).isEqualTo(Boolean.TRUE);
    }
}
