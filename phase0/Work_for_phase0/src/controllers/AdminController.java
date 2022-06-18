package controllers;

import usecases.AdminManager;

public class AdminController {
    private AdminManager adminManager;

    public AdminController(AdminManager adminManager){
        this.adminManager = new AdminManager();
    }
    // AdminController stores an instance of AdminManage




}
