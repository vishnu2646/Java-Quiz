import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class QuestionService {

    Question[] questions = new Question[5];

    String userAnswer[] = new String[5];

    public QuestionService() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            questions = mapper.readValue(new File("data/questions.json"), Question[].class);
        } catch (Exception e) {
            // Exception
            e.printStackTrace();
        }
    }

    public void playQuiz() {
        int i=0;

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            for(Question q: questions) {
                System.out.println("Question no: " + q.getId());
                System.out.println(q.getQuestion());
    
                for(Options opt: q.getOptions()) {
                    System.out.println(opt.getOption());
                }
    
                System.out.print("Enter Your Answer:  ");
                userAnswer[i] = scanner.nextLine();
                
                for(Options opt: q.getOptions()) {
                    if(opt.getOption().equals(userAnswer[i])) {
                        opt.setIsSelected(true);
                        break;
                    }
                }
    
                i++;
    
                System.out.println();
            }
        } finally {
            if( scanner != null) {
                scanner.close();
            }
        }
    }

    public void calcScore() {
        int score = 0;

        for(int i=0; i < questions.length; i++) {
            Question q = questions[i];

            String ans = q.getAnswer();

            String userAns = userAnswer[i];

            if(ans.equals(userAns)) {
                score += 1;
            } else {
                score -= 1;
            }
        }

        System.out.println("Your score is " + score);
    }
}
