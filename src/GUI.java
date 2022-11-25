import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    // Could reformat this all most probably via poly and then add them to the panel with a for loop way more clean
    private static JLabel emailLabel;
    private static JTextField emailText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JLabel confirmationLabel;
    private static JPasswordField confirmationText;
    private static JButton confirmationButton;
    private static JLabel  successLabel;
    private static EmailSystem emailSystem=new EmailSystem();
public static void main(String[] args){
    JPanel panel=new JPanel();
    panel.setLayout(null);

    JFrame frame=new JFrame();
    frame.setSize(350,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    // Setting the Email labels and text fields
    emailLabel =new JLabel("Email");
    emailLabel.setBounds(10,20,80,25);
    emailText =new JTextField(20);
    emailText.setBounds(100,20,165,25);
    // Setting the password labels and text boundaries
    passwordLabel =new JLabel("Password");
    passwordLabel.setBounds(10,50,80,25);
    passwordText =new JPasswordField(20);
    passwordText.setBounds(100,50,165,25);
    // Confirm the password label and text
    confirmationLabel =new JLabel("Confirm");
    confirmationLabel.setBounds(10,80,80,25);
    confirmationText =new JPasswordField(20);
    confirmationText.setBounds(100,80,165,25);
    //Adding a button to confirm
    confirmationButton= new JButton("Register");
    confirmationButton.setBounds(125,110,100,25);
    confirmationButton.addActionListener(new GUI());
    //Adding a success label that will eventually appear if a user registers
    successLabel =new JLabel("");
    successLabel.setBounds(10,140,300,25);
    //Adding all the different elements to the panel

    panel.add(emailLabel);
    panel.add(emailText);
    panel.add(passwordLabel);
    panel.add(passwordText);
    panel.add(confirmationLabel);
    panel.add(confirmationText);
    panel.add(confirmationButton);
    panel.add(successLabel);
    frame.setVisible(true);
}

    //This method handles the user information
    @Override
    public void actionPerformed(ActionEvent e) {
        //Example of how you get the text in a box
        String email= emailText.getText();
        // Could use information expert here to handle all the information and maybe create a facade?
        boolean good=false;
        if(good) {
            emailSystem.sendEmail();
        }
    }
}