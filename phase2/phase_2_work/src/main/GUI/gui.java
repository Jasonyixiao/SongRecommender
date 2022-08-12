package GUI;

import controllers.ShellState;
import driver.LoadData;
import driver.TopNineRunner;


import java.io.IOException;

public class gui {
    public static void main(String[] args){
        try {
            LoadData loadData = new LoadData();
//            loadData.loadInitialSongs();
            ShellState shell = loadData.loadCurrentData();
//            TopNineRunner topNineRunner = new TopNineRunner();
//            topNineRunner.loadInitialSongs();
          new GuiChooseLanguage(shell);
        } catch(IOException | ClassNotFoundException e){

            e.printStackTrace();



        }

}}