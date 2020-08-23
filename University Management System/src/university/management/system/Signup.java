
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        super("Create Account");
        setBounds(600, 250, 606, 600);
	contentPane = new JPanel();

	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username ");
	lblUsername.setForeground(new Color(15,19,42));
	lblUsername.setFont(new Font("sitka text",Font.BOLD,17));
	lblUsername.setBounds(100, 122, 185, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Name");
	lblName.setForeground(new Color(15,19,42));
	lblName.setFont(new Font("sitka text",Font.BOLD,17));
	lblName.setBounds(100, 171, 185, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setForeground(new Color(15,19,42));
	lblPassword.setFont(new Font("sitka text",Font.BOLD,17));
	lblPassword.setBounds(100, 219, 185, 26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer");
	lblAnswer.setForeground(new Color(15,19,42));
	lblAnswer.setFont(new Font("sitka text",Font.BOLD,17));
	lblAnswer.setBounds(100, 315, 185, 26);
	contentPane.add(lblAnswer);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your Favourite Book?"}));
	comboBox.setBounds(265, 262, 185, 30);
	contentPane.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Security Question");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("sitka text",Font.BOLD,17));
	lblSecurityQuestion.setBounds(100, 267, 185, 26);
	contentPane.add(lblSecurityQuestion);

        textField = new JTextField();
	textField.setBounds(265, 118, 185, 30);
          textField.setFont(new Font("sitka text",Font.PLAIN,17));
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 166, 185, 30);
          textField_1.setFont(new Font("sitka text",Font.PLAIN,17));
	contentPane.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 214, 185, 30);
          textField_2.setFont(new Font("sitka text",Font.PLAIN,17));
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 310, 185, 30);
        textField_3.setFont(new Font("sitka text",Font.PLAIN,17));
	contentPane.add(textField_3);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	   b1.setFont(new Font("sitka text",Font.BOLD,17));
	b1.setBounds(150, 400, 100, 50);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	   b2.setFont(new Font("sitka text",Font.BOLD,17));
	b2.setBounds(350, 400, 100, 50);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, (String) comboBox.getSelectedItem());
		st.setString(5, textField_3.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Login().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}
