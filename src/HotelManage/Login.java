package HotelManage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.GroupLayout.Alignment.*;


public class Login extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("LOGIN");
    private JPanel upPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel downPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JLabel idLabel = new JLabel("ID", JLabel.CENTER);
    private JLabel pwdLabel = new JLabel("PASSWORD", JLabel.CENTER);
    private JTextField idInput = new JTextField();
    private JPasswordField pwdInput = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");

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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(this);

        mainPanel.setLayout(null);
        panel.setBounds(dim.width/2-175, dim.height/2-90, 350, 100);
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(pwdLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
        System.out.println(panel.getWidth() +", " +panel.getHeight());
        TitledBorder title;
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        title = BorderFactory.createTitledBorder(blackline, "LOGIN");
        panel.setBorder(title);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton){
            System.out.println("initial Monitor");
            // checking employees' table and accept or deny login try
        }
    }
    public static void main(String[] args){
        Login login = new Login();
        login.showLoginPanel();
    }
}