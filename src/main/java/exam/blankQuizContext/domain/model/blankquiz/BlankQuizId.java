package exam.blankQuizContext.domain.model.blankquiz;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BlankQuizId implements ValueObject<BlankQuizId> {

    private String id;

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }
}
