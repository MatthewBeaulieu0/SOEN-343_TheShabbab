import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


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
     * @param inputEmail
     * @return
     */
    public boolean verifyEmail(String inputEmail) {
        String line="";
        String splitBy=",";
        try{
        BufferedReader br = new BufferedReader(new FileReader("src/database.csv"));
        while((line=br.readLine()) !=null)
        {
            String[] member = line.split(splitBy);
            if(member[0].equals(inputEmail)){
                return true;
            }
        }


        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
