package HotelManage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;

public class Customer_List {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextArea check_area = new JTextArea();

    public Customer_List() {
        frame.setTitle("회원관리 페이지");
        frame.setSize(1500, 1200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        panel.setFont(new Font("필기체", 1, 12));
        panel.setBorder(new TitledBorder("Customer List"));
        panel.setBounds(380, 80, 1000, 1000);
        panel.setLayout(null);

        check_area.setBorder(new LineBorder(Color.gray, 2));
        check_area.setLayout(null);
        check_area.setBounds(150, 150, 1500, 800);
        check_area.setEditable(true);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(check_area);

        scroll.setBounds(100, 100, 1500, 800);

        panel.add(scroll); //scroll.setBounds�� �����ؾ� ��ġ �� ������ ���� ������

        frame.add(panel);

        frame.setTitle("회원관리 페이지");
        frame.setSize(1800, 1000);
        frame.setVisible(true);
    }
}

