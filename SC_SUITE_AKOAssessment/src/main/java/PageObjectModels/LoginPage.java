package PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Login Page
public class LoginPage {
    private String userNameField, passWordField, loginSignInButton;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\LoginPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/LoginPage.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getUserNameField() {
        userNameField = properties.getProperty("LOGIN_USERNAME_INPUTBOX");
        return userNameField;
    }
    public String getPasswordField() {
        passWordField = properties.getProperty("LOGIN_PASSWORD_INPUTBOX");
        return passWordField;
    }
    public String getloginSignInButton() {
        loginSignInButton = properties.getProperty("LOGIN_SIGNIN_BUTTON");
        return loginSignInButton;
    }
}