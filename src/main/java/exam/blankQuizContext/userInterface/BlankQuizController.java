package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.application.BlankQuizService;
import exam.blankQuizContext.application.CreateBlankQuizCommand;
import exam.blankQuizContext.application.UpdateBlankQuizCommand;
import exam.blankQuizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankQuizContext.infrastructure.MemoryBlankQuizReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlankQuizController {

    private BlankQuizService blankQuizService;
    private MemoryBlankQuizReadRepository memoryBlankQuizReadRepository;

    @Autowired
    public BlankQuizController(BlankQuizService blankQuizService, MemoryBlankQuizReadRepository memoryBlankQuizReadRepository) {
        this.blankQuizService = blankQuizService;
        this.memoryBlankQuizReadRepository = memoryBlankQuizReadRepository;
    }

    @GetMapping("/blankQuizzes")
    List<BlankQuiz> getAll() {
        return memoryBlankQuizReadRepository.getAll();
    }

    @PostMapping("/blankQuizzes/{blankQuizId}")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CreateBlankQuizCommand command) {
        blankQuizService.createBlankQuiz(command);
    }

    @PutMapping("/blankQuizzes/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable String blankQuizId, @RequestBody UpdateBlankQuizCommand command) {
        blankQuizService.updateBlankQuiz(blankQuizId, command);
    }

    @DeleteMapping("/blankQuizzes/{blankQuizId}")
    void delete(@PathVariable String blankQuizId) {
        blankQuizService.deleteBlankQuiz(blankQuizId);
    }
}
