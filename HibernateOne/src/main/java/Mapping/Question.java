package Mapping;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "Question_Id")
    private int questionId;
    private String question;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Answer_Id") // Make sure the column name matches your database schema
    private Answer answer;


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
        super();
    }
}
