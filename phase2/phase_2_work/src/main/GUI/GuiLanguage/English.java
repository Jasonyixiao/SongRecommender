package GUI.GuiLanguage;

/**
 * This class is responsible for providing text for the GUI in English languages.
 */
public class English implements ILanguage {
    public English() {
    }
    public String chooseUserToPromote(){
        return "Choose User to promote to Admin";
    }
    @Override
    public String register(){
        return "register";
    }
    @Override
    public String homepageNormalUser() {
        return "homepage normal user";
    }
    @Override
    public String registerSystem(){
        return"Register System";
    }

    @Override
    public String back() {
        return "back";
    }

    @Override
    public String logInFailed() {
        return "Log in Failed, banned from the system or invalid username/password.";
    }

    @Override
    public String registerFailed() {
        return "User already exists, please try again";
    }

    @Override
    public String logoutFailed() {
        return "Logout successful, but we were not able to save your data";
    }



    @Override
    public String receiverUsername() {
        return "Receiver's Username:";
    }

    @Override
    public String message() {
        return "message";
    }

    @Override
    public String recommendFailed() {
        return "Failed.Can't find song in the system.";
    }

    @Override
    public String recommendSucceeded() {
        return "You have successfully recommend the song.";
    }

    @Override
    public String noNotification() {
        return "You do not have any Notifications";
    }

    @Override
    public String author() {
        return "author";
    }

    @Override
    public String rateSongSucceed() {
        return "Rating successful！";
    }


    @Override
    public String userInfo() {
        return "User info";
    }

    @Override
    public String LoginHistory() {
        return "Login History";
    }

    @Override
    public String chooseUserToDelete(){
        return "Choose User to Delete";
    }
    @Override
    public String chooseUserToBan(){
        return "Choose User to Ban";
    }
    @Override
    public String homepageAdminUser(){
        return "Homepage-Admin User";
    }
    @Override
    public String notification(){
        return "Notification";
    }

    @Override
    public String recommend(){
        return "Recommend";
    }

    @Override
    public String admin(){
        return "Admin";
    }



    @Override
    public String checkHistory() {
        return "Check History";
    }

    @Override
    public String logout() {
        return "Logout";
    }



    @Override
    public String checkAllNotifications() {
        return "Check All Notifications";
    }


    @Override
    public String rateASong() {
        return "RateSong";
    }

    @Override
    public String recommendToUser() {
        return "Recommend to User";
    }

    @Override
    public String promote() {
        return "Create admin";
    }

    @Override
    public String ban() {
        return "Ban";
    }

    @Override
    public String delete() {
        return "Delete";
    }

    @Override
    public String userName() {
        return "Username";
    }



    @Override
    public String listen() {
        return "Listen";
    }


    @Override
    public String loginSystem() {
        return "Login System";
    }

    @Override
    public String userID() {
        return "User ID";
    }

    @Override
    public String password() {
        return "Password";
    }

    @Override
    public String login() {
        return "Login";
    }

    @Override
    public String songName() {
        return "Song Name";
    }

    @Override
    public String rate() {
        return "Rate";
    }



    @Override
    public String forExistedUser() {
        return "For Existed User";
    }

    @Override
    public String forNewUser() {
        return "For New User";
    }

    @Override
    public String welcome() {
        return "Welcome";
    }

    @Override
    public String enterMessage(){
        return "enter your message";
    }

    @Override
    public String youHaveMessageFrom() {
        return "you have message from";
    }



    public String giveYourRating(){
        return "give your rating" ;
    }

    @Override
    public String rateSongSuccess() {
        return "you have successfully rated the song.";
    }

    @Override
    public String rateSongSaveFailed() {
        return "Error occurred when saving rating data";
    }

    public String rateSongFailed(){
        return "Rate song failed, song not in system/rating not out of 5.";
    }

    @Override
    public String recommendStrategy() {
        return "Recommend Strategy";
    }

    @Override
    public String recommendByAvgRating() {
        return "" +
                "Recommend by Avg Rating";
    }

    @Override
    public String rating() {
        return "rating";
    }

    @Override
    public String confirm() {
        return "confirm";
    }

    @Override
    public String adminTaskComplete() {
        return " Task completed";
    }

    @Override
    public String adminTaskFailed() {
        return "Task failed. Can't perform such operation to an admin/yourself.";
    }


}
