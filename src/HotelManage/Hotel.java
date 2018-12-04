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
    private JButton editButton = new JButton("Edit");
    private Image img = null;

    public Hotel(){
        prepareGUI();
    }

    private void prepareGUI(){
        frame.setSize(800, 540);
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        GridBagConstraints[] gbc = new GridBagConstraints[6];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<6;i++){
            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 0;
            gbc[i].gridy = i;
            gbc[i].gridwidth = 2;
        }

        JLabel image = new JLabel(new ImageIcon(img));

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

        gbc[5].gridx = 1;
        gbc[5].gridwidth = 1;
        editButton.addActionListener(this);

        panel.add(image, gbc[0]);
        panel.add(Hname, gbc[1]);
        panel.add(Haddress, gbc[2]);
        panel.add(telNo, gbc[3]);
        panel.add(faxNo, gbc[4]);
        panel.add(editButton, gbc[5]);

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
        //hire button
        gbc[1].insets = new Insets(5, 0, 5,2);
        gbc[1].weightx = 0.0;
        gbc[1].weighty = 0.0;
        gbc[1].gridx = 1;
        gbc[1].gridy = 0;
        //delete button
        gbc[2].insets = new Insets(5, 0, 5,25);
        gbc[2].weightx = 0.0;
        gbc[2].weighty = 0.0;
        gbc[2].gridx = 2;
        gbc[2].gridy = 0;
        //staff list
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
        deleteButton.addActionListener(this);

        return panel;
    }

    private JPanel HotelFacInform(){
        JPanel panel = new JPanel();
        GridBagConstraints[] gbc = new GridBagConstraints[6];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<6;i++){
            gbc[i] = new GridBagConstraints();
        }

        JLabel facManage = new JLabel("1. 부대시설 관리");
        gbc[0].insets = new Insets(10, 20, 10, 0);
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].weightx = 0.0;
        gbc[0].weighty = 0.0;
        panel.add(facManage, gbc[0]);

        JComboBox<String> HfacMng = new JComboBox<>();
        HfacMng.addItem("주차장");
        HfacMng.addItem("수영장");
        HfacMng.addItem("식당");
        HfacMng.addItem("헬스장");
        HfacMng.addItem("스키장");
        gbc[1].insets = new Insets(10, 10, 10, 20);
        gbc[1].gridx = 1;
        gbc[1].gridy = 0;
        gbc[0].weightx = 0.0;
        gbc[0].weighty = 0.0;
        panel.add(HfacMng, gbc[1]);

        JTextArea facInformation = new JTextArea();
        JScrollPane facInfoScroll = new JScrollPane(facInformation);
        facInfoScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        facInfoScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        gbc[2].insets = new Insets(10, 20, 5, 20);
        gbc[2].gridx = 0;
        gbc[2].gridy = 1;
        gbc[2].gridwidth=3;
        gbc[2].weightx = 1.0;
        gbc[2].weighty = 0.7;
        gbc[2].fill = GridBagConstraints.BOTH;
        panel.add(facInfoScroll, gbc[2]);

        JLabel roomInfo = new JLabel("2. 객실정보");
        gbc[3].insets = new Insets(10, 10, 10, 0);
        gbc[3].gridx = 0;
        gbc[3].gridy = 2;
        gbc[3].weightx = 0.0;
        gbc[3].weighty = 0.0;
        panel.add(roomInfo, gbc[3]);

        JPanel infoLabel = new JPanel();
        GridBagConstraints[] gbcinfo = new GridBagConstraints[11];
        infoLabel.setLayout(new GridBagLayout());
        for(int i=0;i<11;i++){
            gbcinfo[i] = new GridBagConstraints();
            gbcinfo[i].gridx = 0;
            gbcinfo[i].gridy = i;
        }
        JLabel roomInfoString1 = new JLabel("◈ 객실 총 갯수 : 100개");
        roomInfoString1.setHorizontalTextPosition(SwingConstants.LEFT);
        JLabel roomInfoString2 = new JLabel("-방 종류");
        roomInfoString2.setHorizontalTextPosition(SwingConstants.LEFT);
//        gbcinfo[1].gridx = 1;

        JLabel roomInfoString2_std = new JLabel("STANDARD ROOM : 40");
        JLabel roomInfoString2_dlx = new JLabel("DELUXE ROOM : 30");
        JLabel roomInfoString2_st = new JLabel("SUITE ROOM : 30");
//        for(int i=2;i<5;i++){
//            gbcinfo[i].gridx = 2;
//        }

        JLabel roomInfoString3 = new JLabel("-침대 수");
//        gbcinfo[5].gridx = 1;

        JLabel roomInfoString3_db = new JLabel("DOUBLE ROOM : 50", SwingConstants.LEFT);
        JLabel roomInfoString3_tw = new JLabel("TWIN ROOM : 30", SwingConstants.LEFT);
        JLabel roomInfoString3_tp = new JLabel("TRIPLE ROOM : 10", SwingConstants.LEFT);
        JLabel roomInfoString3_fm = new JLabel("FAMILY ROOM : 7", SwingConstants.LEFT);
        JLabel roomInfoString3_cn = new JLabel("Connecting ROOM : 3", SwingConstants.LEFT);
//        for(int i=6;i<11;i++){
//            gbcinfo[i].gridx = 2;
//        }
        infoLabel.add(roomInfoString1, gbcinfo[0]);
        infoLabel.add(roomInfoString2, gbcinfo[1]);
        infoLabel.add(roomInfoString2_std, gbcinfo[2]);
        infoLabel.add(roomInfoString2_dlx, gbcinfo[3]);
        infoLabel.add(roomInfoString2_st, gbcinfo[4]);
        infoLabel.add(roomInfoString3, gbcinfo[5]);
        infoLabel.add(roomInfoString3_db, gbcinfo[6]);
        infoLabel.add(roomInfoString3_tw, gbcinfo[7]);
        infoLabel.add(roomInfoString3_tp, gbcinfo[8]);
        infoLabel.add(roomInfoString3_fm, gbcinfo[9]);
        infoLabel.add(roomInfoString3_cn, gbcinfo[10]);

        gbc[4].insets = new Insets(0, 10, 10, 0);
        gbc[4].gridx = 0;
        gbc[4].gridy = 3;
        gbc[4].weightx = 1.0;
        gbc[4].weighty = 0.3;
        panel.add(infoLabel, gbc[4]);
        return panel;
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == hireButton){
            new getStaffInform();
        }
        if(e.getSource() == deleteButton){
            new deleteStaffInform();
            // delete the selected Staff's information
        }
        if(e.getSource() == editButton){
            // can edit hotel's information
        }
    }
}
