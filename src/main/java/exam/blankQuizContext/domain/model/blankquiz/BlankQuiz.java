package exam.blankQuizContext.domain.model.blankquiz;

import exam.paperContext.domain.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class BlankQuiz implements Entity<BlankQuiz> {

    private BlankQuizId quizId;
    private String question;
    private String answer;

    public BlankQuiz(BlankQuizId quizId, String question, String answer) {
        this.quizId = quizId;
        this.question = question;
        this.answer = answer;
    }

    public void update(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return quizId.sameValueAs(other.getQuizId());
    }
}
