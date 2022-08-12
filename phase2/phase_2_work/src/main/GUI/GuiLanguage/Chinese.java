package GUI.GuiLanguage;

/**
 * This class is responsible for providing text in the GUI in Chinese Language.
 */
public class Chinese implements ILanguage {
    public Chinese() {
    }
    @Override
    public String register(){
        return "注册";
    }

    public String chooseUserToPromote(){
        return "选择要提升成管理员的用户";
    }

    public String chooseUserToDelete(){
        return "选择需要删除的用户";
    }

    public String chooseUserToBan(){
        return "选择封号的用户";
    }

    public String homepageAdminUser(){
        return "管理员的主页面";
    }

    public String notification(){
        return "信息";
    }

    public String recommend() {
        return "推荐";
    }

    public String admin(){
        return "管理员";
    }



    @Override
    public String checkHistory() {
        return "查看历史登录记录";
    }

    @Override
    public String logout() {
        return "登出";
    }


    @Override
    public String checkAllNotifications() {
        return "查看所有通知";
    }


    @Override
    public String rateASong() {
        return "为歌曲评分";
    }

    @Override
    public String recommendToUser() {
        return "推荐歌曲";
    }

    @Override
    public String promote() {
        return "更改用户类型";
    }


    @Override
    public String ban() {
        return "封号";
    }

    @Override
    public String delete() {
        return "删除";
    }

    @Override
    public String userName() {
        return "用户名";
    }


    @Override
    public String listen() {
        return "听歌";
    }


    @Override
    public String loginSystem() {
        return "登录系统";
    }

    @Override
    public String userID() {
        return "用户名";
    }

    @Override
    public String password() {
        return "密码";
    }

    @Override
    public String login() {
        return "登陆";
    }

    @Override
    public String songName() {
        return "歌曲名字";
    }

    @Override
    public String rate() {
        return "打分";
    }


    @Override
    public String forExistedUser() {
        return "已注册用户";
    }

    @Override
    public String forNewUser() {
        return "新用户";
    }
    @Override
    public String LoginHistory() {
        return "登录历史";
    }

    @Override
    public String homepageNormalUser() {
        return "普通用户主界面";
    }

    @Override
    public String registerSystem(){
        return"注册系统";
    }

    @Override
    public String back() {
        return "返回";
    }

    @Override
    public String logInFailed() {
        return "登陆失败，账户已被封禁或账号密码错误";
    }

    @Override
    public String registerFailed() {
        return "用户名已被占用，请重试";
    }

    @Override
    public String logoutFailed() {
        return "您已成功登出，但您的用户数据无法保存";
    }




    @Override
    public String receiverUsername() {
        return "收件人的用户名:";
    }

    @Override
    public String message() {
        return "说点什么";
    }

    @Override
    public String recommendFailed() {
        return "推荐歌曲失败，找不到该歌曲";
    }

    @Override
    public String recommendSucceeded() {
        return "您已成功推荐歌曲";
    }

    @Override
    public String noNotification() {
        return "您目前没有收到任何消息";
    }

    @Override
    public String enterMessage() {
        return "输入您的消息";
    }

    @Override
    public String youHaveMessageFrom() {
        return "您有消息来自";
    }

    @Override
    public String urlOfTheSongIs() {
        return "他推荐给您了这首歌";
    }

    @Override
    public String author() {
        return "作者";
    }

    @Override
    public String Succeeded() {
        return "评分成功";
    }



    @Override
    public String welcome() {
        return "欢迎";
    }
    @Override
    public String userInfo() {
        return "用户信息";
    }

    public String giveYourRating(){
        return "输入您的评分";
    }

    @Override
    public String rateSongSuccess() {
        return "成功为你的歌评分";
    }

    @Override
    public String rateSongFailed() {
        return "评分不在1-5之间/歌曲不存在";
    }

    @Override
    public String recommendStrategy() {
        return "推荐策略";
    }

    @Override
    public String recommendByAvgRating() {
        return "评分最高";
    }

    @Override
    public String rating() {
        return "评分";
    }

    @Override
    public String confirm() {
        return "确认";
    }

    @Override
    public String adminTaskComplete() {
        return "成功";
    }

    @Override
    public String adminTaskFailed() {
        return "失败，该操作不能对管理员/您自己使用";
    }


}
