package Practice.Easy.StackOverFlow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    Map<Integer,User> userMap;
    Map<Integer,Question> questionMap;
    Map<Integer,Answer> answerMap;
    Map<String,Tag> tagMap;

    public StackOverflow(){
        userMap = new ConcurrentHashMap<>();
        questionMap = new ConcurrentHashMap<>();
        answerMap = new ConcurrentHashMap<>();
        tagMap = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email){
        int id = userMap.size() + 1;
        User user = new User(id,username,email);
        userMap.put(id,user);
        return user;
    }

    public Question postQuestion(String title, String content, User user, List<String> tagNames){
        Question question = user.postQuestion(title,content,tagNames);
        questionMap.put(question.getQuestionId(), question);
        for(Tag tag : question.getTags()){
            this.tagMap.putIfAbsent(tag.getName(), tag);
        }
        return question;
    }

    public Answer postAnswer(Question question, String content ,User user){
        Answer answer = user.answerQuestion(content,question);
        answerMap.put(answer.getAnswerId(),answer);
        return answer;
    }

    public Comment postComment(Commentable commentable, String content, User user){
        return user.addComment(commentable,content);
    }

    public void voteQuestion(User user, int value, Question question){
        question.vote(user,value);
    }

    public void voteAnswer(User user, int value, Answer answer){
        answer.vote(user,value);
    }

    public void acceptAnswer(Answer answer){
        answer.markAccepted();
    }

    public List<Question> searchQuestion(String query){
        return questionMap.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query))
                        ).collect(Collectors.toList());
    }

}
