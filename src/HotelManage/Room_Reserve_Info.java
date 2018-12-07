package HotelManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Room_Reserve_Info implements ActionListener {

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

    String columns [] = {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String contents [][] = {
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

    };
    private JTable Reservetable = new JTable(contents, columns);

    public void RmNb_PopUp() {
        RmNm_PopUp_frame.setTitle("호실 검색");
        RmNm_PopUp_frame.setBounds(880, 175, 300, 500);
        RmNm_PopUp_frame.setLayout(null);

        JLabel RoomNumb = new JLabel("Room Number");
        RoomNumb.setBounds(30, 30, 100, 40);
        JLabel RoomType = new JLabel("Type");
        RoomType.setBounds(55, 70, 100, 40);
        JLabel RoomMaxPerson = new JLabel("MaxPerson");
        RoomMaxPerson.setBounds(40, 110, 100, 40);
        JLabel RoomMaxPrice = new JLabel("Price");
        RoomMaxPrice.setBounds(53, 150, 100, 40);
        JLabel RoomFacility = new JLabel("Facility");
        RoomFacility.setBounds(110, 190, 100, 40);

        JTextField RoomNumbBox = new JTextField();
        RoomNumbBox.setBounds(140, 40, 70, 20);
        JTextField RoomTypeBox = new JTextField();
        RoomTypeBox.setBounds(140, 80, 70, 20);
        JTextField RoomMaxPersonBox = new JTextField();
        RoomMaxPersonBox.setBounds(140, 120, 70, 20);
        JTextField RoomPriceBox = new JTextField();
        RoomPriceBox.setBounds(140, 160, 70, 20);
        JTextField RoomFacilityBox = new JTextField();
        RoomFacilityBox.setBounds(140, 160, 70, 20);

        JTextArea Facility_area = new JTextArea();
        Facility_area.setBounds(20, 230, 230, 200);


        RmNm_PopUp_frame.add(RoomNumb);
        RmNm_PopUp_frame.add(RoomType);
        RmNm_PopUp_frame.add(RoomMaxPerson);
        RmNm_PopUp_frame.add(RoomMaxPrice);
        RmNm_PopUp_frame.add(RoomFacility);
        RmNm_PopUp_frame.add(RoomNumbBox);
        RmNm_PopUp_frame.add(RoomTypeBox);
        RmNm_PopUp_frame.add(RoomMaxPersonBox);
        RmNm_PopUp_frame.add(RoomPriceBox);
        RmNm_PopUp_frame.add(Facility_area);

        RmNm_PopUp_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RmNm_PopUp_frame.setVisible(false);
                RmNm_PopUp_frame.dispose();
            }
        });

        RmNm_PopUp_frame.setVisible(true);
    }


    public void ReservationRegister_PopUp() {
        ReservationRegister_PopUp_frame.setTitle("예약 등록");
        ReservationRegister_PopUp_frame.setBounds(1185, 50, 250, 250);
        ReservationRegister_PopUp_frame.setLayout(null);

        JLabel Name = new JLabel("Name");
        Name.setBounds(60, 30, 100, 40);
        JLabel Check_In = new JLabel("Check in");
        Check_In.setBounds(55, 70, 100, 40);
        JLabel Check_Out = new JLabel("Check_Out");
        Check_Out.setBounds(50, 110, 100, 40);

        JTextField NameBox = new JTextField();
        NameBox.setBounds(140, 40, 70, 20);
        JTextField Check_In_Box = new JTextField();
        Check_In_Box.setBounds(140, 80, 70, 20);
        JTextField Check_Out_Box = new JTextField();
        Check_Out_Box.setBounds(140, 120, 70, 20);

        PopUpRegistrationButton.setBounds(150, 160, 60, 30);

        ReservationRegister_PopUp_frame.add(Name);
        ReservationRegister_PopUp_frame.add(Check_In);
        ReservationRegister_PopUp_frame.add(Check_Out);
        ReservationRegister_PopUp_frame.add(NameBox);
        ReservationRegister_PopUp_frame.add(Check_In_Box);
        ReservationRegister_PopUp_frame.add(Check_Out_Box);
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
        ReservationRegisterCancel_PopUp_frame.setTitle("예약 취소");
        ReservationRegisterCancel_PopUp_frame.setBounds(1185, 50, 250, 300);
        ReservationRegisterCancel_PopUp_frame.setLayout(null);

        JLabel BookingID = new JLabel("BookingID");
        BookingID.setBounds(30, 30, 100, 40);
        JLabel Name = new JLabel("Name");
        Name.setBounds(45, 70, 100, 40);
        JLabel Check_In = new JLabel("Check in");
        Check_In.setBounds(40, 110, 100, 40);
        JLabel Check_Out = new JLabel("Check_Out");
        Check_Out.setBounds(30, 150, 100, 40);

        JTextField BookingIDBox = new JTextField();
        BookingIDBox.setBounds(140, 40, 70, 20);
        JTextField NameBox = new JTextField();
        NameBox.setBounds(140, 80, 70, 20);
        JTextField Check_In_Box = new JTextField();
        Check_In_Box.setBounds(140, 120, 70, 20);
        JTextField Check_Out_Box = new JTextField();
        Check_Out_Box.setBounds(140, 160, 70, 20);

        PopUpCancelButton.setBounds(150, 200, 60, 30);

        ReservationRegisterCancel_PopUp_frame.add(BookingID);
        ReservationRegisterCancel_PopUp_frame.add(Name);
        ReservationRegisterCancel_PopUp_frame.add(Check_In);
        ReservationRegisterCancel_PopUp_frame.add(Check_Out);
        ReservationRegisterCancel_PopUp_frame.add(BookingIDBox);
        ReservationRegisterCancel_PopUp_frame.add(NameBox);
        ReservationRegisterCancel_PopUp_frame.add(Check_In_Box);
        ReservationRegisterCancel_PopUp_frame.add(Check_Out_Box);
        ReservationRegisterCancel_PopUp_frame.add(PopUpCancelButton);

        ReservationRegisterCancel_PopUp_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ReservationRegisterCancel_PopUp_frame.setVisible(false);
                ReservationRegisterCancel_PopUp_frame.dispose();
            }
        });
        ReservationRegisterCancel_PopUp_frame.setVisible(true);
    }


    public Room_Reserve_Info() {


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



        JPanel SearchPanel = new JPanel();
        SearchPanel.setLayout(null);

        JLabel RoomTypeLabel = new JLabel("@ Room Type");
        RoomTypeLabel.setBounds(95, 28, 100, 40);
        String[] type={"Standard", "Superior", "Deluxe", "Suite"};
        JComboBox RoomTypeBox= new JComboBox(type);
        RoomTypeBox.setBounds(90, 60, 100, 40);

        JLabel DescriptionLabel = new JLabel("@ Description");
        DescriptionLabel.setBounds(255, 28, 100, 40);
        String[] Description={"View", "Single(Bed)", "Double(Bed)", "Twin(Bed)", "Triple(Bed)", "Smoke", "Balcony"};
        JComboBox DescriptionBox= new JComboBox(Description);
        DescriptionBox.setBounds(250, 60, 100, 40);

        JButton RoomSearchButton = RmSearchButton;
        RoomSearchButton.setBounds(410, 80, 70, 20);

        JLabel RoomNumberLabel = new JLabel("@ Room Number");
        RoomNumberLabel.setBounds(900, 28, 100, 40);

        JTextField RoomNumbInput = new JTextField();
        RoomNumbInput.setBounds(920, 60, 70, 30);

        JButton RoomNumbSearchButton = RmNbSearchButton;
        RoomNumbSearchButton.setBounds(1020, 69, 70, 20);
        RoomNumbSearchButton.addActionListener(this);

        JTextArea check_area = new JTextArea();
        check_area.setBorder(new LineBorder(Color.gray, 2));
        check_area.setBounds(20, 110, 850, 500);
        check_area.setEditable(true);


        SearchPanel.add(RoomTypeLabel);
        SearchPanel.add(RoomTypeBox);
        SearchPanel.add(DescriptionLabel);
        SearchPanel.add(DescriptionBox);
        SearchPanel.add(RoomSearchButton);
        SearchPanel.add(RoomNumberLabel);
        SearchPanel.add(RoomNumbInput);
        SearchPanel.add(RoomNumbSearchButton);
        SearchPanel.add(check_area);


        tPane.addTab("예약관리", ReservationPanel);
        tPane.addTab("검색", SearchPanel);

        frame.setTitle("예약관리 페이지");
        frame.setSize(1200,750);
        frame.add(tPane);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RmNbSearchButton) {
            RmNb_PopUp();
        }
        else if (e.getSource() == ReserveRegistrationButton) {
            ReservationRegister_PopUp();
        }
        else if (e.getSource() == ReserveRegistrationCancelButton) {
            ReserveRegistrationCancel_PopUp();
        }
    }

}

