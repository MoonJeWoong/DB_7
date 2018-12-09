package HotelManage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer_List implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    JScrollPane scroll = new JScrollPane();
    private JButton reload = new JButton("Reload");
    private static Connection dbTest;


    private void createTable() throws SQLException {
        Object header[] = {"CustomerID", "Name", "Address", "Postcode", "Phone No", "Email", "CustomerPoints", "CustomerType", "PaymentMethod"};
        Object contents[][] = {};
        DefaultTableModel defaultTableModel= new DefaultTableModel(contents, header);
        JTable CustomerInform = new JTable(defaultTableModel){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };

        String sqlStr = "select * from Customer";
        PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            String CustomerID = rs.getString("CustomerID");
            String name = rs.getString("Name");
            String address = rs.getString("Address");
            String postcode = rs.getString("Postcode");
            String phone = rs.getString("PhoneNo");
            String email = rs.getString("EmailAddress");
            Integer CustomerPoints = rs.getInt("CustomerPoints");
            String CustomerType = rs.getString("CustomerType");
            String PaymentMethod = rs.getString("PaymentMethod");

            Object data[] = {CustomerID, name, address, postcode, phone, email, CustomerPoints, CustomerType, PaymentMethod};
            defaultTableModel.addRow(data);
        }

        CustomerInform.setBounds(100, 100, 800, 400);
        scroll.setViewportView(CustomerInform);

        rs.close();
        stmt.close();
    }




    public Customer_List(Connection dbTest) {

        this.dbTest = dbTest;

        panel.setBorder(new TitledBorder("Customer List"));
        panel.setBounds(380, 80, 1000, 1000);
        panel.setLayout(null);


        reload.setBounds(1500, 65, 80, 30);
        reload.setVisible(true);
        reload.addActionListener(this);




        scroll.setBounds(100, 100, 1500, 800);

        panel.add(scroll); //scroll.setBounds�� �����ؾ� ��ġ �� ������ ���� ������
        panel.add(reload);

        frame.add(panel);

        frame.setTitle("회원관리 페이지");
        frame.setSize(1800, 1000); //�׵θ� ������
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reload) {
            try {
                createTable();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
