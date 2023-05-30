package com.exam.examportal.controller;

import com.exam.examportal.model.exam.Question;
import com.exam.examportal.model.exam.Quiz;
import com.exam.examportal.services.QuestionServices;
import com.exam.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private  QuestionServices questionServices;

    @Autowired
    private QuizService quizService;

    // add question

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionServices.addQuestion(question));
    }
    // update question put
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question)
    {
        return  ResponseEntity.ok(this.questionServices.updateQuestion(question));
    }

    //get all question all quizes

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionQuiz(@PathVariable("qid") long qid)
    {
        System.out.println("question controller call");
//        Quiz quiz=new Quiz();
//        quiz.setQid(qid);
//        Set<Question> questionSet= this.questionServices.getQuestionofQuiz(quiz);
//        return  ResponseEntity.ok(questionSet);

         Quiz quiz=this.quizService.getQuiz(qid);
         Set<Question> questions= quiz.getQuestions();

        List<Question> list=new ArrayList(questions);

        if(list.size()>Integer.parseInt(quiz.getNumberofQuestions()) )
        {
            list=list.subList(0,Integer.parseInt(quiz.getNumberofQuestions() + 1));
        }
        list.forEach((q)->{
            q.setAnswer(" ");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }
    //question admin panel
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionQuizAdmin(@PathVariable("qid") long qid)
    {

        Quiz quiz=new Quiz();
        quiz.setQid(qid);
        Set<Question> questionSet= this.questionServices.getQuestionofQuiz(quiz);
        return  ResponseEntity.ok(questionSet);

//        return ResponseEntity.ok(list);

    }

    //get single question

    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId)
    {
        return  this.questionServices.getQuestion(quesId);
    }
    //delete question
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId)
    {
        this.questionServices.deleteQuestion(quesId);

    }

    @PostMapping("/eval-quize")
    public ResponseEntity<?> evaluevatedQuiz(@RequestBody List<Question> questions) {
        System.out.println("call evaluaevation"+questions);

        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;

        for (Question q : questions) {
            System.out.println(q.getGivenAnswer());
            //single question


            Question question = this.questionServices.get(q.getQuesId());
            if (question.getAnswer().equals(q.getGivenAnswer())) {

                correctAnswers++;
                System.out.println("correct ans:-"+correctAnswers);


                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
                marksGot += marksSingle;

            }

//            else if(q.getGivenAnswer() ==null)
//            {
//                correctAnswers--;
//                System.out.println("correct ans:-"+correctAnswers);
//            }
            if (q.getGivenAnswer() != null)
            {

                attempted++;
                System.out.println(attempted);

            }


        }


        Map<String, Object> map = new HashMap<String,Object>();
        map.put("marksGot", marksGot);
        map.put("correctAnswers",correctAnswers);
        map.put("attempted",attempted);


        return ResponseEntity.ok(map);


    }

}
