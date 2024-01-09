package JSON_POJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty
    private Flags flags;

    @JsonProperty
    private Name name;
    @JsonProperty
    private List<String> capital;
    @JsonProperty
    private int population;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public int getPopulation() {
        return population/1000;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    @Override
    public String toString() {
        return name.getOfficial() + "\t" + capital.toString() + "\t" + population + "\t" + flags.getFlagIndex() + "\n";
    }

}
