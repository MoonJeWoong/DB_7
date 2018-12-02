package HotelManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelInform {
    private JFrame frame;
    private JPanel panel1;
    private JTabbedPane HotelTabPane;
    private JLabel HotelImage;
    private JPanel HotelInfo;
    private JPanel StaffInfo;
    private JPanel HotelFacInfo;
    private JLabel FAX;
    private JLabel address;
    private JLabel name;
    private JLabel tel;
    private JButton EditButton;
    private JTextArea staffInform;
    private JLabel staffInfoLabel;
    private JButton hireButton;
    private JButton deleteButton;

    public HotelInform(){
        prepareGUI();
        createUIComponents();
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == EditButton){
                    //pop up window that can edit name, address, tel, FAX;
                }
            }
        });
        hireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == hireButton){
                    //pop-up the new hire page
                    new getStaffInform();
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==deleteButton){
                    //delete the selected staff's information
                }
            }
        });
    }

    private void prepareGUI(){
        frame = new JFrame("HOTEL");
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        frame.setVisible(true);

    }

    private void createUIComponents() {

        HotelImage = new JLabel(new ImageIcon("the-palm-962785_1920_1.png"));
    }


}
