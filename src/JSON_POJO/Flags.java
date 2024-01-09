package JSON_POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Flags {
    @JsonProperty
    public String png;
    @JsonProperty
    public String svg;
    @JsonProperty
    public String alt;


    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getFlagIndex() {
        return png.substring(25);
    }


    @Override
    public String toString() {
        return png;
    }
}
