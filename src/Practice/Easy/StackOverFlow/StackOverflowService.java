package Practice.Easy.StackOverFlow;

import java.util.Arrays;
import java.util.List;

public class StackOverflowService {
    public static void main(String[] args){
        StackOverflow stackOverflow = new StackOverflow();
        
        User alice = stackOverflow.createUser("Alice", "alice@abc.com");
        User bob = stackOverflow.createUser("Bob", "bob@abc.com");
        User charlie = stackOverflow.createUser("Charlie", "charlie@abc.com");

        // Alice asks a question
        Question javaQuestion = stackOverflow.postQuestion( "What is polymorphism in Java?",
                "Can someone explain polymorphism in Java with an example?",alice,
                Arrays.asList("java", "oop"));

        // Bob answers Alice's question
        Answer bobAnswer = stackOverflow.postAnswer(javaQuestion, "Polymorphism in Java is the ability of an object to take on many forms...",bob);

        // Charlie comments Alice's question
        stackOverflow.postComment(javaQuestion, "Great question! I'm also interested in learning about this.", charlie);
        
        // Alice comments on Bob's answer
        stackOverflow.postComment(bobAnswer, "Thanks for the explanation! Could you provide a code example?", alice);

        // Charlie votes on the question and answer
        stackOverflow.voteQuestion(charlie,1,javaQuestion);  // Upvote
        stackOverflow.voteAnswer(charlie,1,bobAnswer);  // Upvote

        // Alice accepts Bob's answer
        stackOverflow.acceptAnswer(bobAnswer);

        // Bob asks another question
        Question pythonQuestion = stackOverflow.postQuestion( "How to use list comprehensions in Python?",
                "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?",bob,
                Arrays.asList("python", "list-comprehension"));

        // Alice answers Bob's question
        Answer aliceAnswer = stackOverflow.postAnswer( pythonQuestion,
                "List comprehensions in Python provide a concise way to create lists...",alice);

        // Charlie votes on Bob's question and Alice's answer
        stackOverflow.voteQuestion(charlie, 1,pythonQuestion);  // Upvote
        stackOverflow.voteAnswer(charlie,1,aliceAnswer);  // Upvote

        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getName());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + bobAnswer.getAuthor().getName() + ":");
        System.out.println(bobAnswer.getContent());
        System.out.println("Votes: " + bobAnswer.getVoteCount());
        System.out.println("Accepted: " + bobAnswer.isAccepted());
        System.out.println("Comments: " + bobAnswer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("Alice: " + alice.getReputationScore());
        System.out.println("Bob: " + bob.getReputationScore());
        System.out.println("Charlie: " + charlie.getReputationScore());

        // Demonstrate search functionality
        System.out.println("\nSearch Results for 'java':");
        List<Question> searchResults = stackOverflow.searchQuestion("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        System.out.println("\nSearch Results for 'python':");
        searchResults = stackOverflow.searchQuestion("python");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }
    }
}
