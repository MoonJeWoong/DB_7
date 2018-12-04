package HotelManage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class Login extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("LOGIN");
    private JPanel mainPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JLabel idLabel = new JLabel("ID", JLabel.CENTER);
    private JLabel pwdLabel = new JLabel("PASSWORD", JLabel.CENTER);
    private JTextField idInput = new JTextField();
    private JPasswordField pwdInput = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    private static Connection dbTest;
    private Integer username;
    private String password;

    public Login(){
        prepareGUI();
    }

    private void prepareGUI(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(500, 180);
        mainPanel.setSize(350,100);

//      아래코드와 같은 역할을 함.
//      frame.setLocation((dim.width/2) - (frame.getWidth()/2), (dim.height/2) - (frame.getHeight()/2));
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(this);

        mainPanel.setLayout(new FlowLayout());
//        panel.setBounds(dim.width/2-175, dim.height/2-90, 350, 100);
//        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(panel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showLoginPanel(){
        loginButton.setPreferredSize(new Dimension(80,35));
        idInput.setPreferredSize(new Dimension(80, 30));
        pwdInput.setPreferredSize(new Dimension(80, 30));
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(idLabel)
                    .addComponent(pwdLabel)
                )
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(idInput)
                    .addComponent(pwdInput)
                )
                .addComponent(loginButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(idLabel)
                .addComponent(idInput))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(pwdLabel)
                .addComponent(pwdInput)
                .addComponent(loginButton))
        );

        panel.setLayout(layout);
        TitledBorder title;
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        title = BorderFactory.createTitledBorder(blackline, "LOGIN");
        panel.setBorder(title);

        frame.setVisible(true);

    }

    public void loginCheck(Integer username, String password) throws SQLException {
        String jquery = "select StaffID from Staff where StaffID="+username;
        PreparedStatement stmt = dbTest.prepareStatement(jquery);
        ResultSet rs = stmt.executeQuery();
        Integer idCheck = null;
        if(rs.next()) {
            idCheck = rs.getInt("StaffID");
        }

        jquery = "select DPassword from Staff where DPassword = '"+password+"'";
        stmt = dbTest.prepareStatement(jquery);
        rs = stmt.executeQuery();
        String pwdCheck = null;
        if(rs.next()) {
            pwdCheck = rs.getString("DPassword");
        }

        if((username.equals(idCheck)) && (password.equals(pwdCheck))){
            jquery = "select DPosition from Staff where StaffID = "+username;
            stmt = dbTest.prepareStatement(jquery);
            rs = stmt.executeQuery();
            String position = null;
            if(rs.next()) {
                position = rs.getString("DPosition");
            }
            System.out.println(position);
            frame.setVisible(false);
            new InitialMonitor(position);
        }else{
            new DeniedMessage();
        }
        rs.close();
        stmt.close();
//        if(rs.getString("DPosition") == "Manager"){
//            new InitialMonitor();
//        }
//        if(rs.getString("DPosition") == "Staff"){
//            new InitialMonitor_S();
//        }
//        if(rs.getString("DPosition") == "Housekeeper"){
//            new InitialMonitor_H();
//        }
//        if(rs.getString("DPosition") == "Accountant"){
//            new
//        }
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton){
            username = Integer.parseInt(idInput.getText());
            password = new String(pwdInput.getPassword());
            //checking employees' table and accpet or deny login try
            try{
                //if accepted,
                loginCheck(username, password);
            } catch(SQLException se){
                //if denied,
                //show denied alert.
                new DeniedMessage();
                se.printStackTrace();
            }
        }
    }

    public static void connectDB(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE", "database", "database");
            System.out.println("데이터베이스에 연결 되었습니다.");

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection Failed");
            System.out.println("SQLException: " + e);
        } catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }
    public static void main(String[] args){
        Login login = new Login();
        login.showLoginPanel();
        connectDB();

    }
}