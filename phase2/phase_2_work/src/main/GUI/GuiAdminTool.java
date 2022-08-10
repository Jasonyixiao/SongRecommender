package GUI;

import javax.swing.*;


public class GuiAdminTool extends JDialog {
    public static void main(String[] args) {
        new GuiChangeUserAdmin("English");
        new GuiDelete("English");
        new GuiBan("English");
    }
}


class GuiChangeUserAdmin{
    public GuiChangeUserAdmin(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToPromote(), language);
    }

}

class GuiDelete{
    public GuiDelete(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToDelete(), language);

    }
}

class GuiBan{
    public GuiBan(String language){
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToBan(), language);
    }
}