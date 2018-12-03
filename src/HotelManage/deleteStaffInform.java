package HotelManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteStaffInform implements ActionListener {
    private JFrame frame = new JFrame("직원정보 삭제");
    private JPanel mainPanel = new JPanel();
    private JLabel staffID = new JLabel("직원 ID");
    private JTextField staffIDInput = new JTextField();
    private JButton deleteButton = new JButton("삭제");

    public deleteStaffInform(){
        prepareGUI();
    }

    private void prepareGUI(){
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(null);
        staffID.setBounds(25, 20, 70, 30);
        staffIDInput.setBounds(100, 20, 150, 30);
        deleteButton.setBounds(180, 60, 70, 30);

        deleteButton.addActionListener(this);

        mainPanel.add(staffID);
        mainPanel.add(staffIDInput);
        mainPanel.add(deleteButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == deleteButton){
            // delete staff's inform
            frame.dispose();
        }
    }
}
