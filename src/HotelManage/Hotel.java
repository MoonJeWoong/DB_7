package HotelManage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Hotel implements ActionListener{
    private JFrame frame = new JFrame("HOTEL");
    private JButton hireButton = new JButton("New");
    private JButton deleteButton = new JButton("Delete");
    private Image img = null;

    public Hotel(){
        prepareGUI();
        showHotelManage();

    }

    private void prepareGUI(){
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            File sourceimage = new File("C:\\Users\\kimjiwoo\\OneDrive\\문서\\PROGRAMMING\\2학년\\2_데이터베이스\\DBPBL\\src\\HotelManage\\the-palm-962785_1920_1.png");
            img = ImageIO.read(sourceimage);
        } catch (IOException e){
            System.out.println("이미지파일이 없습니다.");
        }

        JTabbedPane HotelTab = new JTabbedPane();

        HotelTab.addTab("자사정보관리", HotelInform());
        HotelTab.addTab("직원정보", StaffInform());
        HotelTab.addTab("호텔상품", HotelFacInform());

        frame.add(HotelTab);
        frame.setVisible(true);
//        frame.setResizable(true);
    }

    private JPanel HotelInform(){
        JPanel panel = new JPanel();
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<5;i++){
            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 0;
            gbc[i].gridy = i;
        }

        JLabel image = new JLabel(new ImageIcon(img));
//        image.setBounds(640,360,640,360);

        String name = " Atlantis the Palm, Dubai";
        JLabel Hname = new JLabel(name);

        String address = "Address : Jumeirah Palm";
        JLabel Haddress = new JLabel(address);

        String tel = "Tel No. ";
        String no = "000-0000-0000";
        String telNum = tel + no;
        JLabel telNo = new JLabel(telNum);

        String fax = "FAX: ";
        String fno = "000-000-0000";
        String FaxNum = fax + fno;
        JLabel faxNo = new JLabel(FaxNum);

//        image.setBounds(640,100,640,360);
//        Hname.setBounds(700,500,300,100);
//        Haddress.setBounds(700, 610, 300, 100);
//        telNo.setBounds(700,720,300,100);
//        faxNo.setBounds(700,830,300,100);
//
        panel.add(image, gbc[0]);
        panel.add(Hname, gbc[1]);
        panel.add(Haddress, gbc[2]);
        panel.add(telNo, gbc[3]);
        panel.add(faxNo, gbc[4]);

        return panel;

    }

    private JPanel StaffInform(){
        JPanel panel = new JPanel();
        GridBagConstraints[] gbc = new GridBagConstraints[4];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<4;i++){
            gbc[i] = new GridBagConstraints();
        }
        JLabel staffInfoLabel = new JLabel("직원 목록");
        staffInfoLabel.setHorizontalAlignment(2);
        staffInfoLabel.setVerticalAlignment(0);
        gbc[0].insets = new Insets(5, 0, 5, 0);
        gbc[0].weightx = 1.0;
        gbc[0].weighty = 0.0;
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;


        hireButton.setHorizontalAlignment(0);
        hireButton.setVerticalAlignment(0);
        gbc[1].insets = new Insets(5, 0, 5,2);
        gbc[1].weightx = 0.0;
        gbc[1].weighty = 0.0;
        gbc[1].gridx = 1;
        gbc[1].gridy = 0;


        gbc[2].insets = new Insets(5, 0, 5,25);
        gbc[2].weightx = 0.0;
        gbc[2].weighty = 0.0;
        gbc[2].gridx = 2;
        gbc[2].gridy = 0;

        JTextArea staffInform = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(staffInform);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        gbc[3].insets = new Insets(0,25,30,25);
        gbc[3].weightx = 1.0;
        gbc[3].weighty = 1.0;
        gbc[3].gridx = 0;
        gbc[3].gridy = 1;
        gbc[3].gridwidth = 3;
        gbc[3].fill = GridBagConstraints.BOTH;

        panel.add(staffInfoLabel, gbc[0]);
        panel.add(hireButton, gbc[1]);
        panel.add(deleteButton, gbc[2]);
        panel.add(scrollPane, gbc[3]);

        hireButton.addActionListener(this);

        return panel;
    }

    private JPanel HotelFacInform(){
        JPanel panel = new JPanel();

        return panel;
    }

    private void showHotelManage(){

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == hireButton){
            new getStaffInform();
        }
        if(e.getSource() == deleteButton){
            // delete the selected Staff's information
        }
    }
}
