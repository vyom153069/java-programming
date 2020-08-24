
package university.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new StudentFeeForm().setVisible(true);
    }


    public StudentFeeForm() {
        super("Student Fee Form");
	setBounds(700, 200, 600, 603);
	contentPane = new JPanel();
	
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
	c1 = new Choice();
        c1.setForeground(new Color(47, 79, 79));
	c1.setFont(new Font("sitka text",Font.PLAIN,17));
	
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                c1.add(rs.getString("rollno"));
            }
        }catch(Exception e) { }
        
	JLabel l1 = new JLabel("Select Roll No");
	l1.setForeground(new Color(15,19,42));
	l1.setFont(new Font("sitka text",Font.  BOLD,17));
	l1.setBounds(50, 25, 150, 28);
	contentPane.add(l1);

	c1.setBounds(300, 25, 184, 30);
	contentPane.add(c1);

        JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(15,19,42));
	l2.setFont(new Font("sitka text",Font.BOLD,17));
	l2.setBounds(50, 80, 150, 28);
	contentPane.add(l2);
        
	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("sitka text",Font.PLAIN,17));
	t2.setColumns(10);
	t2.setBounds(300, 80, 184, 30);
	contentPane.add(t2);
        
        JLabel l3 = new JLabel("Father's Name");
	l3.setForeground(new Color(15,19,42));
	l3.setFont(new Font("sitka text",Font.BOLD,17));
	l3.setBounds(50, 135, 150, 28);
	contentPane.add(l3);


	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("sitka text",Font.PLAIN,17));
	t3.setColumns(10);
	t3.setBounds(300, 135, 184, 30);
	contentPane.add(t3);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student where rollno = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("fathers_name"));
            }
        }catch(Exception e){}
        
        JLabel l7 = new JLabel("Course");
	l7.setForeground(new Color(15,19,42));
	l7.setFont(new Font("sitka text",Font.BOLD,17));
	l7.setBounds(50, 190, 150, 28);
	contentPane.add(l7);

	comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(
			new String[] { "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "MCA" }));
	comboBox_3.setForeground(new Color(47, 79, 79));
	comboBox_3.setFont(new Font("sitka text",Font.PLAIN,17));
	comboBox_3.setBounds(300, 190, 184, 30);
	contentPane.add(comboBox_3);
        
        JLabel l4 = new JLabel("Branch");
	l4.setForeground(new Color(15,19,42));
	l4.setFont(new Font("sitka text",Font.BOLD,17));
	l4.setBounds(50, 245, 150, 28);
	contentPane.add(l4);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Mechanical", "CSE", "IT", "Civil", "Automobile", "Electronics", "Other" }));
	comboBox.setForeground(new Color(47, 79, 79));
	comboBox.setFont(new Font("sitka text",Font.PLAIN,17));
	comboBox.setBounds(300, 245, 184, 30);
	contentPane.add(comboBox);

        
        
        JLabel l5 = new JLabel("Semester");
	l5.setForeground(new Color(15,19,42));
	l5.setFont(new Font("sitka text",Font.BOLD,17));
	l5.setBounds(50, 300, 150, 28);
	contentPane.add(l5);
        
	comboBox_2 = new JComboBox();
	comboBox_2.setModel(
			new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
	comboBox_2.setFont(new Font("sitka text",Font.PLAIN,17));
	comboBox_2.setForeground(new Color(47, 79, 79));
	comboBox_2.setBounds(300, 300, 184, 30);
	contentPane.add(comboBox_2);
        
        JLabel l6 = new JLabel("Total Payable");
	l6.setForeground(new Color(15,19,42));
	l6.setFont(new Font("sitka text",Font.BOLD,17));
	l6.setBounds(50, 360, 150, 28);
	contentPane.add(l6);
        
        t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("sitka text",Font.PLAIN,17));
	t1.setColumns(10);
	t1.setBounds(300, 355, 184, 30);
        add(t1);
        
	b1 = new JButton("Pay");
	b1.addActionListener(this);
	
	b1.setBounds(150, 450, 111, 50);
         b1.setFont(new Font("sitka text",Font.BOLD,17));
        b1.addActionListener(this);
        b1.setBackground(new Color(15,19,42));
        b1.setForeground(Color.WHITE);
        add(b1);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	
	b2.setBounds(340, 450, 111, 50);
       b2.setFont(new Font("sitka text",Font.BOLD,17));
        b2.setBackground(new Color(15,19,42));
        b2.setForeground(Color.WHITE);
        add(b2);

	contentPane.add(b2);

	

	JPanel panel = new JPanel();
	
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10, 38, 358, 348);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);

    }

    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                Conn con = new Conn();
                String sql = "insert into fee(rollno, name, fathers_name, course, branch, semester, fee_paid) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, c1.getSelectedItem());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());
		st.setString(4, (String) comboBox_3.getSelectedItem());
		st.setString(5, (String) comboBox.getSelectedItem());
		st.setString(6, (String) comboBox_2.getSelectedItem());
		st.setString(7, t1.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Paid");
                    this.setVisible(false);
                }
		else
                    JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception e){
            
        }
    }
}

