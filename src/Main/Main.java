package Main;
import javax.swing.*;

public class Main {

    private JTable countriesTable;

    public void createTable(String countriesFileName){
        CountryTable table = new CountryTable(countriesFileName);
        countriesTable = table.create();
    }

    public void show() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFrame f = new JFrame("Countries table");
                f.add( new JScrollPane(countriesTable) );
                f.pack();
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    public static void main(String[] args)  {
        Main main = new Main();
        String url = "src/Data/countriesJSON.json";
        String filePath = "src/Data/countries.txt";
        try {
            DataFromAPI.get(url,filePath);
            main.createTable(filePath);
            main.show();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Table creation failed, " + e);
            e.printStackTrace();
        }
    }
}
