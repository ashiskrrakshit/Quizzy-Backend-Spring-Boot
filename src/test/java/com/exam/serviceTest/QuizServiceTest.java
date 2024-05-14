package com.exam.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;
import org.mockito.*;

import com.exam.model.exam.*;
import com.exam.repo.QuizRepository;
import com.exam.service.impl.QuizServiceImpl;

class QuizServiceTest {

    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    private QuizRepository quizRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddQuiz() {
        Quiz quizToAdd = new Quiz(); // Create your quiz object here
        Quiz savedQuiz = new Quiz(); // Create the saved quiz object here after saving
        when(quizRepository.save(quizToAdd)).thenReturn(savedQuiz);

        Quiz result = quizService.addQuiz(quizToAdd);

        assertEquals(savedQuiz, result);
        verify(quizRepository, times(1)).save(quizToAdd);
    }

    @Test
    void testUpdateQuiz() {
        Quiz quizToUpdate = new Quiz(); // Create your quiz object here
        Quiz updatedQuiz = new Quiz(); // Create the updated quiz object here after updating
        when(quizRepository.save(quizToUpdate)).thenReturn(updatedQuiz);

        Quiz result = quizService.updateQuiz(quizToUpdate);

        assertEquals(updatedQuiz, result);
        verify(quizRepository, times(1)).save(quizToUpdate);
    }



    @Test
    void testGetQuiz() {
        Long quizId = 1L; // Provide a quiz ID
        Quiz quiz = new Quiz(); // Create a quiz object
        when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));

        Quiz result = quizService.getQuiz(quizId);

        assertEquals(quiz, result);
        verify(quizRepository, times(1)).findById(quizId);
    }

    @Test
    void testDeleteQuiz() {
        Long quizId = 1L; // Provide a quiz ID

        quizService.deleteQuiz(quizId);

        verify(quizRepository, times(1)).deleteById(quizId);
    }

    @Test
    void testGetQuizzesOfCategory() {
        Category category = new Category(); // Create a category
        List<Quiz> quizzes = new ArrayList<>(); 
        when(quizRepository.findBycategory(category)).thenReturn(quizzes);

        List<Quiz> result = quizService.getQuizzesOfCategory(category);

        assertEquals(quizzes, result);
        verify(quizRepository, times(1)).findBycategory(category);
    }

    @Test
    void testGetActiveQuizzes() {
        List<Quiz> activeQuizzes = new ArrayList<>(); // Add some active quizzes here
        when(quizRepository.findByActive(true)).thenReturn(activeQuizzes);

        List<Quiz> result = quizService.getActiveQuizzes();

        assertEquals(activeQuizzes, result);
        verify(quizRepository, times(1)).findByActive(true);
    }

    @Test
    void testGetActiveQuizzesOfCategory() {
        Category category = new Category(); // Create a category
        List<Quiz> activeQuizzesInCategory = new ArrayList<>(); // Add some active quizzes in this category
        when(quizRepository.findByCategoryAndActive(category, true)).thenReturn(activeQuizzesInCategory);

        List<Quiz> result = quizService.getActiveQuizzesOfCategory(category);

        assertEquals(activeQuizzesInCategory, result);
        verify(quizRepository, times(1)).findByCategoryAndActive(category, true);
    }
}
