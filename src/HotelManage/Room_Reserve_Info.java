package HotelManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Room_Reserve_Info implements ActionListener {

    private static Connection dbTest;

    private JFrame frame = new JFrame();
    private JFrame RmNm_PopUp_frame = new JFrame();
    private JFrame ReservationRegister_PopUp_frame = new JFrame();
    private JFrame ReservationRegisterCancel_PopUp_frame = new JFrame();

    private JButton PopUpRegistrationButton = new JButton("확인");
    private JButton PopUpCancelButton = new JButton("확인");
    private JButton ReserveRegistrationButton = new JButton("등록");
    private JButton ReserveRegistrationCancelButton = new JButton("취소");
    private JButton RmNbSearchButton = new JButton("검색");
    private JButton RmSearchButton = new JButton("검색");


    JTextField RRPF_BookingID_Box = new JTextField();
    JTextField RRPF_CustomerID_Box = new JTextField();
    JTextField RRPF_RoomID_Box = new JTextField();
    JTextField RRPF_BookingDate_Box = new JTextField();
    JTextField RRPF_CheckInDate_Box = new JTextField();
    JTextField RRPF_CheckOutDate_Box = new JTextField();
    JTextField RRPF_Nights_Box = new JTextField();
    JTextField RRPF_Comments_Box = new JTextField();
    JTextField RRPF_BookType_Box = new JTextField();
    JTextField RRPF_BookTotalCost_Box = new JTextField();
    JTextField RRPF_BookingStatus_Box = new JTextField();
    JTextField RRPF_TotalAdults_Box = new JTextField();
    JTextField RRPF_TotalChildrens_Box = new JTextField();
    JTextField RRPF_TotalRooms_Box = new JTextField();

    JTextField RRCP_BookingIDBox = new JTextField();

    String[] RMSCH_Description={"DOUBLE", "TWIN", "TRIPLE"};
    JComboBox RMSCH_DescriptionBox= new JComboBox(RMSCH_Description);
    String[] RMSCH_type={"standard", "superior", "deluxe", "suite"};
    JComboBox RMSCH_RoomTypeBox= new JComboBox(RMSCH_type);
    JScrollPane RMSCH_scroll = new JScrollPane();

    JTextField RNSCH_RoomNumbBox = new JTextField();
    JTextField RNSCH_RoomTypeBox = new JTextField();
    JTextField RNSCH_RoomMaxPersonBox = new JTextField();
    JTextField RNSCH_RoomOccupiedBox = new JTextField();
    JTextField RNSCH_RoomDescriptionBox = new JTextField();
    JTextField RoomNumbInput = new JTextField();
    JScrollPane RNSCH_Facility_area = new JScrollPane();
    String RoomTypeDescription = new String("");

    String room[] = new String[100];
    String columns [] = {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String contents [][] = {
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"101", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"102", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"103", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"104", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"105", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"106", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"107", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"108", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"109", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"201", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"202", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"203", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"204", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"205", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"206", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"207", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"208", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"209", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"301", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"302", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"303", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"304", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"305", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"306", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"307", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"308", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"309", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"401", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"402", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"403", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"404", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"405", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"406", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"407", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"408", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"409", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"501", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"502", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"503", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"504", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"505", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"506", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"507", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"508", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"509", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"601", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"602", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"603", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"604", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"605", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"606", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"607", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"608", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"609", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"701", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"702", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"703", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"704", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"705", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"706", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"707", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"708", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"709", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"801", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"802", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"803", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"804", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"805", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"806", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"807", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"808", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"809", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"901", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"902", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"903", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"904", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"905", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"906", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"907", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"908", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"909", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1001", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1002", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1003", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1004", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1005", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1006", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1007", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1008", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
            {"1009", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
    };
    private JTable Reservetable = new JTable(contents, columns);

    public void RmNb_PopUp() {
        RmNm_PopUp_frame.setTitle("ȣ�� �˻�");
        RmNm_PopUp_frame.setBounds(880, 175, 300, 500);
        RmNm_PopUp_frame.setLayout(null);

        JLabel RoomNumb = new JLabel("Room Number");
        RoomNumb.setBounds(30, 30, 100, 40);
        JLabel RoomType = new JLabel("Type");
        RoomType.setBounds(55, 70, 100, 40);
        JLabel RoomMaxPerson = new JLabel("MaxPerson");
        RoomMaxPerson.setBounds(40, 110, 100, 40);
        JLabel RoomMaxOccupied = new JLabel("Occupied");
        RoomMaxOccupied.setBounds(53, 150, 100, 40);
        JLabel RoomDescription = new JLabel("Description");
        RoomDescription.setBounds(40, 190, 100, 40);



        RNSCH_RoomNumbBox.setBounds(140, 40, 70, 20);
        RNSCH_RoomNumbBox.setText(RoomNumbInput.getText());
        RNSCH_RoomNumbBox.setHorizontalAlignment(JTextField.CENTER);
        RNSCH_RoomNumbBox.setEditable(false);

        RNSCH_RoomTypeBox.setBounds(140, 80, 70, 20);
        RNSCH_RoomTypeBox.setHorizontalAlignment(JTextField.CENTER);
        RNSCH_RoomTypeBox.setEditable(false);

        RNSCH_RoomMaxPersonBox.setBounds(140, 120, 70, 20);
        RNSCH_RoomMaxPersonBox.setHorizontalAlignment(JTextField.CENTER);
        RNSCH_RoomMaxPersonBox.setEditable(false);

        RNSCH_RoomOccupiedBox.setBounds(140, 160, 70, 20);
        RNSCH_RoomOccupiedBox.setHorizontalAlignment(JTextField.CENTER);
        RNSCH_RoomOccupiedBox.setEditable(false);

        RNSCH_RoomDescriptionBox.setBounds(140, 200, 70, 20);
        RNSCH_RoomDescriptionBox.setHorizontalAlignment(JTextField.CENTER);
        RNSCH_RoomDescriptionBox.setEditable(false);


        RNSCH_Facility_area.setBounds(20, 230, 250, 200);


        RmNbSearchButton.addActionListener(this);


        RmNm_PopUp_frame.add(RoomNumb);
        RmNm_PopUp_frame.add(RoomType);
        RmNm_PopUp_frame.add(RoomMaxPerson);
        RmNm_PopUp_frame.add(RoomMaxOccupied);
        RmNm_PopUp_frame.add(RoomDescription);

        RmNm_PopUp_frame.add(RNSCH_RoomNumbBox);
        RmNm_PopUp_frame.add(RNSCH_RoomTypeBox);
        RmNm_PopUp_frame.add(RNSCH_RoomMaxPersonBox);
        RmNm_PopUp_frame.add(RNSCH_RoomOccupiedBox);
        RmNm_PopUp_frame.add(RNSCH_RoomDescriptionBox);

        RmNm_PopUp_frame.add(RNSCH_Facility_area);

        RmNm_PopUp_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RmNm_PopUp_frame.setVisible(false);
                RmNm_PopUp_frame.dispose();
            }
        });

        RmNm_PopUp_frame.setVisible(true);
    }

    public void RoomInfo_Search() throws SQLException {
        String sqlStr = "select * from Room where RoomID = '" + RoomNumbInput.getText() + "'";
        System.out.println(sqlStr);
        PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            RoomTypeDescription = rs.getString("RoomType");
            RNSCH_RoomTypeBox.setText(rs.getString("RoomType"));
            String Maxperson = String.valueOf(rs.getInt("MaxPerson"));
            RNSCH_RoomMaxPersonBox.setText(Maxperson);
            RNSCH_RoomOccupiedBox.setText(rs.getString("Occupied"));
            RNSCH_RoomDescriptionBox.setText(rs.getString("Description"));
        }

        rs.close();
        stmt.close();
    }

    public void setRoomFacility() throws SQLException {
        Object header[] = {"FacName", "FacPrice", "Quantity"};
        Object contents[][] = {};
        DefaultTableModel defaultTableModel= new DefaultTableModel(contents, header);
        JTable RoomFacilityInform = new JTable(defaultTableModel){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };

        String sqlStr2 = "select * from RoomFacility where RoomType = '" + RoomTypeDescription + "'";
        System.out.println(sqlStr2);
        PreparedStatement stmt2 = dbTest.prepareStatement(sqlStr2);
        ResultSet rs2 = stmt2.executeQuery();
        System.out.println(rs2.next());
        while(rs2.next()) {
            String RoomFacName = rs2.getString("RoomFacName");
            System.out.println(RoomFacName);
            String RoomFacPrice = String.valueOf(rs2.getInt("RoomFacPrice"));
            String Quantity = String.valueOf(rs2.getInt("Quantity"));

            Object data[] = {RoomFacName, RoomFacPrice, Quantity};
            defaultTableModel.addRow(data);
        }

        RNSCH_Facility_area.setViewportView(RoomFacilityInform);

        rs2.close();
        stmt2.close();
    }


    public void ReservationRegister_PopUp() {
        ReservationRegister_PopUp_frame.setTitle("예약 등록");
        ReservationRegister_PopUp_frame.setBounds(1185, 50, 350, 700);
        ReservationRegister_PopUp_frame.setLayout(null);

        JLabel BookingID = new JLabel("Booking ID");
        JLabel CustomerID = new JLabel("Customer ID");
        JLabel RoomID = new JLabel("RoomID");
        JLabel BookingDate = new JLabel("Booking Date");
        JLabel CheckInDate = new JLabel("Check in Date");
        JLabel CheckOutDate = new JLabel("Check Out Date");
        JLabel Nights = new JLabel("Nights");
        JLabel Comments = new JLabel("Comments");
        JLabel BookType = new JLabel("Book Type");
        JLabel BookTotalCost = new JLabel("Book Total Cost");
        JLabel BookingStatus = new JLabel("Booking Status");
        JLabel TotalAdults = new JLabel("Total Adults");
        JLabel TotalChildrens = new JLabel("Total Childrens");
        JLabel TotalRooms = new JLabel("Total Rooms");

        BookingID.setBounds(45, 30, 100, 40);
        CustomerID.setBounds(45, 70, 100, 40);
        RoomID.setBounds(45, 110, 100, 40);
        BookingDate.setBounds(45, 150, 100, 40);
        CheckInDate.setBounds(45, 190, 100, 40);
        CheckOutDate.setBounds(45, 230, 100, 40);
        Nights.setBounds(45, 270, 100, 40);
        Comments.setBounds(45, 310, 100, 40);
        BookType.setBounds(45, 350, 100, 40);
        BookTotalCost.setBounds(45, 390, 100, 40);
        BookingStatus.setBounds(45, 430, 100, 40);
        TotalAdults.setBounds(45, 470, 100, 40);
        TotalChildrens.setBounds(45, 510, 100, 40);
        TotalRooms.setBounds(45, 550, 100, 40);

        RRPF_BookingID_Box.setBounds(140, 40, 70, 20);
        RRPF_CustomerID_Box.setBounds(140, 80, 70, 20);
        RRPF_RoomID_Box.setBounds(140, 120, 70, 20);
        RRPF_BookingDate_Box.setBounds(140, 160, 70, 20);
        RRPF_CheckInDate_Box.setBounds(140, 200, 70, 20);
        RRPF_CheckOutDate_Box.setBounds(140, 240, 70, 20);
        RRPF_Nights_Box.setBounds(140, 280, 70, 20);
        RRPF_Comments_Box.setBounds(140, 320, 70, 20);
        RRPF_BookType_Box.setBounds(140, 360, 70, 20);
        RRPF_BookTotalCost_Box.setBounds(140, 400, 70, 20);
        RRPF_BookingStatus_Box.setBounds(140, 440, 70, 20);
        RRPF_TotalAdults_Box.setBounds(140, 480, 70, 20);
        RRPF_TotalChildrens_Box.setBounds(140, 520, 70, 20);
        RRPF_TotalRooms_Box.setBounds(140, 560, 70, 20);



        PopUpRegistrationButton.setBounds(230, 600, 60, 30);
        PopUpRegistrationButton.addActionListener(this);

        ReservationRegister_PopUp_frame.add(BookingID);
        ReservationRegister_PopUp_frame.add(CustomerID);
        ReservationRegister_PopUp_frame.add(RoomID);
        ReservationRegister_PopUp_frame.add(BookingDate);
        ReservationRegister_PopUp_frame.add(CheckInDate);
        ReservationRegister_PopUp_frame.add(CheckOutDate);
        ReservationRegister_PopUp_frame.add(Nights);
        ReservationRegister_PopUp_frame.add(Comments);
        ReservationRegister_PopUp_frame.add(BookType);
        ReservationRegister_PopUp_frame.add(BookTotalCost);
        ReservationRegister_PopUp_frame.add(BookingStatus);
        ReservationRegister_PopUp_frame.add(TotalAdults);
        ReservationRegister_PopUp_frame.add(TotalChildrens);
        ReservationRegister_PopUp_frame.add(TotalRooms);


        ReservationRegister_PopUp_frame.add(RRPF_BookingID_Box);
        ReservationRegister_PopUp_frame.add(RRPF_CustomerID_Box);
        ReservationRegister_PopUp_frame.add(RRPF_RoomID_Box);
        ReservationRegister_PopUp_frame.add(RRPF_BookingDate_Box);
        ReservationRegister_PopUp_frame.add(RRPF_CheckInDate_Box);
        ReservationRegister_PopUp_frame.add(RRPF_CheckOutDate_Box);
        ReservationRegister_PopUp_frame.add(RRPF_Nights_Box);
        ReservationRegister_PopUp_frame.add(RRPF_Comments_Box);
        ReservationRegister_PopUp_frame.add(RRPF_BookType_Box);
        ReservationRegister_PopUp_frame.add(RRPF_BookTotalCost_Box);
        ReservationRegister_PopUp_frame.add(RRPF_BookingStatus_Box);
        ReservationRegister_PopUp_frame.add(RRPF_TotalAdults_Box);
        ReservationRegister_PopUp_frame.add(RRPF_TotalChildrens_Box);
        ReservationRegister_PopUp_frame.add(RRPF_TotalRooms_Box);


        ReservationRegister_PopUp_frame.add(PopUpRegistrationButton);

        ReservationRegister_PopUp_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ReservationRegister_PopUp_frame.setVisible(false);
                ReservationRegister_PopUp_frame.dispose();
            }
        });
        ReservationRegister_PopUp_frame.setVisible(true);
    }


    public void ReserveRegistrationCancel_PopUp() {
        ReservationRegisterCancel_PopUp_frame.setTitle("예약취소");
        ReservationRegisterCancel_PopUp_frame.setBounds(1185, 50, 250, 300);
        ReservationRegisterCancel_PopUp_frame.setLayout(null);

        JLabel BookingID = new JLabel("BookingID");
        BookingID.setBounds(30, 30, 100, 40);


        RRCP_BookingIDBox.setBounds(140, 40, 70, 20);

        PopUpCancelButton.addActionListener(this);
        PopUpCancelButton.setBounds(150, 200, 60, 30);

        ReservationRegisterCancel_PopUp_frame.add(BookingID);

        ReservationRegisterCancel_PopUp_frame.add(RRCP_BookingIDBox);

        ReservationRegisterCancel_PopUp_frame.add(PopUpCancelButton);

        ReservationRegisterCancel_PopUp_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ReservationRegisterCancel_PopUp_frame.setVisible(false);
                ReservationRegisterCancel_PopUp_frame.dispose();
            }
        });
        ReservationRegisterCancel_PopUp_frame.setVisible(true);
    }


    public void InsertReservation() throws SQLException {

        String BookingID = (String) RRPF_BookingID_Box.getText();
        String CustomerID = (String) RRPF_CustomerID_Box.getText();
        String RoomID = (String) RRPF_RoomID_Box.getText();
        String BookingDate = (String) RRPF_BookingDate_Box.getText();
        String CheckInDate = (String) RRPF_CheckInDate_Box.getText();
        String CheckOutDate = (String) RRPF_CheckOutDate_Box.getText();
        String Nights = (String) RRPF_Nights_Box.getText();
        String Comments = (String) RRPF_Comments_Box.getText();
        String BookType = (String) RRPF_BookType_Box.getText();
        String BookTotalCost = (String) RRPF_BookTotalCost_Box.getText();
        String BookingStatus = (String) RRPF_BookingStatus_Box.getText();
        String TotalAdults = (String) RRPF_TotalAdults_Box.getText();
        String TotalChildrens = (String) RRPF_TotalChildrens_Box.getText();
        String TotalRooms = (String) RRPF_TotalRooms_Box.getText();


        String sqlStr = "INSERT INTO BOOKINGINFO VALUES ('" + BookingID + "', '" + CustomerID + "', '" + RoomID + "', '" + BookingDate + "', '" + CheckInDate + "', '" + CheckOutDate + "', " + Nights + ", '" + Comments  + "', '" + BookType + "', " + BookTotalCost + ", " + BookingStatus + ", " + TotalAdults + ", " + TotalChildrens + ", " + TotalRooms +")";
        System.out.println(sqlStr);
        Statement stmt = dbTest.createStatement();
        int cnt = stmt.executeUpdate(sqlStr);
        System.out.println(cnt>0?"등록성공":"등록실패");

    }


    public void RemoveReservation() throws SQLException {
        String RRCP_BookingID = (String) RRCP_BookingIDBox.getText();

        String sqlStr = "DELETE FROM BOOKINGINFO WHERE BOOKINGID = '" + RRCP_BookingID + "'";
        System.out.println(sqlStr);
        Statement stmt = dbTest.createStatement();
        int cnt = stmt.executeUpdate(sqlStr);
        System.out.println(cnt>0?"취소 성공":"취소 실패");
    }

    private void createRoomTable() throws SQLException {
        Object header[] = {"RoomID", "RoomType", "MaxPerson", "HotelID", "Status", "Occupied", "Description"};
        Object contents[][] = {};
        DefaultTableModel defaultTableModel= new DefaultTableModel(contents, header);
        JTable RoomInform = new JTable(defaultTableModel){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };


        String box_RoomType = (String) RMSCH_RoomTypeBox.getSelectedItem();
        String box_Description = ((String) RMSCH_DescriptionBox.getSelectedItem()).toUpperCase();

        String sqlStr = "select * from Room where RoomType = '" + box_RoomType + "' and Description = '" + box_Description + "'";
        System.out.println(sqlStr);
        PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            String RoomID = rs.getString("RoomID");
            String RoomType = rs.getString("RoomType");
            String MaxPerson = rs.getString("MaxPerson");
            String HotelID = rs.getString("HotelID");
            String Status = rs.getString("Status");
            String Occupied = rs.getString("Occupied");
            String Description = rs.getString("Description");

            Object data[] = {RoomID, RoomType, MaxPerson, HotelID, Status, Occupied, Description};
            defaultTableModel.addRow(data);
        }

        RMSCH_scroll.setViewportView(RoomInform);

        rs.close();
        stmt.close();
    }

    private void CheckRegistration() throws Exception {

        int checkindateInput = Integer.parseInt(RRPF_CheckInDate_Box.getText());
        int checkOutdateInput = Integer.parseInt(RRPF_CheckOutDate_Box.getText());

        String sqlStr = "select count(*) as num from BookingInfo where roomID = '" + RRPF_RoomID_Box.getText() + "' and CheckinDate <= " + checkindateInput + " and CheckOutDate >= " + checkindateInput + " or (CheckOutDate >= " + checkOutdateInput + "and CheckinDate <= " + checkOutdateInput + ") or (CheckOutDate <= " + checkOutdateInput + "and CheckinDate >= " + checkindateInput + ")";
        System.out.println(sqlStr);
        PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int number = rs.getInt("num");
        if(number > 0) {
            throw new Exception();
        }
        else {

        }


    }


    public Room_Reserve_Info(Connection dbTest) {
        this.dbTest = dbTest;
        //��ü �� �г� ����
        JTabbedPane tPane = new JTabbedPane();

        //������� �� �г� �����
        JPanel ReservationPanel = new JPanel();
        ReservationPanel.setLayout(null);
        JScrollPane scroll = new JScrollPane(Reservetable);
        scroll.setBounds(20, 20, 1000, 600);
        JButton ReserveRegistration = ReserveRegistrationButton;
        ReserveRegistration.setBounds(1070, 30, 70, 20);
        ReserveRegistration.addActionListener(this);

        JButton ReserveRegistrationCancel = ReserveRegistrationCancelButton;
        ReserveRegistrationCancel.setBounds(1070, 70, 70, 20);
        ReserveRegistrationCancel.addActionListener(this);

        ReservationPanel.add(scroll);
        ReservationPanel.add(ReserveRegistration);
        ReservationPanel.add(ReserveRegistrationCancel);



        //�˻� �� �г� �����
        JPanel SearchPanel = new JPanel();
        SearchPanel.setLayout(null);

        JLabel RoomTypeLabel = new JLabel("@ Room Type");
        RoomTypeLabel.setBounds(195, 28, 100, 40);

        RMSCH_RoomTypeBox.setBounds(190, 60, 100, 40);

        JLabel DescriptionLabel = new JLabel("@ Description");
        DescriptionLabel.setBounds(485, 28, 100, 40);

        RMSCH_DescriptionBox.setBounds(480, 60, 100, 40);


        RmSearchButton.addActionListener(this);
        JButton RoomSearchButton = RmSearchButton;
        RoomSearchButton.setBounds(770, 80, 70, 20);

        JLabel RoomNumberLabel = new JLabel("@ Room Number");
        RoomNumberLabel.setBounds(900, 28, 100, 40);


        RoomNumbInput.setBounds(920, 60, 70, 30);


        RmNbSearchButton.setBounds(1020, 69, 70, 20);

        RmNbSearchButton.addActionListener(this);


        RMSCH_scroll.setBounds(20, 110, 850, 500);


        SearchPanel.add(RoomTypeLabel);
        SearchPanel.add(RMSCH_RoomTypeBox);
        SearchPanel.add(DescriptionLabel);
        SearchPanel.add(RMSCH_DescriptionBox);
        SearchPanel.add(RoomSearchButton);
        SearchPanel.add(RoomNumberLabel);
        SearchPanel.add(RoomNumbInput);
        SearchPanel.add(RmNbSearchButton);
        SearchPanel.add(RMSCH_scroll);

        for(int i=0;i<100;i++){
            if(i % 10 == 0){
                room[i] = "0";
            }
            else{
                room[i] = contents[i][0];
            }
        }
        for(int i=0;i<100;i++){
            System.out.println(i+" "+room[i]);
        }

        //���гο� �������, �˻� �г� �߰�
        tPane.addTab("예약관리", ReservationPanel);
        tPane.addTab("검색", SearchPanel);

        frame.setTitle("회원관리 페이지");
        frame.setSize(1200,750);
        frame.add(tPane);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RmNbSearchButton) {
            RmNb_PopUp();
            try {
                RoomInfo_Search();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                setRoomFacility();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == ReserveRegistrationButton) {
            ReservationRegister_PopUp();
        }
        else if (e.getSource() == ReserveRegistrationCancelButton) {
            ReserveRegistrationCancel_PopUp();
        }
        else if (e.getSource() == PopUpRegistrationButton) {
            try {
                CheckRegistration();
                InsertReservation();
            } catch (Exception e1) {
                System.out.println("Reservation Overlapped!!");
            }
//			try {
//				InsertReservation();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
        }
        else if (e.getSource() == PopUpCancelButton) {
            try {
                RemoveReservation();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == RmSearchButton) {
            try {
                createRoomTable();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }


}
