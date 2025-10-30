import java.awt.*;
import java.awt.event.*;



public class LoginForm_24rp08520 extends Frame implements ActionListener {

    Label lblTitle, lblUsername, lblPassword;
    TextField txtUsername, txtPassword;
    Button btnLogin;


    private static final String CORRECT_USER = "jose";
    private static final String CORRECT_PASS = "jose123";

    public LoginForm_24rp08520() {

        setTitle("AWTLogin_24rp08520 - Login Validation");
        setSize(400, 200);


        setLayout(new BorderLayout(10, 10)); // Added some outer padding


        lblTitle = new Label("Simple AWT Login Implementation", Label.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));

        lblUsername = new Label("Username:");
        lblPassword = new Label("Password:");
        txtUsername = new TextField(15);
        txtPassword = new TextField(15);

        txtPassword.setEchoChar('*');

        btnLogin = new Button("LOGIN");
        btnLogin.addActionListener(this); // Register the button listener


        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));

        inputPanel.add(lblUsername);
        inputPanel.add(txtUsername);
        inputPanel.add(lblPassword);
        inputPanel.add(txtPassword);

        add(lblTitle, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnLogin);
        add(buttonPanel, BorderLayout.SOUTH);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
        setResizable(false);
    }

    private void showMessageDialog(String message, String title) {
        Dialog msgDialog = new Dialog(this, title, true);
        msgDialog.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));


        msgDialog.add(new Label(message, Label.CENTER));

        Button btnOk = new Button("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msgDialog.dispose(); // Close the dialog
            }
        });
        msgDialog.add(btnOk);

        msgDialog.pack(); // Adjusts size to fit components
        msgDialog.setLocationRelativeTo(this); // Center over the main frame
        msgDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String enteredUser = txtUsername.getText();
            String enteredPass = txtPassword.getText();

            if (enteredUser.equals(CORRECT_USER) && enteredPass.equals(CORRECT_PASS)) {

                String message = "Welcome, " + enteredUser + "! Login Successful.";
                showMessageDialog(message, "Success");
            } else {

                String message = "Incorrect credentials. Please try again.";
                showMessageDialog(message, "Login Failed");
            }
        }
    }

    public static void main(String[] args) {
        new LoginForm_24rp08520();
    }
}