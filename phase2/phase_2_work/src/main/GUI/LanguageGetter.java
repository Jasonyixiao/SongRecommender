package GUI;

import GUI.GuiLanguage.Chinese;
import GUI.GuiLanguage.English;
import GUI.GuiLanguage.language;

import java.util.HashMap;

public class LanguageGetter {
    private HashMap<String, language> languageMap;

    public LanguageGetter() {
        languageMap = new HashMap<>();
        languageMap.put("Chinese", new Chinese());
        languageMap.put("English", new English());
    }

    public language translateto(String language) {
        return languageMap.get(language);
    }

}
