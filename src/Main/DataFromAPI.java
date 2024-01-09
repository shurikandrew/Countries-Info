package Main;

import JSON_POJO.CountriesList;
import JSON_POJO.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class DataFromAPI {
    public static void get(String url, String filepath) throws  IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
        writer.write("Country\tCapital\tPopulation\tFlag\n");
        String country;
        ArrayList<Country> countries = readJSON(url);
        for (Country cntr :
                countries) {
            if(!new File(("src/Data/Images/"+cntr.getFlags().getFlagIndex())).exists() && !cntr.getFlags().getPng().equals("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_the_Taliban.svg/320px-Flag_of_the_Taliban.svg.png")) {
                try (InputStream in = new URL(cntr.getFlags().getPng()).openStream()) {
                    Files.copy(in, Paths.get("src/Data/Images/" + cntr.getFlags().getFlagIndex()));
                } catch (IOException e) {
                    System.out.println("File " + cntr.getFlags().getPng() + " was not saved successfully");
                }
            }
            if(cntr.getFlags().getPng().equals("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_the_Taliban.svg/320px-Flag_of_the_Taliban.svg.png") && !new File("src/Data/Images/tb.png").exists())
            {
                try (InputStream in = new URL(cntr.getFlags().getPng()).openStream()) {
                    Files.copy(in, Paths.get("src/Data/Images/tb.png"));
                } catch (IOException e) {
                    System.out.println("File " + cntr.getFlags().getPng() + " was not saved successfully");
                }
                cntr.getFlags().setPng("https://flagcdn.com/w320/tb.png");
            }
            country = cntr.toString();
            writer.write(country);
        }
        writer.close();
    }

    private static ArrayList<Country> readJSON(String url){
        ObjectMapper mapper = new ObjectMapper();
        if(!new File("src/Data/countriesJSON.json").exists()) {
            try (InputStream in = new URL("https://restcountries.com/v3.1/all?fields=name,capital,population,flags").openStream()) {
                Files.copy(in, Paths.get("src/Data/countriesJSON.json"));
            } catch (IOException e) {
                System.out.println("JSON data was not saved successfully");
            }
        }
        ArrayList<Country> countries;
        try {
            countries = mapper.readValue(new File(url), CountriesList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

}
