package GUI.GuiLanguage;

/**
 * Interface for language that can display text in their specified language.
 */
public interface ILanguage {
    String chooseUserToPromote();

    String chooseUserToDelete();

    String chooseUserToBan();

    String homepageAdminUser();

    String notification();

    String recommend();

    String admin();


    String checkHistory();
    String logout();

    String checkAllNotifications();

    String rateASong();
    String recommendToUser();
    String promote();
    String ban();
    String delete();
    String userName();

    String listen();

    String loginSystem();
    String userID();
    String password();
    String login();
    String songName();
    String rate();

    String forExistedUser();
    String forNewUser();
    String welcome();
    String register();

    String userInfo();

    String LoginHistory();

    String homepageNormalUser();

    String registerSystem();

    String back();

    String logInFailed();

    String registerFailed();

    String logoutFailed();


    String receiverUsername();

    String message();

    String recommendFailed();

    String noNotification();

    String recommendSucceeded();

    String enterMessage();

    String youHaveMessageFrom();

    String author();



    String rateSongSucceed();

    String rateSongFailed();


    String giveYourRating();

    String rateSongSuccess();
    String rateSongSaveFailed();

    String recommendStrategy();

    String recommendByAvgRating();

    String rating();

    String confirm();

    String adminTaskComplete();

    String adminTaskFailed();
}
