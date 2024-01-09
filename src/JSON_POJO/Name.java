package JSON_POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(value = { "nativeName" })
public class Name {
    @JsonProperty
    private String common;
    @JsonProperty
    private String official;
    @JsonProperty
    private List<Name> nativeName;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public List<Name> getNativeName() {
        return nativeName;
    }

    public void setNativeName(List<Name> nativeName) {
        this.nativeName = nativeName;
    }

    @Override
    public String toString() {
        return official;
    }
}
