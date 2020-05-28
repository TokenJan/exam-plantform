package exam.blankQuizContext.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBlankQuizCommand {

    private String question;

    private String answer;

}
