package GUI;

import javax.swing.*;

public class GuiGetNotification extends JDialog {
    public static void main(String[] args) {
        new GuiNewNotification("English");
        new GuiDelete("English");

    }
}

class GuiNewNotification{
    LanguageGetter languageGetter = new LanguageGetter();
    public GuiNewNotification(String language) {
        new GuiNotification(languageGetter.translateto(language).newNotifications(), language);
    }

}

class GuiAllNotification{
    public GuiAllNotification(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        new GuiNotification(languageGetter.translateto(language).allNotifications(), language);

    }
}