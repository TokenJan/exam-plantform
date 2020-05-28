package exam.blankQuizContext.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateBlankQuizCommand {

    private String question;

    private String answer;

}
