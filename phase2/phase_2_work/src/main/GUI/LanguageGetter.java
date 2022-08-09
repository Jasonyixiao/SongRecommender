package GUI;

import GUI.GuiLanguage.Chinese;
import GUI.GuiLanguage.English;
import GUI.GuiLanguage.language;

import java.util.HashMap;

public class LanguageGetter {
    HashMap<String, GUI.GuiLanguage.language> languageMap;

    public LanguageGetter() {
        languageMap.put("Chinese", new Chinese());
        languageMap.put("English", new English());
    }

    public language translateto(String language) {
        return languageMap.get(language); // this might return null
    }

}
