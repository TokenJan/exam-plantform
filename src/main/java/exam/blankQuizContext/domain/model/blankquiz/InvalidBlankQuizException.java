package exam.blankQuizContext.domain.model.blankquiz;

public class InvalidBlankQuizException extends IllegalArgumentException {

    public InvalidBlankQuizException() {
        super("Invalid Blank Quiz: question or answer should not be null.");
    }
}
