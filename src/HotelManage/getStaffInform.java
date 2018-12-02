package HotelManage;

import javax.swing.*;

public class getStaffInform {
    private JFrame frame = new JFrame("직원정보");
    private JLabel name = new JLabel("이름");
    private JLabel sex = new JLabel("성별");
    private JLabel email = new JLabel("이메일");
    private JLabel address = new JLabel("주소");
    private JLabel phone = new JLabel("번호");
    private JLabel position = new JLabel("직급");

    private JTextField nameInput = new JTextField();
    private JRadioButton sexInputF = new JRadioButton("여");
    private JRadioButton sexInputM = new JRadioButton("남");
    private JTextField emailInput = new JTextField();
    private JTextField addressInput = new JTextField();
    private JTextField phoneInput = new JTextField();
    private JComboBox<String> positionInput = new JComboBox<String>();


    public getStaffInform(){
        prepareGUI();
        showWindow();
    }

    private void prepareGUI(){
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        positionInput.addItem("Manager");
        positionInput.addItem("Staff");
        positionInput.addItem("Housekeeper");
        positionInput.addItem("Accountant");

        frame.setVisible(true);
    }

    private void showWindow(){

    }
}
