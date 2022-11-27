

public class Member {

    private CSVSystem database = CSVSystem.getInstance();
    private String email;
    private String password;
    private String location;

    public Member(String emailParam, String passwordParam, String confirmPassword, String locationParam) throws Exception{

        if(database.verifyEmail(emailParam)){
            throw new Exception("Error: Email already registered!");
        }
        if(!database.checkLocation("\""+locationParam+"\"")){
            throw  new Exception("Error: location not valid");
        }
        if(!checkPassword(passwordParam,confirmPassword)){
            throw  new Exception("Error: location not valid");
        }


        email=emailParam;
        password=passwordParam;
        location=locationParam;



    }

    private boolean checkPassword(String pass, String confirmPass){
        return pass.equals(confirmPass);
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }
}
