package GUI;

import javax.swing.*;

class GuiDelete extends JDialog{
    private static JLabel label;
    private static JTextField UserName;
    private static JButton button;


    public GuiDelete(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Choose User to Delete");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("User name:");
        label.setBounds(10,20,80,25);
        panel.add(label);
        UserName = new JTextField();
        UserName.setBounds(100,20,165,25);
        panel.add(UserName);
        frame.setVisible(true);

        button = new JButton("Search");
        button.setBounds(10,80,80,25);
        panel.add(button);
    }

}
