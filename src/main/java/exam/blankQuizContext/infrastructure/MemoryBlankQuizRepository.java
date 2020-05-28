package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {

    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream()
                .filter(blankQuiz -> blankQuiz.getQuizId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.add(blankQuiz);
    }

    @Override
    public BlankQuizId nextBlankQuizId() {
        return new BlankQuizId("blankQuiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizzes);
    }

    @Override
    public void delete(BlankQuizId blankQuizId) {
        blankQuizzes.stream()
                .filter(blankQuiz -> blankQuiz.getQuizId().equals(blankQuizId))
                .findFirst()
                .ifPresent(blankQuiz -> blankQuizzes.remove(blankQuiz));
    }
}
