package HotelManage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialMonitor implements ActionListener {
    private JFrame frame = new JFrame("MANAGE");
    private JPanel panel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JLabel hotel = new JLabel("HOTEL", JLabel.CENTER);
    private JLabel room = new JLabel("ROOM", JLabel.CENTER);
    private JLabel customer = new JLabel("CUSTOMER", JLabel.CENTER);
    private JButton basicmanageButton = new JButton("기초관리");
    private JButton accountButton = new JButton("정산관리");
    private JButton bookingButton = new JButton("예약관리");
    private JButton roomButton = new JButton("객실관리");
    private JButton customerButton = new JButton("회원관리");
    private String position;


    public InitialMonitor(String StaffPosition){
        this.position = StaffPosition;
        prepareGUI();
        showInitial();
    }

    private void prepareGUI(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(350, 170);
        mainPanel.setSize(350 ,170);

        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hotel.setHorizontalTextPosition(SwingConstants.CENTER);
        hotel.setVerticalTextPosition(SwingConstants.CENTER);

        basicmanageButton.addActionListener(this);
        accountButton.addActionListener(this);
        bookingButton.addActionListener(this);
        roomButton.addActionListener(this);
        customerButton.addActionListener(this);

        mainPanel.setLayout(new FlowLayout());
//        panel.setBounds(dim.width/2 - 145, dim.height/2-90, 500, 500);
        mainPanel.add(panel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showInitial(){
        GroupLayout layer = new GroupLayout(this.panel);
        layer.setAutoCreateGaps(true);
        layer.setAutoCreateContainerGaps(true);

        layer.setHorizontalGroup(layer.createSequentialGroup()
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(hotel)
                    .addComponent(basicmanageButton)
                    .addComponent(accountButton))
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(room)
                    .addComponent(bookingButton)
                    .addComponent(roomButton))
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(customer)
                    .addComponent(customerButton))
        );

        layer.setVerticalGroup(layer.createSequentialGroup()
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(hotel)
                .addComponent(room)
                .addComponent(customer))
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(basicmanageButton)
                .addComponent(bookingButton)
                .addComponent(customerButton))
            .addGroup(layer.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(accountButton)
                .addComponent(roomButton))
        );
        panel.setSize(295, 100);
        panel.setLayout(layer);
        TitledBorder title;
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        title = BorderFactory.createTitledBorder(blackline);
        panel.setBorder(title);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
//        if(position == "Manager"){
//            if(e.getSource() == basicmanageButton){
//                new Hotel();
//                //new window for basic management monitor
//            }
//            if(e.getSource() == accountButton){
//                new Hotel();
//                //new window for account manage monitor
//            }
//            if(e.getSource() == bookingButton){
//                new Hotel();
//                //new window for booking manage monitor
//            }
//            if(e.getSource() == roomButton){
//                new Hotel();
//                //new window for room manage monitor
//            }
//            if (e.getSource() == customerButton) {
//                new Hotel();
//                //new window for customer manage monitor
//            }
//        }
//        if(position == "Staff"){
//            if(e.getSource() == bookingButton){
//                new Hotel();
//                //new window for booking manage monitor
//            }
//            if(e.getSource() == roomButton){
//                new Hotel();
//                //new window for room manage monitor
//            }
//            if (e.getSource() == customerButton) {
//                new Hotel();
//                //new window for customer manage monitor
//            }
//        }
//        if(position == "Housekeeper"){
//            if(e.getSource() == roomButton){
//                new Hotel();
//                //new window for room manage monitor
//            }
//        }
//        if(position == "Accountant"){
//            if(e.getSource() == accountButton){
//                new Hotel();
//                // new window for room manage monitor
//            }
//        }
        if(e.getSource() == basicmanageButton){
            if(position.equals("Manager")){ new Hotel(); }
            if(position.equals("Staff")){ System.out.println("staff deny");}
            if(position.equals("Housekeeper")){System.out.println("housekeeper deny"); }
            if(position.equals("Accountant")){System.out.println("accountant deny"); }
            //new window for basic management monitor
        }
        if(e.getSource() == accountButton){
            if(position.equals("Manager")){System.out.println("account - manager");}
            if(position.equals("Staff")){System.out.println("staff deny");}
            if(position.equals("Housekeeper")){System.out.println("housekeeper deny");}
            if(position.equals("Accountant")){System.out.println("account - accountant");}
            //new window for account manage monitor
        }
        if(e.getSource() == bookingButton){
            if(position.equals("Manager")){System.out.println("booking - manager");}
            if(position.equals("Staff")){System.out.println("booking - staff");}
            if(position.equals("Housekeeper")){System.out.println("housekeeper deny");}
            if(position.equals("Accountant")){System.out.println("accountant deny");}
            //new window for booking manage monitor
        }
        if(e.getSource() == roomButton){
            if(position.equals("Manager")){System.out.println("room - manager");}
            if(position.equals("Staff")){System.out.println("room - staff");}
            if(position.equals("Housekeeper")){ System.out.println("room - housekeeper");}
            if(position.equals("Accountant")){System.out.println("accountant deny");}
            //new window for room manage monitor
        }
        if (e.getSource() == customerButton) {
            if(position.equals("Manager")){System.out.println("customer - manager");}
            if(position.equals("Staff")){System.out.println("customer - staff");}
            if(position.equals("Housekeeper")){System.out.println("housekeeper deny");}
            if(position.equals("Accountant")){System.out.println("accountant deny"); }
            //new window for customer manage monitor
        }
    }

}
