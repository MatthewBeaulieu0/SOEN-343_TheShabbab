import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is a case of pure fabrication as it's only job is to handle the database
 * it is also a singleton to avoid doing reads and write at the same time on the database
 */
public class CSVSystem {


    private static CSVSystem instance = new CSVSystem();

    private CSVSystem() {
    }

    public static CSVSystem getInstance() {
        return instance;
    }

    /**
     * This function returns true whenever it matches the input string else it returns false
     * which means that there is no duplicate of that email
     *
     * @param inputEmail
     * @return
     */
    public boolean verifyEmail(String inputEmail) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/database.csv"));
            while ((line = br.readLine()) != null) {
                String[] member = line.split(splitBy);
                if (member[0].equals("\""+inputEmail+"\"")){
                    return true;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void writeMember(Member member) throws Exception {
        String[] csvData = {member.getEmail(), member.getPassword(), member.getLocation()};

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/database.csv", true))) {
            writer.writeNext(csvData);
        }

    }
}
