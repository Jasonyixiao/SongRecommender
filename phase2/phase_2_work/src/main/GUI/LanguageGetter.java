package GUI;

import GUI.GuiLanguage.Chinese;
import GUI.GuiLanguage.English;
import GUI.GuiLanguage.ILanguage;

import java.util.HashMap;

public class LanguageGetter {
    private HashMap<String, ILanguage> languageMap;

    public LanguageGetter() {
        languageMap = new HashMap<>();
        languageMap.put("Chinese", new Chinese());
        languageMap.put("English", new English());
    }

    public ILanguage translateTo(String language) {
        return languageMap.get(language);
    }

}
