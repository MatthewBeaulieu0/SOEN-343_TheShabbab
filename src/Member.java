import java.util.Locale;

/**
 * The class member is the information expert for the GUI class since it
 * has all the functions for the CSVSystem and also takes care of the typing of
 * members
 */
public class Member {

    private CSVSystem database = CSVSystem.getInstance();
    private String email;
    private String password;
    private String location;

    public Member(String emailParam, String passwordParam, String confirmPassword, String locationParam) throws Exception {

        if (database.verifyEmail(emailParam)) {
            throw new Exception("Error: Email already registered!");
        }
        if (checkLocation(locationParam)) {
            throw new Exception("Error: location not valid");
        }
        if (!checkPassword(passwordParam, confirmPassword)) {
            throw new Exception("Error: Password not valid");
        }

        this.email = emailParam;
        this.password = passwordParam;
        this.location = locationParam;
        database.writeMember(this);
    }

    private boolean checkPassword(String pass, String confirmPass) {
        return pass.equals(confirmPass);
    }

    private boolean checkLocation(String location) {
        System.out.print(location);
        if ("MTL".equals(location.toUpperCase(Locale.ROOT)) || "LAVAL".equalsIgnoreCase(location.toUpperCase(Locale.ROOT))) {
            return false;
        } else {
            return true;
        }
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
