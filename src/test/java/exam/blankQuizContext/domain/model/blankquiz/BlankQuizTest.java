package exam.blankQuizContext.domain.model.blankquiz;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {

    @Test
    public void should_create_blank_quiz() {

        final String blankQuizId = "quiz-f500ee0d-3c9f-494a-bc13-993250053194";
        final String question = "what is your name?";
        final String answer = "Jan";

        BlankQuiz blankQuiz = new BlankQuiz(new BlankQuizId(blankQuizId), question, answer);

        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getQuizId(), is(new BlankQuizId(blankQuizId)));
        assertThat(blankQuiz.getQuestion(), is(question));
        assertThat(blankQuiz.getAnswer(), is(answer));
        assertThat(blankQuiz.getDeleted(), is(false));
    }

    @Test
    public void should_update_blank_quiz() {

        final String blankQuizId = "quiz-f500ee0d-3c9f-494a-bc13-993250053194";
        final String oldQuestion = "what is your name?";
        final String oldAnswer = "Jan";
        final String newQuestion = "how old are your?";
        final String newAnswer = "18";

        BlankQuiz blankQuiz = new BlankQuiz(new BlankQuizId(blankQuizId), oldQuestion, oldAnswer);
        blankQuiz.update(newQuestion, newAnswer);

        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getQuizId(), is(new BlankQuizId(blankQuizId)));
        assertThat(blankQuiz.getQuestion(), is(newQuestion));
        assertThat(blankQuiz.getAnswer(), is(newAnswer));
        assertThat(blankQuiz.getDeleted(), is(false));
    }

    @Test
    public void should_delete_blank_quiz() {

        final String blankQuizId = "quiz-f500ee0d-3c9f-494a-bc13-993250053194";
        final String question = "what is your name?";
        final String answer = "Jan";

        BlankQuiz blankQuiz = new BlankQuiz(new BlankQuizId(blankQuizId), question, answer);
        blankQuiz.delete();

        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getQuizId(), is(new BlankQuizId(blankQuizId)));
        assertThat(blankQuiz.getQuestion(), is(question));
        assertThat(blankQuiz.getAnswer(), is(answer));
        assertThat(blankQuiz.getDeleted(), is(true));
    }
}
