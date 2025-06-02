package Practice.Easy.StackOverFlow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private final int userId;
    private final String name;
    private final String email;
    private int reputationScore;
    private final List<Question> postedQuestions;
    private final List<Answer> postedAnswers;
    private final List<Comment> postedComments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String username, String email){
        this.userId = id;
        this.name = username;
        this.email = email;
        this.reputationScore = 0;
        this.postedQuestions = new ArrayList<>();
        this.postedAnswers = new ArrayList<>();
        this.postedComments = new ArrayList<>();
    }

    public Question postQuestion(String title, String content, List<String> tagNames){
        Question question = new Question(title,content,tagNames,this);
        postedQuestions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(String content, Question question){
        Answer answer = new Answer(content,this,question);
        postedAnswers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content){
        Comment comment = new Comment(content,this);
        postedComments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public synchronized void updateReputation(int value){
        this.reputationScore += value;
        if(this.reputationScore < 0){
            this.reputationScore = 0;
        }
    }
}
