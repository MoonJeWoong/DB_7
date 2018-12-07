package HotelManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteStaffInform implements ActionListener {
    private JFrame frame = new JFrame("직원정보 삭제");
    private JPanel mainPanel = new JPanel();
    private JLabel alert = new JLabel("삭제되었습니다.");
    private JButton okButton= new JButton("확인");

    public deleteStaffInform(){
        prepareGUI();
    }

    private void prepareGUI(){
        frame.setSize(190, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(null);
        alert.setBounds(40, 10, 150, 30);
        okButton.setBounds(55, 50, 70, 30);
        okButton.addActionListener(this);

        mainPanel.add(alert);
        mainPanel.add(okButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==okButton){
            frame.dispose();
        }
    }
}
