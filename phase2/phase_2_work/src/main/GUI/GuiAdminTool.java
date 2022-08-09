package GUI;

import javax.swing.*;


public class GuiAdminTool extends JDialog {
    public static void main(String[] args) {
        new GuiChangeUserAdmin();
        new GuiDelete();
        new GuiBan();
    }
}


class GuiChangeUserAdmin{
    public GuiChangeUserAdmin() {
        new GuiFindUser("Choose User to Admin");
    }

}

class GuiDelete{
    public GuiDelete() {
        new GuiFindUser("Choose User to Delete");

    }
}

class GuiBan{
    public GuiBan(){
        new GuiFindUser("Choose User to Ban");
    }
}