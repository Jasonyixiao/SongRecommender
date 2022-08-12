package GUI;

import controllers.ShellState;
import driver.LoadData;


import java.io.IOException;

public class gui {
    public static void main(String[] args){
        try {
            LoadData loadData = new LoadData();
            loadData.loadInitialSongs();
            ShellState shell = loadData.loadCurrentData();
            new GuiChooseLanguage(shell);
        } catch(IOException | ClassNotFoundException e){

            e.printStackTrace();



        }

}}