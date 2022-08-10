package GUI;

import controllers.ShellState;
import driver.LoadData;



import java.io.IOException;

public class gui {
    public static void main(String[] args){
        try {
            LoadData loadData = new LoadData();
            ShellState shell = loadData.loadCurrentData();
            loadData.loadInitialSongs();
          new GuiChooseLanguage(shell);
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Unable to start GUI, failed to load data from your local directory");



        }

}}