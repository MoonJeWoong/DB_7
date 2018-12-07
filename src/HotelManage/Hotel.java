package HotelManage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hotel implements ActionListener{
    private JFrame frame = new JFrame("HOTEL");
    private JButton hireButton = new JButton("New");
    private JButton deleteButton = new JButton("Delete");
    private JButton modifyButton = new JButton("Modify");
    private JButton insertButton = new JButton("New");
    private JButton changeButton = new JButton("Revise");
    public static JTable staffInform;
    private Image img = null;
    private Connection dbTestHotel;
    public static DefaultTableModel defaultTableModel;
    private DefaultTableModel defaultmodel;
    private JTable facInformation;
    private JTextField FacNameInput = new JTextField();
    private JTextField priceInput = new JTextField();
    private JLabel FacName = new JLabel("시설 이름");
    private JLabel price = new JLabel("가격");
    private JButton acceptButton = new JButton("확인");
    private JButton reviseButton = new JButton("수정");
    private JFrame insrtFrame = new JFrame("시설 정보");
    private JFrame rvsFrame = new JFrame("정보 수정");

    public Hotel(Connection dbTest){
        this.dbTestHotel = dbTest;
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
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<5;i++){
            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 0;
            gbc[i].gridy = i;
            gbc[i].gridwidth = 2;
        }

        JLabel image = new JLabel(new ImageIcon(img));

        String HotelID = "1234567890";
        String name, address, code, no;
        try {
            String HotelSql = "select * from Hotel where HOTELID = '" + HotelID + "'";
            PreparedStatement Hotelstmt = dbTestHotel.prepareStatement(HotelSql);
            ResultSet Hotelrs = Hotelstmt.executeQuery();

            while (Hotelrs.next()) {
                name = Hotelrs.getString("DNAME");
                address = Hotelrs.getString("ADDRESS");
                code = Hotelrs.getString("PostCode");
                no = Hotelrs.getString("PhoneNo");

                JLabel Hname = new JLabel(name);
                Hname.setFont(new Font("맑은 고딕", Font.BOLD, 30));
                Hname.setForeground(Color.decode("#ffb437"));
                JLabel Haddress = new JLabel(address);
                String tel = "Tel No. ";
                String telNum = tel + no;
                JLabel telNo = new JLabel(telNum);
                String post = "PostCode : ";
                String postcode = post + code;
                JLabel pCode = new JLabel(postcode);

                panel.add(image, gbc[0]);
                panel.add(Hname, gbc[1]);
                panel.add(Haddress, gbc[2]);
                panel.add(telNo, gbc[3]);
                panel.add(pCode, gbc[4]);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return panel;
    }

    private void initShowStaff() throws SQLException {
        Object header[] = {"Staff ID", "Name", "Address", "Postcode", "Phone No", "Email", "Salary", "Position"};
        Object contents[][] = {};
        defaultTableModel= new DefaultTableModel(contents, header);
        staffInform = new JTable(defaultTableModel){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        String staffQuery = "select * from Staff";
        PreparedStatement staffStmt = dbTestHotel.prepareStatement(staffQuery);
        ResultSet staffrs = staffStmt.executeQuery();

        while(staffrs.next()){
            Integer staffid = staffrs.getInt("StaffID");
            String name = staffrs.getString("DName");
            String address = staffrs.getString("Address");
            String postcode = staffrs.getString("PostCode");
            String phone = staffrs.getString("PhoneNo");
            String email = staffrs.getString("EmailAddress");
            Integer salary = staffrs.getInt("Salary");
            String position = staffrs.getString("DPosition");

            Object data[] = {staffid, name, address, postcode, phone, email, salary, position};
            defaultTableModel.addRow(data);
        }
        staffrs.close();
        staffStmt.close();
    }

    private JPanel StaffInform(){
        JPanel panel = new JPanel();
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<5;i++){
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
        gbc[2].gridx = 3;
        gbc[2].gridy = 0;
        //modify button
        gbc[4].insets = new Insets(5, 0, 5, 2);
        gbc[4].weighty = 0.0;
        gbc[4].weightx = 0.0;
        gbc[4].gridx = 2;
        gbc[4].gridy = 0;
        //staff list
        try {
            initShowStaff();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(staffInform);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        gbc[3].insets = new Insets(0,25,30,25);
        gbc[3].weightx = 1.0;
        gbc[3].weighty = 1.0;
        gbc[3].gridx = 0;
        gbc[3].gridy = 1;
        gbc[3].gridwidth = 4;
        gbc[3].fill = GridBagConstraints.BOTH;


        panel.add(staffInfoLabel, gbc[0]);
        panel.add(hireButton, gbc[1]);
        panel.add(deleteButton, gbc[2]);
        panel.add(scrollPane, gbc[3]);
        panel.add(modifyButton, gbc[4]);

        hireButton.addActionListener(this);
        deleteButton.addActionListener(this);
        modifyButton.addActionListener(this);

        return panel;
    }

    private void initShowHFac() throws SQLException{
        Object col_name[] = {"Facility ID", "Name", "Price"};
        Object rows[][] = {};

        defaultmodel = new DefaultTableModel(rows, col_name);
        facInformation = new JTable(defaultmodel){
            public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };

        String HFacQuery = "select * from HotelFacility";
        PreparedStatement HFacstmt = dbTestHotel.prepareStatement(HFacQuery);
        ResultSet HFacrs = HFacstmt.executeQuery();

        while(HFacrs.next()){
            String HFacID = HFacrs.getString("HotelFacID");
            String HFacName = HFacrs.getString("HotelFacName");
            Integer HFacPrice = HFacrs.getInt("HotelFacPrice");

            Object data[] = {HFacID, HFacName, HFacPrice};
            defaultmodel.addRow(data);
        }

        HFacrs.close();
        HFacstmt.close();
    }

    private JPanel HotelFacInform(){
        JPanel panel = new JPanel();
        GridBagConstraints[] gbc = new GridBagConstraints[8];
        panel.setLayout(new GridBagLayout());

        for(int i=0;i<8;i++){
            gbc[i] = new GridBagConstraints();
        }

        JLabel facManage = new JLabel("1. 부대시설 관리");
        facManage.setAlignmentX(JLabel.LEFT);
        gbc[0].insets = new Insets(10, 20, 10, 0);
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].weightx = 1.0;
        gbc[0].weighty = 0.0;
        panel.add(facManage, gbc[0]);

        // Hotel Facility Insert Button
        gbc[6].gridx = 2;
        gbc[6].gridy = 0;
        gbc[6].weightx = 0.0;
        gbc[6].weighty = 0.0;
        gbc[6].insets = new Insets(10, 20, 5, 20);
        panel.add(insertButton, gbc[6]);
        insertButton.addActionListener(this);

        // Hotel Facility change Button
        gbc[7].gridx = 3;
        gbc[7].gridy = 0;
        gbc[7].weightx = 0.0;
        gbc[7].weighty = 0.0;
        gbc[7].insets = new Insets(10, 0, 5, 20);
        panel.add(changeButton, gbc[7]);
        changeButton.addActionListener(this);

        try{
            initShowHFac();
        } catch(SQLException se){
            se.printStackTrace();
        }
        JScrollPane facInfoScroll = new JScrollPane(facInformation);
        facInfoScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        facInfoScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        gbc[2].insets = new Insets(10, 20, 5, 20);
        gbc[2].gridx = 0;
        gbc[2].gridy = 1;
        gbc[2].gridwidth = 4;
        gbc[2].weightx = 1.0;
        gbc[2].weighty = 0.7;
        gbc[2].fill = GridBagConstraints.BOTH;
        panel.add(facInfoScroll, gbc[2]);

        JLabel roomInfo = new JLabel("2. 객실정보");
//        gbc[3].insets = new Insets(10, 10, 10, 0);
        gbc[3].gridx = 0;
        gbc[3].gridy = 2;
        gbc[3].weightx = 1.0;
        panel.add(roomInfo, gbc[3]);


        JTextArea roomInfoText = new JTextArea();
        roomInfoText.setEditable(false);
        String info = "◈ 객실 총 갯수 : 90개\n";
        info+= "   -방종류\n";

        try{
            String roomSql = "select count(*) as cnt from Room where RoomType = 'standard'";
            PreparedStatement roomstmt = dbTestHotel.prepareStatement(roomSql);
            ResultSet roomRs = roomstmt.executeQuery();

            roomRs.next();
            Integer numbr = roomRs.getInt("cnt");
            String roomInfoString2_std = "STANDARD : " + numbr.toString();

            info += "     " + roomInfoString2_std + "\n";

            roomSql = "select count(*) as cnt from Room where RoomType = 'deluxe'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString2_dlx = "DELUXE : " + numbr.toString();

            info += "     " + roomInfoString2_dlx + "\n";

            roomSql = "select count(*) as cnt from Room where RoomType = 'superior'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString2_sp = "SUPERIOR : " + numbr.toString();

            info += "     " + roomInfoString2_sp + "\n";

            roomSql = "select count(*) as cnt from Room where RoomType = 'suite'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString2_st = "SUITE : " + numbr.toString();

            info += "     " + roomInfoString2_st + "\n";

            info += "   -침대수\n";

            roomSql = "select count(*) as cnt from Room where Description = 'DOUBLE'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString3_db = "DOUBLE : " + numbr.toString();

            info += "     " + roomInfoString3_db + "\n";

            roomSql = "select count(*) as cnt from Room where Description = 'TWIN'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString3_tw = "TWIN : " + numbr.toString();

            info += "     " + roomInfoString3_tw + "\n";

            roomSql = "select count(*) as cnt from Room where Description = 'TRIPLE'";
            roomstmt = dbTestHotel.prepareStatement(roomSql);
            roomRs = roomstmt.executeQuery();

            roomRs.next();
            numbr = roomRs.getInt("cnt");
            String roomInfoString3_tp = "TRIPLE : " + numbr.toString();

            info += "     " + roomInfoString3_tp + "\n";

            roomInfoText.setText(info);

        } catch(SQLException se){
            se.printStackTrace();
        }

        gbc[4].insets = new Insets(10, 20, 10, 20);
        gbc[4].gridx = 0;
        gbc[4].gridy = 3;
        gbc[4].gridwidth = 4;
        gbc[4].weightx = 1.0;
        gbc[4].weighty = 0.3;
        gbc[4].fill = GridBagConstraints.BOTH;
        panel.add(roomInfoText, gbc[4]);
        return panel;
    }

    private void facWindow(){
        FacNameInput.setText(null);
        priceInput.setText(null);
        insrtFrame.setSize(300, 130);
        JPanel insrtPanel = new JPanel();

        insrtFrame.setLocationRelativeTo(null);
        insrtPanel.setLayout(null);

        FacName.setBounds(10, 10, 100, 30);
        FacNameInput.setBounds(90, 10, 100, 30);

        price.setBounds(10, 50, 100, 30);
        priceInput.setBounds(90, 50, 100, 30);

        acceptButton.setBounds(200, 30, 70, 30);
        acceptButton.addActionListener(this);

        insrtPanel.add(FacName);
        insrtPanel.add(FacNameInput);
        insrtPanel.add(price);
        insrtPanel.add(priceInput);
        insrtPanel.add(acceptButton);

        insrtFrame.add(insrtPanel);
        insrtFrame.setVisible(true);
    }

    private void facReviseWindow(){
        FacNameInput.setText(null);
        priceInput.setText(null);

        rvsFrame.setSize(300, 130);
        rvsFrame.setLocationRelativeTo(null);

        JPanel rvsPanel = new JPanel();
        rvsPanel.setLayout(null);

        FacName.setBounds(10, 10, 100, 30);
        FacNameInput.setBounds(90, 10, 100, 30);

        price.setBounds(10, 50, 100, 30);
        priceInput.setBounds(90, 50, 100, 30);

        reviseButton.setBounds(200, 30, 70, 30);
        reviseButton.addActionListener(this);

        rvsPanel.add(FacName);
        rvsPanel.add(FacNameInput);
        rvsPanel.add(price);
        rvsPanel.add(priceInput);
        rvsPanel.add(reviseButton);

        rvsFrame.add(rvsPanel);
        rvsFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        //STAFF
        if(e.getSource() == hireButton){
            new getStaffInform(dbTestHotel);
        }
        int row = staffInform.getSelectedRow();
        if(row!=-1){
            if(e.getSource() == deleteButton){
                try{
                    Object staffID = staffInform.getValueAt(row, 0);
                    String delquery = "delete from Staff where StaffId = "+staffID;
                    PreparedStatement stmt = dbTestHotel.prepareStatement(delquery);
                    ResultSet rs = stmt.executeQuery();

                    defaultTableModel.removeRow(row);

                    new deleteStaffInform();
                } catch(SQLException se){
                    se.printStackTrace();
                }
            }
            if(e.getSource() == modifyButton){
                System.out.println(row);
                new modifyStaffInform(dbTestHotel, row);
            }
        }

        //Hotel Facility
        if(e.getSource() == insertButton){
            facWindow();
        }
        if(e.getSource() == acceptButton){
            try{
                String sqlquery = "select count(*) as cnt from HotelFacility";
                PreparedStatement sqlstmt = dbTestHotel.prepareStatement(sqlquery);
                ResultSet sqlrs = sqlstmt.executeQuery();
                sqlrs.next();
                Integer cnt = sqlrs.getInt("cnt")+1;

                String cnts = cnt.toString();
                String id = "";
                for(int i=0;i<9-cnts.length();i++){
                    id+="0";
                }
                id += cnts;
                sqlrs.close();
                sqlstmt.close();

                String newSql = "insert into HotelFacility values('"+id+ "', '"+FacNameInput.getText()+"', "+priceInput.getText()+")";
                PreparedStatement newstmt = dbTestHotel.prepareStatement(newSql);
                ResultSet newrs = newstmt.executeQuery();

                newrs = newstmt.executeQuery("(select * from Staff) minus (select * from Staff where rownum < (select count(*) from Staff))");
                while(newrs.next()){
                    Object data[] = {id, FacNameInput.getText(), priceInput.getText()};
                    defaultmodel.addRow(data);
                }
                defaultmodel.fireTableDataChanged();

                newrs.close();
                newstmt.close();

                insrtFrame.dispose();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        int facrow = facInformation.getSelectedRow();
        if(facrow != -1){
            if(e.getSource() == changeButton){
                facReviseWindow();
                Object FacId = defaultmodel.getValueAt(facrow, 0);
                String facQuery;
                PreparedStatement facstmt;
                ResultSet facrs;
                try{
                    facQuery = "select * from HotelFacility where HotelFacID = '" + FacId +"'";
                    facstmt = dbTestHotel.prepareStatement(facQuery);
                    facrs = facstmt.executeQuery();

                    facrs.next();
                    String facNamer = facrs.getString("HotelFacName");
                    Integer facPrice = facrs.getInt("HotelFacPrice");

                    FacNameInput.setText(facNamer);
                    priceInput.setText(facPrice.toString());
                } catch(SQLException se){
                    se.printStackTrace();
                }
            }

            if (e.getSource() == reviseButton) {
                Object FacId = defaultmodel.getValueAt(facrow, 0);
                String facQuery;
                PreparedStatement facstmt;
                ResultSet facrs;
                try {
                    String newFacName = FacNameInput.getText();
                    String newPrice = priceInput.getText();
                    facQuery = "update HotelFacility set HotelFacName = '" + newFacName + "', HotelFacPrice = " + newPrice + " where HotelFacID = '" + FacId + "'";
                    facstmt = dbTestHotel.prepareStatement(facQuery);
                    facrs = facstmt.executeQuery();

                    defaultmodel.setValueAt(newFacName, facrow, 1);
                    defaultmodel.setValueAt(newPrice, facrow, 2);
                    defaultmodel.fireTableDataChanged();
                    facrs.close();
                    facstmt.close();
                    rvsFrame.dispose();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
