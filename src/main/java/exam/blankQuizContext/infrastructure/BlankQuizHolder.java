package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankquiz.BlankQuiz;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Component
public class BlankQuizHolder {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();
}
