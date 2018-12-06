package HotelManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static HotelManage.Hotel.defaultTableModel;
public class getStaffInform implements ActionListener {
    private JFrame frame = new JFrame("직원정보");
    private JPanel mainPanel = new JPanel();
    private JLabel name = new JLabel("이름");
    private JLabel sex = new JLabel("성별");
    private JLabel sexF = new JLabel("여");
    private JLabel sexM = new JLabel("남");
    private JLabel registrationNo = new JLabel("주민번호");
    private JLabel bar = new JLabel("ㅡ");
    private JLabel email = new JLabel("이메일");
    private JLabel address = new JLabel("주소");
    private JLabel postCode = new JLabel("우편번호");
    private JLabel phone = new JLabel("번호");
    private JLabel position = new JLabel("직급");
    private JLabel salary = new JLabel("연봉");
    private JButton registerButton = new JButton("등록");

    private JTextField nameInput = new JTextField();
    private JRadioButton sexInputF = new JRadioButton("여", false);
    private JRadioButton sexInputM = new JRadioButton("남", false);
    private ButtonGroup sexGroup = new ButtonGroup();
    private JTextField registrationBirth = new JTextField();
    private JTextField registrationOnly = new JTextField();
    private JTextField emailInput = new JTextField();
    private JTextField addressInput = new JTextField();
    private JTextField postCodeInput = new JTextField();
    private JTextField phoneInput = new JTextField();
    private JComboBox<String> positionInput = new JComboBox<>();
    private JTextField salaryInput = new JTextField();
    private Connection dbTest;

    public getStaffInform(Connection dbTest){
        this.dbTest = dbTest;
        prepareGUI();
    }

    private void prepareGUI(){
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        positionInput.addItem("Manager");
        positionInput.addItem("Staff");
        positionInput.addItem("Housekeeper");
        positionInput.addItem("Accountant");

        mainPanel.setLayout(null);
        name.setBounds(40, 20, 70, 30);
        registrationNo.setBounds(40, 60, 70, 30);
        sex.setBounds(40, 100, 70, 30 );
        email.setBounds(40, 140, 70, 30);
        address.setBounds(40, 180, 70, 30);
        postCode.setBounds(40, 220, 70, 30);
        phone.setBounds(40, 260, 70, 30);
        position.setBounds(40, 300, 70, 30);
        salary.setBounds(40, 340, 70, 30);

        nameInput.setBounds(100, 20, 130, 30);
        registrationBirth.setBounds(100, 60, 50, 30);
        bar.setBounds(150, 60, 20, 30);
        registrationOnly.setBounds(165, 60, 65, 30);
        sexInputF.setBounds(100, 100, 20, 30);
        sexF.setBounds(125, 100, 20, 30);
        sexInputM.setBounds(145, 100, 20, 30);
        sexM.setBounds(170, 100, 20, 30);
        sexGroup.add(sexInputF);
        sexGroup.add(sexInputM);
        emailInput.setBounds(100, 140, 130, 30);
        addressInput.setBounds(100, 180, 130, 30);
        postCodeInput.setBounds(100, 220, 130, 30);
        phoneInput.setBounds(100, 260, 130, 30);
        positionInput.setBounds(100, 300, 130, 30);
        salaryInput.setBounds(100, 340, 130, 30);

        registerButton.setBounds(160, 380, 70, 30);

        mainPanel.add(name);
        mainPanel.add(registrationNo);
        mainPanel.add(sex);
        mainPanel.add(email);
        mainPanel.add(address);
        mainPanel.add(postCode);
        mainPanel.add(phone);
        mainPanel.add(position);
        mainPanel.add(salary);

        mainPanel.add(nameInput);
        mainPanel.add(registrationBirth);
        mainPanel.add(bar);
        mainPanel.add(registrationOnly);
        mainPanel.add(sexInputF);
        mainPanel.add(sexF);
        mainPanel.add(sexInputM);
        mainPanel.add(sexM);
        mainPanel.add(emailInput);
        mainPanel.add(addressInput);
        mainPanel.add(postCodeInput);
        mainPanel.add(phoneInput);
        mainPanel.add(positionInput);
        mainPanel.add(salaryInput);

        mainPanel.add(registerButton);

        registerButton.addActionListener(this);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==registerButton){
            try {
//                Integer StaffOrder;
//                String jquery = "select count(*) as rs from Staff";
//                PreparedStatement stmt = dbTest.prepareStatement(jquery);
//                ResultSet rs = stmt.executeQuery();
//
//                rs.next();
//                StaffOrder = rs.getInt("rs");

                String jquery = "(select StaffId from Staff) minus (select StaffId from Staff where rownum < (select count(*) as rs from Staff))";
                PreparedStatement stmt = dbTest.prepareStatement(jquery);
                ResultSet rs = stmt.executeQuery();

                rs.next();
                Integer number = rs.getInt("StaffId") % 1000 + 1;

                System.out.println(number);

               Integer staffID = Integer.parseInt(registrationBirth.getText())*1000+number;
                jquery = "INSERT INTO Staff VALUES("+staffID+", '"+nameInput.getText()+"', '"+
                        addressInput.getText()+"', "+postCodeInput.getText()+", '"+phoneInput.getText()+"', '"+emailInput.getText()+"', '0000', "+
                        salaryInput.getText()+""+", '"+positionInput.getSelectedItem()+"', 0, null)";
                stmt = dbTest.prepareStatement(jquery);
                rs = stmt.executeQuery();

                rs = stmt.executeQuery("(select * from Staff) minus (select * from Staff where rownum < (select count(*) from Staff))");
                while(rs.next()){
                    Integer staffid = staffID;
                    String name = rs.getString("DName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("PhoneNo");
                    String email = rs.getString("EmailAddress");
                    Integer salary = rs.getInt("Salary");
                    String position = rs.getString("DPosition");

                    Object data[] = {staffid, name, address, phone, email, salary, position};
                    defaultTableModel.addRow(data);
                }
                defaultTableModel.fireTableDataChanged();

                rs.close();
                stmt.close();
                frame.dispose();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
