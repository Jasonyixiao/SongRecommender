package GUI;

import javax.swing.*;

/**
 * This class is responsible for classes that will open the GuiNotification page.
 */
public class GuiGetNotification extends JDialog {
    public static void main(String[] args) {
        new GuiNewNotification("English");
        new GuiDelete("English");

    }
}

/**
 * This class is responsible for calling the new notification page.
 */
class GuiNewNotification{
    LanguageGetter languageGetter = new LanguageGetter();
    public GuiNewNotification(String language) {
        new GuiNotification(languageGetter.translateto(language).newNotifications(), language);
    }

}

/**
 * This class is responsible for calling the all notification page.
 */
class GuiAllNotification{
    public GuiAllNotification(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiNotification(languageGetter.translateto(language).allNotifications(), language);

    }
}