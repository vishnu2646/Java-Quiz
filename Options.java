import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Options {
    private int id;
    private String option;
    private boolean isSelected;

    @JsonCreator
    public Options(
        @JsonProperty("id")int id, 
        @JsonProperty("option")String option, 
        @JsonProperty("isSelected")boolean isSelected
    ) {
        this.id = id;
        this.option = option;
        this.isSelected = isSelected;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("option")
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }

    @JsonProperty("isSelected")
    public boolean getIsSelected() {
        return isSelected;
    }
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
