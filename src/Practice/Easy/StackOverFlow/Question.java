package Practice.Easy.StackOverFlow;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Question implements Votable, Commentable{
    private final int questionId;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;

    public Question(String title, String content, List<String> tagNames, User author){
        this.questionId = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        for(String tagName : tagNames){
            tags.add(new Tag(tagName));
        }
    }

    private int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            answers.add(answer);
        }
    }

    @Override
    public void vote(User user, int value){
        if(value != 1 && value != -1){
            throw new IllegalArgumentException("Vote value must be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateReputation(value * 5); // +5 for upvote and -5 for down vote
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
