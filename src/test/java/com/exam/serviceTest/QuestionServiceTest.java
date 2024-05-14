package com.exam.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.service.impl.QuestionServiceImpl;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    void testAddQuestion() {
        Question question = new Question();
        when(questionRepository.save(question)).thenReturn(question);
        
        Question savedQuestion = questionService.addQuestion(question);
        
        assertEquals(question, savedQuestion);
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void testUpdateQuestion() {
        Question question = new Question();
        when(questionRepository.save(question)).thenReturn(question);
        
        Question updatedQuestion = questionService.updateQuestion(question); 
        
        assertEquals(question, updatedQuestion);
        verify(questionRepository, times(1)).save(question);
    }

//    @Test
//    void testGetQuestions() {
//        Set<Question> questions = new HashSet<>();
//        when(questionRepository.findAll()).thenReturn(questions);
//        
//        Set<Question> retrievedQuestions = questionService.getQuestions();
//        
//        assertEquals(questions, retrievedQuestions);
//        verify(questionRepository, times(1)).findAll();
//    }

    @Test
    void testGetQuestion() {
        Long questionId = 1L;
        Question question = new Question();
        when(questionRepository.findById(questionId)).thenReturn(Optional.of(question));
        
        Question retrievedQuestion = questionService.getQuestion(questionId);
        
        assertEquals(question, retrievedQuestion);
        verify(questionRepository, times(1)).findById(questionId);
    }

    @Test
    void testGetQuestionsOfQuiz() {
        Quiz quiz = new Quiz();
        Set<Question> questions = new HashSet<>();
        when(questionRepository.findByQuiz(quiz)).thenReturn(questions);
        
        Set<Question> retrievedQuestions = questionService.getQuestionsOfQuiz(quiz);
        
        assertEquals(questions, retrievedQuestions);
        verify(questionRepository, times(1)).findByQuiz(quiz);
    }

//    @Test
//    void testDeleteQuestion() {
//        Long quesId = 1L;
//        Question question = new Question();
//        question.setQuesId(quesId);
//        
//        questionService.deleteQuestion(quesId);
//        
//        verify(questionRepository, times(1)).delete(question);
//    }

    @Test
    void testGet() {
        Long questionsId = 1L;
        Question question = new Question();
        when(questionRepository.getById(questionsId)).thenReturn(question);
        
        Question retrievedQuestion = questionService.get(questionsId);
        
        assertEquals(question, retrievedQuestion);
        verify(questionRepository, times(1)).getById(questionsId);
    }
}

