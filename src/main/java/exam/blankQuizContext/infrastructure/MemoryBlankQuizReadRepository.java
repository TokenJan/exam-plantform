package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankquiz.BlankQuiz;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizReadRepository {

    private BlankQuizHolder blankQuizHolder;

    public MemoryBlankQuizReadRepository(BlankQuizHolder blankQuizHolder) {
        this.blankQuizHolder = blankQuizHolder;
    }

    public List<BlankQuiz> getAll() {
        return this.blankQuizHolder.getBlankQuizzes().stream()
                .filter(BlankQuiz::isAvailable)
                .collect(Collectors.toList());
    }

}
