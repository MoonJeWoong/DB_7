package HotelManage;

import javax.swing.*;
import java.awt.*;

public class DeniedMessage {
    private JFrame frame = new JFrame("FAILED");
    private JLabel deniedmessage = new JLabel("로그인에 실패하였습니다.");
    public DeniedMessage(){
        prepareGUI();
    }
    private void prepareGUI(){
        frame.setSize(150, 70);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.add(deniedmessage, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
