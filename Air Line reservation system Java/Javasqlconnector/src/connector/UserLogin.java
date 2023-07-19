package connector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1 ;
    public static JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserLogin() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
      
           
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 39);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 39);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(321, 178, 150, 25);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(334, 280, 137, 52);
        contentPane.add(lblPassword);
       
        JCheckBox checkBox1 = new JCheckBox("I am not a Robot");  
        checkBox1.setFont(new Font("Arial Black", Font.BOLD, 15));
        checkBox1.setBounds(481,343,286,39);  
        contentPane.add(checkBox1);  
       
  
      
        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 102, 50);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                @SuppressWarnings("deprecation")
				String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from account_holders where name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                         UserLogin ah = new UserLogin ();
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        ah.dispose();
                        use frame = new use();
    					frame.setVisible(true);
                    } else  {
                    	
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                        
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\air.jpg"));
        lblNewLabel_1.setBounds(67, 133, 204, 188);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("VIMANA AARAKSHANAM ");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setBounds(446, 10, 232, 25);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Create new account");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(535, 469, 303, 25);
        contentPane.add(lblNewLabel_3);
        
        JButton btnNewButton_1 = new JButton("SignIn");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Project1 p2=new Project1();
            	p2.setVisible(true);
            	p2.setLayout(null);
        	}
        });
        btnNewButton_1.setBounds(545, 509, 85, 21);
        contentPane.add(btnNewButton_1);
        
        
        JButton btnNewButton_2 = new JButton(" Owner");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		owner frame = new owner();
				frame.setVisible(true);
        		
        	}
        });
        btnNewButton_2.setBounds(853, 41, 90, 36);
        contentPane.add(btnNewButton_2);
        
    }
}

 class Project1
{
JFrame f1=new JFrame();


Project1()
{
	
	 
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.setVisible(true);
f1.setBounds(100,100,450,300);



JLabel lblNewLabel = new JLabel("SignUp");
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

f1.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

JTextField textField = new JTextField();
textField.setBounds(135, 76, 206, 31);
f1.add(textField);
textField.setColumns(1);

JLabel lblNewLabel_1 = new JLabel("UserName");
lblNewLabel_1.setBounds(446, 10, 232, 25);
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
lblNewLabel_1.setBounds(47, 71, 82, 36);
f1.add(lblNewLabel_1);

JTextField PasswordField_1 = new JPasswordField();
PasswordField_1.setBounds(135, 131, 206, 31);
f1.add(PasswordField_1);
PasswordField_1.setColumns(10);

JLabel lblPassword = new JLabel("Enter Password");
lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
lblPassword.setBounds(534, 280, 88, 36);
f1.add(lblPassword);

JButton btnNewButton_1 = new JButton("Login");
btnNewButton_1.setBackground(Color.CYAN);
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

btnNewButton_1.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent e) { 
    	f1.dispose();
    	UserLogin p2=new UserLogin();
    	p2.setVisible(true);
    	p2.setLayout(null);
    	
    } 
});
f1.setVisible(true);
f1.setLayout(null);
btnNewButton_1.setBounds(280,212,85,36);
f1.add(btnNewButton_1);

JButton btnNewButton = new JButton("Signup");
btnNewButton.setBounds(183, 212, 85, 21);

f1.setVisible(true);
f1.setLayout(null);
f1.add(btnNewButton);

btnNewButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
        String userName = textField.getText();
        String password = PasswordField_1.getText();
        if(textField.getText()!=null) 
	
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                "root", "@Cj16724!");
            PreparedStatement sql = (PreparedStatement) connection
                    .prepareStatement("INSERT  INTO account_holders VALUES(?,?) ");
            
       	 
       	 sql.setString(1,userName);
       	sql.setString(2,password);
     
       sql.executeUpdate();
       JOptionPane.showMessageDialog(btnNewButton, "You have successfully Signed in  now you can login ");
        
       
            
        } catch (SQLException sqlException) {
        	
        	JOptionPane.showMessageDialog(btnNewButton, "user name already exists");
        }
    }
});


    }

	protected void setLayout(Object object) {
	// TODO Auto-generated method stub
	
}

	protected void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}


protected void setTitle(String string) {
	// TODO Auto-generated method stub
	
}
}
