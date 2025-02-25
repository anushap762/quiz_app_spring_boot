/*
 * package com.udemycourses.quizapp;
 * 
 * import static org.mockito.ArgumentMatchers.any; import static
 * org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 * 
 * import java.util.ArrayList;
 * 
 * import org.junit.jupiter.api.BeforeEach; import
 * org.junit.jupiter.api.Disabled; import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.udemycourses.quizapp.controller.QuizController; import
 * com.udemycourses.quizapp.model.Question; import
 * com.udemycourses.quizapp.model.Quiz; import
 * com.udemycourses.quizapp.services.QuizService;
 * 
 * @Disabled
 * 
 * @WebMvcTest(QuizController.class) public class QuizControllerTests {
 * 
 * @MockBean private QuizService quizService;
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * private Quiz quiz; private Question question;
 * 
 * @BeforeEach void setUp() { question = new Question(); question.setId(2);
 * question.setQuestionTitle("question title"); question.setCategory("java");
 * question.setOption1("1"); question.setOption2("2"); question.setOption3("3");
 * question.setOption4("4"); ArrayList<Question> questions = new ArrayList<>();
 * questions.add(question); quiz = new Quiz(); quiz.setId(101);
 * quiz.setQuestions(questions); quiz.setTitle("quiz title"); }
 * 
 * @Test void testCreateQuiz() throws Exception { String category = "java"; int
 * numQ = 2; String title = "quiz title1";
 * 
 * ResponseEntity<String> mockResponse = ResponseEntity.ok("added");
 * 
 * // Mocking the service method when(quizService.addQuestion(category, numQ,
 * title)).thenReturn(mockResponse);
 * 
 * // Perform the test mockMvc.perform(post("/quiz/create") .param("category",
 * category) .param("numQ", String.valueOf(numQ)) .param("title", title))
 * .andExpect(status().isOk()) // Expect HTTP 200 OK
 * .andExpect(content().string("Quiz Created Successfully")); }
 * 
 * @Disabled void testgetQuizQuestions() { // Disabled test method } }
 */