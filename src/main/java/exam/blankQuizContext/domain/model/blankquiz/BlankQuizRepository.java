package exam.blankQuizContext.domain.model.blankquiz;

public interface BlankQuizRepository {

    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    BlankQuizId nextBlankQuizId();

}
