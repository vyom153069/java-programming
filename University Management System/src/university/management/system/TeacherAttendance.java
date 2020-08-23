package university.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherAttendance extends JFrame implements ActionListener{
    
    JLabel l0,l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
     private JPanel contentPane;
    
    TeacherAttendance(){
        super("Teacher Attendance");
        setBounds(600, 250, 606, 600);
	contentPane = new JPanel();

	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
       
        
        c2 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                c2.add(rs.getString("emp_id"));    
            }
      
      
       }catch(Exception e){ }
       
        l0=new JLabel("Select Roll Number");
        l0.setForeground(Color.BLACK);
	l0.setFont(new Font("sitka text",Font.BOLD,17));
	l0.setBounds(80, 80, 185, 26);
	contentPane.add(l0);
                              
         c2.setBounds(300, 80, 185, 30);
         c2.setFont(new Font("sitka text",Font.PLAIN,17));
        add(l0);
        
        add(c2);
      
        l1 = new JLabel("First Half");
        l1.setForeground(Color.BLACK);
	l1.setFont(new Font("sitka text",Font.BOLD,17));
	 l1.setBounds(80, 171, 185, 26);
   
        fh = new Choice();
        fh.setBounds(300, 171, 185, 30);
        fh.setFont(new Font("sitka text",Font.PLAIN,17));
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
       
        add(l1);
        add(fh);
        
        l2 = new JLabel("Second Half");
        l2.setForeground(Color.BLACK);
	l2.setFont(new Font("sitka text",Font.BOLD,17));
	l2.setBounds(80, 262, 185, 26);
	contentPane.add(l2);

        sh = new Choice();
         sh.setBounds(300, 262, 185, 30);
        sh.setFont(new Font("sitka text",Font.PLAIN,17));
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
       
       
       
        add(l2);
        add(sh);
       
        b1 =new JButton("Submit");
 
	
	   b1.setFont(new Font("sitka text",Font.BOLD,17));
	b1.setBounds(150, 400, 100, 50);
      
         b1.setBackground(new Color(15,19,42));
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

        
     
        b2 = new JButton("Back");
	
	   b2.setFont(new Font("sitka text",Font.BOLD,17));
	b2.setBounds(350, 400, 100, 50);
      
        b2.setBackground(new Color(15,19,42));
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
       
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = new java.util.Date().toString();
        String id=c2.getSelectedItem();
        String qry = "insert into attendance_teacher values("+ id +",'"+dt+"','"+f+"','"+s+"')";
       
        try{
            Conn c1 = new Conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Attendance confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public static void main(String s[]){
        new TeacherAttendance();
    }
}

