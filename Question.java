import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private int id;
    private String question;
    private Options options[];
    private String answer;

    @JsonCreator
    public Question(
        @JsonProperty("id")int id, 
        @JsonProperty("question")String question, 
        @JsonProperty("options")Options[] options, 
        @JsonProperty("answer")String answer
    ) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public Options[] getOptions() {
        return options;
    }
    public void setOptions(Options[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        StringBuilder optionsBuilder = new StringBuilder();

        for (Options opts : this.options) {
            optionsBuilder.append("id: ").append(opts.getId())
                        .append(", option: ").append(opts.getOption())
                        .append(", isSelected: ").append(opts.getIsSelected());
        }

        if(optionsBuilder.length() > 0) {
            optionsBuilder.setLength(optionsBuilder.length() - 1);
        }
        return  "Id: " + id + ", Question: " + question + ", options: [" + optionsBuilder + "], answer: " + answer;
    }
}
