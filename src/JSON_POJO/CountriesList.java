package JSON_POJO;

import java.util.*;

public class CountriesList extends ArrayList<Country> {
    public List<Country> countries;

    public CountriesList(List<Country> countries) {
        this.countries = countries;
    }

    public CountriesList() {
        countries = new ArrayList<Country>();
    }

}
