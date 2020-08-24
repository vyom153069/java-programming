 
package university.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){

      super("Login");

      setBackground(Color.white);
      
       

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(150,40,100,30);
        l1.setFont(new Font("sitka text",Font.BOLD,17));
        l1.setForeground(Color.black);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(150,90,100,30);
         l2.setFont(new Font("sitka text",Font.BOLD,17));
         l2.setForeground(Color.black);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(250,40,150,30);
         t1.setFont(new Font("sitka text",Font.PLAIN,17));
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(250,90,150,30);
         t2.setFont(new Font("sitka text",Font.PLAIN,17));
        add(t2);
        
       


        b1 = new JButton("Login");
        b1.setBounds(190,160,120,40);
        b1.setFont(new Font("sitka text",Font.BOLD,17));
        b1.addActionListener(this);
        b1.setBackground(new Color(15,19,42));
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Signup");
        b2.setBounds(340,160,120,40);
        b2.setFont(new Font("sitka text",Font.BOLD,17));
        b2.setBackground(new Color(15,19,42));
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(500,300);

    }

    public void actionPerformed(ActionEvent ae){
           
        if(ae.getSource()==b1){
        try{
            Conn c1 = new Conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from account where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
          if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
    }
    public static void main(String[] arg){
        Login l = new Login();
    }
}
