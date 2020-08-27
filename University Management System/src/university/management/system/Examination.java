package university.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Examination extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1, b2, b3;

    public void Book() {
        try {
            Conn con = new Conn();
            String sql = "select * from addstudent";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {
        }

    }

    public Examination() {

        setBounds(70, 70, 930, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 1080, 282);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 10).toString());
            }
        });

        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("sitka text", Font.BOLD, 17));
        scrollPane.setViewportView(table);

        b1 = new JButton("Result");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(59, 174, 255), 2, true));
        b1.setBackground(new Color(20, 107, 202));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sitka text", Font.BOLD, 17));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

        JLabel l1 = new JLabel("Check Result");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sitka text", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);

        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(59, 174, 255), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("sitka text", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("sitka text", Font.BOLD, 18));
        l3.setBounds(97, 89, 72, 33);
        contentPane.add(l3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(20, 107, 202), 3, true), "Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 174, 239)));
        panel.setBounds(67, 54, 1100, 368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        Book();
        setSize(1200, 500);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) {
                new Marks(search.getText()).setVisible(true);
                this.setVisible(false);
            };
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new Examination().setVisible(true);
    }
}
