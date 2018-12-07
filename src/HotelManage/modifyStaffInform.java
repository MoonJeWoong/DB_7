package HotelManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static HotelManage.Hotel.defaultTableModel;
public class modifyStaffInform implements ActionListener {
    private JFrame frame = new JFrame("직원정보");
    private JPanel mainPanel = new JPanel();
    private JLabel name = new JLabel("이름");
    private JLabel email = new JLabel("이메일");
    private JLabel address = new JLabel("주소");
    private JLabel postCode = new JLabel("우편번호");
    private JLabel phone = new JLabel("번호");
    private JLabel salary = new JLabel("연봉");
    private JButton modifyButton = new JButton("수정");

    private JTextField nameInput = new JTextField();
    private JTextField emailInput = new JTextField();
    private JTextField addressInput = new JTextField();
    private JTextField postCodeInput = new JTextField();
    private JTextField phoneInput = new JTextField();
//    private JComboBox<String> positionInput = new JComboBox<>();
    private JTextField salaryInput = new JTextField();
    private Connection dbTest;
    private int row;
    private Object stfId;

    public modifyStaffInform(Connection dbTest, int row){
        this.dbTest = dbTest;
        this.row = row;
        prepareGUI();
    }

    private void prepareGUI(){
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//        positionInput.addItem("Manager");
//        positionInput.addItem("Staff");
//        positionInput.addItem("Housekeeper");
//        positionInput.addItem("Accountant");

        mainPanel.setLayout(null);
        name.setBounds(40, 20, 70, 30);
        email.setBounds(40, 60, 70, 30);
        address.setBounds(40, 100, 70, 30);
        postCode.setBounds(40, 140, 70, 30);
        phone.setBounds(40, 180, 70, 30);
        salary.setBounds(40, 220, 70, 30);

        nameInput.setBounds(100, 20, 130, 30);
        emailInput.setBounds(100, 60, 130, 30);
        addressInput.setBounds(100, 100, 130, 30);
        postCodeInput.setBounds(100, 140, 130, 30);
        phoneInput.setBounds(100, 180, 130, 30);
//        positionInput.setBounds(100, 300, 130, 30);
        salaryInput.setBounds(100, 220, 130, 30);

        modifyButton.setBounds(160, 260, 70, 30);

        try {
            stfId = defaultTableModel.getValueAt(row, 0);
            PreparedStatement staffstmt = dbTest.prepareStatement("select * from Staff where StaffID = '" + stfId + "'");
            ResultSet staffrs = staffstmt.executeQuery();

            while (staffrs.next()) {
                nameInput.setText(staffrs.getString("DName"));
                emailInput.setText(staffrs.getString("EmailAddress"));
                addressInput.setText(staffrs.getString("Address"));
                postCodeInput.setText(staffrs.getString("PostCode"));
                phoneInput.setText(staffrs.getString("PhoneNo"));
                salaryInput.setText(staffrs.getString("Salary"));
            }

            staffrs.close();
            staffstmt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        mainPanel.add(name);
        mainPanel.add(email);
        mainPanel.add(address);
        mainPanel.add(postCode);
        mainPanel.add(phone);
        mainPanel.add(salary);

        mainPanel.add(nameInput);
        mainPanel.add(emailInput);
        mainPanel.add(addressInput);
        mainPanel.add(postCodeInput);
        mainPanel.add(phoneInput);
        mainPanel.add(salaryInput);

        mainPanel.add(modifyButton);

        modifyButton.addActionListener(this);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==modifyButton){

            String staffQuery;
            PreparedStatement staffstmt;
            ResultSet staffrs;
            try {
                String newstaffname = nameInput.getText();
                String newemail = emailInput.getText();
                String newaddress = addressInput.getText();
                String newpostcode = postCodeInput.getText();
                String newphone = phoneInput.getText();
                Integer newsalary = Integer.parseInt(salaryInput.getText());

                staffQuery = "update Staff set DName = '"+newstaffname+"', EmailAddress = '"+newemail+"', Address = '"+
                        newaddress+"', PostCode = '"+newpostcode+"', PhoneNo = '"+newphone+"', Salary = "+newsalary+
                        "where StaffID = '"+stfId+"'";
                staffstmt = dbTest.prepareStatement(staffQuery);
                staffrs = staffstmt.executeQuery();

                defaultTableModel.setValueAt(newstaffname, row, 1);
                defaultTableModel.setValueAt(newaddress, row, 2);
                defaultTableModel.setValueAt(newpostcode, row, 3);
                defaultTableModel.setValueAt(newphone,row, 4);
                defaultTableModel.setValueAt(newemail,row, 5);
                defaultTableModel.setValueAt(newsalary, row, 6);
                defaultTableModel.fireTableDataChanged();
                staffrs.close();
                staffstmt.close();
                frame.dispose();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
