package GUI;

import javax.swing.*;

/**
 * This class responsible for classes that will open GuiFindUser page.
 */
public class GuiAdminTool extends JDialog {
    public static void main(String[] args) {
        new GuiChangeUserAdmin("English");
        new GuiDelete("English");
        new GuiBan("English");
    }
}

/**
 * This class is responsible for admin user to create another admin user.
 */
class GuiChangeUserAdmin{
    public GuiChangeUserAdmin(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToPromote(), language);
    }

}

/**
 * This Class is responsible for deleting a user.
 */
class GuiDelete{
    public GuiDelete(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToDelete(), language);

    }
}

/**
 * This Class is responsible for banning a normal user.
 */
class GuiBan{
    public GuiBan(String language){
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiFindUser(languageGetter.translateto(language).chooseUserToBan(), language);
    }
}