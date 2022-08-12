package GUI;

import javax.swing.*;

/**
 * This class responsible for classes that will open GuiFindUser page.
 */
public class GuiAdminTool extends JDialog {
    public static void main(String[] args) {
        new GuiPromoteUserToAdmin("English");
        new GuiDelete("English");
        new GuiBan("English");
    }
}

/**
 * This class is responsible for admin user to create another admin user.
 */
class GuiPromoteUserToAdmin {
    public GuiPromoteUserToAdmin(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateTo(language).chooseUserToPromote(), language);
    }

}

/**
 * This Class is responsible for deleting a user.
 */
class GuiDelete{
    public GuiDelete(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateTo(language).chooseUserToDelete(), language);

    }
}

/**
 * This Class is responsible for banning a normal user.
 */
class GuiBan{
    public GuiBan(String language){
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateTo(language).chooseUserToBan(), language);
    }
}