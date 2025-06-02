package Practice.Easy.StackOverFlow;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Answer implements Votable, Commentable{
    private final int answerId;
    private final User author;
    private final String content;
    private final Question question;
    private final Date creationDate;
    private boolean isAccepted;
    private final List<Vote> votes;
    private final List<Comment> comments;

    public Answer(String content, User author, Question question){
        this.content = content;
        this.author = author;
        this.question = question;
        this.answerId = generateId();
        this.creationDate = new Date();
        this.isAccepted = false;
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    private int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void markAccepted(){
        if(isAccepted){
            throw new IllegalArgumentException("Answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(15);
    }

    @Override
    public void vote(User user, int value){
        if(value != 1 && value != -1){
            throw new IllegalArgumentException("Vote value must be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateReputation(value * 10); // +10 for upvote and -10 for down vote
    }

    @Override
    public int getVoteCount(){
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments(){
        return new ArrayList<>(comments);
    }
}
