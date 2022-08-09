package GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiRegister extends JDialog{
    public static void main(String[] args) {
        new GuiRegister();
    }
    private static JLabel label, passwordLabel, success;
    private static JTextField UserLink;
    private static JPasswordField passwordText;
    private static JButton RegisterButton;

    public GuiRegister() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Register System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("New User ID");
        label.setBounds(10, 20, 80, 25);
        UserLink = new JTextField(20);
        UserLink.setBounds(100, 20, 165, 25);

        passwordLabel = new JLabel("Set Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(10, 80, 80, 25);
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);

        panel.add(label);
        panel.add(UserLink);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(RegisterButton);
        panel.add(success);


        //Password enter->出发输入框事件
        UserAndPassword userAndPassword = new UserAndPassword();
        passwordText.addActionListener(userAndPassword);
        UserLink.addActionListener(userAndPassword);

        //设置替换编码
        passwordText.setEchoChar('*'); //char ///////

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if ...
                new GuiSign();
                frame.dispose();
            }
        });

        frame.setVisible(true);


    }

    // @SuppressWarnings("unchecked")
    //private void RegisterJBAction(java.awt.event.ActionEvent evt){
    //    dispose();
    //    GuiRegister guiRegister = new GuiRegister();
    //    guiRegister.setVisible(true);
    //}

    static class UserAndPassword implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JTextField field = (JTextField) e.getSource(); //获得资源，返回对象
            System.out.println(field.getText()); //获得输入框中的文本

            //if User d.n.e
            field.setText("");
            //System.out.println("Please Register first."); 也许要加新的page for instruction?

            //if password is Wrong:
            //field.setText(""); // set empty
            //System.out.println("Wrong Password."); 也许要加新的page for instruction?

            //if User and password correct
            //if normal
            //go to homepage-normal
            //if Admin
            //go to homepage-Admin

        }
    }
}
