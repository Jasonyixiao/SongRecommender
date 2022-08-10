package GUI;
import commands.CommandFactory;
import controllers.ShellState;
import driver.LoadData;
import driver.TopNineRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLOutput;

public class gui {
    public static void main(String[] args){
        LoadData loadData = new LoadData();
        ShellState shell = loadData.loadCurrentData();
        new GuiChooseLanguage(shell);

}}