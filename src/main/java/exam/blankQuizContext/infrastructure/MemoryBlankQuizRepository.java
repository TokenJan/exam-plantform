package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {

    private BlankQuizHolder blankQuizHolder;

    public MemoryBlankQuizRepository(BlankQuizHolder blankQuizHolder) {
        this.blankQuizHolder = blankQuizHolder;
    }

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return this.blankQuizHolder.getBlankQuizzes().stream()
                .filter(BlankQuiz::isAvailable)
                .filter(blankQuiz -> blankQuiz.getQuizId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        this.blankQuizHolder.getBlankQuizzes().add(blankQuiz);
    }

    @Override
    public BlankQuizId nextBlankQuizId() {
        return new BlankQuizId("blankQuiz-" + UUID.randomUUID().toString());
    }

}
