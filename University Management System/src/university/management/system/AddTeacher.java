package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class AddTeacher implements ActionListener {

    JFrame f;
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb15, lb16, lb17, lab, lab1, lab2;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton btn, btn1, btn2, btn3;
    JComboBox c1, c2;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);

    AddTeacher() {
        f = new JFrame("Add Teacher");
        f.setBackground(Color.white);
        f.setLayout(null);

        lb15 = new JLabel();
        lb15.setBounds(0, 0, 900, 700);
        lb15.setLayout(null);

        lb8 = new JLabel("New Teacher Details");
        lb8.setBounds(320, 30, 500, 50);
        lb8.setFont(new Font("Sitka Text", Font.BOLD, 25));
        lb8.setForeground(new Color(0, 102, 102));
        lb15.add(lb8);
        f.add(lb15);

        lb1 = new JLabel("Name:");
        lb1.setBounds(50, 150, 100, 30);
        lb1.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb1);

        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        lb15.add(t1);

        lb2 = new JLabel("Father's Name:");
        lb2.setBounds(400, 150, 200, 30);
        lb2.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb2);

        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        lb15.add(t2);

        lb3 = new JLabel("Age:");
        lb3.setBounds(50, 200, 100, 30);
        lb3.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb3);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        lb15.add(t3);

        lb4 = new JLabel("DOB(yyyy-mm-dd):");
        lb4.setBounds(400, 200, 200, 30);
        lb4.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb4);

        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        lb15.add(t4);

        lb5 = new JLabel("Address:");
        lb5.setBounds(50, 250, 100, 30);
        lb5.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb5);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        lb15.add(t5);

        lb6 = new JLabel("Phone No.:");
        lb6.setBounds(400, 250, 100, 30);
        lb6.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb6);

        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        lb15.add(t6);

        lb7 = new JLabel("Email Id:");
        lb7.setBounds(50, 300, 100, 30);
        lb7.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb7);

        t7 = new JTextField();
        t7.setBounds(200, 300, 150, 30);
        lb15.add(t7);

        lb8 = new JLabel("Class X(%):");
        lb8.setBounds(400, 300, 130, 30);
        lb8.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb8);

        t8 = new JTextField();
        t8.setBounds(600, 300, 150, 30);
        lb15.add(t8);

        lb9 = new JLabel("Class XII(%):");
        lb9.setBounds(50, 350, 130, 30);
        lb9.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb9);

        t9 = new JTextField();
        t9.setBounds(200, 350, 150, 30);
        lb15.add(t9);

        lb10 = new JLabel("Aadhar No.:");
        lb10.setBounds(400, 350, 130, 30);
        lb10.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb10);

        t10 = new JTextField();
        t10.setBounds(600, 350, 150, 30);
        lb15.add(t10);

        lab = new JLabel("Qualification:");
        lab.setBounds(50, 400, 150, 30);
        lab.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lab);

        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "BA", "BCom"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 400, 150, 30);
        lb15.add(c1);

        lab2 = new JLabel("Department:");
        lab2.setBounds(400, 400, 150, 30);
        lab2.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lab2);

        String branch[] = {"Computer Science", "Electronics", "Electrical", "Mechanical", "Civil"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(600, 400, 150, 30);
        lb15.add(c2);

        lb11 = new JLabel("Employee Id:");
        lb11.setBounds(400, 450, 150, 30);
        lb11.setFont(new Font("Sitka Text", Font.BOLD, 18));
        lb15.add(lb11);

        t11 = new JTextField();
        t11.setText("101" + first);
        t11.setBounds(600, 450, 150, 30);
        lb15.add(t11);

        btn = new JButton("Submit");
        btn.setBackground(new Color(15, 19, 42));
        btn.setForeground(Color.WHITE);
        btn.setBounds(250, 550, 150, 40);

        lb15.add(btn);

        btn1 = new JButton("Cancel");
        btn1.setBackground(new Color(15, 19, 42));
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(450, 550, 150, 40);
        lb15.add(btn1);

        btn.addActionListener(this);
        btn1.addActionListener(this);

        f.setVisible(true);
        f.setSize(900, 700);
        f.setLocation(400, 150);
        f.getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {

        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = (String) c1.getSelectedItem();
        String l = t11.getText();
        String m = (String) c2.getSelectedItem();

        if (ae.getSource() == btn) {
            try {
                Conn cc = new Conn();
                String q = "insert into addteacher values('" + a + "','" + bb + "','" + c + "','" + d + "','" + e + "','" + ff + "','" + g + "','" + h + "','" + i + "','" + j + "','" + k + "','" + l + "','" + m + "')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                f.setVisible(false);

            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        } else if (ae.getSource() == btn1) {
            f.setVisible(false);
            new Dashboard().setVisible(true);

        }
    }

    public static void main(String[] arg) {
        new AddTeacher().f.setVisible(true);
    }
}
