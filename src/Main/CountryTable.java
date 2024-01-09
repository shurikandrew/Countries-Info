package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountryTable {

    public String countries;
    public String[] names = new String[4];

    public CountryTable(String countries) {
        this.countries = countries;
    }

    public JTable create() {
        Object[][] arr = getData();
        for (int i = 0; i < arr[0].length; i++) {
            names[i] = (String) arr[0][i];
        }
        Object[][] result = new Object[246][4];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i+1];
        }
        JTable table = new JTable(result, names) {
            public Class getColumnClass(int column) {
                return (column == 3) ? ImageIcon.class :((column == 2) ? Integer.class : String.class);
            }
        };
        return table;
    }

    public Object[][] getData(){
        Object[][] result = new Object[251][4];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(countries));
            String line = reader.readLine();
            String[] arr;
            int i = 0;
            while (line != null) {
                arr = line.split("\t");
                for (int j = 0; j < arr.length; j++) {
                    result[i][j] = arr[j];
                }
                if(i != 0){
                    ImageIcon icon = new ImageIcon("src/Data/Images/" + result[i][3]);
                    Image image = icon.getImage();
                    image = image.getScaledInstance(30, 20,  java.awt.Image.SCALE_SMOOTH);
                    result[i][3] = new ImageIcon(image);
                }
                line = reader.readLine();
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
