package GUI;

import javax.swing.*;

public class GuiGetNotification extends JDialog {
    public static void main(String[] args) {
        new GuiNewNotification();
        new GuiDelete();

    }
}

class GuiNewNotification{
    public GuiNewNotification() {
        new GuiNotification("New Notifications");
    }

}

class GuiAllNotification{
    public GuiAllNotification() {
        new GuiNotification("All Notifications");

    }
}